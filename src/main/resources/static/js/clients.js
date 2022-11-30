function deleteClient(id) {


	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this client!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				$.ajax({
					url: '/clients/delete-ajax',
					type: 'POST',  // http method
					data: { 'id': id },  // data to submit
					success: function() {
						$("#" + id).remove();
						swal("Poof! Your client has been deleted!", {
							icon: "success",
						});
					}
				});


			} else {
				swal("Your client is safe!");
			}
		});




}