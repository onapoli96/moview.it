<%@page import="servlets.Film"%>

<% 
if (request.getAttribute("films") != null) 
			{
	%>
			
<div class="card col-md-5 mx-2 my-3">
	<img class="card-img-top" src="<%=f.getPoster() %>"
		alt="Card image cap">
	<div class="card-body">
		<h2 class="card-title text-secondary"><%=f.getTitolo() %></h2>
		
			<h5>Trama</h5>
		<p class="card-text">
	
		<%=f.getTrama()%>
		</p>
		
	</div>
	<div class="card-footer text-muted">
	<p>	Director: <%=f.getDirettore()%> </p>
	<p>Data rilascio: <%=f.getRilasciato()%></p>
	
	</div>
</div>
<% }
%>
