
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

@WebServlet("/buscarMascotaPorId")
public class BuscarPorIdServlet extends HttpServlet{
    
    @Inject 
    IMascotaService iMascotaService;
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Mascota mascotaPorId = new Mascota();
        mascotaPorId.setId(10);
        
        Mascota mascota = iMascotaService.buscarPorId(mascotaPorId);
        
        request.setAttribute("mascota", mascota);
        request.getRequestDispatcher("/buscarMascotasPorId.jsp").forward(request, response);
    }
    
    
    
}
