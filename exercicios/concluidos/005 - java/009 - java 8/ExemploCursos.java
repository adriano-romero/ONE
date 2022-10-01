import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
        //cursos.forEach(c-> System.out.println(c.getNome()));
        //Imprimindo cursos com mais de 100 membros
        cursos.stream().filter(c->c.getAlunos()>=100).forEach(c-> System.out.println(c.getNome()));
        cursos.stream().filter(c->c.getAlunos()>=100).map(c->c.getAlunos()).forEach(System.out::println);

        int sum = cursos.stream().filter(c->c.getAlunos()>=100).mapToInt(Curso::getAlunos).sum();

        // Como transformar o nosso Stream<Curso> em um Stream<String> contendo apenas os nomes dos cursos?
        //Stream<String> nomes = cursos.stream().map(Curso::getNome);

        cursos.stream().filter(c -> c.getAlunos() > 100).findAny().ifPresent(c-> System.out.println(c.getNome()));
        //Optional<Curso> optional = cursos.stream().filter(c -> c.getAlunos() > 100).findAny();
        //Curso curso = optional.orElse(null);
        //System.out.println(curso.getNome());
        List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());

        Map mapa = cursos
                .stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome +" tem " + alunos + " alunos"));


    }
}
