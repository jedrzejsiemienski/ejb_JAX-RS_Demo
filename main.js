$(document).ready(function()
{
	updateEmployees();
	
	$("#post-employee").click(function()
	{
		sendFormData();
	});
	
});

var API_URL = "http://localhost:8080/ejb_JAX-RS_Demo/rest/employee";

function updateEmployees() {
	$('#employees-list').empty();
	$.get( API_URL + "/getAll", function( data ) {
		var list = $('<ul />');
		jQuery.each(data, function(index, employee) {
	        $('<li />', {text: index + ' - ' + employee.name}).appendTo(list);
	    });
		$('#employees-list').append(list);
	});
}

function sendFormData() {
	var postData = $("#create-employee-form").serializeArray();
	postData = JSON.stringify({"name":postData[0]["value"]});
	
	$.ajax(
	{
		url : API_URL + "/save",
		type: "POST",
		data : postData,
	    headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		success:function(data, textStatus, jqXHR) 
		{
			updateEmployees();
		},
		error: function(jqXHR, textStatus, errorThrown) 
		{
			$("#simple-msg").html(
				'<pre><code class="prettyprint">AJAX Request Failed<br/> textStatus='
				+ textStatus + ', errorThrown='+errorThrown+'</code></pre>'
			);
		}
	});	
}