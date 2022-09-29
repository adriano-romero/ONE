package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintWriter;


public class TesteEscritaPrintWriter {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("lorem2.txt", "UTF-8");

        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");

        pw.close();

       pw.close();

    }
}
