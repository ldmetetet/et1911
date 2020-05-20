<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hi</title>
</head>
<body>
	<h4>测试数组传参</h4>
	<!-- webapp/ json不用这个enctype-->
	<form enctype="application/x-www-form-urlencoded" 
	action="${pageContext.request.contextPath }/javaBean/array"
	method="post">
		爱好：
		<input type="checkbox" name="hobby" value="踢球" /> 踢球
		<input type="checkbox" name="hobby" value="唱歌" /> 唱歌
		<input type="checkbox" name="hobby" value="篮球" /> 篮球
		<input type="checkbox" name="hobby" value="旅游" /> 旅游
		<br>
		<input type="submit" value="提交"/>
	</form>
	<br>
		<h4>测试List传参</h4>
	<!-- webapp/ json不用这个enctype-->
	<form enctype="application/x-www-form-urlencoded" 
	action="${pageContext.request.contextPath }/javaBean/list"
	method="post">
		爱好：
		<input type="checkbox" name="hobbyList" value="踢球" /> 踢球
		<input type="checkbox" name="hobbyList" value="唱歌" /> 唱歌
		<input type="checkbox" name="hobbyList" value="篮球" /> 篮球
		<input type="checkbox" name="hobbyList" value="旅游" /> 旅游
		<br>
		<input type="submit" value="测试List"/>
		
	</form>
	<button id="testMap" type="button">测试Map传参</button>
	<br>
	<button onclick="JsonToMap()" type="button">测试json转Map传参</button>
	<hr>
	<button onclick="JsonToList()" type="button">测试json转List传参</button>
	<hr>
	<button onclick="JsonToBean()" type="button">测试json转Bean传参</button>
	<script src="${pageContext.request.contextPath }/static/js/jquery.min.js" 
	type="text/javascript" ></script>
	<script type="text/javascript">
		const path = "${pageContext.request.contextPath }"
		/*  */
		$(function () {
			//alert(path)
			$("#testMap").click(() => {
				//alert("mmmmmmm");
				$.ajax({
					url:path + '/javaBean/map',
					type:'post',//http method
					dataType:'text',//文本
					data:"stuMap['id']=1&stuMap['name']=LLL",
					success:function(data){
						alert(data)
					}
				})
			})
		})
		/* json->map  json类似object*/
		function JsonToMap(){
			//js对象
			let obj ={id:1,name:"LLL"};
			$.ajax({
				url:path + '/json/JsonToMap',
				type:'post',//http method
				dataType:'json',//文本
				contentType:'application/json;charset=UTF-8',
				data:JSON.stringify(obj),//将js对象转成json字符串
				success:function(msg){
					alert(msg.str)
				}
			})			
		}
		/* json->List  */ 
		function JsonToList() {
			let array = [{id:2,name:"vv",age:23}];
			let user={id:1,name:"cc",age:23};
			array.push(user)
			$.ajax({
				url:path + '/json/JsonToList',
				type:'post',//http method
				dataType:'json',//文本
				contentType:'application/json;charset=UTF-8',
				data:JSON.stringify(array),//将js对象转成json字符串
				success:function(msg){
					alert(msg.code + '===='+ msg.str);
				}
			})
		}
		/* json-->bean */
		function JsonToBean() {
			let obj ={id:11,
					name:"gg",
					age:12,
					hobbyList:['学习','听音乐','跑步'],
					stuMap:{id:6,score:200}
			};
			$.ajax({
				url:path + '/json/JsonToBean',
				type:'post',//http method
				dataType:'json',//文本
				contentType:'application/json;charset=UTF-8',
				data:JSON.stringify(obj),//将js对象转成json字符串
				success:function(msg){
					alert(msg.code + '===='+ msg.str);//在vo里面的
				}
			})
		}
		
		
		
	</script>
</body>
</html>






















