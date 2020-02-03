package com.study.springboot.springbootbbs.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SimpleBbsDto {
    private int id;
    @NotEmpty(message = "작성자가 빈값일 수 없습니다.")
    private String writer;
    @NotEmpty(message = "제목이 빈값일 수 없습니다.")
    private String title;
    private String content;
}