package Oppg1a;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

            listen.sort((s1, s2) -> Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)));
            System.out.println(listen);

            };
    }







