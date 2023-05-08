package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;

@WebServlet("/load-wifi")
public class LoadWifiServelt extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int total = -1;
	
	@Override
	public void init() throws ServletException{
		super.init();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		total = ApiExplorer.getWifiDatas().getTbPublicWifiInfo().getRow().size();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>와이파이 정보 구하기</title></head>");
		out.print("<body>");
		out.print("<center><h3>" + total + "개의 WIFI 정보를 정상적으로 저장하였습니다.</h3></center>"
				+ "	<center>"
				+ "		<a href=\"welcome.jsp\">홈으로 가기</a>"
				+ "	</center>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
