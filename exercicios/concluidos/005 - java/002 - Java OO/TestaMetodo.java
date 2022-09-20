import bytebankcomposto.Conta;

public class TestaMetodo {
    public static void main(String[] args) {
        Conta contaDoPaulo = new Conta(100, 1);
        contaDoPaulo.deposita(100);
        contaDoPaulo.deposita(50);
        System.out.println(contaDoPaulo.getSaldo());

        boolean conseguiuRetirar = contaDoPaulo.saca(20);
        System.out.println(contaDoPaulo.getSaldo());
        System.out.println(conseguiuRetirar);

        Conta contaDaMarcela = new Conta(100, 2);
        contaDaMarcela.deposita(1000);

        boolean sucessoTransferencia = contaDaMarcela.transfere(300, contaDoPaulo);
        if (sucessoTransferencia) {
            System.out.println("transferencia com sucesso");
        } else {
            System.out.println("faltou dinheiro");

        }
        System.out.println("Saldo conta Marcela: " + contaDaMarcela.getSaldo());
        System.out.println("Saldo conta Paulo: " + contaDoPaulo.getSaldo());
    }
}
