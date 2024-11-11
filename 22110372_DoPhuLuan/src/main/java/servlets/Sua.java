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
 * Servlet implementation class Sua
 */
@WebServlet(urlPatterns = "/sua",name = "sua")
public class Sua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("maLoaiCF");
		Cafe item = cafedao.laycafe(ma);
		List<NuocNhapKhau> list = cafedao.DSNuocNhapKhau();
		request.setAttribute("item", item);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Sua.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ma = request.getParameter("maLoaiCF");
		Cafe item = cafedao.laycafe(ma);
		if(item!=null) {
			int nuocnhapkhauid = Integer.parseInt(request.getParameter("nuocnhapkhauId"));
			float giaBan = Float.parseFloat(request.getParameter("giaban"));
			String tencf = request.getParameter("tenCF");
			
			System.out.println(nuocnhapkhauid+" " +giaBan+" " +tencf+" "+ ma);
			cafedao.Sua(nuocnhapkhauid, giaBan, tencf, ma);
			response.sendRedirect("/22110372_DoPhuLuan/ds");
		}else {
			int nuocnhapkhauid = Integer.parseInt(request.getParameter("nuocnhapkhauId"));
			float giaBan = Float.parseFloat(request.getParameter("giaban"));
			String tencf = request.getParameter("tenCF");
			cafedao.Them(nuocnhapkhauid, giaBan, tencf, ma);
			System.out.println("thêm cafe");
			response.sendRedirect("/22110372_DoPhuLuan/ds");
		}

	}

}
