<%@ include file="/WEB-INF/jsp/includes/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<c:if test='${pageTitle == null }'>Home</c:if>
	${pageTitle} - ${initParam.siteTitle }
</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="//fonts.googleapis.com/css?family=Numans" rel="stylesheet">

<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath }/assets/vendors/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- Fontawesome -->
<link href="${pageContext.request.contextPath }/assets/vendors/css/all.css" rel="stylesheet"
	type="text/css">


<!--Login Page Custom CSS -->
<%-- <ss:if test="${page == 'login'}"> --%>
<link href="${pageContext.request.contextPath }/assets/css/custom.css" rel="stylesheet"
	type="text/css">
<%-- </ss:if> --%>

<!-- BOOTSTRAP JS & JQUERY JS -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">SPCP</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="${pageContext.request.contextPath }">Home</a> 
					<a class="nav-link" href="#">Explore</a> 
					<c:if test="${user == null }">
						<a class="nav-link" href="${pageContext.request.contextPath }/login">Login</a>
					</c:if>
					<c:if test="${user != null }">
						<a class="nav-link" href="${pageContext.request.contextPath }/logout">Logout</a>
					</c:if>
				</nav>
			</div>
		</header>