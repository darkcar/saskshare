<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
	
	<main id="content">
		<div class="container py-6">
			<h1 class="display-4 pb-4">${product.title }</h1>
		</div>
		<div class="image">
			<img src="${pageContext.request.contextPath }/uploads/${gallery.path}" width="50%">
		</div>
		<div class="row">
			<div class="col-lg-4">
				<dl class="mt-1">
                	<dt class="font-weight-light">Email</dt>
                    <dd>${contact.email }</dd>
                    <dt class="font-weight-light">Phone</dt>
                    <dd>${contact.phoneNumber }</dd>
                    <dt class="font-weight-light">Address</dt>
                    <dd>${contact.address }</dd>
                </dl>
			</div>
			<div class="col-lg-8">
				<p>${product.description }</p>
				<p>Available from ${product.fromDate } to ${product.endDate }</p> 
				<form action="${pageContext.request.contextPath }/bookit" method="post">
					<input type="hidden" name="fromDate" value="${product.fromDate }">
					<input type="hidden" name="endDate" value="${product.endDate }">
					<input type="hidden" name="userId" value="${user.id }">
					<input type="hidden" name="productId" value="${product.productId }">
					<button type="submit" class="btn btn-warning btn-lg btn-block">Book Now</button>
				</form>
			</div>
		</div>
	</main>
	

<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
