import bytebankcomposto.Conta;

public class TesteReferencias {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta(100, 1);
        primeiraConta.deposita(300);

        System.out.println("saldo da primeira: " + primeiraConta.getSaldo());

        Conta segundaConta = primeiraConta;

        System.out.println("saldo da segunda conta: " + segundaConta.getSaldo());

        segundaConta.deposita(100);
        System.out.println("saldo da segunda conta " + segundaConta.getSaldo());

        System.out.println(primeiraConta.getSaldo());

        if(primeiraConta == segundaConta) {
            System.out.println("é a mesma conta");
        }

        System.out.println(primeiraConta);
        System.out.println(segundaConta);
    }
}