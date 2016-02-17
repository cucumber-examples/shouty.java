package shouty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShoutyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<table>");
		response.getWriter().println("<thead>");
		response.getWriter().println("<tr><th>item</th><th>amount</th></tr>");
		response.getWriter().println("</thead>");
		response.getWriter().println("<tbody>");
		response.getWriter().println("<tr><td>apples</td><td>3</td></tr>");
		response.getWriter().println("<tr><td>cucumbers</td><td>99</td></tr>");
		response.getWriter().println("<tr><td>steak</td><td>5</td></tr>");
		response.getWriter().println("</tbody>");
		response.getWriter().println("</table>");
	}
}
