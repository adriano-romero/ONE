import bytebankcomposto.Cliente;
import bytebankcomposto.Conta;

public class TestaGetESet {
    public static void main(String[] args) {
        Conta conta = new Conta(100, 1);

        conta.setNumero(1337);
        System.out.println(conta.getNumero());

        Cliente paulo = new Cliente();
        paulo.setNome("paulo silveira");

        conta.setTitular(paulo);

        System.out.println(conta.getTitular().getNome());

        conta.getTitular().setProfissao("programador");
        //agora em duas linhas:
        Cliente titularDaConta = conta.getTitular();
        titularDaConta.setProfissao("programador");

        System.out.println(titularDaConta);
        System.out.println(paulo);
        System.out.println(conta.getTitular());
        System.out.println(titularDaConta.getNome());


    }
}