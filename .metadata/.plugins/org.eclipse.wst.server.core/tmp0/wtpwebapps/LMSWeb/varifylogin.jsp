<div>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">Card Number Required</h4>
	</div>
	<form action="validateLogin" method="post">
		<div class="modal-body">
			<h3>Enter valid card number:</h3>
			<input type="text" name="cardNo" value="" required>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="submit" class="btn btn-primary">Manage My
				Books</button>
		</div>
	</form>
</div>