package com.song.bean;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 自动装箱性能损耗测试
 *
 * @author song@liu@ele.me
 * @date 2016-11-10 15:12
 */
public class AutoBoxing {
    public static void main(String[] args){
        StopWatch watch = new StopWatch();
        watch.start();
        Long sum = 0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum += i;
        }
        watch.stop();
        System.out.println(sum + " auto boxing "+ watch.getTime());

        watch.reset();
        watch.start();
        long sum2 = 0l;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum2 += i;
        }
        watch.stop();
        System.out.println(sum2 + " no boxing " + watch.getTime());
    }
}
