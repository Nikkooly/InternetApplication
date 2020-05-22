$("button").click(function(e) {
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/AS_09FEA/json",
        header: {"XRand-N":  this.n.value},
        success: function(result) {
            alert('ok');
        },
        error: function(result) {
            alert('error');
        }
    });
});
