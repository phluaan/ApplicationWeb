package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Cafe;
import beans.NuocNhapKhau;
import dao.cafedao;

/**
 * Servlet implementation class Dsservlet
 */
@WebServlet(urlPatterns = "/ds",name = "ds")
public class Dsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dsservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NuocNhapKhau> ncNhapKhau = cafedao.DSNuocNhapKhau();
		request.setAttribute("ncNhapKhau", ncNhapKhau);
		if(request.getParameter("locid")!=null) {
			if(!request.getParameter("locid").equals("Tất cả")) {
				request.setAttribute("kq", Integer.parseInt(request.getParameter("locid")));
				List<Cafe> list = cafedao.DSTheoLoaiNuoc(Integer.parseInt(request.getParameter("locid")));
				request.setAttribute("list", list);
			}else {
				List<Cafe> list = cafedao.DS();
				request.setAttribute("list", list);
			}
			request.getRequestDispatcher("ds.jsp").forward(request, response);
		}else {
			List<Cafe> list = cafedao.DS();
			request.setAttribute("list", list);
			request.getRequestDispatcher("ds.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
