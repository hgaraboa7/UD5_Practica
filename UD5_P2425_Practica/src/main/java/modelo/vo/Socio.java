/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

/**
 *
 * @author hector.garaboacasas
 */
public class Socio {
    
    public String dni;
    public String nombre;
    public String fechaAlta;
    public int cuota;

    public Socio(String dni, String nombre, String fechaAlta, int cuota) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return  nombre ;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }
    
    
    
}
