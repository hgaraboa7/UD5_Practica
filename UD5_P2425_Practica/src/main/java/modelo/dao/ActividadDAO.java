/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import controlador.factory.Conexion;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author hector.garaboacasas
 */
public class ActividadDAO {

    public void insertarActividad(Conexion conn, String dni, String nombre, String tipo, String fecha, String monitor, Integer tiempo) {
  
        Bson filtro=Filters.eq("socio.dni",dni);
         
        Document actividad=new Document("nombre",nombre)
                .append("tipo", tipo)
                .append("fecha", fecha)
                .append("duracion", tiempo)
                .append("monitor", monitor);
        
        Bson pullEmpty = Updates.pull("actividades", new Document());
        conn.getColeccion("Empresa").updateOne(filtro, pullEmpty);
        
        Bson update=Updates.addToSet("actividades",actividad);
        
        conn.getColeccion("Empresa").updateOne(filtro, update);
                
        
        
    }
    
}
