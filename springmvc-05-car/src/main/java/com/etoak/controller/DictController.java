package com.etoak.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Dict;
import com.etoak.bean.User;
import com.etoak.service.DictService;
import com.etoak.service.UserService;

@Controller
@RequestMapping("/dict")

public class DictController {//Logger->import org.slf4j.Logger;
	private static final Logger log=LoggerFactory.getLogger(DictController.class);
	@Autowired
	DictService dictService;
	/**
	 * @PathVariable可以吧url地址映射到参数上  参数上要和url上的一样  
	 * 如果由多个 在@PathVariable（value = ）参数就是String id   namevalue上的值和url一样
	 * @param groupId
	 * @return
	 */
	@GetMapping("/{groupId}")
	@ResponseBody
	public List<Dict> queryList(@PathVariable String groupId){
		log.info("groupId---->>>>", groupId);
			return dictService.queryList(groupId);
	}
}
