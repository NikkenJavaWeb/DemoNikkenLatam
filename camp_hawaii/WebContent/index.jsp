<%@include file="importacion.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <link href="css/datatable/jquery-ui-1.8.22.custom.css" rel="stylesheet"/>
	   	<link href="css/datatable/jquery.dataTables.css" rel="stylesheet" />
	   	<link href="css/datatable/demo_table.css" rel="stylesheet" />
	   	<link href="css/datatable/demo_table_jui.css" rel="stylesheet" />
	</head>
	<body id="page5">
		
		
	 <%
	 	String codigoCi = request.getParameter("ci");
	 	String nombreCi = request.getParameter("name");
	 	
	 	
	 %>
		<div class="body1">
            <div class="body2">
                <div class="body5">
                    <div class="main">
                        <!-- header -->
						<header>
							<div class="wrapper">
			                	<h1><a href="index.jsp" id="logo">NIKKEN LATINOAMERICA</a></h1>
			                     <% Utilitario.obtenerHoraActual(); %>
			                     <nav> 
			                     	<ul id="menu"> 
			                     		<li >
			                     			<a> HAWAII 2016
			                            		<span> SEGUIMIENTO 1000 DE VP MARZO/16 <br/> </span>
			                                </a>
			                            </li>
									</ul>
			                   </nav>
							</div>
						</header>
			            <!-- header end-->
                    </div>
                </div>
            </div>
		</div>
		<div class="body3">
			<div class="main">
			<!-- content -->
			<article id="content">
				<h2 class="under">Bienvenido(a): <%=nombreCi %> <br> </h2>
				<div class="wrapper pad_bot1">
					<div style=" margin-bottom: 7px;"><h6>Este reporte muestra los volúmenes personales al cierre del mes de 
					Marzo de 2016, donde podrás revisar que Asesores de Bienestar cumplieron con el requisito previo para 
					entrar a calificar a la convocatoria para el Viaje Incentivo Hawaii 2016.</h6></div>
					<span><h6>Para este reporte, se toman los filtros combinados. <br/>
					Por favor seleccione el tipo de Genealogia y Requisito que desee consultar </h6>
					</span>
				</div>
				<fieldset style="width:78%;margin-top: 2%;">
					<legend style="margin-left:7%;    " ><h6>Filtros</h6></legend>
						<form method ="post" action="">
						<input type="hidden" id="ip_visitante" name="ip_vis"/>
						<script src="http://www.searchnc.com/cgi-bin/myip.pl"></script>
						<script type="text/javascript">
							var c = IP;
							document.getElementById("ip_visitante").value=c;
						</script>
						
						<div style="margin-left:15%">
							<table style="width: 70%;">
								<tr>
									<td><p>1000 de VP Marzo</p></td>
									<td>
										<select name="tipo_asesor" style="width: 100%;border: 1px solid #458701;height: 32px;border-radius: 10px;">
											<option value="ALL"> Todos </option>
											<option value="SI"> Si Cumplió</option>
											<option value="NO"> No Cumplió</option>
										</select>
									</td>
									<td rowspan="2">
										<img src="images/seacr_g.png" style="    width: 48%;   margin-left: 100%;   cursor: pointer;" onclick="consultar()"/>
										<img id="cargando" src="images/cargando.gif" style="    position: absolute;   margin-top: -12%;   margin-left: 30%;   width: 17%;"/>
									</td>
								</tr>
								<tr>
									<td><p>Tipo de Genealogía</p></td>
									<td>
										<select name="tipo_genealogia" style="width: 100%;border: 1px solid #458701;height: 32px;border-radius: 10px;">
											<option value="ALL"> Todos </option>
											<option value="GP"> Grupo Personal</option>
										</select>
									</td>
								</tr>
							</table>
							<script>
								function consultar(){
									document.getElementById("cargando").style.display="block";
									document.getElementById("enviar").click();
								}
							</script>
							<div style="display:none;">
								<input type="submit" id="enviar" name="consulta"/>
							</div>
						</div>
					</form>
				</fieldset>
				<%
				if(request.getParameter("consulta")!=null){
					String ip = request.getParameter("ip_vis");
					String tipo_asesor = request.getParameter("tipo_asesor");
					String tipo_genealogia = request.getParameter("tipo_genealogia");
					List<Genealogia> list = new ArrayList<Genealogia>();
					
					if(codigoCi!=null){
				 		boolean ingresar_datos = CampRepuestoDao.ingreso_informacion_acceso(codigoCi,ip);
				 	}
					
					list = GenealogiaDao.obtener_Genealogia(tipo_asesor, tipo_genealogia, codigoCi);
					session.setAttribute("lstResultExcel", list);
				%>
				<fieldset style="width:70%">
					<legend style="margin-left:4%;" ><h6>Resultados</h6></legend>
					<table id="mi_tabla" style="width: 170%;    ">
						<thead>
       		    			<tr>
         		 				<th>No.</th>
              					<th>Nivel</th>
              					<th>Código</th>
              					<th><div>Nombre</div></th>
              					<th>Tipo A.</th>
              					<th>Telefono</th>
              					<th>Correo</th>
              					<th>VP Marzo/16</th>
              					<th>Requisito 1000 VP</th>
              					<th>Rango</th>
              					<th>País</th>
              					<th>Estado</th>
             				</tr>
         				</thead>
   						<tbody>
   							
   								<%
   									for(Genealogia obj : list){
   										%>
   										<tr>
   											<td><%=obj.getNumero_registro() %></td>
   											<td><%=obj.getNivel_profundidad() %></td>
   											<td><%=obj.getId() %></td>
   											<td><%=obj.getNombre_asesor() %></td>
   											<td><%=obj.getTipo_asesor() %></td>
   											<td><%=obj.getTelefono() %></td>
   											<td><%=obj.getCorreo()%></td>
   											<td><%=obj.getPeriodo_1() %></td>
   											<td><%=obj.getPeriodo_2() %></td>
   											<td><%=obj.getRango() %></td>
   											<td><%=obj.getPais() %></td>
   											<td><%=obj.getEstado()%></td>
   										</tr>
   										<%
   									}
   								%>
   						</tbody>
					</table>
					<a style="margin-left: 55%;" href="Descargar_Reporte">Descargar Resultados<img src="images/excelicon.png" /></a>
				</fieldset>	
				<%} %>				
			</article>
			</div>
	    </div>
		
		
		<div class="main">
	        <!-- footer -->
			<footer>
		        <p>Desarrollado por: Tecnologías de la Información.</p>
		           Nikken Latinoamérica
		            <br/>
			</footer>
	        <!-- footer end -->
        </div>
		<script type="text/javascript" src="js/jquery-1.6.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/Swis721_Cn_BT_400.font.js"></script>
        <script type="text/javascript" src="js/Swis721_Cn_BT_700.font.js"></script>
        <script type="text/javascript" src="js/tabs.js"></script> 
		
		<!-- =========================
		     SCRIPTS 
		============================== -->
		<script>
    		document.getElementById("cargando").style.display="none";
    	</script>
		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    	<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	 	<script type="text/javascript" >
   			 $("#mi_tabla").dataTable({
    			"bJQueryUI": true,
   	    		"iDisplayLength": 10,
   	        	"scrollCollapse": true,
   	    		"aaSorting": [],
   	    		"sScrollX":"599px",
   	    	    "sScrollCollapse": true,
   	    	    "pagingType": "simple_numbers",
   	    	 	"ordering":  true,
   	      		"aoColumns": [{ "sWidth": "6%" }, 
   	      		              { "sWidth": "6%" }, 
   	      		              { "sWidth": "7%" }, 
   	      		              { "sWidth": "79%" }, 
   	      		              { "sWidth": "25%" }, 
   	      		              { "sWidth": "10%" }, 
   	      		              { "sWidth": "2%" }, 
   	      		              { "sWidth": "5%" }, 
   	      		              { "sWidth": "10%"},
   	      		         	  { "sWidth": "5%"},
   	      		         	  { "sWidth": "5%"},
   	      		         	  { "sWidth": "5%"}]
    		});
  		</script>
  		
		<script type="text/javascript" src="js/jquery-1.6.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/Swis721_Cn_BT_400.font.js"></script>
        <script type="text/javascript" src="js/Swis721_Cn_BT_700.font.js"></script>
        <script type="text/javascript" src="js/tabs.js"></script> 
	</body>
</html>