<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Empleados</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>
<body>
<div class="container is-widescreen">
    <br/>
    <section class="hero is-link">
        <div class="hero-body">
            <p class="title">
                <%
                    int x = 100;
                    String nombre = "carlos";
                    List<String> nombres = Arrays.asList("pedro", "juan", "carlos");
                %>
                <h1><%= "El valor de x es " + x %></h1>
            </p>
            <p class="subtitle">
                <a href="hello-servlet">Hello Servlet <%= nombre %></a>
                <ul>
            <%
                for (int i = 0; i < nombres.size(); i++) {
                        %>
                        <li><%= nombres.get(i) %></li>
                        <%
                }
                for(String nom: nombres){
            %>
                        <li><%= nom %></li>
                    <%
                }
            %>
        </ul>
            </p>

            <form method="POST" action="EmployeeServlet">
                <label>Documento: <input type="text" id="doc" name="documento" placeholder="22222" />
                </label>
                <label>Nombre: <input type="text" name="nombre"></label>}
                <label>Fecha de nacimiento: <input type="date" name="fecha_nacimiento"></label>
                <input type="submit" value="enviar"/>
            </form>



        </div>
    </section>
</div>
</body>
</html>