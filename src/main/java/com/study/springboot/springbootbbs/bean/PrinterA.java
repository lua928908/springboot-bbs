package com.study.springboot.springbootbbs.bean;

public class PrinterA implements Printer {

    @Override
    public void print(String message){
        System.out.println("Printer A : " + message);
    }
}
