<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
	<form method="get" action="#" id="labnol">
		<div class="speech-control-container">
			<div class="speech-control">
				<div class="fa fa-microphone microphone-icon"></div>
			</div>
			<input type="hidden" name="q" id="transcript">
			<div class="speech-control-pulse"></div>
			<svg x="0px" y="0px" class="speech-control-loader">
				<circle class="circle" stroke-width="10" r="101" />
			</svg>
		</div>
	</form>
<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
