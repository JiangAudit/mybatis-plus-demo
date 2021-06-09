package com.tdk.mybatisplus.demo.common.entity;

import static com.tdk.mybatisplus.demo.common.entity.ResultEnum.FAIL;
import static com.tdk.mybatisplus.demo.common.entity.ResultEnum.SUCCESS;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 前端返回结果类
 *
 * @author: taodingkai
 * @modified:
 * @version: 2021/5/17 11:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "Result对象", description = "公共返回结果类")
public class Result<T> {

  @NonNull
  @ApiModelProperty(value = "编码")
  private Integer code;
  @NonNull
  @ApiModelProperty(value = "消息")
  private String  message;
  @ApiModelProperty(value = "数据")
  private T       data;

  public static <T> Result<T> success(T data) {
    return Result.<T>builder().code(SUCCESS.getCode()).message(SUCCESS.getMessage()).data(data).build();
  }

  public static <T> Result<T> fail(T data) {
    return Result.<T>builder().code(FAIL.getCode()).message(FAIL.getMessage()).data(data).build();
  }

  public static <T> Result<T> success(String message, T data) {
    return Result.<T>builder().code(SUCCESS.getCode()).message(message).data(data).build();
  }

  public static <T> Result<T> fail(String message, T data) {
    return Result.<T>builder().code(FAIL.getCode()).message(message).data(data).build();
  }
}