package servletPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookMarkGroupList{
	private static int ID = 1;
	
	private static List<BookMarkGroup> bookMarkGroupList;
	
	public static List getBookMarkGroupList() {
		if(bookMarkGroupList==null)
			bookMarkGroupList = new ArrayList();
		
		return bookMarkGroupList;
	}
	
	public static void addBookMarkGroupList(int order, String name) {
		if(bookMarkGroupList==null)
			bookMarkGroupList = new ArrayList();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		BookMarkGroup temp = new BookMarkGroup(order, name, ID, formatter.format(calendar.getTime()));
		ID++;
		bookMarkGroupList.add(temp);
	}
}
