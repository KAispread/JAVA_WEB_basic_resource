<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function loadMembers () {
			$.ajax({
				type:"get",
				async:false,
				url:"http://localhost:8080/pro16/json3",
				success: function (data, textStatus) {
					let jsonData = JSON.parse(data);
					let printOut = "회원 정보 <br> ========== <br>";
					for (let i in jsonData.members) {
						printOut += "이름 : " + jsonData.members[i].name + "<br>";
						printOut += "나이 : " + jsonData.members[i].age + "<br>";
						printOut += "성별 : " + jsonData.members[i].gender + "<br>";
						printOut += "별명 : " + jsonData.members[i].nickname + "<br><br>";
					}
					$("#members").html(printOut);
				},
				error: function(data, textStatus) {
					alert("Error!!!!!!!!");
				}
			})
		};
		function loadBooks() {
			$.ajax({
				type:"get",
				async:false,
				url:"http://localhost:8080/pro16/json3",
				success: function (data, textStatus) {
					let jsonData = JSON.parse(data);
					let printOut = "책 정보 <br> ========= <br>";
					for (let i in jsonData.books) {
						printOut += "제목 : " + jsonData.books[i].title + "<br>";
						printOut += "저자 : " + jsonData.books[i].author+ "<br>";
						printOut += "가격 : " + jsonData.books[i].price + "<br>";
						printOut += "분류 : " + jsonData.books[i].genre + "<br>";
						printOut += "<img src="+jsonData.books[i].image +"><br>";
					}
					$("#books").html(printOut);
				},
				error: function(data, textStatus) {
					alert("Error!!!!!!!!");
				}
			})
		}
	</script>
</head>
<body>
	<input type="submit" value="MEMBER 데이터 받아오기" id="memberInfo" onClick="loadMembers()" />
	<div id="members"></div>
	<input type="submit" value="BOOK 데이터 받아오기" id="bookInfo" onClick="loadBooks()" />
	<div id="books"></div>
</body>
</html>