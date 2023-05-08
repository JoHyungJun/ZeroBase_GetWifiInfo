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
	<h3>북마크 그룹</h3>
	
	<p>
		<a href="welcome.jsp">홈</a> | 
		<a href="history.jsp">위치 히스토리 목록</a> | 
		<a href="load-wifi">Open API 와이파이 정보 가져오기</a> | 
		<a href="">북마크 보기</a> | 
		<a href="bookmark-group-add">북마크 그룹 관리</a>
	</p>
	
	<table>
		<tr>
			<th>ID</th>
			<th>북마크 이름</th>
			<th>순서</th>
			<th>등록일자</th>
			<th>수정일자</th>
		</tr>
		<%List<BookMarkGroup> list = BookMarkGroupList.getBookMarkGroupList();%>
		<%for(int i=0; i<list.size(); i++) {
			BookMarkGroup temp = list.get(i);%>
			<tr>
				<td></td>
				<td><%=temp.getName()%></td>
				<td><%=temp.getOrder()%></td>
				<td><%=temp.getCreateDate()%></td>
				<td></td>
			</tr>
			<%}%>
	</table>
</body>
</html>