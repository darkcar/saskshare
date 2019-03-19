<%@ include file="/WEB-INF/jsp/includes/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle} - ${initParam.siteTitle }</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath }/assets/vendors/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- Fontawesome -->
<link href="${pageContext.request.contextPath }/assets/vendors/css/all.css" rel="stylesheet"
	type="text/css">


<!--Login Page Custom CSS -->
<ss:if test="${page == 'login'}">
<link href="${pageContext.request.contextPath }/assets/css/custom.css" rel="stylesheet"
	type="text/css">
</ss:if>

<!-- BOOTSTRAP JS & JQUERY JS -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</head>
<body>