package servletPackage;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookmark-group-add")
public class BookMarkGroupAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BookMarkGroupAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String order = request.getParameter("order");
		
		if(name!=null && order!=null) {
			BookMarkGroupList.addBookMarkGroupList(Integer.parseInt(order), name);
			Collections.sort(BookMarkGroupList.getBookMarkGroupList());
		}
		
		request.getRequestDispatcher("bookmark-group-add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
