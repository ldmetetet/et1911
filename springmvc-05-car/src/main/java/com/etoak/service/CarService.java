package com.etoak.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.Dict;
import com.etoak.bean.Page;


public interface CarService {
	int addCar(Car car);
	Page<CarVo> queryList(int pageNum,int pageSize,CarVo carVo, String[] priceList);
	//查询所有的品牌
	List<String> getAllBrand();
	List<String> getSeriesByBrand(@Param("brand")String brand);
}
