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
import program.model.AngkotModel;

/**
 *
 * @author Taufik
 */
@WebServlet(name = "angkot", urlPatterns = {"/angkot"})
public class angkot extends HttpServlet {

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
        if (proses.equals("input-angkot")){
            response.sendRedirect("tambah_angkot.jsp");
        }else if(proses.equals("edit-angkot")){
            response.sendRedirect("edit_angkot.jsp?id_angkot="+request.getParameter("id_angkot"));
        }else if(proses.equals("hapus-angkot")){
            AngkotModel hm=new AngkotModel();
            int id_angkt;
            id_angkt = Integer.parseInt(request.getParameter("id_angkot"));
            hm.setId_angkot(id_angkt);
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
            if(data.equals("angkot")){
                 AngkotModel um=new AngkotModel();
                 um.setNama_angkot(request.getParameter("nama_angkot"));
                 um.setKode_trayek(request.getParameter("kode_trayek"));
                  if (proses.equals("input-angkot")){
                    um.simpan();
                  }else if (proses.equals("edit-angkot")){
                    int id_angkot = Integer.parseInt(request.getParameter("id_angkot"));
                    um.setId_angkot(id_angkot);
                    um.update();
                  } else if(proses.equals("hapus-angkot")){
                    um.hapus();
                  }
                  response.sendRedirect("angkot.jsp");
                 }
            }
        }
    }
