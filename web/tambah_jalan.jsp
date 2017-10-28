<%-- 
    Document   : tambah_jalan
    Created on : Jul 19, 2017, 7:42:46 PM
    Author     : Taufik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <center><h1>Input Jalan</h1></center>
        <form action="user?data=user&proses=input-jalan" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <td>Nama Jalan</td>
                    <td><input type="text" name="nama_jalan"></td>
		</tr>
		<tr>
                    <td>Latitude</td>
                    <td><input type="text" name="latitude"></td>
		</tr>
                <tr>
                    <td>Longitude</td>
                    <td><input type="text" name="longitude"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
		</tr>
            </table>
	</form>	
    </body>
</html>