<%-- 
    Document   : tambah_angkot
    Created on : Jul 26, 2017, 9:12:50 AM
    Author     : Taufik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
          <center><h1>Input Angkot</h1></center>
        <form action="angkot?data=angkot&proses=input-angkot" method="post">
            <table style="margin:20px auto;">
		<tr>
                    <td>Nama Angkot</td>
                    <td><input type="text" name="nama_angkot"></td>
		</tr>
		<tr>
                    <td>Kode Trayek</td>
                    <td><input type="text" name="kode_trayek"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Tambah"></td>
		</tr>
            </table>
	</form>	
    </body>
</html>
