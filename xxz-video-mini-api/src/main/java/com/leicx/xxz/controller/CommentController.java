package com.leicx.xxz.controller;

import com.leicx.xxz.dto.comment.CommentListDTO;
import com.leicx.xxz.dto.comment.CommentSaveDTO;
import com.leicx.xxz.entity.Comments;
import com.leicx.xxz.service.CommentService;
import com.leicx.xxz.util.LcxJSONResult;
import com.leicx.xxz.vo.video.CommentListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 视频评论的controller
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/save")
    public LcxJSONResult save(@RequestBody CommentSaveDTO commentSaveDTO) {
        Comments comment = new Comments();
        BeanUtils.copyProperties(commentSaveDTO, comment);
        commentService.saveComment(comment);
        return LcxJSONResult.ok();
    }

    @PostMapping(value = "/list")
    public LcxJSONResult listVideo(@RequestBody CommentListDTO commentListDTO) {

        CommentListVO commentListVO = commentService.getCommentsList(commentListDTO);
        return LcxJSONResult.ok(commentListVO);
    }
}
