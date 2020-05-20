package com.etoak.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
	public Integer code;
	public String str;//跟前端的接受的msg.xxx 对应不上就是未定义

}
