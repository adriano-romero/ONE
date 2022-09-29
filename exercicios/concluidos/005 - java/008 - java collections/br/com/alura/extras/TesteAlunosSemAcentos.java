package br.com.alura.extras;

import java.util.HashSet;
import java.util.Set;

public class TesteAlunosSemAcentos {
    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");

        System.out.println(alunos.size());

        //tente adicionar um aluno que existe
        boolean adicionou = alunos.add("Pedro");
        System.out.println("Pedro foi adicionado ao Set? " + adicionou);

        System.out.println(alunos.size());
    }
}
