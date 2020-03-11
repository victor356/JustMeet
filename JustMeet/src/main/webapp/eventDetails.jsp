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
			<h2 class="col-12">Dettagli evento</h2>
				<div class="row justify-content-md-center">
					<div class="col-3"></div>
					<div class="card col-6">
						<div class="card-body">
							<h4 class="card-title">Titolo: ${eventDetail.titolo}</h4>
							<p class="card-text">Categoria: ${eventDetail.categoria}</p>
							<p class="card-text">Data Evento: ${eventDetail.dataEvento}</p>
							<p class="card-text">Numero Partecipanti: ${countPartecipated}</p>
							<p class="card-text">Prezzo: ${eventDetail.prezzo}</p>
							<p class="card-text">Cauzione: ${eventDetail.cauzione}</p>
							<p class="card-text">Valore cauzione: ${eventDetail.qtaCauzione}</p>
							<a href="addRequest?id=${eventDetail.id}"
								class="btn btn-lg btn-primary btn-block">Invia richiesta di
								partecipazione</a>
						</div>
					</div>
					<div class="col-3"></div>
				</div>
			</div>
		</div>

	</header>
	<%@include file="assets/footer.html"%>

</body>
</html>