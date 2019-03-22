<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
<main role="main">
<form class="well form-horizontal" action="${pageContext.request.contextPath }/addProduct" method="post"
	id="contact_form" enctype="multipart/form-data">
	<fieldset>
		<!-- Form Name -->
		<legend>Share it Today!</legend>
		<!-- Image field goes first -->
		<div class="form-group">
			<label class="col-md-12 control-label">Upload pictures first,
				and our system will do the rest</label>
			<div class="row" id="image-group">
				<div class="col-md-12">
					<div class="file-upload">
						<button class="file-upload-btn" type="button"
							onclick="$('.file-upload-input').trigger('click')">Add
							Image</button>
						<div class="image-upload-wrap">
							<input class="file-upload-input" type="file"
								onchange="readURL(this);" accept="image/*" name="picture"/>
							<div class="drag-text">
								<h3>Drag and drop a file or select add Image</h3>
							</div>
						</div>
						<div class="file-upload-content">
							<img class="file-upload-image" src="#" alt="your image" id="image">
							<div class="image-title-wrap">
								<button type="button" onclick="removeUpload()"
									class="remove-image">
									Remove <span class="image-title">Uploaded Image</span>
								</button>
							</div>
						</div>
					</div>
				</div> <!-- row -->
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">Title <span id="possibility"></span></label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="title" placeholder="Title" class="form-control"
						type="text" id="title">
				</div>
			</div>
		</div>

		<c:set var="date" value="<%=new java.util.Date()%>"></c:set>
		<c:set var="futureDate" value="<%= WebUtils.addOneWeek() %>"></c:set>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">From Date</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="fromDate" placeholder="From Date" class="form-control"
						type="date"
						value='<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>'>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-12 control-label">End Date</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="endDate" placeholder="End Date" class="form-control"
						type="date" value='<fmt:formatDate value="${futureDate }" pattern="yyyy-MM-dd" />'/>
				</div>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">Real Name</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="realname" placeholder="Real Name" class="form-control"
						type="text" value="${user.realname }">
					<input type="hidden" name="ownerId" value="${user.id }">
				</div>
			</div>
		</div>

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">E-Mail</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="email" placeholder="E-Mail Address"
						class="form-control" type="text">
				</div>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">Phone #</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="phone" placeholder="(306)555-1212"
						class="form-control" type="text">
				</div>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-12 control-label">Address</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<input name="address" placeholder="Address" class="form-control"
						type="text" id="address">
				</div>
			</div>
		</div>
		<!-- Text area -->
		<div class="form-group">
			<label class="col-md-12 control-label">Description</label>
			<div class="col-md-12 inputGroupContainer">
				<div class="input-group">
					<textarea class="form-control" name="description"
						placeholder="Project Description"></textarea>
				</div>
			</div>
		</div>

		<!-- Success message -->
		<div class="alert alert-success" role="alert" id="success_message">
			Success <i class="fa fa-thumbs-up"></i> Thanks for contacting us, we
			will get back to you shortly.
		</div>
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-12 control-label"></label>
			<div class="col-md-12">
				<button type="submit" class="btn btn-warning">
					Send 
				</button>
			</div>
		</div>
	</fieldset>
</form>
</main>
<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
