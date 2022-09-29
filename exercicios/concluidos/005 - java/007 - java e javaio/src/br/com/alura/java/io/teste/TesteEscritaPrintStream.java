package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStream {
    public static void main(String[] args) throws IOException {
        // Fluxo de sáida de arquivos

//        OutputStream fos = new FileOutputStream("lorem2.txt");
//        Writer osw = new OutputStreamWriter(fos);
//        BufferedWriter bw = new BufferedWriter(osw);

//        FileWriter fw = new FileWriter("lorem2.txt");
//
//        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
//        fw.write(System.lineSeparator());
        PrintStream ps = new PrintStream("lorem2.txt");
        ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
        ps.println("asfasdfsafdas dfs sdf asf assdß");

       ps.close();

    }
}
