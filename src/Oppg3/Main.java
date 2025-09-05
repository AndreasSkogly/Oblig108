package Oppg3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ansatt> an = new ArrayList<>();
        ArrayList<String> anLastName = new ArrayList<>();

        an.add(new Ansatt("Daniel", "Hyssingen", "Sjef", Kjonn.MANN, 1000000));
        an.add(new Ansatt("Andreas", "Skogen", "Utvikler", Kjonn.MANN, 800000));
        an.add(new Ansatt("Siri", "Eple", "Designer", Kjonn.DAME, 300000));
        an.add(new Ansatt("Kjersti", "Løkrull", "Vaskedame", Kjonn.DAME, 200000));
        an.add(new Ansatt("Jesper", "Lette", "Utvikler", Kjonn.MANN, 600000));

        an.forEach(a -> anLastName.add(a.getEtternavn()));

        skrivUtAlle(anLastName);

        }

    private static void skrivUtAlle(List<String> etternavn) {
        etternavn.forEach (System.out::println);

    }


    }



