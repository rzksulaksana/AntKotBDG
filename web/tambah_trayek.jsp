<%-- 
    Document   : tambah_trayek
    Created on : Jul 26, 2017, 12:28:45 PM
    Author     : Taufik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <center><h1>Input Trayek</h1></center>
        <form action="trayek?data=trayek&proses=input-trayek" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <td>Kode Trayek</td>
                    <td><input type="text" name="kode_trayek"></td>
		</tr>
		<tr>
                    <td>Id Jalan</td>
                    <td><input type="text" name="id_jalan"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
		</tr>
            </table>
	</form>	
    </body>
</html>
