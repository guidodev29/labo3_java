
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
        segundaParteCascada();
    }  
    
    private static void segundaParteCascada(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MascotaMA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Mascota mascota = new Mascota();
        mascota.setNombre("Ramon");
        mascota.setTipo("Cerdo");
        mascota.setEdad(4);
        
        Dueno dueno = new Dueno();
        dueno.setNombre("Amilcar");
        dueno.setApellido("Gonzalez");
        dueno.setEdad(21);
        
        // Establecer la relación entre Mascota y Dueno
        dueno.setMascota(mascota);
        mascota.setDueno(dueno);
        
        em.persist(dueno);
        tx.commit();
        
        System.out.println("\nDueño y mascota agregados con Exito");
    }
}
