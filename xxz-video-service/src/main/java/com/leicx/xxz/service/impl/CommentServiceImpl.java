package com.leicx.xxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leicx.xxz.constant.ParamConstant;
import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.dto.comment.CommentListDTO;
import com.leicx.xxz.entity.Comments;
import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.entity.Videos;
import com.leicx.xxz.entity.ext.CommentExt;
import com.leicx.xxz.mapper.CommentsMapper;
import com.leicx.xxz.mapper.UsersMapper;
import com.leicx.xxz.service.CommentService;
import com.leicx.xxz.util.MapUtil;
import com.leicx.xxz.util.TimeAgoUtils;
import com.leicx.xxz.vo.video.CommentListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void insertComment(Comments comments) {
        Date now = new Date();
        comments.setCreateTime(now);
        comments.setUpdateTime(now);
        commentsMapper.insertSelective(comments);
    }

    @Override
    public void updateComment(Comments comments) {
        Date now = new Date();
        comments.setUpdateTime(now);
    }

    @Override
    public Videos getCommentById(Integer commentId) {
        return null;
    }

    @Override
    public CommentListVO getCommentsList(CommentListDTO commentListDTO) {
        Integer start = commentListDTO.getStart();
        Integer pageNum = commentListDTO.getPageNum();
        // 封装条件
        Map<String, Object> param = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        MapUtil.addToMap(param, "videoId", commentListDTO.getVideoId());
        MapUtil.addToMap(param, ParamConstant.DEL, 0);
        MapUtil.addToMap(param, ParamConstant.ORDER_BY_STR, "update_time desc");
//        MapUtil.addToMap(param, ParamConstant.START, start, 1);
//        MapUtil.addToMap(param, ParamConstant.PAGE_NUM, pageNum, 10);

        PageHelper.startPage(start, pageNum);
        List<Comments> commentsList = commentsMapper.getCommentsList(param);
        PageInfo<Comments> commentsPageInfo = new PageInfo<>(commentsList);

        // 拼装返回
        CommentListVO commentListVO = new CommentListVO();
        commentListVO.setCommentsList(commentsList);
        commentListVO.setTotalCount(commentsPageInfo.getTotal());
        commentListVO.setPageTotal(commentsPageInfo.getPages());

        // 获取对应用户头像，名称等
        if (commentsList == null || commentsList.isEmpty()) {
            return commentListVO;
        }

        Set<Integer> userIdIn = new HashSet<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        userIdIn.add(-1);
        commentsList.forEach(item -> {
            userIdIn.add(item.getUserId());
            Integer toUserId = item.getToUserId();
            if (toUserId != null) {
                userIdIn.add(toUserId);
            }
        });
        param.clear();
        MapUtil.addToMap(param, ParamConstant.ID_IN, userIdIn);
        MapUtil.addToMap(param, ParamConstant.COLUMNS, "id,name,avatar");
        List<UserEntity> userList = usersMapper.getUserList(param);

        // 拼装返回
        ArrayList<CommentExt> result = new ArrayList<>();
        Map<Integer, UserEntity> userMap = new HashMap<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        userList.forEach(item -> userMap.put(item.getId(), item));
        for (Comments comment : commentsList) {
            Integer userId = comment.getUserId();
            Integer toUserId = comment.getToUserId();
            CommentExt commentExt = new CommentExt();
            BeanUtils.copyProperties(comment, commentExt);
            if (userMap.containsKey(userId)) {
                commentExt.setUserEntity(userMap.get(userId));
            }
            if (toUserId != null && userMap.containsKey(toUserId)) {
                commentExt.setToUserEntity(userMap.get(toUserId));
            }
            // 评论时间转换
            Date updateTime = comment.getUpdateTime();
            String timeAgoStr = TimeAgoUtils.format(updateTime);
            commentExt.setTimeAgoStr(timeAgoStr);
            result.add(commentExt);
        }
        commentListVO.setCommentsList(result);
        return commentListVO;
    }

    @Override
    public void saveComment(Comments comments) {
        Integer commentId = comments.getId();
        if (commentId == null) {
            insertComment(comments);
        } else {
            updateComment(comments);
        }
    }
}
