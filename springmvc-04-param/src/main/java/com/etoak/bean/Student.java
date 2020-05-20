package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data->包含get set 。。。。
 * @author Administrator
 *
 */

@Data
@NoArgsConstructor//无参
@AllArgsConstructor//有参
public class Student {
 private Integer id;
 private String name;
 private Integer age;
 private Map<String,Object> stuMap;
 private List<String> hobbyList;
 

 
 
}
