/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import controlador.factory.Conexion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.vo.Socio;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author hector.garaboacasas
 */
public class SocioDAO {

    public Document buscarSocio(Conexion conn, String dni) {

        Bson filtro = Filters.eq("socio.dni", dni);

        FindIterable<?> iter = conn.getColeccion("Empresa").find(filtro);
        MongoCursor<?> cursor = iter.iterator();
        if (cursor.hasNext()) {
            return (Document) cursor.next();
        } else {
            return null;
        }

    }

    public void insertar(Conexion conn, String dni, String nombre, String fechaAlta, String cuota) {

        Document ult = (Document) conn.getColeccion("Empresa").find().sort(Sorts.descending("_id")).first();

        int id = 10 + ult.getInteger("_id");

        Document soc = new Document("_id", id);

        soc.append("socio", new Document()
                .append("nombre", nombre)
                .append("dni", dni)
                .append("fecha_alta", fechaAlta)
                .append("cuota", Integer.valueOf(cuota)));
        soc.append("actividades",new ArrayList<Document>());

        conn.getColeccion("Empresa").insertOne(soc);

    }

    public void cargarcombo(Conexion conn, DefaultComboBoxModel modeloCombo) {

        modeloCombo.removeAllElements();


        List<Document> salida = (List<Document>) conn.getColeccion("Empresa").find().into(new ArrayList<>());

        for (Document d : salida) {
            
           
            Document socio = (Document)d.get("socio");
            
            
            if(socio!=null){
                String nombreSocio=socio.getString("nombre");
                String dni=socio.getString("dni");
                String fechaAlta=socio.getString("fecha_alta");
                int cuota=socio.getInteger("cuota");
                
                Socio soc=new Socio(dni,nombreSocio,fechaAlta,cuota);
                
                
                modeloCombo.addElement(soc);
            }

           
        }

    }

    public Document buscarSocioNombre(Conexion conn, String nombre) {
   
            Bson filtro = Filters.eq("socio.nombre", nombre);

        FindIterable<?> iter = conn.getColeccion("Empresa").find(filtro);
        MongoCursor<?> cursor = iter.iterator();
        if (cursor.hasNext()) {
            return (Document) cursor.next();
        } else {
            return null;
        }
        
    }

    public void modificar(Conexion conn, Document d, String nombre, String fecha_alta, String dni, Integer cuota) {
        Document doc = new Document();

        doc.append("nombre", nombre) 
                .append("fecha_alta", fecha_alta)
                .append("cuota", cuota);

        conn.getColeccion("Empresa").updateOne(d, 
                new Document("$set", doc));     
        
        
      //  Bson act=Updates.combine(Updates);
  
    
    }

}
