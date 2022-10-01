import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;


public class OrdenaStrings {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        //palavras.sort((s1, s2) -> compare(s1.length(),s2.length()));
        //palavras.sort((s1, s2) -> Integer.compare(s1.length(),s2.length()));
        //palavras.sort(Comparator.comparing(s-> s.length()));
        //palavras.sort(Comparator.comparing(String::length));
        palavras.sort(comparing(String::length));
        //palavras.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(palavras);

        palavras.forEach(System.out::println);
    }
}

//Implementações com override nos default methods:

//class ComparadorDeStringPorTamanho implements Comparator<String> {
//    public int compare(String s1, String s2) {
//        if(s1.length() < s2.length())
//            return -1;
//        if(s1.length() > s2.length())
//            return 1;
//        return 0;
//    }
//}

//class ConsumidorDeString implements Consumer<String> {
//    public void accept(String s) {
//        System.out.println(s);
//    }
//}
