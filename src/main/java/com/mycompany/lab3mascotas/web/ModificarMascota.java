
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

@WebServlet("/modificarMascota")
public class ModificarMascota extends HttpServlet{
      
    @Inject 
    IMascotaService iMascotaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Mascota mascotaPaModificar = new Mascota();
        mascotaPaModificar.setId(13);  
        
        Mascota mascotaAModificar = iMascotaService.buscarPorId(mascotaPaModificar);
        
        mascotaAModificar.setNombre("Clarence");
        mascotaAModificar.setTipo("Perico");
        mascotaAModificar.setEdad(1);
       
        iMascotaService.modificarMascota(mascotaAModificar);

        request.setAttribute("mascotaAModificar", mascotaAModificar);

        request.getRequestDispatcher("/modificarMascota.jsp").forward(request, response);
    }
    
    
}
