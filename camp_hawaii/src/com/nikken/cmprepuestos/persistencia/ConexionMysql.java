package com.nikken.cmprepuestos.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionMysql {
	   
	   PreparedStatement stmt;
	   Statement scSQL;
	   ResultSet rs;
	   Connection con;
	   
	   String cadena;
	   String sDriver = ConstantesPersistencia.dirver_mysql;
	   String usu = ConstantesPersistencia.usuario_mysql;
	   String contra = ConstantesPersistencia.password_mysql;
	   
	   Boolean certif = false;
	   
	   public Boolean Execute (String Cadena,String db)
	   {
	       try
	       {
	    	   String sURL = "jdbc:mysql://"+ConstantesPersistencia.ip_intranet+"/"+db+""; 
	          cadena =Cadena;
	          Class.forName(sDriver).newInstance();
	          con = DriverManager.getConnection(sURL,usu ,contra);
	          stmt =con.prepareStatement(cadena);
	          stmt.executeUpdate();
	          certif = true;
	       }
	       catch(Exception e)
	       {
	           certif = false;
	           System.out.println("Error en la conexión tratando de ejecutar la siguiente sentencia :"+Cadena+" en la base de Datos "+db+" a causa de  :");
	           e.printStackTrace();
	       }
	   return certif;
	   }
	   
	   public ResultSet Consultar( String cadena, String db)
	   {
	       try
	       {
	    	   String sURL = "jdbc:mysql://"+ConstantesPersistencia.ip_intranet+"/"+db+""; 
	          Class.forName(sDriver).newInstance();
	          con = DriverManager.getConnection(sURL,usu ,contra);
	          scSQL = con.createStatement();
	          rs=scSQL.executeQuery(cadena);
	          
	       }
	       catch(Exception e)
	       {
	    	   System.out.println("Error en la conexión tratando de ejecutar la siguiente sentencia :"+cadena+" en la base de Datos "+db+" a causa de  :");
	           e.printStackTrace();
	       }
	       return rs;
	       
	   }
}
