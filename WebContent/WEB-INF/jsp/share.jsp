<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
<main role="main">
	<form class="well form-horizontal" action=" " method="post" id="contact_form">
		<fieldset>
			<!-- Form Name -->
			<legend>Share it Today!</legend>
			<!-- Image field goes first -->
			<div class="form-group">
				<label class="col-md-12 control-label">Upload pictures first, and our system will do the rest</label>
				<div class="col-md-12">
					<div class="input-group">
						<input type="file" class="form-control">
					</div>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-12 control-label">Real Name</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<input name="realname"
							placeholder="Real Name" class="form-control" type="text">
					</div>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-12 control-label">E-Mail</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<input name="email"
							placeholder="E-Mail Address" class="form-control" type="text">
					</div>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-12 control-label">Phone #</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<input name="phone"
							placeholder="(306)555-1212" class="form-control" type="text">
					</div>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-12 control-label">Address</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<input name="address"
							placeholder="Address" class="form-control" type="text" id="address">
					</div>
				</div>
			</div>
			<!-- Text area -->
			<div class="form-group">
				<label class="col-md-12 control-label">Project Description</label>
				<div class="col-md-12 inputGroupContainer">
					<div class="input-group">
						<textarea class="form-control" name="comment"
							placeholder="Project Description"></textarea>
					</div>
				</div>
			</div>
			<!-- Success message -->
			<div class="alert alert-success" role="alert" id="success_message">
				Success <i class="fa fa-thumbs-up"></i> Thanks for
				contacting us, we will get back to you shortly.
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-12 control-label"></label>
				<div class="col-md-12">
					<button type="submit" class="btn btn-warning">
						Send <span class="fa fa-send"></span>
					</button>
				</div>
			</div>
		</fieldset>
	</form>
</main>
<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
