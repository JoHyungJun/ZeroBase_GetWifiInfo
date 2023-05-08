package servletPackage;

import java.text.SimpleDateFormat;
import java.util.*;
public class HistoryList {
	private static List<History> historyDB;
	private static int ID = 1;
	
	private HistoryList() {}
	
	public static List<History> getHisroyList() {
		return historyDB;
	}
	
	public static void addHistoryList(String LAT, String LNT) {
		if(historyDB == null)
			historyDB = new ArrayList();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 날짜 포맷 참고 링크 https://developer-talk.tistory.com/408
		History history = new History(Integer.toString(ID), LAT, LNT, formatter.format(calendar.getTime()).toString());
		ID++;
		historyDB.add(history);
	}
}
