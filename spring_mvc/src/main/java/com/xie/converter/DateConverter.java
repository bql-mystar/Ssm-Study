package com.xie.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    public Date convert(String dataStr) {
        // 将日期字符串转换成日期对象，返回
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
