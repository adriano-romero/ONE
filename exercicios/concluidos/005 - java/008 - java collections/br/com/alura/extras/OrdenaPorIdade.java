package br.com.alura.extras;

import br.com.alura.modelo.Funcionario;

import java.util.Comparator;

public class OrdenaPorIdade implements Comparator<Funcionario> {


    @Override
    public int compare(Funcionario funcionario, Funcionario outroFuncionario) {
        return funcionario.getIdade() - outroFuncionario.getIdade();
    }

}
