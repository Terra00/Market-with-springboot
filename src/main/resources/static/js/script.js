var prezzoT = 0.0;
var numO = 0;
var temp = 1;
var barcodeGlo = [];
function carica() {
    getOrtofrutta();
}

// function sendJson() {
//     let obj = new Object();
//     obj.quantita = document.getElementById("quantitaOgg").value;

//     obj.prezzo = document.getElementById("prezzoTot").value;

//     postJasonWithParms("/json/echoobj", obj, 100)
// }


//Async function
async function getOrtofrutta() {
    let url = "/ortofruttarest/list";
    const response = await fetch(url); // legge da network (con GET)
    const ortofrutta = await response.json(); // prende il risultato
    generaTabellaortofrutta(ortofrutta);
    generaCarelloOrtofrutta();
}

async function postJasonWithParms(url, payload = '', numero) {
    let data = JSON.stringify(payload);
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: data
    });
    const objectsList = await response.json();
    barcodeGlo[numero]=parseInt(objectsList.barcode);
}

// modifica della tabella
function pesa(id) {

    let quant = "quant" + id.charAt(4);
    let peso = "peso" + id.charAt(4);

    let prezzouni = "pu" + id.charAt(4);

    let temp = document.getElementById(quant).value;
    let pesoc = document.getElementById(peso);
    let prezzoUnit = document.getElementById(prezzouni).innerText;

    let num = 0.5;
    num = num * temp;
    num = num.toFixed(3);
    pesoc.setAttribute("value", num);
    calcolaPrezzoConPeso(id.charAt(4), num, prezzoUnit);
}

function calcolaPrezzoConPeso(id, num, prezzo) {
    let idprezzo = "prezzo" + id;
    let prezzoPeso = document.getElementById(idprezzo);
    let prezzoPesoc = prezzo * num;
    prezzoPesoc = prezzoPesoc.toFixed(2);
    prezzoPeso.setAttribute("value", prezzoPesoc);
}

function calcolaPrezzoSensaPeso(id) {
    let prezz = "prezzo" + id.charAt(5);
    let pu = "pu" + id.charAt(5);
    let quant = "quant" + id.charAt(5);
    let quantita = document.getElementById(quant).value;
    let prezzo = document.getElementById(prezz);
    let prezzoUni = document.getElementById(pu).innerText;
    let num = (prezzoUni * quantita);
    num = num.toFixed(2);
    prezzo.setAttribute("value", num);
    // console.log(prezzo);
}

function inserisciCarello(id) {

    let idProd = document.getElementById("idProdotto" + id.charAt(7)).innerText;
    let quantita = document.getElementById("quant" + id.charAt(7)).value;
    let prezzo = document.getElementById("prezzo" + id.charAt(7)).value;
    let pu = document.getElementById("pu" + id.charAt(7)).innerText;
    let peso = document.getElementById("peso" + id.charAt(7)).value;
    let prodObj = { idProdotto: idProd, quantita: quantita, prezzo: pu };

    let quantitaTotale = document.getElementById("quantitaOgg");
    let prezzoTotale = document.getElementById("prezzoTot");
    numO += parseInt(quantita);
    quantitaTotale.setAttribute("value", numO);
    prezzoT += parseFloat(prezzo);
    prezzoTotale.setAttribute("value", prezzoT);
    
    
    aggiungiTabellaCarello(id.charAt(7), idProd, quantita, prezzo, peso, prodObj);

}

function resetAll() {
    let quantitaTotale = document.getElementById("quantitaOgg");
    let prezzoTotale = document.getElementById("prezzoTot");
    numO = 0;
    prezzoT = 0;
    quantitaTotale.setAttribute("value", numO);
    prezzoTotale.setAttribute("value", prezzoT);
    for (let i = 1; i < temp; i++) {
        try{ 
            document.getElementById("tabellaCarello").deleteRow(1);
        }catch (e){}
    }
    temp = 1;
}

function cancellaSingolo(tableID,currentRow) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            /*var chkbox = row.cells[0].childNodes[0];*/
            /*if (null != chkbox && true == chkbox.checked)*/

            if (row == currentRow.parentNode.parentNode) {
                if (rowCount <= 1) {
                    alert("Cannot delete all the rows.");
                    break;
                }
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    } catch (e) {
        alert(e);
    }
}

