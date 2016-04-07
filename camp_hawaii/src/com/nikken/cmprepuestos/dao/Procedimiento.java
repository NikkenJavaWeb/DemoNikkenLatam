package com.nikken.cmprepuestos.dao;

import java.net.UnknownHostException;

import com.nikken.cmprepuestos.util.Utilitario;

/**
 * @author fcordoba
 *
 */
public class Procedimiento {

	
	/**
	 * @param usuario
	 * @param contrasena
	 * Consulta de la campaña de repuestos
	 * @return
	 */
	public static String consulta_sp_camprepuestos(String tipoAsesor, String tipoGenealogia , String codigoABI){
		return "EXEC dbo.pCampHawaii '"+codigoABI+"', '"+tipoAsesor+"', '"+tipoGenealogia+"'";
	}
	
	/**
	 * @param codigo_abi
	 * @return
	 * Se ingresa en el sistema informacion de el comerciante que 
	 * esta accediendo a la aplicacion para realizar reporte. 
	 */
	public static String ingreso_acceso_camprepuestos(String codigo_abi , String ip){
		String query="";
		
		 try {
			query = "insert into camphawaii_accesos (codigo_abi,fecha_ingreso,hora,ip) "
					+ "values ('"+codigo_abi+"' , "
					+"'"+Utilitario.obtenerFechaActual()+"' , "
					+"'"+Utilitario.obtenerHoraActual()+"' , "
					+"'"+ip+"' ) ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return query;
	}
	
	
	
	
}
