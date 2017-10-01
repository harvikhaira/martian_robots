$(document).ready(function() {
    $("#inp_submit").click(function() {
        $.ajax({
            url: "http://localhost:8090/process",
            data: {
                instructions: $("#inp_instructions").val()
            },
            success: function (resp) {
                var output = resp.replace(/\n/g, "\r");
                $("#inp_output").val(output);
            },
            error: function(e) {
                console.log('Error: robot processing error');
            }
        });
    });
})