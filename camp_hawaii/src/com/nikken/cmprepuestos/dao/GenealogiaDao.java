package com.nikken.cmprepuestos.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nikken.cmprepuestos.model.Genealogia;
import com.nikken.cmprepuestos.persistencia.ConexionSql;
import com.nikken.cmprepuestos.persistencia.ConstantesPersistencia;

/**
 * @author fcordoba
 *
 */
public class GenealogiaDao {

	
	/**
	 * @param tipo_asesor
	 * @param tipo_genealogia
	 * @return
	 * 
	 * Obtiene los registros de la campaña de repuestos 
	 * del procedimiento almacenado;
	 */
	public static List<Genealogia> obtener_Genealogia (String tipo_asesor, String tipo_genealogia, String codigoABi){
		List<Genealogia> lista_resultado = new ArrayList<Genealogia>();
		ConexionSql cn = new ConexionSql();
		
		String sql_query = Procedimiento.consulta_sp_camprepuestos(tipo_asesor, tipo_genealogia , codigoABi);
		ResultSet ds =cn.Consulta(sql_query, ConstantesPersistencia.database_dwh, ConstantesPersistencia.ip_dwh);
		
		try{
			while(ds.next()){
				Genealogia obj = new Genealogia();
				obj.setNumero_registro(ds.getObject(1).toString());
				obj.setNivel_profundidad(ds.getObject(2).toString());
				obj.setId(ds.getObject(3).toString());
				obj.setNombre_asesor(ds.getObject(4).toString());
				obj.setTipo_asesor(ds.getObject(5).toString());
				obj.setTelefono(ds.getObject(6).toString());
				obj.setRango(ds.getObject(7).toString());
				obj.setCorreo(ds.getObject(8).toString());
				obj.setPais(ds.getObject(9).toString());
				obj.setEstado(ds.getObject(10).toString());
				obj.setPeriodo_1(ds.getObject(11).toString());
				obj.setPeriodo_2(ds.getObject(12).toString());
				lista_resultado.add(obj);
			}
			
		}catch(Exception ex){
			System.out.println("Error tratando de ejecutar la consulta "+sql_query +" a causa de : "+ ex.toString());
			ex.printStackTrace();
		}
		
		return lista_resultado;
	}
}
