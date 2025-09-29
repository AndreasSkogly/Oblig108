class DeltagerManager {
    // Deklarer felt-variabler her
    nameInput;
    startInput;
    timeInput;
    registerButton;
    messageParagraph;
    messageSpans;
    used;
    resultat;
    deltagereButton;
    deltakere;
    resultatBody;
    nedreTid;
    ovreTid;
    sluttTidSortererListe;

  constructor(root) {
      // Legg inn kode her

      this.startInput = root.querySelector('#startnummer');
      this.nameInput = root.querySelector('#deltagernavn');
      this.timeInput = root.querySelector('#sluttid');
      this.registerButton = root.querySelector('.registrering button[type="button"]');
      this.messageParagraph = root.querySelector('.registrering p'); //output
      this.messageSpans = this.messageParagraph.querySelectorAll('span'); // output
      this.used = new Set();
      this.resultat = root.querySelector('.resultat');
      this.deltagereButton = root.querySelector('.resultat button[type="button"]');
      this.resultatBody = root.querySelector('.resultat table tbody');
      const ingen_resultat = root.querySelector('.resultat p');
      this.nedreTid = root.querySelector('#nedregrense');
      this.ovreTid = root.querySelector('#ovregrense');
      this.deltakere = [];
      this.sluttTidSortererListe = [];
      const s = this.startInput.value.trim();
      const n = this.nameInput.value.trim();
      const t = this.timeInput.value.trim();

        this.deltagereButton.addEventListener('click', () => {
            this.ovreTid.setCustomValidity(''); // Nullstiller feilmeldingen

            if (this.nedreTid.value && this.ovreTid.value && this.nedreTid.value > this.ovreTid.value) {
                this.ovreTid.setCustomValidity("Øvre grense må være større enn nedre");
                this.ovreTid.reportValidity();
                this.ovreTid.focus();
                return;
            }
            ingen_resultat.style.display = 'none';
            this.visDeltagerListen();
        });

    this.registerButton.addEventListener('click', e => {
        e.preventDefault();
        const s = this.startInput.value.trim();
        this.startInput.setCustomValidity('');
        if(this.used.has(s)){
            this.startInput.setCustomValidity('Startnummer er allerede registrert');
            this.startInput.reportValidity();
            this.startInput.focus();
            return;
        }
        if(!this.validate(this.nameInput)) return;
        else{
        this.handle();
        this.used.add(s);
        }
    });}

    resultatListe(startnr, navn, slutt_tid) {

          const tr = document.createElement('tr');
          const plassering = this.resultatBody.rows.length + 1;

          tr.innerHTML = `
            <td>${plassering}</td>
            <td>${startnr}</td>
            <td>${navn}</td>
            <td>${slutt_tid}</td>
            `;
          this.resultatBody.appendChild(tr);

    }

    visDeltagerListen () {
        this.deltakere.sort((a, b) => a.slutt_tid.localeCompare(b.slutt_tid));
        this.resultatBody.innerHTML = '';

        let plasseringDeltager = 1;

        for (let i = 0; this.deltakere.length > i; ++i) {
            const deltaker = this.deltakere[i];

            if ((this.nedreTid.value === "" || deltaker.slutt_tid >= this.nedreTid.value) &&
                (this.ovreTid.value === "" || deltaker.slutt_tid <= this.ovreTid.value)) {

                const tr = document.createElement('tr');
                tr.innerHTML = `
                <td>${plasseringDeltager++}</td>
                <td>${deltaker.startnr}</td>
                <td>${deltaker.navn}</td>
                <td>${deltaker.slutt_tid}</td>
                `;
                this.resultatBody.appendChild(tr);

            }
        }
    }


// denne gjør sånn per-tom tomsen blir Per-Tom Tomsen som i oppgaven
  normName(n) {
    return n.trim().split(/\s+/).map(w =>
      w.split('-').map(p => p ? p[0].toUpperCase()+p.slice(1).toLowerCase() : p).join('-')
    ).join(' ');
  }
  validate(inputEl){
    if (!inputEl.checkValidity()) {
    const v = inputEl.validity;
    const msg =
        v.valueMissing ? (inputEl.title || 'Feltet må fylles ut.') :
            v.patternMismatch ? (inputEl.title || 'Ugyldig format.') : 'Ugyldig verdi.';
    inputEl.setCustomValidity(msg);
    inputEl.reportValidity();
    try { inputEl.focus(); } catch {}
return false;
}
return true;
}




  handle() {
      const s = this.startInput.value.trim();
      const n = this.nameInput.value.trim();
      const t = this.timeInput.value.trim();

    const navn = this.normName(n);
    const tid  = t;

    this.messageSpans[0].textContent = navn;
    this.messageSpans[1].textContent = s;
    this.messageSpans[2].textContent = tid;
    this.messageParagraph.classList.remove('hidden');

      this.deltakere.push({startnr: s, navn: n,slutt_tid: t});
   // this.resultatListe(s, n, t);

    this.startInput.value = '';
    this.nameInput.value  = '';
    this.timeInput.value  = '';
    this.startInput.focus();
  }
}

const rootelement = document.getElementById('root');
new DeltagerManager(rootelement);
console.log(this.deltakere);

