/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import controlador.factory.Conexion;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author hector.garaboacasas
 */
public class SocioDAO {

    public Document buscarSocio(Conexion conn, String dni) {
  
        Bson filtro=Filters.eq("socio.dni",dni);
        
        FindIterable<?>iter=conn.getColeccion("Empresa").find(filtro);
        MongoCursor<?>cursor=iter.iterator();
        if(cursor.hasNext()){
            return (Document) cursor.next();
        }else{
            return null;
        }
        
    }

    public void insertar(Conexion conn, String dni, String nombre, String fechaAlta, String cuota) {
   
    }
    
}
