function Fill(req){
    let xmldoc = req.responseXML;
    let tsnum = xmldoc.getElementsByTagName("num");
    let rc = "";
    for (let i = 0; i < tsnum.length; i++){
        rc += tsnum[i].textContent + " ";
    }
    return (rc);
};
function OnClickXml(n, s) {
    let patern = new RegExp(/^[1-9]+[0-9]*$/);
    if (patern.test(n)){
        if (req){
            req.open("POST","http://localhost:8080/AS_09FEA/xml", false);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill(req);
                        s.className ="h1";
                    }else alert("status = "+
                        req.status +"\n"+req.statusText);
                }
            };
            req.setRequestHeader("XRand-N",  n)
            req.send("null");
        }
    }else alert ("error");
};
