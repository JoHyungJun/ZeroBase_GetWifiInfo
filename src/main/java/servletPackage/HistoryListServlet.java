package servletPackage;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history")
public class HistoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HistoryListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		List<History> historyDB = HistoryList.getHisroyList();
		History temp;
		
		
		for(int i=0; i<historyDB.size(); i++) {
			if(historyDB.get(i).getID().equals(id)) {
				historyDB.remove(i);
				break;
			}
		}
		
		request.getRequestDispatcher("history.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
