<%-- 
    Document   : angkot
    Created on : Jul 26, 2017, 8:26:43 AM
    Author     : Taufik
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.AngkotModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Tabel Daftar Angkot Di Kota Bandung</h1>
         <table style="margin:20px auto;" border="1">
	<tr>
            <th>Id Angkot</th>
            <th>Nama Angkot</th>
            <th>Trayek</th>
	</tr>
        <%
            AngkotModel km = new AngkotModel();
            List<AngkotModel> data = new ArrayList<AngkotModel>();
            String ket = request.getParameter("ket");
            if (ket == null) {
                data = km.tampil();
            } 
            for (int x = 0; x < data.size(); x++) {
        %>
        <tr>
            <td><%=x + 1%></td>
            <td><%=data.get(x).getId_angkot()%></td>
            <td><%=data.get(x).getNama_angkot()%></td>
            <td><%=data.get(x).getKode_trayek()%></td>
            <td>
                <a href="angkot?proses=edit-angkot&id_angkot=<%=data.get(x).getId_angkot()%>">Edit</a>
                <a href="angkot?proses=hapus-angkot&id_angkot=<%=data.get(x).getId_angkot()%>">Hapus</a>
            </td>
        </tr>
        <%}%>
    </table>
       <center>
            <a class="tambah" href="angkot?proses=input-angkot">Tambah Angkot</a>
       </center>
    </body>
</html>
