package com.nikken.cmprepuestos.persistencia;

/**
 * Valores fijos de conexión a servidores de SQL server y MySQl
 * @author fcordoba
 *
 */
public class ConstantesPersistencia {

	// Hosts SQL Server
	public static final String ip_col="190.144.233.37";
	public static final String ip_cri="200.66.68.167";
	public static final String ip_ecu="200.66.68.167";
	public static final String ip_pan="200.66.68.167";
	public static final String ip_per="200.66.68.167";
	public static final String ip_dwh="200.66.68.167";
	public static final String ip_slv="200.66.68.169";
	public static final String ip_gtm="200.66.68.169";
	public static final String ip_mex="200.66.68.169";
	
	// Bases de datos Sql Server
	public static final String database_col ="NIKKENCOL";
	public static final String database_cri ="NIKKENCRI";
	public static final String database_ecu ="NIKKENECUT";
	public static final String database_pan ="NIKKENPAN";
	public static final String database_per ="NIKKENPER";
	public static final String database_slv ="NIKKENSLV";
	public static final String database_gtm ="NIKKENGTM";
	public static final String database_mex ="NIKKENMEX";
	public static final String database_dwh ="NIKKENDWH";
	public static final String database_reg ="NIKKENREG";
	
	//Credenciales Sql Server
	public static final String usuario_sql ="sa";
	public static final String password_sql ="B1Admin";
	
	//Sql Driver 
	public static final String dirver_sql = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	
	//Hosts My SQl
	public static final String ip_intranet ="200.66.68.174";
	
	//Bases de Datos My Sql
	public static final String database_intranet ="intralat";
	public static final String database_facturacion_web ="facturacion_web";
	
	//Credenciales Sql Server
	public static final String usuario_mysql ="root";
	public static final String password_mysql ="Jlpmx10";
	
	//My Sql Driver 
	public static final String dirver_mysql = "com.mysql.jdbc.Driver";
		
	
}
