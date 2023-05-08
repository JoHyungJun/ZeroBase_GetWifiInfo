package servletPackage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set-distance")
public class SetDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SetDistanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String LAT = request.getParameter("LAT");
		String LNT = request.getParameter("LNT");
		
		
		HistoryList.addHistoryList(LAT, LNT);
		
		Double lat = Double.parseDouble(LAT);
		Double lnt = Double.parseDouble(LNT);
		
		List<WifiListRowItem> list = ApiExplorer.getWifiDatas().getTbPublicWifiInfo().getRow();
		setDistance(list, lat, lnt);
		Collections.sort(list);
		
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void setDistance(List<WifiListRowItem> list, double lat, double lnt) {
		WifiListRowItem temp = null;
		double wifiLat = -1; double wifiLnt = -1; double result = -1;
		for(int i=0; i<list.size(); i++) {
			temp = list.get(i);
			wifiLat = Double.parseDouble(temp.getLAT());
			wifiLnt = Double.parseDouble(temp.getLNT());
			
			result = setEachDistance(lat, lnt, wifiLat, wifiLnt);
			
			temp.setDoubleDistance(result);
			temp.setDistance(String.format("%.4f", result));
		}
	}
	
	// 거리 계산 참고 링크 https://github.com/bearjun05/publicwifi-location-service/blob/main/src/main/java/com/example/demo/api/DistanceApi.java
	private double setEachDistance(double lat, double lnt, double wifiLat, double wifiLnt) {
        double theta = lnt - wifiLnt;
        double dist = Math.sin(deg2rad(lat)) * Math.sin(deg2rad(wifiLat)) +
                Math.cos(deg2rad(lat)) * Math.cos(deg2rad(wifiLat)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return (dist);
	}
	
	private static double deg2rad(double deg) {
	    return (deg * Math.PI / 180.0);
	}
	
	private static double rad2deg(double rad) {
	    return (rad * 180 / Math.PI);
	} 
}
