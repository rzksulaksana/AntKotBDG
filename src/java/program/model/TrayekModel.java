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
public class TrayekModel {
   int id_trayek;
   String kode_trayek;
   int id_jalan;
   
     
   Koneksi db = null;
   public TrayekModel() {
        db = new Koneksi();
    }
   
    public int getId_trayek() {
        return id_trayek;
    }

    public void setId_trayek(int id_trayek) {
        this.id_trayek = id_trayek;
    }

    public String getKode_trayek() {
        return kode_trayek;
    }

    public void setKode_trayek(String kode_trayek) {
        this.kode_trayek = kode_trayek;
    }

    public int getId_jalan() {
        return id_jalan;
    }

    public void setId_jalan(int id_jalan) {
        this.id_jalan = id_jalan;
    }
   
   
   public List tampil() {
        List<TrayekModel> data = new ArrayList<TrayekModel>();
        ResultSet rs = null;
 
        try {
            String sql = "select * from ttrayek order by id_trayek asc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                TrayekModel um = new TrayekModel();
                um.setId_trayek(rs.getInt("id_trayek"));
                um.setKode_trayek(rs.getString("kode_trayek"));
                um.setId_jalan(rs.getInt("id_jalan"));
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data trayek" + ex);
        }
        return data;
    }
    
    public void simpan(){
        String sql="INSERT INTO ttrayek values(null,'"+kode_trayek+"','"+id_jalan+"')";
        db.simpanData(sql);
    }
    
     public void update(){
        String sql="UPDATE ttrayek SET kode_trayek='"+kode_trayek+"',id_jalan='"+id_jalan+"' WHERE id_trayek='"+id_trayek+"'";
        db.simpanData(sql);
    }
     
     public List cariID() {
        List<TrayekModel> data = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from ttrayek where id_trayek='"+id_trayek+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                TrayekModel m = new TrayekModel();
                m.setId_trayek(rs.getInt("id_trayek"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                m.setId_jalan(rs.getInt("id_jalan"));
                data.add(m);
 
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data trayek" + ex);
        }
        return data;
    }
    public void hapus(){
        String sql="DELETE FROM ttrayek WHERE id_trayek='"+id_trayek+"'";
        db.simpanData(sql);
    }
}
