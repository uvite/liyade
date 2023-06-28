package com.ruoyi.project.app.controller.utils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateDeserializer implements ObjectDeserializer {


    @Override
    public int getFastMatchToken() {
        return 0;
    }

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {

        String dateStr = parser.getLexer().stringVal();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (T) sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }
}