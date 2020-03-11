<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Login</title>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body class="bg-primary">

	<div class="center-div">
		<div class="container">
			<div class="card shadow-lg border-0 rounded-lg mt-5">
				<div class="card-header">
					<h3 class="text-center">Accedi</h3>
				</div>
				<div class="card-body">

					<form method="POST" action="${contextPath}/login"
						class="form-signin">
						<div class="form-group ${error != null ? 'has-error' : ''}">
							<span>${message}</span> <input name="username" type="text"
								class="form-control" placeholder="Username" autofocus="true" />
							<input name="password" type="password" class="form-control"
								placeholder="Password" /> <span>${error}</span> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<button class="btn btn-lg btn-primary btn-block" type="submit">Log
								In</button>
							<h4 class="text-center">
								<a href="${contextPath}/registration">Create an account</a>
							</h4>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