// Genera tabelle
function generaTabellaortofrutta(ortofrutta) {

    let i = 1;
    let temp;
    let tabella = document.createElement("table");
    let riga = document.createElement("tr");
    riga.setAttribute("class", "color");

    let cella = document.createElement("th");
    cella.innerText = "";
    riga.appendChild(cella);

    cella = document.createElement("th");
    cella.innerText = "Id";
    riga.appendChild(cella);

    cella = document.createElement("th");
    cella.innerText = "Descrizione";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Prezzo Unitario";
    riga.appendChild(cella)


    cella = document.createElement("th");
    cella.innerText = "Pesatura";
    riga.appendChild(cella)


    cella = document.createElement("th");
    cella.innerText = "Pesa";
    riga.appendChild(cella)


    cella = document.createElement("th");
    cella.innerText = "Peso calcolato";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Quantit\u00E0";
    riga.appendChild(cella)


    cella = document.createElement("th");
    cella.innerText = "Costo totale";
    riga.appendChild(cella);

    cella = document.createElement("th");
    cella.innerText = "Nel carello";
    riga.appendChild(cella);

    tabella.appendChild(riga); // riga intestazione

    for (let ortof of ortofrutta) {
        riga = document.createElement("tr");

        cella = document.createElement("th");
        cella.innerText = i;
        cella.setAttribute("class", "color");
        riga.appendChild(cella);

        riga.appendChild(cella);
        temp = "idProdotto" + i;
        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        cella.setAttribute("id", temp);
        cella.innerText = ortof.id;
        riga.appendChild(cella);

        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        cella.innerText = ortof.descrizione;
        riga.appendChild(cella);

        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        temp = "pu" + i;
        cella.setAttribute("id", temp);
        cella.innerText = ortof.prezzoUnitario;
        riga.appendChild(cella);

        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        if (ortof.pesatura == "DA_PESARE") {
            cella.innerText = "Si";
            cella.setAttribute("class", "cella");
            riga.appendChild(cella);


            cella = document.createElement("td");
            cella.setAttribute("class", "cella");
            let bottone = document.createElement("input");
            temp = "butt" + i;
            bottone.setAttribute("id", temp);
            bottone.setAttribute("type", "button");
            bottone.setAttribute("value", "Pesa")
            bottone.setAttribute("onclick", "pesa(this.id)")
            cella.appendChild(bottone);
            riga.appendChild(cella);

        } else {
            cella.innerText = "No";
            riga.appendChild(cella);

            cella = document.createElement("td");
            cella.setAttribute("class", "cella");
            let bottone = document.createElement("input");
            bottone.setAttribute("type", "button");
            bottone.setAttribute("value", "Pesa")
            bottone.disabled = "disabled";
            cella.appendChild(bottone);
            riga.appendChild(cella);
        }


        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        let testo1 = document.createElement("input");
        temp = "peso" + i;
        testo1.setAttribute("id", temp);
        testo1.setAttribute("type", "text");
        testo1.setAttribute("placeholder", "0");
        testo1.readOnly = true;
        cella.appendChild(testo1);
        riga.appendChild(cella);


        let testo2 = document.createElement("input");
        if (ortof.pesatura == "DA_PESARE") {
            cella = document.createElement("td");
            cella.setAttribute("class", "cella");
            let testo2 = document.createElement("input");
            temp = "quant" + i;
            testo2.setAttribute("type", "number");
            testo2.setAttribute("id", temp);
            testo2.setAttribute("min", "0");
            testo2.setAttribute("placeholder", "0");
            cella.appendChild(testo2);
            riga.appendChild(cella);
        } else {
            cella = document.createElement("td");
            cella.setAttribute("class", "cella");
            temp = "quant" + i;
            testo2.setAttribute("oninput", "calcolaPrezzoSensaPeso(this.id)");
            testo2.setAttribute("type", "number");
            testo2.setAttribute("id", temp);
            testo2.setAttribute("min", "0");
            testo2.setAttribute("placeholder", "0");
            cella.appendChild(testo2);
            riga.appendChild(cella);
        }

        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        let testo3 = document.createElement("input");
        testo3.setAttribute("type", "text");
        temp = "prezzo" + i;
        //console.log(temp);
        testo3.setAttribute("id", temp);
        testo3.setAttribute("placeholder", "0");
        testo3.readOnly = true;
        cella.appendChild(testo3);
        riga.appendChild(cella);


        cella = document.createElement("td");
        cella.setAttribute("class", "cella");
        temp = "carello" + i;
        let bottone = document.createElement("input");
        bottone.setAttribute("type", "button");
        bottone.setAttribute("id", temp);
        bottone.setAttribute("onclick", "inserisciCarello(this.id)")
        bottone.setAttribute("value", "Metti nel carello")
        cella.appendChild(bottone);
        riga.appendChild(cella);

        tabella.appendChild(riga);
        i++;
    }

    let tabellaf = document.getElementById("tabella");
    tabellaf.appendChild(tabella);
    i = 1;
}

