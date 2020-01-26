package com.study.springboot.springbootbbs;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {
    @Override
    public boolean supports(Class<?> arg0){
        return ContentDto.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입 정보
    }

    @Override
    public void validate(Object obj, Errors errors){
        ContentDto dto = (ContentDto)obj;

//        String sWriter = dto.getWriter();
//        if(sWriter == null || sWriter.trim().isEmpty()){
//            System.out.println("Writer is null or empty");
//            errors.rejectValue("writer", "trouble");
//        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "trouble"); // 값이 있는지 없는지 체크해서 없으면 errors에 에러메세지를 삽입
        String sWriter = dto.getWriter();
        if(sWriter.length() < 3){ // 3글자 이하면 수동으로 에러 메세지 삽입
            errors.rejectValue("writer", "writer is too short.");
        }

//        String sContent = dto.getContent();
//        if(sContent == null || sContent.trim().isEmpty()){
//            System.out.println("Content is null or empty");
//            errors.rejectValue("content", "trouble");
//        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "trouble");
    }
}
