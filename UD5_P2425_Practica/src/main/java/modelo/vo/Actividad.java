/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

/**
 *
 * @author hector.garaboacasas
 */
public class Actividad {
    private String nombre;
    private String tipo;
    private String fecha;
    private int duracion;
    private String monitor;

    public Actividad(String nombre, String tipo, String fecha, int duracion, String monitor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.monitor = monitor;
    }
    @Override
    public String toString() {
        return nombre + ", fecha=" + fecha ;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
    
    
    
}
