# Java e java.util: Coleções, Wrappers e Lambda expressions
- `Array` no jva é definido por `[]` seu tipo e tamanho, ex: `int[] nums = new int[5];` ou `int[] refs = {1,2,3,4,5};`
- Os Arrays no Java não são dinâmicos, para isso é necessário usar `Collections` e `ArrayList`
- Array é inicialziado com os valores padrões.
- Em `Array`, `length` é um atributo e não um método
- Podemos utilizar `cast` para atribuir métodos genéricos para mais específicios. Ex: `ContaPoupanca ref2 = (ContaPoupanca) contas[1];`
- o `String[]` no `main` serve para que possamos passar parâmetros a partir do terminal, podemos alterar os `Program Arguments` na IDE
- O `ArrayList` permite array dinâmicos e é importado do `java.util.ArrayList`, usa um Array internamente.
- `for(Object o : lista) {o.algo}` é uma forma de interagir com ArrayLists, é uma alternativa o equivalente a "forEach"
- Um `ArrayList` não tem limite especificado, o limite é a memória da JVM.
- Podemos definir um tipo para o `ArrayList` entre `<>`, os chamados `generics`. Exemplo:  `ArrayList<Conta> lista = new ArrayList();`
  - Ainda se pode definir um tamanho inicial, exemplo:  `ArrayList<Conta> lista = new ArrayList(26);`
  - E iniciar uma lista a partir de outra. `ArrayList nova = new ArrayList(lista); `
- `contains(obj)` trabalha com referências, então objetos diferentes, mas com os mesmos atributos, são considerados diferentes.
- Para resolver isso, é necessário um `@Override` no método `public boolean equals(Object ref) {} `, com cast interno, para comparar os atributros de cada objeto.
- O `ArrayList` não é suficiente para inserir elementos no início e apagá-los, pq ele precisa reorganizar o Array a cada elemento apagado.
- A alternativa é o `LinkedList` que guarda o primeiro elemento e cada elemento tem uma ligação para o próximo e anterior.
- Uma desvantagem da `LinkedList` é que para iterar sobre ele, necessariamente começa no início.
- `List` é uma interface, a `ArrayList` e a `LinkedList` são implementações
- A classe `java.util.Arrays` possui vários métodos estáticos auxiliares para trabalhar com arrays. 
  - Um deles, permite a conversão de Arrays para Listas, exemplo: `List<String> argumentos = Arrays.asList(args);`
- Internamente, `java.util.Vector` também usa o `ArrayList`, a diferença é que ele é threadsafe, isso é, pode ser manipulado através de várias pilhas de execução concorrentemente.
- Além dessas listas, a `Collections` implementa `java.util.Set` e `java.util.HashSet`
- Não se trata de sequências, os sets espalham seus elementos com base no `hashCode()`
- O array pode ser primitivo, onde cada casa guarda o valor primitivo, ou de referência, onde cada case guarda o "valor" para encontrar o objeto, mas nas listas só há referências.
- Não se cria uma lista de primitivos, como `List<int>`, mas de seus objetos, o chamado `autoboxing`, exemplo: `List<Integer>`
- A transformação do tipo primitivo para o objeto referência acontece automaticamente, e é chamada de `autoboxing`. O caminho inverso é chamado de `unboxing`.
- As classes que existem para cada tipo primitivo se chamam `wrappers`. Isso porque elas "embrulham" o tipo primitivo do objeto, que internamente guarda o valor primitivo
- `parse` transforma o elemento em um tipo primitivo. ex: `.parseInt(s)`
- A classe `java.lang.Number` é estendida por `Double`, `Float`, ambas flutuantes, `Long`, `Integer`, `Short` e `Byte`. ex:
  ```java
  List<Number> lista = new ArrayList<>();
          lista.add(10);
          lista.add(32.6);
          lista.add(25.6f);
  ```
- A classe string tem o método `compareTo()` para comparações.
- Podemos implementar um `Comparator` e dar override no método `compare (a,b)` para realizarmos `sort()` no Java.
- A forma legada de usar comparações é usando o `Collections`
- Podemos utilizar uma "ordem natural" isso é, como a comparação será realizada se não for utlizado um comparator. É com a interface `Comparatable`
- Se passarmos `null` para `.sort()` para o `ArrayList`, ele usará a ordem natural definida.
- Podemos criar classes anônimas em Java. Utizamos `new ParentClass/InterfaceName (){}` onde `()` são os argumentos do `construror` da `ParentClass` e `{}`são os métodos a serem implementadaos
- `Function Object` é um objeto que só encapsula uma função/método/procedimento. As classes anônimas facilitam um pouco a criação desses objetos.
- As funções lambda são funções sem declaração, exemplo: `(int a, int b) -> {  return a + b; }`