package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car{
	private String levelName;//名称  后台 数据库 前端
	private String gearboxName;
	private String outputVName;
	//传到sql  在前端不显示 结果不被封装
	@JsonIgnore
	private List<Map<String,Integer>>  priceMapList;
	//前端的车龄  0-1  3-5   
	@JsonIgnore
	private String vehicleAge;
	//传sql的条件
	@JsonIgnore
	private Integer startYear;
	@JsonIgnore
	private Integer endYear;
}
