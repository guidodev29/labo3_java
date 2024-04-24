package com.mycompany.lab3mascotas.web;

import com.mycompany.lab3mascotas.dominio.Mascota;
import com.mycompany.lab3mascotas.servicios.IMascotaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mascotas")
public class MascotaServlet extends HttpServlet {
    
    @Inject 
    IMascotaService iMascotaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mascota> mascotas = iMascotaService.buscarMascotas();
        System.out.println("Mascotas: " + mascotas);
        request.setAttribute("mascotas", mascotas);
        request.getRequestDispatcher("/listadoMascotas.jsp").forward(request, response);
    }
}
