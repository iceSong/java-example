package com.song.threlocal.bean;

/**
 * ThreadLocal测试参数
 *
 * @author song@liu@ele.me
 * @date 2016-09-29 17:31
 */
public class Parameter {
    private static ThreadLocal<Parameter> _parameter = new ThreadLocal<>();

    public static void init(){
        _parameter.set(new Parameter());
    }

    public static Parameter getParameter(){
        return _parameter.get();
    }
}
