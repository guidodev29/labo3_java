package com.mycompany.lab3mascotas.datos;

import com.mycompany.lab3mascotas.dominio.Mascota;
import java.util.List;

public interface IMascotaDao {
    
    public List<Mascota> buscarMascotas();
    public Mascota buscarPorId(Mascota mascota);
    public Mascota buscarPorTipo(Mascota mascota);
    public void insertarMascota(Mascota mascota);
    public void modificarMascota(Mascota mascota);
    public void eliminarMascota(Mascota mascota);
    
}
