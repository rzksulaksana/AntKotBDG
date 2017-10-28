package program.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taufik
 */
public class AngkotModel {
   int id_angkot;
   String nama_angkot;
   String kode_trayek;
    
   Koneksi db = null;
   public AngkotModel() {
        db = new Koneksi();
    }
   
    public int getId_angkot() {
        return id_angkot;
    }

    public void setId_angkot(int id_angkot) {
        this.id_angkot = id_angkot;
    }

    public String getNama_angkot() {
        return nama_angkot;
    }

    public void setNama_angkot(String nama_angkot) {
        this.nama_angkot = nama_angkot;
    }

    public String getKode_trayek() {
        return kode_trayek;
    }

    public void setKode_trayek(String kode_trayek) {
        this.kode_trayek = kode_trayek;
    }
    
    
     public List tampil() {
        List<AngkotModel> data = new ArrayList<AngkotModel>();
        ResultSet rs = null;
 
        try {
            String sql = "select * from tangkot order by id_angkot asc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                AngkotModel um = new AngkotModel();
                um.setId_angkot(rs.getInt("id_angkot"));
                um.setNama_angkot(rs.getString("nama_angkot"));
                um.setKode_trayek(rs.getString("kode_trayek"));
                data.add(um);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data angkot" + ex);
        }
        return data;
    }
    
    public void simpan(){
        String sql="INSERT INTO tangkot values(null,'"+nama_angkot+"','"+kode_trayek+"')";
        db.simpanData(sql);
    }
    
    public void update(){
        String sql="UPDATE tangkot SET nama_angkot='"+nama_angkot+"',kode_trayek='"+kode_trayek+"' WHERE id_angkot='"+id_angkot+"'";
        db.simpanData(sql);
    }
     
     public List cariID() {
        List<AngkotModel> data = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from tangkot where id_angkot='"+id_angkot+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                AngkotModel m = new AngkotModel();
                m.setId_angkot(rs.getInt("id_angkot"));
                m.setNama_angkot(rs.getString("nama_angkot"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                data.add(m);
            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data angkot" + ex);
        }
        return data;
    }
    public void hapus(){
        String sql="DELETE FROM tangkot WHERE id_angkot='"+id_angkot+"'";
        db.simpanData(sql);
    }
}
