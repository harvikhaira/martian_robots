$(document).ready(function() {
    $("#inp_submit").click(function() {
        $.ajax({
            url: "http://localhost:8090/process",
            data: {
                instructions: $("#inp_instructions").val()
            },
            success: function (resp) {
                $("#inp_output").val(resp);
            },
            error: function(e) {
                alert('Error: '+e);
            }
        });
    });
})