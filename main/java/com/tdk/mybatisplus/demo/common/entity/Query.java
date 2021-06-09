package com.tdk.mybatisplus.demo.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 查询条件
 *
 * @author: taodingkai
 * @modified:
 * @version: 2021/5/17 18:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Query对象", description = "带分页的查询")
@Builder
public class Query<T> {
  @ApiModelProperty(value = "页码")
  private Long pageNum;
  @ApiModelProperty(value = "每页大小")
  private Long pageSize;
  @ApiModelProperty(value = "条件")
  private T condition;
}
