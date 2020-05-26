package com.etoak.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.StringUtils;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.Page;
import com.etoak.mapper.CarMapper;

import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class CarServiceImpl implements CarService{
	@Autowired
	CarMapper carMapper;
	@Override
	public int addCar(Car car) {
		
		return carMapper.addCar(car);
	}
	@Override
	public Page<CarVo> queryList(int pageNum, int pageSize, CarVo carVo,String[] priceList) {
		//价格区间
		List<Map<String,Integer>> priceMapList= this.handlePrice(priceList);
		//直接下面处理
		  this.handleVehicleAge(carVo);
		//封装进car
		carVo.setPriceMapList(priceMapList);
		// 设置分页条件
		PageHelper.startPage(pageNum, pageSize);
		//查询列表
		List<CarVo> carList = carMapper.queryList(carVo);
		//创建pageInfo对象  获取分页数据  如果是空的就是没有传CarList
		PageInfo<CarVo> pageInfo = new PageInfo<>(carList);
		return new  Page<CarVo>(pageInfo.getPageNum(),
				pageInfo.getPageSize(),
				carList,
				pageInfo.getTotal(),
				pageInfo.getPages(),
				pageInfo.isIsFirstPage(),
				pageInfo.isIsLastPage());
	}
	private void handleVehicleAge(CarVo carVo) {
		// TODO Auto-generated method stub
		String vehicleAge=carVo.getVehicleAge();
		if(!StringUtils.isEmpty(vehicleAge)) {
			String[] vehicleAgeArray=vehicleAge.split("-");
			//先查询大范围的 再查小范围的  所以 3-5  end=3  start=5
			if(!"0".equals(vehicleAgeArray[0])) {
				carVo.setEndYear(Integer.parseInt(vehicleAgeArray[0]));
			}
			if(!"0".equals(vehicleAgeArray[1])) {
				carVo.setStartYear(Integer.parseInt(vehicleAgeArray[1]));
			}
			
		}
		
	}
	private List<Map<String, Integer>> handlePrice(String[] priceList) {
		List<Map<String, Integer>> priceMapList = new ArrayList<>();
		//判断价格里面不是空的
		if(!ArrayUtils.isEmpty(priceList)) {
			//遍历
			for(String priceStr:priceList) {
				//根据-劈开
				String[] prices=priceStr.split("-");
				Map<String,Integer> priceM = new HashMap<>();
				priceM.put("start", Integer.parseInt(prices[0]));
				priceM.put("end", Integer.parseInt(prices[1]));
				priceMapList.add(priceM);
			}
		}
		
		return priceMapList;
	}
	@Override
	public List<String> getAllBrand() {
		
		return carMapper.getAllBrand();
	}
	@Override
	public List<String> getSeriesByBrand(String brand) {
		//
		return  carMapper.getSeriesByBrand(brand);
	}
	

}
