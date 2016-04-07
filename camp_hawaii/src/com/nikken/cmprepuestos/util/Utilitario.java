package com.nikken.cmprepuestos.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utilitario  {
	
	public static String format$(String value){
		String result="";
		try{
		
		double val = Double.parseDouble(value);
		
		DecimalFormat  _num= new DecimalFormat("##,###.00");
		result=_num.format(val);
		if(result.equals(".00") || result.equals("0")){
			result="0.00";
		}
		
		}catch(Exception ex){
			System.out.println("error format "+ex.toString());
		}
		return result;
	}
	
	public static String obtenerFechaActual(){
		String fecha = "";
		Calendar cl = new GregorianCalendar();
		int a = cl.get(Calendar.YEAR);
		int m = cl.get(Calendar.MONTH)+1;
		int d = cl.get(Calendar.DAY_OF_MONTH);
		
		String dia = ""+d;
		String mes = ""+m;
		
		if(dia.length()==1){
			dia="0"+d;
		}
		
		if(mes.length()==1){
			mes="0"+m;
		}
		
		fecha = a+mes+dia;
		
		return fecha;
	}
	
	public static String obtenerFechaActual_formato(){
		String fecha = "";
		Calendar cl = new GregorianCalendar();
		int a = cl.get(Calendar.YEAR);
		int m = cl.get(Calendar.MONTH)+1;
		int d = cl.get(Calendar.DAY_OF_MONTH);
		
		String dia = ""+d;
		String mes = validarMes(m);
		
		if(dia.length()==1){
			dia="0"+d;
		}
		
		fecha = mes+" "+dia +" , "+a;
		
		return fecha;
	}
	
	public static String obtenerHoraActual(){
		String hora_sistema = "";
		Calendar cl = new GregorianCalendar();
		int h = cl.get(Calendar.HOUR_OF_DAY);
		int m = cl.get(Calendar.MINUTE);
		
		String hora = ""+h;
		String minuto = ""+m;
		
		if(hora.length()==1){
			hora="0"+h;
		}
		
		if(minuto.length()==1){
			minuto="0"+m;
		}
		
		hora_sistema = hora+":"+minuto;
		
		return hora_sistema;
	}
	
	public static String obtener_ip() throws UnknownHostException{
		InetAddress localHost = InetAddress.getLocalHost();
		return  localHost.getHostName() + " - "+  localHost.getHostAddress();
		
	}
	
	public static void main (String [] args) throws UnknownHostException{
		System.out.println(obtener_ip());
		System.out.println(obtenerFechaActual());
		System.out.println(obtenerHoraActual());
	}
	 	
 	
 	public static String validarMes(int m){
 		String mes="";
 		switch(m){
 		case 1:
 			mes="ENERO";
 			break;
 		case 2:
 			mes="FEBRERO";
 			break;
 		case 3:
 			mes="MARZO";
 			break;
 		case 4:
 			mes="ABRIL";
 			break;
 		case 5:
 			mes="MAYO";
 			break;
 		case 6:
 			mes="JUNIO";
 			break;
 		case 7:
 			mes="JULIO";
 			break;
 		case 8:
 			mes="AGOSTO";
 			break;
 		case 9:
 			mes="SEPTIEMBRE";
 			break;
 		case 10:
 			mes="OCTUBRE";
 			break;
 		case 11:
 			mes="NOVIEMBRE";
 			break;
 		case 12:
 			mes="DICIEMBRE";
 			break;
 		}
 		return mes;
 	}
 	
 
 	
 	
 	
 	 
 	
}
