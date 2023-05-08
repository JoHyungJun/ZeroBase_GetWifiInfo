package servletPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wifi-info")
public class WifiInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WifiInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("MGR_NO");
		List<WifiListRowItem> list = ApiExplorer.getWifiDatas().getTbPublicWifiInfo().getRow();
		WifiListRowItem temp;
		for(int i=0; i<list.size(); i++) {
			temp = list.get(i);
			
			if(no.equals(temp.getX_SWIFI_MGR_NO())) {
				request.setAttribute("select", temp);
				break;
			}
		}
		
		request.getRequestDispatcher("wifi-info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
