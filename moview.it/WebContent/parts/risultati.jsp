<%@page import="java.util.ArrayList"%>
<%@page import="servlets.Film"%>
<script type="text/javascript" src="js/paginazione.js"></script>
<div class="col-md-8 mt-3" onload="nascondiGruppi()">

		<%
		int gruppo = 1;
		if (request.getAttribute("films") != null) {
			ArrayList<Film> films = (ArrayList<Film>) request.getAttribute("films");
			int counter = 0;
			
			%>
			<div class="row gruppo" id="gruppo1">
			
			<div class="row">
			<%
			for (Film f : films) {
			%>
				<%@include file="film.jsp"%>
				<%
				counter++;		
				if (((counter % 2) == 0) && ((counter % 16) != 0)) {
					%>
					</div>
					<div class="row">
					<%
				}
				else if((counter % 16) == 0){
					gruppo++;
					%>
					</div>
					</div>
					<div class="row gruppo" id="gruppo<%=gruppo%>" style="display: none">
					<div class="row">
					<%
				}
				
			} //FINE FOR
		} // FINE IF
		%>
	
	</div>
	</div>
	
	<nav aria-label="Page navigation">
		<ul class="pagination justify-content-center overflow-hidden">
		<%for(int i=1; i<=gruppo; i++){ %>
			<li class="page-item disabled" onclick="cambiaPagina(<%=i %>)"><a class="page-link" href="#"><%=i %></a></li>
				<%} %>
		</ul>
	</nav>

</div>