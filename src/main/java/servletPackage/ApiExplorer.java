package servletPackage;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer{
	public static DtoWifi wifiDatas = null;
	
	private ApiExplorer() {}
	
	private static void setWifiDatas() {
		try {
			String result = getData(1,1);
			//System.out.println(result);
			Gson gson = new Gson();
			wifiDatas = gson.fromJson(result, DtoWifi.class);
			
			long maxIdx = wifiDatas.getTbPublicWifiInfo().getList_total_count();
			DtoWifi temp;
			for(int i=2; i<=maxIdx; i+=1000) {
				result = getData(i, Math.min(maxIdx, i+999));
				temp = gson.fromJson(result, DtoWifi.class);
				wifiDatas.getTbPublicWifiInfo().getRow().addAll(temp.getTbPublicWifiInfo().getRow());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static DtoWifi getWifiDatas() {
		if(wifiDatas == null)
			setWifiDatas();
		
		return wifiDatas;
	}
	
	private static String getData(long startIdx, long endIdx) {
		StringBuilder sb = null;
		
		try {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
		urlBuilder.append("/" +  URLEncoder.encode("6a46654a646a686a3637776d667969","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
		urlBuilder.append("/" + URLEncoder.encode(Long.toString(startIdx),"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
		urlBuilder.append("/" + URLEncoder.encode(Long.toString(endIdx),"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
		// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
		// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
		//urlBuilder.append("/" + URLEncoder.encode("서대문구","UTF-8")); /*X_SWIFI_WRDOFC - 자치구 명*/
		//urlBuilder.append("/" + URLEncoder.encode("서소문로","UTF-8")); /*X_SWIFI_ADRES1 - 도로명 주소*/
		
		System.out.println(urlBuilder.toString());
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		//System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		
		BufferedReader rd;
		
		// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		//System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		List<WifiListRowItem> list = ApiExplorer.getWifiDatas().getTbPublicWifiInfo().getRow();
		Collections.sort(list);
	}
}