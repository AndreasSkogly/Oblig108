package model;


public class Vare {

    private int id;
    String navn;
    int pris;
    String bildefil;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBildefil() {
        return bildefil;
    }

    public void setBildefil(String bildefil) {
        this.bildefil = bildefil;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
