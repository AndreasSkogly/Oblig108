const fornavnInput = document.getElementById("fornavn");
const etternavnInput = document.getElementById("etternavn");
const mobilInput = document.getElementById("tlfNummer")
const password = document.getElementById('password');
const password_rep = document.getElementById('password_rep');
const form = document.getElementById('paamelding_form');
const kjonn = document.getElementsByClassName("kjonn_valg");
const paameldKnapp = document.getElementById('paameld');
const paameldt_fornavn = document.getElementById("paameldt_fornavn");
const paameldt_etternavn = document.getElementById("paameldt_etternavn");
const paameldt_kjonn = document.getElementById("paameldt_kjonn");
const paameldt_nr = document.getElementById("paameldt_nr");




function validatePage() {

    form.onsubmit = function (event) {
        fornavnInput.value = fornavnInput.value.charAt(0).toUpperCase() + fornavnInput.value.slice(1);
        etternavnInput.value = etternavnInput.value.charAt(0).toUpperCase() + etternavnInput.value.slice(1);
        if (password_rep.value !== password.value){
            alert("Passordet er ikke det samme!");
            event.preventDefault();
        }




        console.log(fornavnInput.value);
        console.log(etternavnInput.value);
        console.log(mobilInput.value);
        console.log(password.value);
        console.log(password_rep.value);
        console.log(kjonn);




        // window.onload = function() {
        //     paameldt_fornavn.innerHTML = fornavnInput.value = localStorage.getItem("fornavn");
        //     paameldt_etternavn.innerHTML = etternavnInput.value = localStorage.getItem("etternavn");
        //     paameldt_kjonn.innerHTML = localStorage.getItem("kjonn");
        //     paameldt_nr.innerHTML = localStorage.getItem("mobil");
        // };






    }






}
validatePage();

window.addEventListener("load", () => {
    if (paameldt_fornavn && paameldt_etternavn && paameldt_kjonn && paameldt_nr) {
        paameldt_fornavn.textContent = localStorage.getItem("fornavn") || "";
        paameldt_etternavn.textContent = localStorage.getItem("etternavn") || "";
        paameldt_kjonn.textContent = localStorage.getItem("kjonn") || "";
        paameldt_nr.textContent = localStorage.getItem("mobil") || "";
    }
});
