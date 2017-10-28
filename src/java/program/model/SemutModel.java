package program.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SemutModel {
    int id_jarak;
    int jalan_asal;
    int jalan_tujuan;
    int jml_jalan;
    double jarak;
    String lokasi_asal;
    String lokasi_tujuan;
    int id_trayek;
    String kode_trayek;
    int id_jalan;
    String latitude;
    String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public String getLokasi_tujuan() {
        return lokasi_tujuan;
    }

    public void setLokasi_tujuan(String lokasi_tujuan) {
        this.lokasi_tujuan = lokasi_tujuan;
    }

    public String getLokasi_asal() {
        return lokasi_asal;
    }

    public void setLokasi_asal(String lokasi_asal) {
        this.lokasi_asal = lokasi_asal;
    }
    
    public int getId_jarak() {
        return id_jarak;
    }

    public void setId_jarak(int id_jarak) {
        this.id_jarak = id_jarak;
    }

    public int getJalan_asal() {
        return jalan_asal;
    }

    public void setJalan_asal(int jalan_asal) {
        this.jalan_asal = jalan_asal;
    }

    public int getJalan_tujuan() {
        return jalan_tujuan;
    }

    public void setJalan_tujuan(int jalan_tujuan) {
        this.jalan_tujuan = jalan_tujuan;
    }

    public int getJml_jalan() {
        return jml_jalan;
    }

    public void setJml_jalan(int jml_jalan) {
        this.jml_jalan = jml_jalan;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }
    
    Koneksi db = null;
    public SemutModel() {
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
    
    public Integer jml_jalan() throws SQLException{
        String sql="Select * from tjalan";
        ResultSet rs = null;
        rs = db.ambilData(sql);
        while (rs.next()) {
            jml_jalan++;
        }
        return jml_jalan;
    }
    public List AmbilJarak(){
        List<SemutModel> point = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from jarak order by jalan_asal";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setId_jarak(rs.getInt("id_jarak"));
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setJarak(rs.getDouble("jarak"));
                point.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
        return point;
    }
    public List trayek1(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek1";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    
    public List trayek2(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek2";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    
    public List trayek3(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek3";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    
    public List trayek4(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek4";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    
    public List trayek5(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek5";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    public List trayek6(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek6";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
    
     public List trayek7(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek7";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
     
     public List trayek8(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek8";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
     
     public List trayek9(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek9";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
     public List trayek10(){
        List <SemutModel> tampung = new ArrayList<>();
        
        ResultSet rs = null;
        try {
            String sql = "select jalan_asal,jalan_tujuan,kode_trayek from trayek10";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setJalan_asal(rs.getInt("jalan_asal"));
                m.setJalan_tujuan(rs.getInt("jalan_tujuan"));
                m.setKode_trayek(rs.getString("kode_trayek"));
                tampung.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan data jarak" + ex);
        }
       
        return tampung;
    }
     
    public List Cek_Trayek(int [] jal){
        List <String> trayek = new ArrayList<>();
        
        List <Integer> jalur = new ArrayList<>();
        
        List <SemutModel> tryk1_tamp = new ArrayList<>();
        List <SemutModel> tryk2_tamp = new ArrayList<>();
        List <SemutModel> tryk3_tamp = new ArrayList<>();
        List <SemutModel> tryk4_tamp = new ArrayList<>();
        List <SemutModel> tryk5_tamp = new ArrayList<>();
        List <SemutModel> tryk6_tamp = new ArrayList<>();
        List <SemutModel> tryk7_tamp = new ArrayList<>();
        List <SemutModel> tryk8_tamp = new ArrayList<>();
        List <SemutModel> tryk9_tamp = new ArrayList<>();
        List <SemutModel> tryk10_tamp = new ArrayList<>();
        
        List<List<SemutModel>> All_Trayek = new ArrayList<List<SemutModel>>();
        
        tryk1_tamp = trayek1();
        tryk2_tamp = trayek2();
        tryk3_tamp = trayek3();
        tryk4_tamp = trayek4();
        tryk5_tamp = trayek5();
        tryk6_tamp = trayek6();
        tryk7_tamp = trayek7();
        tryk8_tamp = trayek8();
        tryk9_tamp = trayek9();
        tryk10_tamp = trayek10();
        
        int ctr=0;
        int ctr2;
        int ctr_leng=0;
        int cari=0;
        
        while(ctr_leng<jal.length){
            if(jal[ctr_leng]!=0){
                jalur.add(jal[ctr_leng]);
            }
            ctr_leng++;
        }
        
        All_Trayek.add(tryk1_tamp);
        All_Trayek.add(tryk2_tamp);
        All_Trayek.add(tryk3_tamp);
        All_Trayek.add(tryk4_tamp);
        All_Trayek.add(tryk5_tamp);
        All_Trayek.add(tryk6_tamp);
        All_Trayek.add(tryk7_tamp);
        All_Trayek.add(tryk8_tamp);
        All_Trayek.add(tryk9_tamp);
        All_Trayek.add(tryk10_tamp);
        
        ctr2 = ctr+1;
        if(!All_Trayek.isEmpty()){
            for(int i = 0;i<All_Trayek.size();i++){
                for(int j=0;j<All_Trayek.get(i).size();j++){
                       if(jalur.get(ctr)==All_Trayek.get(i).get(j).getJalan_asal()){
                          if(ctr2<jalur.size()){
                                if(jalur.get(ctr2) == All_Trayek.get(i).get(j).getJalan_tujuan()){
                                    cari++;
                                    ctr++;
                                    ctr2++;
                                }
                           }
                        }
                }
                if((jalur.size()-1)==cari){
                    trayek.add(All_Trayek.get(i).get(cari).getKode_trayek());
                    cari=0;
                }/*else if(cari<(jalur.size()-1)&&cari>0){
                    trayek.add(All_Trayek.get(i).get(cari).getKode_trayek());
                    ctr=cari;
                    ctr2=cari+1;
                }*/
            }
        }
        
       return trayek;
    }
    
    public List LatLong(int id_jalan){
        List <SemutModel> koordinat = new ArrayList();
        ResultSet rs = null;
        try {
            String sql = "select latitude,longitude from tjalan where id_jalan = '"+id_jalan+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                SemutModel m = new SemutModel();
                m.setLatitude(rs.getString("latitude"));
                m.setLongitude(rs.getString("longitude"));
                koordinat.add(m);
            }
            db.diskonek(rs);
        } catch (SQLException ex) {
            System.out.println("Terjadi Kesalah Saat mencari Koordinat" + ex);
        }
        return koordinat;
    }
  
}
