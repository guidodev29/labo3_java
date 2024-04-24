
package com.mycompany.lab3mascotas.web;

import com.mycompany.lab3mascotas.dominio.Mascota;
import com.mycompany.lab3mascotas.servicios.IMascotaService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarMascotaPorTipo")
public class BuscarPorTipoServlet extends HttpServlet{
    
    @Inject 
    IMascotaService iMascotaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Mascota mascotaPorTipo = new Mascota();
        mascotaPorTipo.setTipo("Perro");
        
        Mascota mascota = iMascotaService.buscarPorTipo(mascotaPorTipo);
        
        request.setAttribute("mascota", mascota);
        request.getRequestDispatcher("/buscarMascotasPorTipo.jsp").forward(request, response);
    
    
    
}}
