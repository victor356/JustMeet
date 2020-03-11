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
		<div class="container">
			<div class="intro-text" align="center">
				<c:if test="${mySearchResult.size()==0}">
					<h4>Nessun Evento</h4>
				</c:if>
				<div class="form-group2">
					<form:form method="POST" modelAttribute="modifyEvent"
						class="form-signin">
						<h2 class="form-signin">Modifica evento</h2>
						<p></p>
						<p></p>
						<form:label path="titolo">Titolo</form:label>
						<spring:bind path="titolo">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="titolo" class="form-control"
									placeholder="Titolo" autofocus="true"></form:input>
							</div>
						</spring:bind>
						<form:label path="descrizione">Descrizione</form:label>
						<spring:bind path="descrizione">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="descrizione" class="form-control"
									placeholder="Descrizione" autofocus="true"></form:input>
							</div>
						</spring:bind>
						<form:label path="descrizione">Citt&agrave;</form:label>
						<spring:bind path="descrizione">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="citta" class="form-control"
									placeholder="Citt&agrave;" autofocus="true"></form:input>
							</div>
						</spring:bind>
						<form:label path="categoria">Categoria</form:label>
						<spring:bind path="categoria">
							<div class="form-group ${status.error ? 'has-error' : ''}">
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
						<form:label path="dataEvento">Data Evento</form:label>
						<spring:bind path="dataEvento">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="date" path="dataEvento" class="form-control" id="dataEvento"
									placeholder="DataEvento" autofocus="true" onchange="date(this.value)"></form:input>
							</div>
						</spring:bind>
						<form:label path="prezzo">Prezzo</form:label>
						<spring:bind path="prezzo">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="float" path="prezzo" class="form-control" id="prezzo"
									placeholder="Prezzo" autofocus="true" onchange="price(this.value)"></form:input>
							</div>
						</spring:bind>

						<form:label path="scadenzaPagamento">Data Scadenza Pagamento</form:label>
						<spring:bind path="scadenzaPagamento">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="date" path="scadenzaPagamento" id="scadenzaPagamento"
									class="form-control" placeholder="scadenzaPagamento"
									autofocus="true"></form:input>
							</div>
						</spring:bind>

						<form:label path="cauzione" id="lblCauzione"
									>Cauzione</form:label>
						<spring:bind path="cauzione">
							<div class="form-group2 ${status.error ? 'has-error' : ''} container" id="radioCauzione">
								<div class="row">
									<div class="col">
										Si
									</div>
									<div class="col">
										<form:radiobutton name="cauzioneRadio" value="true"
										path="cauzione" class="form-control"
										style="width: fit-content;" onchange="radio(this.value)"/>
									</div>
									<div class="col">
									  
									</div>
									<div class="col">
										No
									</div>
									<div class="col">
										<form:radiobutton name="cauzioneRadio" value="false"
										path="cauzione" class="form-control"
										style="width: fit-content;" onchange="radio(this.value)"/>
									</div>
								</div>
							</div>
						</spring:bind>
						<form:label path="qtaCauzione" id="lblQtaCauzione"
									>Quantità cauzione</form:label>
						<spring:bind path="qtaCauzione">
							<div class="form-group2 ${status.error ? 'has-error' : ''}">
								<form:input type="number" step="0.01" min="0" value="0" path="qtaCauzione" class="form-control"
									id="qtaCauzione" placeholder="scadenzaPagamento" autofocus="true"
									></form:input>
							</div>
						</spring:bind>


						<button class="btn btn-lg btn-primary btn-block" type="submit">Modifica</button>
					</form:form>
				</div>
			</div>
		</div>
	</header>

	<%@include file="assets/footer.html"%>

</body>
<script type="text/javascript">
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	if(dd<10){
		dd='0'+dd;
	} 
	if(mm<10){
		mm='0'+mm;
	}
	var today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("dataEvento").setAttribute("min", today);
	document.getElementById("scadenzaPagamento").setAttribute("min", today);
	document.getElementById("scadenzaPagamento").setAttribute("max", document.getElementById("dataEvento").value);
	document.getElementById("qtaCauzione").setAttribute("max",document.getElementById("prezzo").value);

	function date(date){
		document.getElementById("scadenzaPagamento").setAttribute("max",date);
	}

	function price(price){
		document.getElementById("qtaCauzione").setAttribute("max",price);
	}

	if(radio.localeCompare("true") == 0){
			document.getElementById("qtaCauzione").setAttribute("max",price);
		}else{
			document.getElementById("qtaCauzione").setAttribute("max",0);
		}

	function radio(radio) {
		if(radio.localeCompare("true") == 0){
			document.getElementById("qtaCauzione").setAttribute("max",document.getElementById("prezzo").value);
		}else{
			document.getElementById("qtaCauzione").setAttribute("max",0);
		}
	}
</script>
</html>