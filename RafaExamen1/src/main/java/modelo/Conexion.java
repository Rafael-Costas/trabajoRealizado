package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	

		 static String bd = "sakila";
		   static String login = "root";
		   static String password = "";
		   static String url = "jdbc:mysql://localhost/"+bd;

		   Connection conn = null;

		   /** Constructor de DbConnection */
		   public Conexion() {
		      try{
		         //obtenemos el driver de para mysql
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         //obtenemos la conexi�n
		         conn = DriverManager.getConnection(url,login,password);

		         if (conn!=null){
		            System.out.println("Conecci�n a base de datos "+bd+" OK");
		         }
		      }
		      catch(SQLException e){
		         System.out.println(e);
		      }catch(ClassNotFoundException e){
		         System.out.println(e);
		      }catch(Exception e){
		         System.out.println(e);
		      }
		   }
		   /**Permite retornar la conexi�n*/
		   public Connection getConnection(){
		      return conn;
		   }

		   public void desconectar(){
		      conn = null;
		   }

		}

