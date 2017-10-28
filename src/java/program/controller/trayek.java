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
import program.model.TrayekModel;

/**
 *
 * @author Taufik
 */
@WebServlet(name = "trayek", urlPatterns = {"/trayek"})
public class trayek extends HttpServlet {

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
        if (proses.equals("input-trayek")){
            response.sendRedirect("tambah_trayek.jsp");
        }else if(proses.equals("edit-trayek")){
            response.sendRedirect("edit_trayek.jsp?id_trayek="+request.getParameter("id_trayek"));
        }else if(proses.equals("hapus-trayek")){
            TrayekModel hm=new TrayekModel();
            int id_tryk;
            id_tryk = Integer.parseInt(request.getParameter("id_trayek"));
            hm.setId_trayek(id_tryk);
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
            if(data.equals("trayek")){
                 TrayekModel um=new TrayekModel();
                 um.setKode_trayek(request.getParameter("kode_trayek"));
                  if (proses.equals("input-trayek")){
                    int id_jln = Integer.parseInt(request.getParameter("id_jalan"));
                    um.setId_jalan(id_jln);
                    um.simpan();
                  }else if (proses.equals("edit-trayek")){
                    int id_tryk = Integer.parseInt(request.getParameter("id_trayek"));
                    int id_jln = Integer.parseInt(request.getParameter("id_jalan"));
                    um.setId_trayek(id_tryk);
                    um.setId_jalan(id_jln);
                    um.update();
                  } else if(proses.equals("hapus-trayek")){
                    um.hapus();
                  }
                  response.sendRedirect("trayek.jsp");
                 }
            }
        }
    }

