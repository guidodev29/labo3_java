package com.mycompany.lab3mascotas.dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT e FROM Mascota e ORDER BY e.nombre")
})

@Entity
public class Mascota implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmascota") //columna
    private int idmascota;
    
    
    private String nombre;
    private String tipo;
    private int edad;
    
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    private Dueno dueno;

    public Mascota() {
    }

    public Mascota(int idmascota, String nombre, String tipo, int edad) {
        this.idmascota = idmascota;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    public int getId() {
        return idmascota;
    }

    public void setId(int id) {
        this.idmascota = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void getEdad(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    
    
        
}
