package com.study.springboot.springbootbbs;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContentDto {
    private int id;
    @NotNull(message="writer is null.") //  null일 수 없다.
    @NotEmpty(message="writer is empty.") // empty일 수 없다.
    @Size(min=3, max=10, message="writer min3, max10.") // 최소 3, 최대10자리
    private String writer;
    @NotNull(message="content is null.")
    @NotEmpty(message="content is empty.")
    private String content;
}
