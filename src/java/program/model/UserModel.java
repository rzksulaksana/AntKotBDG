/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
/**
 *
 * @author Taufik
 */
public class UserModel {
   int id_jalan;
   String nama_jalan;
   double longitude;
   double latitude;

    public int getId_jalan() {
        return id_jalan;
    }

    public void setId_jalan(int id_jalan) {
        this.id_jalan = id_jalan;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
   Koneksi db = null;
       
    public UserModel() {
        db = new Koneksi();
    }
 
    public String getNama_Jalan() {
        return nama_jalan;
    }
 
    public void setNama_Jalan(String nama_jalan) {
        this.nama_jalan = nama_jalan;
    }
 
    
    public List tampil() {
        List<UserModel> data = new ArrayList<UserModel>();
        ResultSet rs = null;
 
        try {
            String sql = "select * from tjalan order by id_jalan asc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                UserModel um = new UserModel();
                um.setId_jalan(rs.getInt("id_jalan"));
                um.setNama_Jalan(rs.getString("nama_jalan"));
                um.setLatitude(rs.getDouble("latitude"));
                um.setLongitude(rs.getDouble("longitude"));
                data.add(um);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data jalan" + ex);
        }
        return data;
    } 
    
    public void simpan(){
        String sql="INSERT INTO tjalan values(null,'"+nama_jalan+"','"+latitude+"','"+longitude+"')";
        db.simpanData(sql);
    }
        
    public void update(){
        String sql="UPDATE tjalan SET nama_jalan='"+nama_jalan+"',latitude='"+latitude+"',longitude='"+longitude+"' WHERE id_jalan='"+id_jalan+"'";
        db.simpanData(sql);
    }
    
    public List cariID() {
        List<UserModel> data = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from tjalan where id_jalan='"+id_jalan+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                UserModel m = new UserModel();
                m.setId_jalan(rs.getInt("id_jalan"));
                m.setNama_Jalan(rs.getString("nama_jalan"));
                m.setLatitude(rs.getDouble("latitude"));
                m.setLongitude(rs.getDouble("longitude"));
                data.add(m);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan" + ex);
        }
        return data;
    }
    public void hapus(){
        String sql="DELETE FROM tjalan WHERE id_jalan='"+id_jalan+"'";
        db.simpanData(sql);
    }
}
