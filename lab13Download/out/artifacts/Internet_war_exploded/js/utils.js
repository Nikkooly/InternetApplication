function OnClickAdd(x, y, z) {
    if (req) {
        req.open("POST", "http://localhost:8080/AS_09FEA/Utils", false);
        req.onreadystatechange = function () {
            if (req.readyState == 4) {
                if (req.status == 200) {
                    z.value = req.getResponseHeader("val3")
                } else {
                    alert("status: " + req.status + "\n" +  req.statusText)
                }
            }
        };
        req.setRequestHeader("val1", x.value);
        req.setRequestHeader("val2", y.value);
        req.send(null)
    } else {
        alert("error")
    }
}