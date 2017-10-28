<%-- 
    Document   : edit_angkot
    Created on : Jul 26, 2017, 9:06:18 AM
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
        <form action="angkot?data=angkot&proses=edit-angkot" method="post">
            <table style="margin:20px auto;">
            <%
                int id_angkot = Integer.parseInt(request.getParameter("id_angkot"));
                AngkotModel km = new AngkotModel();
                km.setId_angkot(id_angkot);
                List<AngkotModel> data = new ArrayList<AngkotModel>();
                data = km.cariID(); 
                if (data.size() > 0) {
            %>
		<tr>
                    <td>Nama Angkot</td>
                    <td><input type="text" name="nama_angkot" value="<%=data.get(0).getNama_angkot()%>"></td>
		</tr>
		<tr>
                    <td>Kode Trayek</td>
                    <td><input type="text" name="kode_trayek" value="<%=data.get(0).getKode_trayek()%>"></td>
                    <td><input type="hidden" name="id_angkot" value="<%=data.get(0).getId_angkot()%>"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
		</tr>
                  <%}%>
            </table>
	</form>	
    </body>
</html>
