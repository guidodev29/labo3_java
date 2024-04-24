
package com.mycompany.lab3mascotas.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Dueno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddueno")
    private int iddueno;
    
    private String nombre;
    private String apellido;
    private int edad;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idmascota")
    private Mascota mascota;

    public Dueno() {
    }

    public Dueno(int iddueno, String nombre, String apellido, int edad) {
        this.iddueno = iddueno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getIddueno() {
        return iddueno;
    }

    public void setIddueno(int iddueno) {
        this.iddueno = iddueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
    
    
    
}
