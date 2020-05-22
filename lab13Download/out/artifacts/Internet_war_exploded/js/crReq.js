function crReq() {
    var req;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest()
    } else if (window.ActiveXObject) {
        try {
            req = new ActiveXObject("Msxml2.XMLHTTP")
        } catch (e) {
            try {
                req = new ActiveXObject("Microsoft.XMLHTTP")
            } catch (e) {
                req = null
            }
        }
    }
    return req
}