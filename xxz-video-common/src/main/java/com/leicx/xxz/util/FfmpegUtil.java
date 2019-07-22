package com.leicx.xxz.util;

import com.leicx.xxz.constant.SysConstant;
import com.leicx.xxz.enums.ErrorCodeEnum;
import com.leicx.xxz.exception.LcxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 视频转换工具类
 * @author daxiong
 * @date 2019-07-17 15:16
 **/
public class FfmpegUtil {

    private static Logger log = LoggerFactory.getLogger(FfmpegUtil.class);

    /**
     * 修改视频的bgm
     * @author daxiong
     * @date 2019-07-18 10:16
     * @param inputVideoPath    输入的视频地址
     * @param inputBgmPath      输入的bgm地址
     * @param outputVideoPath   输出的视频地址
     * @param videoSeconds      视频时长
     * @return void
     **/
    public static void changeVideoBgm(String inputVideoPath, String inputBgmPath,
                                      String outputVideoPath, Double videoSeconds) throws LcxException {
        // ffmpeg -i input.mp4 -i 音乐.mp3 -t 7 -y 新视频.mp4
        List<String> commandList = new ArrayList<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        commandList.add("ffmpeg");
        commandList.add("-i");
        commandList.add(inputVideoPath);

        commandList.add("-i");
        commandList.add(inputBgmPath);

        commandList.add("-t");
        commandList.add(String.valueOf(videoSeconds));

        commandList.add("-y");
        commandList.add(outputVideoPath);

        ProcessBuilder builder = new ProcessBuilder(commandList);

        // 日志打印
        log.debug("运行命令：" + printCommand(commandList));

        try {
            Process process = builder.start();

            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
            }

            if (br != null) {
                br.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (errorStream != null) {
                errorStream.close();
            }

        } catch (IOException e) {
            throw new LcxException(ErrorCodeEnum.ERROR_CODE_300002);
        }

    }

    /**
     * 打印命令行日志
     * @author daxiong
     * @date 2019-07-17 15:11
     * @param commandList   命令行集合
     * @return String   命令字符串
     **/
    public static String printCommand(List<String> commandList) {
        if (commandList == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : commandList) {
            sb.append(str).append(" ");
        }
        return sb.toString();
    }

    /**
     * 改变视频格式
     * @param inputVideoPath    源视频目录
     * @param outputVideoPath   目标视频目录
     */
    public static void changeVideoFormat(String inputVideoPath, String outputVideoPath) throws LcxException {
        // ffmpeg -i /Users/daxiong/test.mp4 /Users/daxiong/format.avi
        List<String> commandList = new ArrayList<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        commandList.add("ffmpeg");
        commandList.add("-i");
        commandList.add(inputVideoPath);

        commandList.add(outputVideoPath);
        ProcessBuilder builder = new ProcessBuilder(commandList);

        // 日志打印
        log.debug("运行命令：" + printCommand(commandList));
        try {
            Process process = builder.start();

            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
            }

            if (br != null) {
                br.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (errorStream != null) {
                errorStream.close();
            }
        } catch (IOException e) {
            throw new LcxException(ErrorCodeEnum.ERROR_CODE_300002);
        }
    }

    public static void getCoverPicture(String inputVideoPath, String outputVideoPath) throws LcxException {
        // ffmpeg -ss 00:00:01 -y -i test.mp4 new.png
        List<String> commandList = new ArrayList<>(SysConstant.COLLECTION_DEFAULT_CAPACITY);
        commandList.add("ffmpeg");

        // 默认截取1s处的图片
        commandList.add("-ss");
        commandList.add("00:00:01");

        commandList.add("-i");
        commandList.add(inputVideoPath);

        commandList.add("-y");
        commandList.add(outputVideoPath);
        ProcessBuilder builder = new ProcessBuilder(commandList);

        // 日志打印
        log.debug("运行命令：" + printCommand(commandList));
        try {
            Process process = builder.start();

            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
            }

            if (br != null) {
                br.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (errorStream != null) {
                errorStream.close();
            }
        } catch (IOException e) {
            throw new LcxException(ErrorCodeEnum.ERROR_CODE_300002);
        }
    }

    public static void main(String[] args) throws LcxException {
        String inputVideoPath = "/Users/daxiong/lcx/xxz-static/video/24/test.mp4";
        String bgmPath = "/Users/daxiong/lcx/xxz-static/video/24/丢火车 - 晚安.mp3";
        String outputVideoPath = "/Users/daxiong/lcx/xxz-static/video/24/format.avi";
        Double seconds = 5D;
//        changeVideoBgm(inputVideoPath, bgmPath, inputVideoPath, seconds);
//        getCoverPicture(inputVideoPath, "/Users/daxiong/lcx/xxz-static/video/24/new.png");
        String coverPicturePath4Jpg = StringUtils.getCoverPicturePath4Jpg(inputVideoPath);
        System.out.println(coverPicturePath4Jpg);
    }

}
