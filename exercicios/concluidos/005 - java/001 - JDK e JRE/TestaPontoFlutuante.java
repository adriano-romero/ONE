public class TestaPontoFlutuante {
    public static void main(String[] args) {
        double salario = 1250.70;
        System.out.println("meu salário é "+ salario);

        double divisao = 3.14 / 2;
        System.out.println(divisao);

        int outraDivisao = 5/2; //Resultado será 2
        System.out.println((outraDivisao));

        double novaTentativa = 5/2; // Resultado será 2.0, necessário especificar um dos 2 como double.
        System.out.println(novaTentativa);

        double tentativaCerta = 5/2.0;
        System.out.println(tentativaCerta);
    }
}
