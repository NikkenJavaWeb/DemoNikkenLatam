package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.SystemException;

import com.nikken.cmprepuestos.model.Genealogia;

/**
 * Servlet implementation class Descargar_Reporte
 */
public class Descargar_Reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Descargar_Reporte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(true);
		List<Genealogia> lst= new ArrayList<Genealogia>();
		lst=(List<Genealogia>)session.getAttribute("lstResultExcel");
		try {
			if(lst!=null){
				session.setAttribute("lstResultExcel",lst);
				response.sendRedirect("excelGenealogia.jsp");
			}else{
				session.setAttribute("lstResultExcel",null);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
