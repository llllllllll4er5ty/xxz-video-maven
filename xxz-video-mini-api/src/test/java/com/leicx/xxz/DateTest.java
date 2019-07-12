package com.leicx.xxz;

import com.leicx.xxz.entity.UserEntity;
import com.leicx.xxz.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = XxzVideoMiniApiApplication.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DateTest {

    @Resource
    private UsersMapper usersMapper;

    @Test
    public void dateTest() throws ParseException {
        Date d = new Date();
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制
        System.out.println(ss.format(d));

        Date date = new Date();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        String LgTime = sdformat.format(date);
        System.out.println(LgTime);

        Map<String, String> map = new HashMap<>();
        map.put("1", "a");

        String s = "2012-06-21 00:10:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d1 = sdf.parse(s); //先把字符串转为util.Date对象
        java.sql.Date d2 = new java.sql.Date(d1.getTime()); //再转换为sql.Date对象
        System.out.println(d2);
    }

}


