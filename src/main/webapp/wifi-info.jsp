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
	<h3>와이파이 정보 구하기</h3>
	
	<p>
		<a href="welcome.jsp">홈</a> | 
		<a href="history.jsp">위치 히스토리 목록</a> | 
		<a href="load-wifi">Open API 와이파이 정보 가져오기</a> | 
		<a href="bookmark-group-show.jsp">북마크 보기</a> | 
		<a href="bookmark-group-add">북마크 그룹 관리</a>
	</p>
	
	<select name="bookMarkName">
	    <option value="">북마크 그룹 이름 선택</option>
	    <%List<BookMarkGroup> list = BookMarkGroupList.getBookMarkGroupList();%>
	      <%for(int i=0; i<list.size(); i++){%>
	      	<%BookMarkGroup temp = list.get(i);%>
	    <option value="<%=temp.getName()%>"><%=temp.getName()%></option>
	    <%}%>
	</select>

	<table>
	<%WifiListRowItem select = (WifiListRowItem)request.getAttribute("select");%>
		<tr>
			<th>거리(Km)</th>
			<td><%=select.getDistance()%></td>
		</tr>
		<tr>
			<th>관리번호</th>
			<td><%=select.getX_SWIFI_MGR_NO()%></td>
		</tr>
		<tr>
			<th>자치구</th>
			<td><%=select.getX_SWIFI_WRDOFC()%></td>
		</tr>
		<tr>
			<th>와이파이명</th>
			<td><%=select.getX_SWIFI_MGR_NO()%></td>
		</tr>
		<tr>
			<th>도로명주소</th>
			<td><%=select.getX_SWIFI_ADRES1()%></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><%=select.getX_SWIFI_ADRES2()%></td>
		</tr>
		<tr>
			<th>설치위치(층)</th>
			<td><%=select.getX_SWIFI_INSTL_FLOOR()%></td>
		</tr>
		<tr>
			<th>설치유형</th>
			<td><%=select.getX_SWIFI_INSTL_TY()%></td>
		</tr>
		<tr>
			<th>설치기관</th>
			<td><%=select.getX_SWIFI_INSTL_MBY()%></td>
		</tr>
		<tr>
			<th>서비스구분</th>
			<td><%=select.getX_SWIFI_SVC_SE()%></td>
		</tr>
		<tr>
			<th>망종류</th>
			<td><%=select.getX_SWIFI_CMCWR()%></td>
		</tr>
		<tr>
			<th>설치년도</th>
			<td><%=select.getX_SWIFI_CNSTC_YEAR()%></td>
		</tr>
		<tr>
			<th>실내외구분</th>
			<td><%=select.getX_SWIFI_INOUT_DOOR()%></td>
		</tr>
		<tr>
			<th>WIFI접속환경</th>
			<td><%=select.getX_SWIFI_REMARS3()%></td>
		</tr>
		<tr>
			<th>X좌표</th>
			<td><%=select.getLNT()%></td>
		</tr>
		<tr>
			<th>Y좌표</th>
			<td><%=select.getLAT()%></td>
		</tr>
		<tr>
			<th>작업일자</th>
			<td><%=select.getWORK_DTTM()%></td>
		</tr>
	</table>
</body>
</html>