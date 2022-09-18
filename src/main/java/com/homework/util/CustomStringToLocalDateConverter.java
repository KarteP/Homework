package com.homework.util;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;

public class CustomStringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String from) {
        return "today".equalsIgnoreCase(from) ? LocalDate.now() : LocalDate.parse(from);
    }
}