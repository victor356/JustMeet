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
<body id="page-top">

	<%@include file="assets/header.html"%>
	<!-- Header -->
	<header class="masthead">
		<div class="container" style="padding: 10%;">
			<c:if test="${searchResult.size()==0}">
				<h4 class="col-12">Nessun Evento trovato, riprova</h4>
			</c:if>
			<form:form method="POST" modelAttribute="searchResults"
				class="row justify-content-md-center">
				<h2 class="col-12">Risultati ricerca: </h2>
				<c:forEach var="event" items="${searchResults}">
					<div class="col-1"></div>
					<div class="card col-4">
					<div class="card-body">
						<h4 class="card-title">${event.titolo}</h4>
						<p class="card-text">${event.descrizione}</p>
						<p class="card-text">${event.categoria}</p>
						<p class="card-text">${event.dataEvento}</p>
						<a href="eventDetails?id=${event.id}"
							class="btn btn-lg btn-primary btn-block">Dettagli Evento</a>
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