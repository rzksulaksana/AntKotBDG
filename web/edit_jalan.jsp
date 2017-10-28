<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="program.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="user?data=user&proses=edit-jalan" method="post">
            <table style="margin:20px auto;">
            <%
                int id_jalan = Integer.parseInt(request.getParameter("id_jalan"));
                UserModel km = new UserModel();
                km.setId_jalan(id_jalan);
                List<UserModel> data = new ArrayList<UserModel>();
                data = km.cariID(); 
                if (data.size() > 0) {
            %>
		<tr>
                    <td>Nama Jalan</td>
                    <td><input type="text" name="nama_jalan" value="<%=data.get(0).getNama_Jalan()%>"></td>
		</tr>
		<tr>
                    <td>Latitude</td>
                    <td><input type="text" name="latitude" value="<%=data.get(0).getLatitude()%>"></td>
                    
		</tr>
                <tr>
                    <td>Longitude</td>
                    <td><input type="text" name="longitude" value="<%=data.get(0).getLongitude()%>"></td>
                    <td><input type="hidden" name="id_jalan" value="<%=data.get(0).getId_jalan()%>"></td>
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
