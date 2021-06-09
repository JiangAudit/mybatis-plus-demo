package com.tdk.mybatisplus.demo.common.entity;

/**
 * 前端返回结果的code和msg枚举
 *
 * @author: taodingkai
 * @modified:
 * @version: 2021/5/17 15:23
 */
public enum ResultEnum {
  SUCCESS(200,"请求成功"),
  FAIL(500,"请求失败"),
  ;
  private Integer code;
  private String  message;

  ResultEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
