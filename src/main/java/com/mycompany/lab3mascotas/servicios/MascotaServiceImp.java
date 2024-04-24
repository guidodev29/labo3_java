package com.mycompany.lab3mascotas.servicios;

import com.mycompany.lab3mascotas.datos.IMascotaDao;
import com.mycompany.lab3mascotas.dominio.Mascota;
import java.util.List;
import javax.inject.Inject;


public class MascotaServiceImp implements IMascotaService{

    @Inject
    private IMascotaDao iMascota;
    
    @Override
    public List<Mascota> buscarMascotas() {
        return iMascota.buscarMascotas();
    }

    @Override
    public Mascota buscarPorId(Mascota mascota) {
        return iMascota.buscarPorId(mascota);
    }

    @Override
    public Mascota buscarPorTipo(Mascota mascota) {
        return iMascota.buscarPorTipo(mascota);
    }

    @Override
    public void insertarMascota(Mascota mascota) {
        iMascota.insertarMascota(mascota);
    }

    @Override
    public void modificarMascota(Mascota mascota) {
        iMascota.modificarMascota(mascota);
    }

    @Override
    public void eliminarMascota(Mascota mascota) {
        iMascota.eliminarMascota(mascota);
    }
    
}
