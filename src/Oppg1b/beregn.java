package Oppg1b;

import java.util.function.BiFunction;

public class beregn {


    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> summerFunksjon) {
        return summerFunksjon.apply(a, b);
    }

    public static void main(String[] args) {


        BiFunction<Integer, Integer, Integer> summerTall = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> storstAvTallene = (x, y) -> Math.max(x, y);
        BiFunction<Integer, Integer, Integer> avstandFunksjon = (x, y) -> Math.abs(x - y);

        int sum = beregn(12, 13, summerTall);
        int storst = beregn(-5, 3, storstAvTallene);
        int avstand = beregn(54, 45, avstandFunksjon);

        System.out.println("Sum av 12 og 13 = " + sum);
        System.out.println("Største av -5 og 3 = " + storst);
        System.out.println("Avstanden mellom 54 og 45 = " + avstand);
    }
}
