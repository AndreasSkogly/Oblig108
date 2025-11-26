package model;

public class Ordrelinje {

    private Vare vare;
    private int antall;


    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public Vare getVare() {
        return vare;
    }

    public void setVare(Vare vare) {
        this.vare = vare;
    }

   public int getBelop() {
        return vare.getPris() * antall;
   }
}
