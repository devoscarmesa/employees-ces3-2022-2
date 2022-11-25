package co.edu.poli.ces3.employeesces320222;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String nombre = request.getParameter("nombre");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.print("query: " + nombre);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<ol>");
        out.print("<li>Cedula: </li>");
        out.print("<li>Nombre: </li>");
        out.print("<li>Fecha de nacimeinto: </li>");
        out.print("</ol>");
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}