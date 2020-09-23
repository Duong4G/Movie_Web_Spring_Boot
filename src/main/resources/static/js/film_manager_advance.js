$(document)
		.ready(
				function() {
					$("#divUpdate").prop('disabled', true);
					$("#divDelete").prop('disabled', true);
					$("#divFilmDetail").prop('disabled', true);

					$('#tableId').on(
							'click',
							function(e) {
								$(e.target).closest('tr').find(
										'input[name="chosenFilm"]').prop(
										"checked", true);
							});

					$('#adminFeature').addClass('current-menu-item');

					$('#searchCondition')
							.keyup(
									function(e) {
										var searchCondition = $(
												'#searchCondition').val();

										if (e.keyCode == 13) {
											window.location
													.replace('filmManagerAdvance?searchCondition='
															+ searchCondition);
										}
									});

					$('#btnEdit')
							.click(
									function() {
										var filmId = $(
												'input[name="chosenFilm"]:checked')
												.val();

										var newFilmName = $('#newFilmName')
												.val();
										var newYear = $('#newYear').val();
										var newLength = $('#newLength').val();
										var newIntroduction = $(
												'#newIntroduction').val();
										var newDeployStatus = $(
												'#newDeployStatus').val();
										var newRequestStatus = $(
												'#newRequestStatus').val();
										var newRequestEmail = $(
												'#newRequestEmail').val();
										var newAcceptAccount = $(
												'#newAcceptAccount').val();

										var token = $('#_csrf').attr('content');
										var header = $('#_csrf_header').attr(
												'content');
										var webDomain = $("#webDomain").val();

										if (newFilmName == ''
												|| newFilmName == null) {
											alert('Film name is invalid');
											return;
										}
										if (newYear == '' || newYear == null) {
											alert('Year is invalid');
											return;
										}
										if (newLength == ''
												|| newLength == null) {
											alert('Length is invalid');
											return;
										}
										if (newIntroduction == ''
												|| newIntroduction == null) {
											alert('Introduction is invalid');
											return;
										}
										if (newDeployStatus == ''
												|| newDeployStatus == null) {
											alert('Deploy status is invalid');
											return;
										}
										if (newRequestStatus == ''
												|| newRequestStatus == null) {
											alert('Request status is invalid');
											return;
										}
										if (newRequestEmail == ''
												|| newRequestEmail == null) {
											alert('Request email is invalid');
											return;
										}
										if (newAcceptAccount == ''
												|| newAcceptAccount == null) {
											alert('Accept account is invalid');
											return;
										}

										var filmObject = {
											'fname' : newFilmName,
											'fyear' : newYear,
											'length' : newLength,
											'introduction' : newIntroduction,
											'fdeploy' : newDeployStatus,
											'frequest' : newRequestStatus,
											'requestEmail' : newRequestEmail,
											'acceptAccount' : newAcceptAccount
										};

										$
												.ajax({
													type : "POST",
													headers : {
														Accept : "application/json; charset=utf-8",
														"Content-Type" : "application/json; charset=utf-8"
													},
													url : webDomain
															+ 'admin/editFilm/'
															+ filmId,
													beforeSend : function(xhr) {
														xhr.setRequestHeader(
																header, token);
														console
																.warn(xhr.responseText)
													},
													data : JSON
															.stringify(filmObject),
													success : function(result) {
														alert("Rquest OK!");
														window.location
																.replace('');
														return result;
													},
													error : function(data,
															status, er) {
														alert("Request Fail!");
													}
												});
									});
					$('#btnDelete')
							.click(
									function() {
										var filmId = $(
												'input[name="chosenFilm"]:checked')
												.val();

										window.location.replace('deleteFilm/'
												+ filmId);
									});
				});
function onclickDeleteFunction() {
	var index = $('input[name="chosenFilm"]:checked').val();
	if (typeof index == 'undefined') {
		alert("Please chosen film!");
	} else {
		$("#divDelete").prop('disabled', false);
	}
}

function onclickEditFunction() {

	var index = $('input[name="chosenFilm"]:checked').val();
	if (typeof index == 'undefined') {
		alert("Please chosen film!");
	} else {

		$('#newFilmName').val($('#filmName' + index).text());
		$('#newYear').val($('#filmYear' + index).text());
		$('#newLength').val($('#filmLength' + index).text());
		$('#newIntroduction').val($('#filmIntroduction' + index).text());
		$('#newDeployStatus').val($('#filmDeploy' + index).text());
		$('#newRequestStatus').val($('#flimRequest' + index).text());
		$('#newRequestEmail').val($('#filmRequestEmail' + index).text());
		$('#newAcceptAccount').val($('#filmAcceptAccount' + index).text());

		$("#divUpdate").prop('disabled', false);
	}
}

function onclickFilmDetail() {
	var index = $('input[name="chosenFilm"]:checked').val();
	if (typeof index == 'undefined') {
		alert("Please chosen film!");
	} else {
		window.location.replace('filmDetail/' + index + '?searchCondition=');
	}
}
function searchFilm() {
	var searchCondition = $('#searchCondition').val();

	window.location.replace('filmManagerAdvance?searchCondition='
			+ searchCondition);
}