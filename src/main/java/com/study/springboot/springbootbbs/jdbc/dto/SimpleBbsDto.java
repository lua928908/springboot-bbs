package com.study.springboot.springbootbbs.jdbc.dto;

import lombok.Data;

@Data
public class SimpleBbsDto {
    private int id;
    private String writer;
    private String title;
    private String content;
}
