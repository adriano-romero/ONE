package br.com.bytebank.banco.teste;

public class TesteString {
    public static void main(String[] args) {
        String nome = "Alura";
        System.out.println(nome);
        nome = nome.toLowerCase();
        System.out.println(nome);


        int pos = nome.indexOf("ur");
        System.out.println(pos);

        System.out.println(nome.length());
        for (int i = 0; i < nome.length(); i++) {
            System.out.println(nome.charAt(i));
        }

        String vazio ="    Alura    ";
        String outroVazio = vazio.trim();

        System.out.println(vazio.contains("Alu"));
    }
}
