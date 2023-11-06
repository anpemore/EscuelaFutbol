/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelafutbol;

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Angel Perez
 */
public class Conexion {
    ResultSet res;
    Connection con;
    Statement st=null;
    
    String url = "jdbc:mysql://localhost:3307/escuela";
    String usuario="root";
    String pass="";
    String driver="com.mysql.cj.jdbc.Driver";
  
    
    
    public Connection Conectar()
  {      
    
    
     try
     {
        System.out.println("datos entregados  ");
        Class.forName(driver);
        con=DriverManager.getConnection(url,usuario,pass);
        JOptionPane.showMessageDialog(null,"Exelente la conexion OK");
    
     }
     catch (ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null,"Error en la conexion con la Base de Datos  "+e.getMessage());
        return null;
     }
     return con;
  }
    
     public void ActualizarDatos(String sql,Connection con){       
       try{         
           st = con.createStatement();
           st.executeUpdate(sql);
           
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error Producido en la funcion "+e);
          
        }
   }
     
     public ResultSet ConsultarJugador(Connection co,String dato)
       throws SQLException{
        PreparedStatement pstmt;
        try
        {     
           //pstmt = co.prepareStatement("select * FROM estudiante INNER JOIN imagen ON estudiante.numeroid=imagen.idForengImagen");
           pstmt = co.prepareStatement("select * FROM imagen where idForenImagen="+dato+"");
           
            res = pstmt.executeQuery();
           // while(res.next())
           //     System.out.println(res.getString("papellido"));
        }
          catch(SQLException e){JOptionPane.showMessageDialog(null, "Error en la funcion ConsultarJugador "+e);}
     return res;

   }
     public ResultSet Consultar(Connection co,String dato)
      {
        PreparedStatement pstmt;
        try
        {     
            pstmt = co.prepareStatement("select * FROM estudiantes where pnombre like'"+dato+"%'");
            res = pstmt.executeQuery();
          
        }
          catch(SQLException e){JOptionPane.showMessageDialog(null, " **** Error en la funcion ConsultarEstudiante"+e);}
     return res;

   }
    public void getAniversario(Connection co){
        
        Calendar fecha = Calendar.getInstance();     
        int mesA = fecha.get(Calendar.MONTH) + 1;
        int diaA = fecha.get(Calendar.DAY_OF_MONTH);     
        PreparedStatement pstmt;
        try
        {     
            pstmt = co.prepareStatement("Select pnombre,snombre,papellido,sapellido,dia,mes from estudiantes INNER JOIN fechas ON estudiantes.identificacion=fechas.idestudiante");
            res = pstmt.executeQuery();
           while(res.next()){             
              if(mesA-(Integer.parseInt(res.getString("mes")))== 0 && diaA-(Integer.parseInt(res.getString("dia")))==0)
              {
                 JOptionPane.showMessageDialog(null, "Hoy esta de Cumple Años "+res.getString("pnombre")+" "+ res.getString("papellido"));
              } 
           }    
        }
          catch(SQLException e)
          {
              JOptionPane.showMessageDialog(null, "Error en la funcion getAniversario");
          }
        
    }  
     
     
     public int NumeroFilas(String sql){       
        int i=0;
        PreparedStatement pstmt;
        try
        {     
            pstmt = con.prepareStatement("SELECT COUNT(*) from estudiantes where estudiante.numeroid <> '';");
            res = pstmt.executeQuery();
            while(res.next())
                 i=res.getRow();
        }
          catch(SQLException e){JOptionPane.showMessageDialog(null, "**** Error en la funcion NumeroFilas  "+e);}
        return i;
     }
}
