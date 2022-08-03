package com.example.mit_lvyou.entity.dto;

import lombok.Data;

@Data
public class ResultDTO {
    /**
     * 返回码
     **/
    private Integer code;
    /**
     * 返回信息
     **/
    private String message;
    /**
     * 返回数据
     **/
    private Object data;

}
