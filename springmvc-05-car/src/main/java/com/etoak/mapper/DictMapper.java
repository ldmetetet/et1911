package com.etoak.mapper;

import java.util.List;

import com.etoak.bean.Dict;

public interface DictMapper {
	//groupId查询字典数据类表
	List<Dict> queryList(String groupId);
	
	
}
