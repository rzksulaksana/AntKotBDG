/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import program.model.UserModel;

/**
 *
 * @author Taufik
 */
@WebServlet(name = "user", urlPatterns = {"/user"})
public class user extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String proses=request.getParameter("proses");
        String action=request.getParameter("action");
        if (proses.equals("input-jalan")){
            response.sendRedirect("tambah_jalan.jsp");
        }else if(proses.equals("edit-jalan")){
            response.sendRedirect("edit_jalan.jsp?id_jalan="+request.getParameter("id_jalan"));
        }else if(proses.equals("hapus-jalan")){
            UserModel hm=new UserModel();
            int id_jln;
            id_jln = Integer.parseInt(request.getParameter("id_jalan"));
            hm.setId_jalan(id_jln);
            hm.hapus();
            response.sendRedirect("");
        }
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
        
        if (data != null){
            if(data.equals("user")){
                 UserModel um=new UserModel();
                 double latitude;
                 double longitude;
                 
                 latitude = Double.parseDouble(request.getParameter("latitude"));
                 longitude =Double.parseDouble(request.getParameter("longitude"));
                
                 um.setNama_Jalan(request.getParameter("nama_jalan"));
                 um.setLatitude(latitude);
                 um.setLongitude(longitude);
                  if (proses.equals("input-jalan")){
                       um.simpan();
                  }else if (proses.equals("edit-jalan")){
                    int id_jalan = Integer.parseInt(request.getParameter("id_jalan"));
                    um.setId_jalan(id_jalan);
                    um.update();
                  } else if(proses.equals("hapus-jalan")){
                    um.hapus();
                  }
                  response.sendRedirect("jalan.jsp");
                 }
            }
        }
    }
