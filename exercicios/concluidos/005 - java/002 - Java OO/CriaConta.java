import bytebankcomposto.Conta;

public class CriaConta {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta(100, 1);
        primeiraConta.deposita(200);
        System.out.println(primeiraConta.getSaldo());

        primeiraConta.deposita(100);
        System.out.println(primeiraConta.getSaldo());

        Conta segundaConta = new Conta(100,2);
        segundaConta.deposita(300);

        System.out.println("primeira conta tem " + primeiraConta.getSaldo());
        System.out.println("segunda conta tem " + segundaConta.getSaldo());

        segundaConta.setAgencia(146);
        System.out.println(primeiraConta.getAgencia());
        System.out.println(primeiraConta.getNumero());

        System.out.println(segundaConta.getAgencia());

        segundaConta.setAgencia(146);
        System.out.println("agora a segunda conta está na agencia " + segundaConta.getAgencia());

        if(primeiraConta == segundaConta) {
            System.out.println("mesma conta");
        } else {
            System.out.println("contas diferentes");
        }

        System.out.println(primeiraConta);
        System.out.println(segundaConta);
    }
}