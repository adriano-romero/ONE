# Java e java.io: Streams, Reader e Writers
- Um exemplo de fluxo de entrada de arquivo é:
    ```java
    FileInputStream fis = new FileInputStream("lorem.txt");
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(isr);
    ```
- Esse padrão acima é chamado `decorator`, onde um objeto decora/complementa o outro.
- Podemos dividimos entre `Streams`, `Readers` e `Writers` 
- Um exemplo de fluxo de saída em arquivo:
    ```java
    OutputStream fos = new FileOutputStream("lorem2.txt");
    Writer osw = new OutputStreamWriter(fos);
    BufferedWriter bw = new BufferedWriter(osw);
    ```
- O fluxo do teclado é identificado por `System.in`
- Para escrever no console, usa-se `OutputStream os = System.out;`
- Como o Line Separator varia conforme Sistemas Operacionais, o Java oferece o método `System.lineSeparator()`
- `PrintStream` e `PrintWriter` são parecidos, o primeiro escreve na forma nativa da máquina, enquanto o segundo usa difernte encondings.
- Com `long millis = System.currentTimeMillis();` recebemos os milissegundos que passaram desde 1 de janeiro de 1970. Podemos usar para medir tempos de execução por exemplo.
- `Scanner` permite a leitura de arquivos e o `parse` de tipos primitivos.
- No `Scanner` podemos definir um delimitador com `useDelimiter()`  e `.next()`, `nextInt()`, `nextDouble()`e afins para selecionar cada atributo.
- `useLocale()` define algumas regras como representação por números por ponto e afins. exemplo: ` linhaScanner.useLocale(Locale.US);;`
- Podedemos usar o `System.out.format()` para exibir variáveis, especificando o tipo. Os mais comuns são `%s` para `String`, `%d` para decimais, `%f` para float/double. Assim como `"string %s aqui".formatted()` para fazer o mesmo direto na string.
- Podemos guardar informações com a classe `Properties` e combinações de chave/valor. ex: `Properties props = new Properties(); props.setProperty("login", "alura");`
  - `props.store(new FileWriter("conf.properties"), "algum comentário");`
  - `props.load(new FileReader("conf.properties"));String login = props.getProperty("login");`]
- Diferente do ASCII, o Unicode tenta representar todos os caracteres do mundo.
- Mais do Unicode pode ser visto [aqui](https://home.unicode.org).
- A classe `Charset` representa encondificações e possui métodos para trabalhjar com eles, como `Charset.defaultCharset();` para descobrir o Enconding padrão do sistema. 
- A serialização é a transformação do objeto Java, localizado na memória, em um fluxo de bits e bytes, e vice-versa.
  - `java.io.ObjectOutputStream` = Objeto -> Bits e Bytes
  - `java.io.ObjectInputStream` = Bits e Bytes -> Objeto
- Se não for especificado o `private static final long serialVersionUID`, qualquer mudança na Classe resultará numa mudança do número de Serialização.
- A boa prática é definir um `serialVersionUID` e alterá-lo a qualquer mudança imcompatível.
- Se a casa mãe é Serializável, não é necessário implementa rna classe-filha.
- Também será necessário implementar em objetos-atributos. Para não ser necessário, é necessário colocar a keyword `transient`