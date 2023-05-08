package servletPackage;

import java.text.SimpleDateFormat;
import java.util.*;
public class BookMarkGroup implements Comparable<BookMarkGroup>{
	private static int GROUP_ID = -1;
	private static List<BookMark> bookMarkGroup;
	
	private int order = -1;
	private String name = null;
	private String createDate = null;
	
	BookMarkGroup(int order, String name, int ID, String createDate){
		this.GROUP_ID = ID;
		this.order = order;
		this.name = name;
		this.createDate = createDate;
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public int getGroupID() {
		return GROUP_ID;
	}

	public void setGroupID(int GROUP_ID) {
		this.GROUP_ID = GROUP_ID;
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static int ID = 1;
	
	
	public static List<BookMark> getBookMarkGroup() {
		if(bookMarkGroup == null)
			bookMarkGroup = new ArrayList();
		
		return bookMarkGroup;
	}
	
	public static void addBookMark() {
		BookMark bookMark = new BookMark(ID++);
		
		if(bookMarkGroup == null)
			bookMarkGroup = new ArrayList();
		
		bookMarkGroup.add(bookMark);
	}
	
	@Override
	public int compareTo(BookMarkGroup obj) {
		return this.GROUP_ID - obj.GROUP_ID;
	}
}
