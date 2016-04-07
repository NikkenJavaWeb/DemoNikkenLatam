<%
List<Genealogia>lstR= new ArrayList<Genealogia>();
lstR=(List<Genealogia>)session.getAttribute("lstResultExcel");
if(lstR!=null){
response.setContentType ("application/vnd.ms-excel"); //Tipo de fichero.
response.setHeader ("Content-Disposition", "attachment;filename=\"Reporte_Hawaii_2016 -"+Utilitario.obtenerFechaActual_formato()+" - "+Utilitario.obtenerHoraActual()+".xls\"");
String pathInfo =(request.getRequestURL()).toString();
String[] pat = pathInfo.split("/");
String reqst=pat[0]+"//"+pat[2]+"/"+pat[3]+"/images/NIKKEN3.png";
%>
<%@include file="importacion.jsp"%>
<br></br>
<table>
	<tr>
	<td><img src="<%=reqst%>" style="width:5%"/><br></td><td></td><td></td>
	<td style="font-weight: bolder;"><p ><% out.println("Informe Hawaii 2016");%></p></td>
	</tr>
</table>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>

<table border="1">
   	<tr>
	 <td style="background:#e5f1f4; font-weight: bold; text-align: center;">No.</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Nivel</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Código</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Nombre</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Tipo Asesor</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Telefono</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Rango</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Correo</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">País</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Estado</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">VP Marzo/16</td>
     <td style="background:#e5f1f4; font-weight: bold; text-align: center;">Requisito 1000 VP</td>
     
 </tr>
   							
	<%
	for(Genealogia obj : lstR){
		%>
		<tr>
			<td><%=obj.getNumero_registro() %></td>
			<td><%=obj.getNivel_profundidad() %></td>
			<td><%=obj.getId() %></td>
			<td><%=obj.getNombre_asesor() %></td>
			<td><%=obj.getTipo_asesor() %></td>
			<td><%=obj.getTelefono() %></td>
			<td><%=obj.getRango() %></td>
			<td><%=obj.getCorreo()%></td>
			<td><%=obj.getPais() %></td>
			<td><%=obj.getEstado()%></td>
			<td><%=obj.getPeriodo_1() %></td>
			<td><%=obj.getPeriodo_2() %></td>
		</tr>
		<%
	}
	session.setAttribute("lstResultExcel",null);
}%>
</table>