function Fill_JSON(req){
    var  xx = eval('('+req+')');
    var rc = "";
    for (var i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand +" ");
    }
    return (rc);
};

$(document).ready(function() {
    $("#btnSubmit").click(function(e) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/AS_12YNS11/json",
            beforeSend: function(request) {
                request.setRequestHeader("XRand-N", $("#numb").val());
            },
            success: function(result) {
                let s = document.getElementById('jquery');
                s.firstChild.data = Fill_JSON(result);
                console.log(result);
                s.className ="h1";
            },
            error: function(result) {
                alert('error');
            }
        });
    });
});
