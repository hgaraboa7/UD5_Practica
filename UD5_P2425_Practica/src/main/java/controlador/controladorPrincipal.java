/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import controlador.factory.Conexion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.dao.SocioDAO;
import org.bson.Document;

import vista.Principal;

/**
 *
 * @author Acceso a datos
 */
public class controladorPrincipal {
    public static Conexion conn;
    //Declara los DAO
  
    public static SocioDAO socio;
    
    public static DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
    public static Principal ventana = new Principal();
    
    public static void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
       
    }
    public static void iniciarConexion() {
        conn=new Conexion();       
        //Inicia los DAO
      socio=Conexion.getSocioDAO();
        
    }
    public static void cerrarConexion() {
        conn.Cerrar();       
    }

    public static void insertarSocio() {
   
        if(ventana.getTxtDni().getText().isBlank()||
                ventana.getTxtNombreSocio().getText().isBlank()||
                ventana.getTxtFechaAlta().getText().isBlank()||
                ventana.getTxtCuotaSocio().getText().isBlank()){
            JOptionPane.showMessageDialog(null, "faltan datos");
            return;
        }
        try {
            Document d=socio.buscarSocio(conn,ventana.getTxtDni().getText());
            if(d!=null){
                JOptionPane.showMessageDialog(null, "ya existe");
                return;
            }else{
                JOptionPane.showMessageDialog(null, "NO existe");
                return;
            }
            
            
            
        } catch (Exception e) {
        }
        
    }

}