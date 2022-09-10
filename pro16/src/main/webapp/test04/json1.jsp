<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#checkJson1").click(function () {
			let jsonStr = '{ "name": ["김강훈", "이기우", "양희준"]}';
			let jsonInfo = JSON.parse(jsonStr);
			let output = "회원이름<br>";
			output+="========<br>";
			for (let i in jsonInfo.name) {
				output += jsonInfo.name[i] + "<br>";
			}
			$("#output1").html(output);
		});
	});
	$(function () {
		$("#checkJson2").click(function () {
			let jsonStr = '{ "age": ["22", "25", "35"]}';
			let jsonInfo = JSON.parse(jsonStr);
			let output = "회원나이<br>";
			output+="========<br>";
			for (let i in jsonInfo.age) {
				output += jsonInfo.age[i] + "<br>";
			}
			$("#output2").html(output);
		});
	});
	$(function () {
		$("#checkJson3").click(function () {
			let jsonStr = '{ "name":"이기우", "age":25, "gender":"남자", "nickname":"Kai" }';
			let jsonInfo = JSON.parse(jsonStr);
			let output = "회원 정보 출력<br>";
			output+="========<br>";
			output += "이름 : " + jsonInfo.name + "<br>" 
					+ "나이 : " + jsonInfo.age + "<br>"
					+ "성별 : " + jsonInfo.gender + "<br>"
					+ "별명 : " + jsonInfo.nickname + "<br>";
			$("#output3").html(output);
		});
	});
	$(function () {
		$("#checkJson4").click(function () {
			let jsonStr = '{"members":[{"name":"이기우", "age":25,"gender":"남자", "nickname":"Kai"}, {"name":"이무성", "age":30, "gender":"남자", "nickname":"이무송"}] }';
			let jsonInfo = JSON.parse(jsonStr);
			let output = "회원 정보 출력<br>";
			output+="========<br>";
			for (let i in jsonInfo.members){
				output += "이름 : " + jsonInfo.members[i].name + "<br>";
				output += "나이 : " + jsonInfo.members[i].age + "<br>";
				output += "성별 : " + jsonInfo.members[i].gender + "<br>";
				output += "별명 : " + jsonInfo.members[i].nickname + "<br><br>";
			}
			$("#output4").html(output);
		});
	});
	$(function () {
		$("#sendJson").click(function () {
			let jsonStr = '{ "name":"이기우", "age":25, "gender":"남자", "nickname":"kai"}';
			
			$.ajax({
				type:"post",
				async:false,
				url:"http://localhost:8080/pro16/json1",
				data: {jsonInfo:jsonStr},
				success:function (data, textStatus) {
				},
				error:function (data, textStatus) {
					alert("Error!!");
				},
				complete:function(data, textStatus) {}
			});			
		});
	});
</script>
</head>
<body>
	<input id="checkJson1" type="button" value="회원 출력" />
	<div id="output1"></div>
	<p>============================</p><br>
	<input id="checkJson2" type="button" value="나이 출력" />
	<div id="output2"></div>
	<p>============================</p><br>
	<input id="checkJson3" type="button" value="회원 정보" />
	<div id="output3"></div>
	<p>============================</p><br>
	<input id="checkJson4" type="button" value="여러 회원 정보" />
	<div id="output4"></div>
	<p>============================</p><br>
	<input type="submit" value="JSON 데이터 제출하기" id="sendJson" />
</body>
</html>