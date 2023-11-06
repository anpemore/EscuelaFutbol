/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelafutbol;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel Perez
 */
public class modeDeTablaDos {
     String datos[]=new String[2];
     DefaultTableModel modelo=new DefaultTableModel();  
     JTable tablaImagen;
     public modeDeTablaDos(JTable tabla){
        tablaImagen= tabla;
        modelo.addColumn("Nombre");
        modelo.addColumn("Url");
        tabla.setModel(modelo);
        tabla.setModel(modelo);
        
     } 
   
     
     public void AddDatosAlaFilas(String url){
        datos[0]="Targeta de Identidad";
        datos[1]= url;       
        modelo.addRow(datos);      
     }
     
     public void DeleteFilas(int fila){
         if(fila>=0)
            modelo.removeRow(fila);            
     }
     
  /*   public void LimpiarTabla(){
        System.out.println("limpiando tabla");
          int i=0;
             filas[i][0]="";
             filas[i][1]="";
             filas[i][2]="";
             filas[i][3]="";
             DefaultTableModel modelo = new DefaultTableModel(filas,encabezado);
             tablaLocal.setModel(modelo);
          
     }*/
     
    public DefaultTableModel getTable(){
          return modelo;
     }
}
