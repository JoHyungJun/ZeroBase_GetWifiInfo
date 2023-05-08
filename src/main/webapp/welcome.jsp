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
	
	<form action="set-distance">
		LAT : <input type="text" value="0.0" name="LAT" id="LAT"></input>, LNT : <input type="text" value="0.0" name="LNT" id="LNT"></input>
		<button type="button" onclick="getLocation()">내 위치 가져오기</button>
		<button type="submit" value="send">근처 WIFI 정보 보기</button>
	</form>
	
	<script type="text/javascript">
	var LAT = document.getElementById("LAT");
	var LNT = document.getElementById("LNT");
	 
	function getLocation() {
	    //alert("getLocation");
	    if(navigator.geolocation){
	        navigator.geolocation.getCurrentPosition(showPosition);
	    }
	    else{
	        alert("위치를 얻을 수 없습니다.");
	    }
	}
	
	function showPosition(position) {
		LAT.value = position.coords.latitude;
		LNT.value = position.coords.longitude;
	}
	</script>

	
	<table border="1">
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<%if(ApiExplorer.wifiDatas == null){%>
		<tr><td colspan='17'><center>위치 정보를 입력한 후에 조회해주세요.</center></td></tr>
		<%}else{
			List<WifiListRowItem> list = ApiExplorer.getWifiDatas().getTbPublicWifiInfo().getRow();
			for(int i=0; i<10; i++){%>
			<tr>
				<td><%=list.get(i).getDistance()%></td>
				<td><%=list.get(i).getX_SWIFI_MGR_NO()%></td>
				<td><%=list.get(i).getX_SWIFI_WRDOFC()%></td>
				<td><a href="wifi-info?MGR_NO=<%=list.get(i).getX_SWIFI_MGR_NO()%>"><%=list.get(i).getX_SWIFI_MAIN_NM()%></a></td>
				<td><%=list.get(i).getX_SWIFI_ADRES1()%></td>
				<td><%=list.get(i).getX_SWIFI_ADRES2()%></td>
				<td><%=list.get(i).getX_SWIFI_INSTL_FLOOR()%></td>
				<td><%=list.get(i).getX_SWIFI_INSTL_TY()%></td>
				<td><%=list.get(i).getX_SWIFI_INSTL_MBY()%></td>
				<td><%=list.get(i).getX_SWIFI_SVC_SE()%></td>
				<td><%=list.get(i).getX_SWIFI_CMCWR()%></td>
				<td><%=list.get(i).getX_SWIFI_CNSTC_YEAR()%></td>
				<td><%=list.get(i).getX_SWIFI_INOUT_DOOR()%></td>
				<td><%=list.get(i).getX_SWIFI_REMARS3()%></td>
				<td><%=list.get(i).getLNT()%></td>
				<td><%=list.get(i).getLAT()%></td>
				<td><%=list.get(i).getWORK_DTTM()%></td>
			</tr>
		<%} } %>
	</table>
	
</body>
</html>