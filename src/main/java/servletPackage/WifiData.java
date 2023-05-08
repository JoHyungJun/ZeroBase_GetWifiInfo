package servletPackage;

import java.util.ArrayList;

public class WifiData {
	private long list_total_count;
	private WifiListResultItem RESULT;
	private ArrayList<WifiListRowItem> row = new ArrayList();
	
	public long getList_total_count() {
		return list_total_count;
	}
	public void setList_total_count(long list_total_count) {
		this.list_total_count = list_total_count;
	}
	public WifiListResultItem getRESULT() {
		return RESULT;
	}
	public void setRESULT(WifiListResultItem rESULT) {
		RESULT = rESULT;
	}
	public ArrayList<WifiListRowItem> getRow() {
		return row;
	}
	public void setRow(ArrayList<WifiListRowItem> row) {
		this.row = row;
	}
}