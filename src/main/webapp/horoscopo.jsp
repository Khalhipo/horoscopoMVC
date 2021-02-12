<%-- 
    Document   : horoscopo
    Created on : 11-feb-2021, 12:59:21
    Author     : Bueno
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        

        <%
            ArrayList<String> meses = (ArrayList<String>) request.getAttribute("meses");
            ArrayList<String> dias = (ArrayList<String>) request.getAttribute("dias");

            String nombreSel = (String) request.getAttribute("nombreSel");
            nombreSel = nombreSel != null ? nombreSel : "";
            String diaSel = (String) request.getAttribute("diaSel");
            String mesSel = (String) request.getAttribute("mesSel");
            String signo = (String) request.getAttribute("signo") != null ? (String) request.getAttribute("signo") : "";

        %>

        <div class="card w-25 p-3 text-center">
            <h1>Horóscopo</h1>
            <div class="card-header">
                Zodiaco
            </div>
            <div class="card-body">

                <form action="horoscopo" method="post">
                    <label for="nombre">Nombre: </label><input type="text" name="nombre" id="nombre" placeholder="Nombre" value="<%= nombreSel%>"><br>
                    <label for="mes">Mes nacimiento: </label><select name="mes" id="mes">
                        <% for (String m : meses) {
                                String textoSelected = "";
                                if (m.equals(mesSel)) {
                                    textoSelected = "selected";
                                }
                        %>
                        <option <%= textoSelected%> value="<%= m%>"><%= m%></option>
                        <% }%>
                    </select><br>
                    <label for="dia">Día nacimiento: </label><select name="dia" id="dia">
                        <% for (String d : dias) {
                                String textoSelected = "";
                                if (d.equals(diaSel)) {
                                    textoSelected = "selected";
                                }
                        %>
                        <option <%= textoSelected%> value="<%= d%>"><%= d%></option>
                        <% }%>
                    </select><br>
                    <input class="btn btn-info" type="submit" value="Signo">
                </form>
            </div>
            <div class="card-footer text-muted">
                <p><%= signo%></p>
            </div>
        </div>
    </body>
</html>
