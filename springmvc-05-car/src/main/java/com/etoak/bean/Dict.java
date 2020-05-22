package com.etoak.bean;

import java.io.Serializable;

import lombok.Data;
@Data					
public class Dict implements Serializable{//开启二级缓存的时候要求序列化
	/**
	 * Add....
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String groupId;
	private String  name;
	private String value;
	private Integer sort;

}
