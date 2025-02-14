package controlador.factory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import modelo.dao.SocioDAO;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Conexion extends DAOFactory{

    private static MongoClient Cliente;
    private static MongoDatabase BD;
    private static CodecRegistry pojoCodecRegistry;
    private static final String nameBD = "BD";//*******Indica la BD **************
    private static final String IP = "192.168.56.101";//*******Indica la IP ***************
    private static final int PORT = 27017;

  public Conexion() {
        try {
            Cliente = new MongoClient(IP, PORT);
            BD = Cliente.getDatabase(nameBD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos ");
        }

    }
    @Override
    public void Cerrar() {
        if (BD != null) {
            Cliente.close();
        }
    }
    @Override
    public MongoDatabase getBD() {
        return BD;
    }

    @Override
    public MongoCollection getColeccion(String nombre) {
        return BD.getCollection(nombre);
    }
 
     
    @Override
    public MongoDatabase ConectarconMapeo() {
        try {
            //Cuando usamos codec para mapear el modelo. El modelo lo tenemos que poner sin contructor.

            pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            Cliente = new MongoClient(IP,
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
            BD = Cliente.getDatabase(nameBD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos ");
        }
        return null;
    }

    @Override
    public CodecRegistry getRegistry() {
        return pojoCodecRegistry;
    }

    //Define los  métodos para los objetos dao
    public static SocioDAO getSocioDAO(){
        return new SocioDAO();
    }
    

}