function generaCarelloOrtofrutta() {
    let form = document.createElement("form");

    form.setAttribute("metod", "post");
    form.setAttribute("action", "#");

    let label = document.createElement("label");
    let testo = document.createElement("input");
    label.setAttribute("for", "quantita");
    label.innerText = "Quantita'";
    testo.setAttribute("type", "text");
    testo.setAttribute("name", "quantita");
    testo.setAttribute("id", "quantitaOgg");
    testo.setAttribute("placeholder", "0");
    testo.readOnly = true;
    form.appendChild(label);
    form.appendChild(testo);

    label = document.createElement("label");
    testo = document.createElement("input");
    label.setAttribute("for", "prezzoa");
    label.innerText = "Prezzo";
    testo.setAttribute("type", "text");
    testo.setAttribute("name", "prezzo");
    testo.setAttribute("id", "prezzoTot");
    testo.setAttribute("placeholder", "0");
    testo.readOnly = true;
    form.appendChild(label);
    form.appendChild(testo);


    let bottone = document.createElement("input");
    bottone.setAttribute("type", "reset");
    bottone.setAttribute("value", "Reset");
    bottone.setAttribute("onclick", "resetAll()");
    form.appendChild(bottone);


    bottone = document.createElement("input");
    bottone.setAttribute("type", "button");
    bottone.setAttribute("onclick", "sendJson()");
    bottone.setAttribute("value", "Acquista");
    form.appendChild(bottone);


    let carello = document.getElementById("carelloTot");
    carello.appendChild(form);
    let carelloOggetti = document.getElementById("carello");
    let tabella = document.createElement("table");
    tabella.setAttribute("id", "tabellaCarello");
    let riga = document.createElement("tr");
    riga.setAttribute("class", "color");
    let cella = document.createElement("th");
    cella.innerText = "";
    riga.appendChild(cella);

    cella = document.createElement("th");
    cella.innerText = "Id";
    riga.appendChild(cella);

    cella = document.createElement("th");
    cella.innerText = "Quantita'";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Prezzo";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Barcoode";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Peso";
    riga.appendChild(cella)

    cella = document.createElement("th");
    cella.innerText = "Cancella prodotto";
    riga.appendChild(cella)

    tabella.appendChild(riga);
    carelloOggetti.appendChild(tabella);

}

function aggiungiTabellaCarello(numero, id, quantita, prezzo, peso, obj) {
    postJasonWithParms("/bilancia/pesare", obj, numero);
    console.log(barcodeGlo[numero]);
    let carello = document.getElementById("tabellaCarello");
    riga = document.createElement("tr");

    cella = document.createElement("th");
    cella.setAttribute("class", "color");
    cella.innerText = temp;
    riga.appendChild(cella);


    cella = document.createElement("td");
    cella.setAttribute("class", "cella");
    cella.innerText = id;
    riga.appendChild(cella);

    riga.appendChild(cella);
    cella = document.createElement("td");
    cella.setAttribute("class", "cella");
    cella.innerText = quantita;
    riga.appendChild(cella);

    cella = document.createElement("td");
    cella.setAttribute("class", "cella");
    cella.innerText = prezzo;
    riga.appendChild(cella);

    cella = document.createElement("td");
    cella.setAttribute("class", "cella");
    cella.innerText = barcodeGlo[numero];
    riga.appendChild(cella);

    cella = document.createElement("td");
    cella.setAttribute("class", "cella");
    cella.innerText = peso;
    riga.appendChild(cella);


    cella = document.createElement("td");
    let button = document.createElement("input");
    button.setAttribute("id", temp);
    button.setAttribute("type", "button");
    button.setAttribute("onclick", "cancellaSingolo('tabellaCarello',this)");
    button.setAttribute("value", "X");
    cella.setAttribute("class", "cella");
    cella.appendChild(button);


    riga.appendChild(cella);

    carello.appendChild(riga);
    temp++;
}

window.onload = carica;
