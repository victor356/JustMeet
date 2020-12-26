<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
			<form:form method="POST" modelAttribute="searchForm"
					class="row" style="justify-content: center;">
				<h2 class="col-12" style="padding:5%;">Cerca evento</h2>
				<label class="col-2" style="text-align: end; padding-right: 0%;">Categoria</label>
				<spring:bind path="categoria">
					<div class="${status.error ? 'has-error' : ''} col-4">
						<form:select type="integer" path="categoria"
							class="form-control" placeholder="Categoria" autofocus="true">
							<optgroup label="SPORT">
								<option value="CALCIO">CALCIO</option>
								<option value="CALCETTO">CALCETTO</option>
								<option value="PALLAVOLO">PALLAVOLO</option>
								<option value="TENNIS">TENNIS</option>
								<option value="BEACH_VOLLEY">BEACH VOLLEY</option>
							</optgroup>
							<optgroup label="SERVIZI">
								<option value="RIPETIZIONI">RIPETIZIONI</option>
								<option value="GIOCHI_DA_TAVOLO">GIOCHI DA TAVOLO</option>
							</optgroup>
						</form:select>
					</div>
				</spring:bind>
				<label class="col-2" style="text-align: end; padding-right: 0%;">Data Evento</label>
				<spring:bind path="dataEvento">
					<div class="${status.error ? 'has-error' : ''} col-4">
						<form:input type="date" path="dataEvento" class="form-control"
							placeholder="DataEvento" autofocus="true"></form:input>
					</div>
				</spring:bind>
				<button class="btn btn-lg btn-primary btn-block col-12" type="submit" styles="align:center">Vai</button>
			</form:form>
			<form:form method="POST" modelAttribute="showAllEvent"
				class="row justify-content-md-center">
				<h2 class="col-12" style="padding-top: 5%;">Tutti gli eventi:</h2>
				<c:forEach var="event" items="${showAllEvent}">
					<div class="col-1"></div>
					<div class="card col-4">
						<div class="card-body">
							<h4 class="card-title">${event.titolo}</h4>
							<p class="card-text">${event.descrizione}</p>
							<p class="card-text">${event.categoria}</p>
							<p class="card-text">${event.dataEvento}</p>
							<a href="eventDetails?id=${event.id}" class="btn btn-lg btn-primary btn-block">Dettagli Evento</a>
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