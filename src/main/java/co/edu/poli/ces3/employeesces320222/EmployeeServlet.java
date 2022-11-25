package co.edu.poli.ces3.employeesces320222;

import co.edu.poli.ces3.employeesces320222.dao.Employee;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Employee e = this.getBody(request);
        out.print("<ol>");
        out.print("<li>Cedula:"+e.getDocumento()+" </li>");
        out.print("<li>Nombre: "+e.getNombre()+"</li>");
        out.print("<li>Fecha de nacimeinto: "+e.getFecha_nacimiento()+"</li>");
        out.print("</ol>");
    }


    public static Employee getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        Gson j = new Gson();

        return j.fromJson(body, Employee.class);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<ol>");
        out.print("<li>Cedula:"+request.getParameter("documento")+" </li>");
        out.print("<li>Nombre: "+request.getParameter("nombre")+"</li>");
        out.print("<li>Fecha de nacimeinto: "+request.getParameter("fecha_nacimiento")+"</li>");
        out.print("</ol>");
    }
}
