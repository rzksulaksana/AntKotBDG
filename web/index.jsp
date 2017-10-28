<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <title>Cari Angkot</title>
    </head>
    <body>
    <center><h1>Pencarian Rute Terpendek Dengan Algoritma Ant Colony</h1></center>
        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <form action="antcol?data=antcol&proses=perhitungan-antcol" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <div class="form-group">
                        <td><label for="lokasi_asal">Lokasi Asal</label></td>
                       <td>
                            
                        <select class="form-control" name="lokasi_asal">
                            <%
                                UserModel km = new UserModel();
                                List<UserModel> data = new ArrayList<UserModel>();
                                String ket = request.getParameter("ket");
                                if (ket == null) {
                                    data = km.tampil();
                                } 
                                for (int x = 0; x < data.size(); x++) {
                            %>
                                
                                 <option value="<%=data.get(x).getId_jalan()%>"><%=data.get(x).getNama_Jalan()%></option>
                            <%}%>
                        </select>
                       </td>
                    </div>
		</tr>
		<tr>
                    <div class="form-group">
                    <td><label for="lokasi_tujuan">Lokasi Tujuan</label></td>
                    <td>
                        <select  class="form-control" name="lokasi_tujuan">
                            <%
                                UserModel hm = new UserModel();
                                List<UserModel> dat = new ArrayList<UserModel>();
                                String kete = request.getParameter("kete");
                                if (kete == null) {
                                    dat = km.tampil();
                                } 
                                for (int x = 0; x < dat.size(); x++) {
                            %>  
                            <option value="<%=dat.get(x).getId_jalan()%>"><%=dat.get(x).getNama_Jalan()%></option>
                            <%}%>
                        </select>
                    </td>
                    </div>
		</tr>
		<tr>
                    <td></td>
                    <td>
                        <br>
                    <input class="btn" type="submit" value="Cari Rute">
                    </td>
		</tr>
            </table>
	</form>	
    </body>
</html>
