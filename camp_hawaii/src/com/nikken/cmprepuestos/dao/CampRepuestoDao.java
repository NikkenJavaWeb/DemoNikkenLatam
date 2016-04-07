package com.nikken.cmprepuestos.dao;

import com.nikken.cmprepuestos.persistencia.ConexionSql;
import com.nikken.cmprepuestos.persistencia.ConstantesPersistencia;

/**
 * @author fcordoba
 *
 */
public class CampRepuestoDao {
	
	/**
	 * @param codigo_abi
	 * @return
	 * 
	 * Procedimiento que almacena en el sistema la informacion del comerciante
	 * devuelve verdad o falso si realiza el ingreso en el sistema
	 */
	public static boolean ingreso_informacion_acceso(String  codigo_abi , String ip){
		ConexionSql cn = new ConexionSql();
		String sql_query = Procedimiento.ingreso_acceso_camprepuestos(codigo_abi , ip);
		return cn.Execute(sql_query, ConstantesPersistencia.database_dwh, ConstantesPersistencia.ip_dwh);
	}

}
