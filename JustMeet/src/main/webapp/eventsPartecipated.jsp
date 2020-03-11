<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<title>JUST MEET</title>
</head>
<body>

	<%@include file="assets/header.html"%>
	<!-- Header -->
	<header class="masthead">
		<div class="container" style="padding: 10%;">
          			<h2 class="col-12">Eventi Partecipati: </h2>
					<c:if test="${ePartecipated.size()==0}">
						<h4 >Nessun Evento</h4>
					</c:if>
						  <form:form method="GET" modelAttribute="ePartecipated" 
						  			class="row" style="justify-content: center;">
      			 			<c:forEach var="event" items="${ePartecipated}">
								<div class="col-1"></div>
								<div class="card col-4">
									<div class="card-body">
										<h4 class="card-title"> ${event.titolo}</h4>
										<p class="card-text">${event.categoria}</p>
										<p class="card-text">${event.dataEvento}</p>
										<p class="card-text">${event.id}</p>
										<a href="removeRequest?id=${event.id}" class="btn btn-lg btn-primary btn-block">Annulla Partecipazione</a>              
									</div>
								  </div>
								  <div class="col-1"></div>
  							</c:forEach>
  						</form:form>
		</div>
	</header>
<%@include file="assets/footer.html"%>
</body>
</html>