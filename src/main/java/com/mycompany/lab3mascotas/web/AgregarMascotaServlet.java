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

@WebServlet("/agregarMascota")
public class AgregarMascotaServlet extends HttpServlet {
    
    @Inject 
    IMascotaService iMascotaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Mascota nvaMascota = new Mascota();
        nvaMascota.setNombre("Kitty");
        nvaMascota.setTipo("Gato");
        nvaMascota.setEdad(2);
        
        iMascotaService.insertarMascota(nvaMascota);
        Mascota buscarNvaMascota = iMascotaService.buscarPorTipo(nvaMascota);
        request.setAttribute("nuevaMascota", buscarNvaMascota);
        request.getRequestDispatcher("/mascotaYaAgregada.jsp").forward(request, response);
    }
    
}
