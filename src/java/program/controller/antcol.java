package program.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import program.model.SemutModel;

/**
 *
 * @author Taufik
 */
@WebServlet(name = "antcol", urlPatterns = {"/antcol"})
public class antcol extends HttpServlet {
   
    int temp;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");
        String nextPage = null;

        if(data!=null){
            if (proses.equals("perhitungan-antcol")){
                int asal;
                int tujuan;
                int []tampung;
                
                SemutModel s=new SemutModel();//deklarasi model Semut               
                /*pengambilan lokasi asal dan lokasi tujuan dari form index.jsp*/
                s.setLokasi_asal(request.getParameter("lokasi_asal"));//mengambil data lokasi asal dari form jsp
                s.setLokasi_tujuan(request.getParameter("lokasi_tujuan"));//mengambil data lokasi tujuan dari form jsp
                asal =  Integer.parseInt(s.getLokasi_asal());
                tujuan = Integer.parseInt(s.getLokasi_tujuan());
                
                try {
                    temp = s.jml_jalan();
                } catch (SQLException ex) {
                    Logger.getLogger(antcol.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                antTSP anttsp = new antTSP();
                List <String> hasil = new ArrayList();
                
                List <Integer> tamp = new ArrayList();
                
                anttsp.graf();
                tampung =anttsp.solve(asal,tujuan);
             
                
                if(tampung==null){
                    response.sendRedirect("nofound.jsp");
                }else{
                    for(int l=0;l<tampung.length;l++){
                        if(tampung[l]!=0){
                            tamp.add(tampung[l]);
                        }
                    }
                    
                    hasil =s.Cek_Trayek(tampung);
                    request.setAttribute("hasil",hasil);
                    request.setAttribute("asal",asal);
                    request.setAttribute("tujuan",tujuan);
                    request.setAttribute("tamp",tamp);

                    nextPage = "/hasil.jsp";
                    RequestDispatcher rd=request.getRequestDispatcher(nextPage);
                    rd.forward(request, response);
                }
            }   
        }
    }
}