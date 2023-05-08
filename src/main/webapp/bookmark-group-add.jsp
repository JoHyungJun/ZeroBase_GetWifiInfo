<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="servletPackage.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<style>
		table {
			border:1px solid white;
			width:100%;
			font-size:12pt;
		}
		td {
			border:solid 1px black;
		}
		th {
			border:solid 1px white;
			background:#3CB371;
			color:white;
			padding:10px 10px;
			font-size:10pt;
		}
	</style>
	<title>와이파이 정보 구하기</title>
</head>
<body>
	<h3>북마크 그룹 추가</h3>
		
	<p>
		<a href="welcome.jsp">홈</a> | 
		<a href="history.jsp">위치 히스토리 목록</a> | 
		<a href="load-wifi">Open API 와이파이 정보 가져오기</a> | 
		<a href="bookmark-group-show.jsp">북마크 보기</a> | 
		<a href="bookmark-group-add">북마크 그룹 관리</a>
	</p>

	<form action="bookmark-group-add">
	<table>
		<tr>
			<th>북마크 이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>순서</th>
			<td><input type="number" name="order"></td>
		</tr>
		<tr>
			<td colspan='2'><input type="submit" value="send"></td>
		</tr>
	</table>
	</form>
</body>
</html>