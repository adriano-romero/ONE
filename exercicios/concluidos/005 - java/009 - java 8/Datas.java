import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasParis = LocalDate.of(2024, Month.JULY, 26);
        int anos = olimpiadasParis.getYear() - hoje.getYear();
        System.out.println(anos);

        Period periodo = Period.between(hoje, olimpiadasParis);
        System.out.println(periodo);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());

        LocalDate proximasOlimpiadas = olimpiadasParis.plusYears(4);
        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));

        YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);

        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);

    }
}