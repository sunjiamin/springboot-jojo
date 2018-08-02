package com.sun.jojo.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

/**
 * description:
 * 测试jdk1.8 时间类新API
 *
 * @author sunjiamin
 * @date 2018-05-11 11:26
 */
public class LocalDateTest {
    public static void main(String[] agrs) {
        System.out.println(LocalDate.now() + " " + LocalTime.now());
        LocalDate date = LocalDate.of(2018, 2, 13);
        System.out.println(date.plusDays(30).toString());

        LocalTime time = LocalTime.of(10, 20, 45);
        System.out.println(time);


        LocalDateTime localDateTime = LocalDateTime.of(2018, 5, 11, 20, 10, 34);

        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println("****************");


        // represents Wed Feb 28 23:24:43 CET 2018
        Date now = new Date();
        System.out.println(now);

        // represents 2018-02-28T23:24:43.106
        LocalDateTime dateTime = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault());
        System.out.println(dateTime);

        // represent Wed Feb 28 23:24:43 CET 2018
        Date date1 = Date.from(dateTime.toInstant(ZoneOffset.ofHours(0)));
        System.out.println(date1);


        System.out.println("*******************");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .optionalStart().appendPattern("dd/MM/yyyy").optionalEnd()
                .optionalStart().appendPattern("MM-dd-yyyy").optionalEnd()
                .optionalStart().appendPattern("yyyy-MMM-dd").optionalEnd()
                .toFormatter();

        System.out.println(LocalDate.parse("2018-09-23", formatter));
        System.out.println(LocalDate.parse("2018-Sep-23", formatter));




    }
}