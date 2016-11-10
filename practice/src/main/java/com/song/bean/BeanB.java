package com.song.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;


/**
 * TODO
 *
 * @author song@liu@ele.me
 * @date 2016-11-08 16:18
 */
public class BeanB extends BeanA{
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args){
        BeanA a = new BeanA();
        a.setA("asas");
        BeanB b = new BeanB();
        BeanUtils.copyProperties(a, b);

        Class clazz = b.getClass();
        try {
            Field field = clazz.getDeclaredField("a");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(b.getA());
    }
}
