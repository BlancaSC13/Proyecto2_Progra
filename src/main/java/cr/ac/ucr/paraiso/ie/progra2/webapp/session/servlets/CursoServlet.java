package cr.ac.ucr.paraiso.ie.progra2.webapp.session.servlets;


import cr.ac.ucr.paraiso.ie.progra2.webapp.session.models.Curso;
import cr.ac.ucr.paraiso.ie.progra2.webapp.session.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.jdom2.DataConversionException;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CursoService service = new CursoServiceImp();
        List<Curso> cursos = null;
        try {
            cursos = service.listar();
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = req.getSession();
        SessionService getSession = new SessionServiceImp();
        Optional<String> sessionOptional = getSession.getUser(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Listado de Cursos</title>");
            out.println("    </head>");
            out.println("    <body>");
            if(sessionOptional.isPresent()) {
                out.println("        <h1>Listado de Cursos!</h1>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>id</th>");
                out.println("<th>Nombre</th>");
                out.println("<th>Carrera</th>");
                out.println("<th>Semestre</th>");
                out.println("</tr>");
                cursos.forEach(c -> {
                    out.println("<tr>");
                    out.println("<td>" + c.getId() + "</td>");
                    out.println("<td>" + c.getNombre() + "</td>");
                    out.println("<td>" + c.getCarrera() + "</td>");
                    out.println("<td>" + c.getSemestre() + "</td>");
                    out.println("</tr>");
                });
                out.println("</table>");
                if (session.getAttribute("role").equals("Admin")) {
                    out.println("        <p><a href=\"/session-webapp/admin.html\">Menu</a></p>");
                }else{
                    out.println("        <p><a href=\"/session-webapp/index.html\">Menu</a></p>");
                }
            }else{
                out.println("        <h1>Debe hacer login para ver los cursos!</h1>");
                out.println("        <p><a href=\"/session-webapp/login.html\">Login</a></p>");
            }
            out.println("    </body>");
            out.println("</html>");
        }
    }

}
