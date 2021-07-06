package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
	HttpSession session;
	private static final long serialVersionUID = 1L;

    public ServletLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession(true);
		session.setAttribute("TipoLog", null);
		session.setAttribute("DNI", null);
		session.setAttribute("Usuario", null);
		response.sendRedirect("index.jsp");
	}

}
