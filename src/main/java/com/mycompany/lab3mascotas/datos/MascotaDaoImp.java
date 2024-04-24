package com.mycompany.lab3mascotas.datos;

import com.mycompany.lab3mascotas.dominio.Mascota;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class MascotaDaoImp implements IMascotaDao {
    
    @PersistenceContext(unitName = "MascotaMA")
    EntityManager em;

    @Override
    public List<Mascota> buscarMascotas() {
        TypedQuery<Mascota> q = em.createQuery("SELECT e FROM Mascota e ORDER BY e.idmascota", Mascota.class);
        return q.getResultList();
        //return em.createNamedQuery("Mascotas.findAll").getResultList();
    }

    @Override
    public Mascota buscarPorId(Mascota mascota) {
        return em.find(Mascota.class, mascota.getId());
    }

    @Override
    public Mascota buscarPorTipo(Mascota mascota) {
        Query q = em.createQuery("select e from Mascota e where e.tipo=:tipo");
        q.setParameter("tipo", mascota.getTipo());
        List<Mascota> resultado = q.getResultList();
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void insertarMascota(Mascota mascota) {
        em.persist(mascota);
    }

    @Override
    public void modificarMascota(Mascota mascota) {
        em.merge(mascota);
    }

    @Override
    public void eliminarMascota(Mascota mascota) {
        em.remove(em.merge(mascota));
    }
    
}
