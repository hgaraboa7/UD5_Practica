/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import controlador.factory.Conexion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.dao.ActividadDAO;
import modelo.dao.SocioDAO;
import modelo.vo.Socio;
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
    
    public static ActividadDAO actividad;
    
    public static DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
    public static Principal ventana = new Principal();
    
    public static void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
       ventana.getCbUsuarioActividad().setModel(modeloCombo);
    }
    public static void iniciarConexion() {
        conn=new Conexion();       
        //Inicia los DAO
      socio=Conexion.getSocioDAO();
      actividad=Conexion.getActividadDAO();
        
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
                socio.insertar(conn, 
                        ventana.getTxtDni().getText(), 
                         ventana.getTxtNombreSocio().getText(), 
                         ventana.getTxtFechaAlta().getText(), 
                         ventana.getTxtCuotaSocio().getText());
                
                JOptionPane.showMessageDialog(null, "socio insertado correctamente");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void cargarCombo() {
   
        try {
            socio.cargarcombo(conn,modeloCombo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en cargar combo");
        }
    
    }

    public static void buscarSocio() {
    
          if(ventana.getTxtDni().getText().isBlank()){
              System.out.println("campo vacio");
              return;
          }
           try {
            Document d=socio.buscarSocio(conn,ventana.getTxtDni().getText());
            if(d!=null){
                  Document socioDoc = d.get("socio", Document.class);
                System.out.println("ya existe");    
                
                ventana.getTxtNombreSocio().setText(socioDoc.getString("nombre"));
                ventana.getTxtFechaAlta().setText(socioDoc.getString("fecha_alta"));
                ventana.getTxtCuotaSocio().setText(socioDoc.getInteger("cuota").toString());                
            }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    public static void cargarSocio() {
   if(ventana.getCbUsuarioActividad().getSelectedItem()==null){
              System.out.println("campo vacio");
              return;
          }
           try {
               
           
                  Socio socioDoc = (Socio)ventana.getCbUsuarioActividad().getSelectedItem();
                System.out.println("ya existe");    
                
                ventana.getTxtDni().setText(socioDoc.getDni());
                ventana.getTxtNombreSocio().setText(socioDoc.getNombre());
                ventana.getTxtFechaAlta().setText(socioDoc.getFechaAlta());
                ventana.getTxtCuotaSocio().setText(String.valueOf(socioDoc.getCuota()));                
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void insertarActividad() {
  
        if(ventana.getCbUsuarioActividad().getSelectedItem()==null){
              System.out.println("campo vacio");
              return;
          }
           try {
           actividad.insertarActividad(conn,((Socio)ventana.getCbUsuarioActividad().getSelectedItem()).getDni(),
                   ventana.getTxtNombreActividad().getText(),
                   ventana.getCbTipoActividad().getSelectedItem().toString(),
                   ventana.getTxtFechaActividad().getText(),
                   ventana.getTxtProfesorActividad().getText(),
                   Integer.valueOf(ventana.getTxtDuracionActividad().getText())
                   
                   );
            
              
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}