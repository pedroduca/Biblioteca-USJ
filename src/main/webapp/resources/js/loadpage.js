
/* global chave */

window.onload = function () {
    var elements = document.getElementsByTagName('*'), i;

    for (i in elements) {
        if (elements[i].hasAttribute && elements[i].hasAttribute('data-include')) {
            fragment(elements[i], elements[i].getAttribute('data-include'));
        }
    }
    function fragment(el, url) {
        var localTest = /^(?:file):/, xmlhttp = new XMLHttpRequest(),
                status = 0;

        xmlhttp.onreadystatechange = function () {
            /* if we are on a local protocol, and we have response text, we'll assume
             *  				things were sucessful */
            if (xmlhttp.readyState == 4) {
                status = xmlhttp.status;
            }
            if (localTest.test(location.href) && xmlhttp.responseText) {
                status = 200;
            }
            if (xmlhttp.readyState == 4 && status == 200) {
                el.outerHTML = xmlhttp.responseText;
            }
        }

        try {
            xmlhttp.open("GET", url, true);
            xmlhttp.send();
        } catch (err) {
            /* todo catch error */
        }
    }
};


function queryString(parameter) {
    var loc = location.search.substring(1, location.search.length);
    var param_value = false;
    var params = loc.split("&");
    for (i = 0; i < params.length; i++) {
        param_name = params[i].substring(0, params[i].indexOf('='));
        if (param_name == parameter) {
            param_value = params[i].substring(params[i].indexOf('=') + 1);
        }
    }
    if (param_value) {
        return param_value;
    } else {
        return false;
    }
}

var id = queryString("page");
var a = queryString("id");


function loadPage() {

    if (id == 'home') {
        var url = './view/home.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }
    if (id == 'formulariovisita') {
        var url = './view/formulariovisita.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }
    if (id == 'formulariorelatorio') {
        var url = './view/formulariorelatorio.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }
    if (id == 'saidarelatorio') {
        var url = './view/saidarelatorio.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }
    if (id == 'adicionarusuario') {
        var url = './view/adicionarusuario.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }
    if (id == 'gerenciaprofessor') {
        var url = './view/gerenciaprofessor.xhtml';
        document.getElementById("loadPageDocument").innerHTML = "<data data-include='" + url + "'></data>";
    }

}

$('.datepicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d'
});
