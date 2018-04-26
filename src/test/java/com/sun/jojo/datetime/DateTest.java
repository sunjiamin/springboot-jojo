package com.sun.jojo.datetime;

import java.util.Date;

public class DateTest {
    public static void main(String[] agrs){


        Date date1 = new Date();
        Date date2 = new Date(System.currentTimeMillis()+10000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            date1.before(date2);

        }
        long end = System.currentTimeMillis();
        System.out.println("before cost:"+(end - start));



        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
           long a = date2.getTime()-date1.getTime();

        }
        long end1 = System.currentTimeMillis();
        System.out.println("getTime cost:"+(end1 - start1));

    }
}
