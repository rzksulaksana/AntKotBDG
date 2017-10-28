<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.UserModel"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <center><h1>Tabel Daftar Jalan Di Kota Bandung</h1></center>
  <table style="margin:20px auto;" border="1">
	<tr>
            <th>No</th>
            <th>ID</th>
            <th>Nama</th>
            <th>Latitude</th>
            <th>Longitude</th>
            <th>Action</th>
	</tr>
        <%
            UserModel km = new UserModel();
            List<UserModel> data = new ArrayList<UserModel>();
            String ket = request.getParameter("ket");
            if (ket == null) {
                data = km.tampil();
            } 
            for (int x = 0; x < data.size(); x++) {
        %>
        <tr>
            <td><%=x + 1%></td>
            <td><%=data.get(x).getId_jalan()%></td>
            <td><%=data.get(x).getNama_Jalan()%></td>
            <td><%=data.get(x).getLatitude()%></td>
            <td><%=data.get(x).getLongitude()%></td>
            <td>
                <a href="user?proses=edit-jalan&id_jalan=<%=data.get(x).getId_jalan()%>">Edit</a>
                <a href="user?proses=hapus-jalan&id_jalan=<%=data.get(x).getId_jalan()%>">Hapus</a>
            </td>
        </tr>
        <%}%>
    </table>
       <center>
            <a class="tambah" href="user?proses=input-jalan">Tambah Jalan</a>
       </center>
    </body>
</html>