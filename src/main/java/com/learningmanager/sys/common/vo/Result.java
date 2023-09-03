package com.learningmanager.sys.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public  static <T> Result<T> success(){
        return new Result<>(20000, "success", null);
    }
    public  static <T> Result<T> success(T data, String message){
        return new Result<>(20000, message, data);
    }
    public  static <T> Result<T> success(T data){
        return new Result<>(20000, "success", data);
    }
    public  static <T> Result<T> success(String message){
        return new Result<>(20000, message, null);
    }

    public  static <T> Result<T> fail(){
        return new Result<>(20001, "fail", null);
    }

    public  static <T> Result<T> fail(T data, String message){
        return new Result<>(20001, message, data);
    }

    public  static <T> Result<T> fail(T data){
        return new Result<>(20001, "fail", data);
    }

    public  static <T> Result<T> fail(String message){
        return new Result<>(20001, message, null);
    }

}