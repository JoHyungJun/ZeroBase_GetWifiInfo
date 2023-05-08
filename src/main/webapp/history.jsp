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
			text-align: center;
		}
		th {
			border:solid 1px white;
			background:#3CB371;
			color:white;
			padding:10px 10px;
			font-size:10pt;
			text-align: center;
		}
	</style>
	<title>와이파이 정보 구하기</title>
</head>
<body>
	<h3>와이파이 히스토리 목록</h3>
	
	<p>
		<a href="welcome.jsp">홈</a> | 
		<a href="history">위치 히스토리 목록</a> | 
		<a href="load-wifi">Open API 와이파이 정보 가져오기</a>
	</p>
	
	<form action="history">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>
		<%if(HistoryList.getHisroyList() == null){%>
		<tr><td colspan='5'>조회 이력이 없습니다.</td></tr>
		<%}else{
			List<History> list = HistoryList.getHisroyList();
			for(int i=0; i<list.size(); i++){%>
			<tr>	
				<td><%=list.get(i).getID()%></td>
				<td><%=list.get(i).getX_COORDINATE()%></td>
				<td><%=list.get(i).getY_COORDINATE()%></td>
				<td><%=list.get(i).getINQUERY_DATE()%></td>
				<td><button type="submit" name="ID" value="<%=list.get(i).getID()%>">삭제</button></td>
			</tr>
		<%} }%>
		
	</table>
	</form>
</body>
</html>