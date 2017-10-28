<%-- 
    Document   : trayek
    Created on : Jul 26, 2017, 12:06:34 PM
    Author     : Taufik
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.TrayekModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <h1>Tabel Daftar Trayek Angkot Di Kota Bandung</h1>
         <table style="margin:20px auto;" border="1">
	<tr>
            <th>Id Trayek</th>
            <th>Trayek</th>
            <th>ID Jalan</th>
            <th>Action</th>
	</tr>
        <%
            TrayekModel km = new TrayekModel();
            List<TrayekModel> data = new ArrayList<TrayekModel>();
            String ket = request.getParameter("ket");
            if (ket == null) {
                data = km.tampil();
            } 
            for (int x = 0; x < data.size(); x++) {
        %>
        <tr>
            <td><%=data.get(x).getId_trayek()%></td>
            <td><%=data.get(x).getKode_trayek()%></td>
            <td><%=data.get(x).getId_jalan()%></td>
            <td>
                <a href="trayek?proses=edit-trayek&id_trayek=<%=data.get(x).getId_trayek()%>">Edit</a>
                <a href="trayek?proses=hapus-trayek&id_trayek=<%=data.get(x).getId_trayek()%>">Hapus</a>
            </td>
        </tr>
        <%}%>
    </table>
       <center>
            <a class="tambah" href="trayek?proses=input-trayek">Tambah Trayek</a>
       </center>
    </body>
</html>
