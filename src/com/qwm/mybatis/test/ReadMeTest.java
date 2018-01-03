package com.qwm.mybatis.test;

import org.junit.Test;

/**
 * @author: qiwenming(杞文明)
 * @date: 18/1/4 上午1:13
 * @className: ReadMeTest
 * @description:
 */
public class ReadMeTest {

    @Test
    public void test1(){
        for (int i = 1; i < 20; i++) {
            if(i<10){
                System.out.println( "[](blog/0"+i+".md)\n" );
            }else{
                System.out.println( "[](blog/"+i+".md)\n" );
            }
        }
    }
}
