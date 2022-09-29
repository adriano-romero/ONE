package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestArrayReferencias {
    public static void main(String[] args) {
        //int[]idades = new int[5]; //inicializa o array com os valores padroes

        Conta[] contas = new Conta[5];
        contas[0] = new ContaCorrente(100,11);
        contas[1] = new ContaPoupanca(100,22);
        ContaCorrente cc = new ContaCorrente(100,33);
        contas[2] = cc;
        contas[3] = new ContaCorrente(100,44);
        contas[4] = new ContaCorrente(100,55);

        Conta ref = contas[2]; // aponta para "ContaCorrente cc"
        ContaPoupanca ref2 = (ContaPoupanca) contas[1];

        for (Conta conta : contas) {
            System.out.println(conta);
        }

        System.out.println( contas[1].getNumero() );
        System.out.println(ref2.getNumero());
        System.out.println(ref.getNumero());

    }
}
