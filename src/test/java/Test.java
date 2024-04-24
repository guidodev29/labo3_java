
import com.mycompany.lab3mascotas.dominio.Dueno;
import com.mycompany.lab3mascotas.dominio.Mascota;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;

public class Test {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        //segundaParteCascada();
        //modificarDuenoYmascota();
        //modificarDueno();
        //eliminarDueno();
    }  
    
    private static void segundaParteCascada(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MascotaMA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Mascota mascota = new Mascota();
        mascota.setNombre("Blue");
        mascota.setTipo("Guacamaya");
        mascota.setEdad(1);
        
        Dueno dueno = new Dueno();
        dueno.setNombre("Linda");
        dueno.setApellido("Ruiz");
        dueno.setEdad(21);
        
        // Establecer la relación entre Mascota y Dueno
        dueno.setMascota(mascota);
        mascota.setDueno(dueno);
        
        em.persist(dueno);
        tx.commit();
        
        System.out.println("\nDueño y mascota agregados con Exito");
    }
    
    private static void modificarDuenoYmascota() {
    // ID del dueño que deseas modificar
    int idDueno = 3;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MascotaMA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    try {
        tx.begin();

        // Buscar el dueño por su ID
        Dueno dueno = em.find(Dueno.class, idDueno);
        if (dueno != null) {
            // Modificar los datos del dueño
            dueno.setNombre("Linda Estela");
            dueno.setApellido("de Ruiz");
            dueno.setEdad(30);
            
            // Obtener la mascota del dueño
            Mascota mascota = dueno.getMascota();
            if (mascota != null) {
                // Modificar los datos de la mascota
                mascota.setNombre("Bigotes");
                mascota.setTipo("Conejo");
                mascota.setEdad(2);
            }
        } else {
            System.out.println("No se encontró al dueño con ID: " + idDueno);
        }

        tx.commit();
        System.out.println("Dueño y mascota modificados con éxito");
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        System.out.println("Error al modificar dueño y mascota: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
}
    
    private static void modificarDueno() {
    int idDueno = 3;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MascotaMA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    try {
        tx.begin();

        Dueno dueno = em.find(Dueno.class, idDueno);
        if (dueno != null) {
            dueno.setNombre("Rina");
            dueno.setApellido("Ochaco");
            dueno.setEdad(30);
        } else {
            System.out.println("No se encontró al dueño con ID: " + idDueno);
        }

        tx.commit();
        System.out.println("Dueño modificado con éxito");
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        System.out.println("Error al modificar dueño: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
}

    private static void eliminarDueno() {
    int idDueno = 3;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MascotaMA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();

        // Buscar al dueño por su ID
        Dueno dueno = em.find(Dueno.class, idDueno);
        if (dueno != null) {
            // Eliminar al dueño
            em.remove(dueno);
        } else {
            System.out.println("No se encontró al dueño con ID: " + idDueno);
        }

        tx.commit();
        System.out.println("Dueño eliminado con éxito");
    } catch (Exception e) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        System.out.println("Error al eliminar dueño: " + e.getMessage());
    } finally {
        em.close();
        emf.close();
    }
}

}
