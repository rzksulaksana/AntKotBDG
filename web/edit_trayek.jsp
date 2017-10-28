<%-- 
    Document   : edit_trayek
    Created on : Jul 26, 2017, 12:28:56 PM
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
        <form action="trayek?data=trayek&proses=edit-trayek" method="post">
            <table style="margin:20px auto;">
            <%
                int id_trayek = Integer.parseInt(request.getParameter("id_trayek"));
                TrayekModel km = new TrayekModel();
                km.setId_trayek(id_trayek);
                List<TrayekModel> data = new ArrayList<TrayekModel>();
                data = km.cariID(); 
                if (data.size() > 0) {
            %>
		<tr>
                    <td>Kode Trayek</td>
                    <td><input type="text" name="kode_trayek" value="<%=data.get(0).getKode_trayek()%>"></td>
		</tr>
                <tr>
                    <td>ID Jalan</td>
                    <td><input type="text" name="id_jalan" value="<%=data.get(0).getId_jalan()%>"></td>
                    <td><input type="hidden" name="id_trayek" value="<%=data.get(0).getId_trayek()%>"></td>
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
