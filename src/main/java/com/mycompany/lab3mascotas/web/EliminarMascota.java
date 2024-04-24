
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

@WebServlet("/eliminarMascota")
public class EliminarMascota extends HttpServlet{
    @Inject 
    IMascotaService iMascotaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mascota mascotaEliminar = new Mascota();
        mascotaEliminar.setId(8);
        request.setAttribute("mascotaEliminadaID", mascotaEliminar.getId());
        Mascota mascotaAEliminar = iMascotaService.buscarPorId(mascotaEliminar);
        iMascotaService.eliminarMascota(mascotaAEliminar);
        request.getRequestDispatcher("/eliminarMascota.jsp").forward(request, response);
    }
}
