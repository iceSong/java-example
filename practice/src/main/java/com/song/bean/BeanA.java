package com.song.bean;

/**
 * switch中String的实现原理
 *
 * @author song@liu@ele.me
 * @date 2016-10-14 15:26
 */
public class BeanA {
    public int strSwitchTest(String key) {
        int flag;
        switch (key){
            case "你好啊，今天天气不错呢":
                flag = 0;
                break;
            case "b":
                flag = 1;
                break;
            default:
                flag = 2;
                break;
        }
        return flag;
    }
}
