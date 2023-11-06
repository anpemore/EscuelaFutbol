/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelafutbol;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel Perez
 */
public class ModeloDeLaTabla {
     Object filas[][] = new Object[20][4];
     Object encabezado[]={"codigo","nombre","url","Accion"};
     JTable tablaLocal;
     public void crearModelo(JTable tabla,Conexion conexion,Connection con,String dato) throws SQLException{
         tablaLocal=tabla;
         tabla.setDefaultRenderer(Object.class,new Render());
         JButton btnVer =new JButton("ver");
         btnVer.setName("ver");
         
        //filas[][] = new Object[20][4];
         
         
        // ResultSet res=conexion.Consultar(con,dato);
         int i=0;
         if(dato.equals("")){
            LimpiarTabla();
         }
         else{
             ResultSet res=conexion.ConsultarJugador(con,dato);
             while(res.next()){
                 filas[i][0]=res.getString("idimagen");
                 filas[i][1]=res.getString("nomImagen");
                 filas[i][2]=res.getString("urlimagen");
                 filas[i][3]=btnVer;
                 //filas[i][2]=res.getString("papellido");
                 i++;
              }
         }   
         
         
         DefaultTableModel modelo = new DefaultTableModel
        (
                
               filas,
              encabezado
        )
        {
           @Override
           public boolean isCellEditable(int row,int column)
           {
               return false;
           }
        };
        tabla.setModel(modelo);
        tabla.setRowHeight(30);
     }
    public void LimpiarTabla(){
        System.out.println("limpiando tabla");
          int i=0;
             filas[i][0]="";
             filas[i][1]="";
             filas[i][2]="";
             filas[i][3]="";
             DefaultTableModel modelo = new DefaultTableModel(filas,encabezado);
             tablaLocal.setModel(modelo);
          
     }
}
