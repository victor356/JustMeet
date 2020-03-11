<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<html>
<head>
<meta charset="utf-8">

<title>Home</title>
</head>
<body>
<%@include file="assets/header.html"%>
	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text">
				<div class="intro-lead-in">Bentornato!</div>
				<div class="intro-heading text-uppercase">nice To See You!</div>
				<a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
					href="#services">Vai</a>
			</div>
		</div>
	</header>
		<!-- Services -->
	<section class="page-section" id="services">
		<div class="container">
			<div class="row" style="
			padding-top: 100px;">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Dimmi di pi&ugrave;</h2>
					<h3 class="section-subheading text-muted">potrebbe piacermi ;)</h3>
				</div>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-paper-plane fa-stack-1x fa-inverse"></i>

					</span>
					<h4 class="service-heading">INVENTA</h4>
					<p class="text-muted">Dai spazio alla tua creativit&agrave; e crea un evento con la tua idea
					</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-laptop fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">ORGANIZZA</h4>
					<p class="text-muted">Preparati a
						conoscere un numero illimitato di persone</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-lock fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="service-heading">CONTROLLA</h4>
					<p class="text-muted">Non farti sfuggire nulla.</p>
				</div>
			</div>
		</div>
	</section>
	
	
<%@include file="assets/footer.html"%>
</body>

</html>
