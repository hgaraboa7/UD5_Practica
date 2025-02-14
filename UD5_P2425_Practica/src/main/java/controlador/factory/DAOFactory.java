/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.factory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;


/**
 *
 * @author Acceso a datos
 */
public abstract class DAOFactory {
    //Definimos los métodos para trabajar con la conexión 
    public abstract void Cerrar();
    public abstract MongoDatabase getBD();
    public abstract MongoCollection getColeccion(String nombre);
    //Estos dos últimos métodos son para el caso de hacer un mapeo a mongo. 
    public abstract MongoDatabase ConectarconMapeo();
    public abstract CodecRegistry getRegistry();
    
    //Definimos los métodos para trabajar con los DAO
    
    //public abstract DepartamentoDAO getDepartamentoDAO();
    
   
}
