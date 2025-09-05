package Oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        ArrayList<Ansatt> an = new ArrayList<Ansatt>();

        int vanligTillegg = 10000;
        double prosentTillegg = 1.03;
        int lavLonn = 400000;
        int lavLonnTillegg = 50000;
        double kjonnsSats = 0.70;

        Function <Ansatt, Integer> vanlig = a -> a.getAarslonn() + vanligTillegg;
        Function <Ansatt, Integer> prosent = a -> (int) (a.getAarslonn() * prosentTillegg);
        Function <Ansatt, Integer> lonnLav = a -> a.getAarslonn() < lavLonn ? a.getAarslonn() + lavLonnTillegg : a.getAarslonn();
        Function <Ansatt, Integer> kjonnFratrekk = a -> a.getKjonn() == Kjonn.DAME ? (int) (a.getAarslonn() * kjonnsSats) : a.getAarslonn();

        an.add(new Ansatt("Daniel", "Hyssingen", "Sjef", Kjonn.MANN, 1000000));
        an.add(new Ansatt("Andreas", "Skogen", "Utvikler", Kjonn.MANN, 800000));
        an.add(new Ansatt("Siri", "Eple", "Designer", Kjonn.DAME, 300000));
        an.add(new Ansatt("Kjersti", "Løkrull", "Vaskedame", Kjonn.DAME, 200000));
        an.add(new Ansatt("Jesper", "Lette", "Utvikler", Kjonn.MANN, 600000));


        lonnsoppgjor(an,lonnLav);
        lonnsoppgjor(an,prosent);
        lonnsoppgjor(an,kjonnFratrekk);
        lonnsoppgjor(an,vanlig);
        skrivUtAlle(an);
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function <Ansatt, Integer> lonnFunksjon) {
        for (Ansatt a : ansatte) {
            a.setAarslonn(lonnFunksjon.apply(a));
        }



    }

    private static void skrivUtAlle(List<Ansatt> ansatte) {
        ansatte.forEach (System.out::println);

    }



}

