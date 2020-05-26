package com.etoak.bean;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	/**
	 * 后端校验   --》CarController
	 */
	private Integer id;
	@NotNull(message="品牌不能为空")
	@NotEmpty(message="品牌不能为空")
	private String brand;
	@NotNull(message="车系不能为空")
	@NotEmpty(message="车系不能为空")
	private String series;
	@NotNull(message="价格不能为空")
	@Min(value = 1 ,message="价格最少是1")
	@Max(value = 1000 ,message="价格最大是1000")
	private Integer price;
	private String licensingTime;
	private String level;
	private String gearbox;
	private String outputV;
	private Integer mileage;
	private String location;
	
	private String pic;
	@Size(min=6,max=12,message="概述只能在6-12个范围内")
	private String summary;
	private String createTime;
}
