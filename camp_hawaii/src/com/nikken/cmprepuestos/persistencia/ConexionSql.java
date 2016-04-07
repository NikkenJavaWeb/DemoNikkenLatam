package com.nikken.cmprepuestos.persistencia;

import java.sql.ResultSet;
import java.sql.Statement;



public class ConexionSql {
	
	private java.sql.Connection con = null;
	Statement stmt =null;
	ResultSet rs = null;
    private final String url = "jdbc:sqlserver://";
    private final String userName = ConstantesPersistencia.usuario_sql;
    private final String password = ConstantesPersistencia.password_sql;
    
    // Indica al controlador que debe utilizar un cursor de servidor, // lo que permite más de una instrucción activa // en una conexión.
    private final String selectMethod = "cursor";

    // Constructor public Connect(){}
    private String getConnectionUrl(String serverName, String databaseName) {
        return url + serverName + ";databaseName=" + databaseName + ";selectMethod=" + selectMethod + ";";
    }

    private java.sql.Connection getConnection(String serverName, String databaseName) {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(getConnectionUrl(serverName,databaseName), userName, password);
            if (con != null) {
                System.out.println("Conexión correcta.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
        }
        return con;
    }

    /* Mostrar las propiedades del controlador y los detalles de la base de datos */
    public void displayDbProperties(String serverName, String databaseName) {
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet rs = null;
        try {
            con = this.getConnection( serverName, databaseName);
            if (con != null) {
                dm = con.getMetaData();
                System.out.println("Información del controlador");
                System.out.println("\tNombre del controlador: " + dm.getDriverName());
                System.out.println("\tVersión del controlador: " + dm.getDriverVersion());
                System.out.println("\nInformación de la base de datos ");
                System.out.println("\tNombre de la base de datos: " + dm.getDatabaseProductName());
                System.out.println("\tVersión de la base de datos: " + dm.getDatabaseProductVersion());
                System.out.println("Catálogos disponibles ");
                rs = dm.getCatalogs();
                while (rs.next()) {
                    System.out.println("\tcatálogo: " + rs.getString(1));
                }
                rs.close();
                rs = null;
                closeConnection();
            } else {
                System.out.println("Error: No hay ninguna conexión activa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm = null;
    }

    private void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
        	System.out.println("Error en la conexión");
            e.printStackTrace();
        }
    }

    
    public boolean Execute (String Cadena,String database, String servername)
    {
    try
    {// Carga el driver sqljdbc 
       
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     
        con = this.getConnection(servername, database);
     
        stmt =con.createStatement();
       
        stmt.executeUpdate(Cadena);
     
        return true;
    }
    catch
    (Exception e)
    {
    	 System.out.println("Error en la conexión tratando de ejecutar la siguiente sentencia :"+Cadena+" en la base de Datos "+servername+"."+database+" a causa de  :");
         e.printStackTrace();
        return false;

    }
    }

    public ResultSet Consulta (String Cadena, String database, String servername)
    {
	    try
	    {
	    	con = this.getConnection(servername, database);
	    	String SQL =Cadena;
	    	stmt = con.createStatement();
	    	rs = stmt.executeQuery(SQL);
	    }
	    catch 
	    (Exception e){
	    	 System.out.println("Error en la conexión tratando de ejecutar la siguiente sentencia :"+Cadena+" en la base de Datos "+servername+"."+database+" a causa de  :");
	         e.printStackTrace();
	    }
	    return rs;
    }
}
