# Java e java.lang: programe com a classe Object e String
- Pastas em Java são "packages" e necessitam a keyword `package` na declaração do arquivo.
- Os pacotes fazem parte do "nome" da Classe, chamado de `Full Qualified Name`, então devemos usar o "pacote.Classe" para utilizar métodos/classes de outros pacotes, ou realizar o `import` no início do arquivo.
- A primeira declaração no arquivo será o `package`, a segunda `import` e depois a classe.
- A nomeclantura padrão de pacotes é `NOME_DO_SITE_AO_CONTRARIO.NOME_DO_PROJETO` ou seja: `país.com.empresa.projeto.pacote`, exemplo: `br.com.bytebank.banco.modelo`
- `ctrl+shift+o` no eclipse e `ctrl+alt+o` no Intellij organiza os imports


    | Modificadores de Acesso/Visibilidade |
    |--------------------------------------|
    | public                               |
    | protected                            |
    | "package private"                    |
    | private                              |
- Esses modificadores se dividem em: 
  - `public`:visível em todos os espaços
  - `protected`: visível dentro do pacote e público para os filhos
  - `<package private>`: ausência do modificador, visível apenas dentro do pacote
  - `private`: visível apenas dentro da classe
- Javadocs (documentação das classes e métodos) é gerado com `/**`
  - Pode-se usar tags como `@author`, `@version`, `@exception`
- Apenas métodos públicos são contemplados nos javadocs.
- O arquivo `jar` é um zip com os arquivos do projeto compilado. No Eclipse, se gera com `Export>java>jar files`, no `Intellij, File | Project Structure | Artifacts `then you should press alt+insert or click the plus icon and create new artifact choose --> jar --> From modules with dependencies. Then go to `Build | Build artifacts` --> choose your artifact.
- Pode-se criar uma pasta no projeto e deixar as bibliotecas usadas nela. Após isso, basta adicioná-las no `buildpath`. No intellij, `Project Structure > Modules> Dependencies > JARs or directories` ou botão direito `Add as library`
- Para um arquivo executável no Eclipse, selecionar `Export>java>runnable jar files`
- Executa-se com o comando no console `java -jar arquivojar`
- Dentro do jar executável, há uma pasta `META-INF` e um arquivo `MANIFES.MF`
- Maven e Gradle são ferramentas para ajudar no gerenciamento de dependências.
- O pacote `java.lang` é importado por padrão
- Apesar da ausência de `new`, `String` ainda é um objeto
- Uma String é imutável.
- um `char` é represetando por aspas simples
- Alguns méotdos de string são `toLowerCase()`, `toUpperCase()`, `charAt(n)`, `indexOf("substring")`, `length()`, `trim()`, `isEmpty()`
- O tipo `CharSequence` é uma interface que a própria classe `String `implementa (pois uma `String` é uma sequência de caracteres!):
- `StringBuilder` ajuda na concatenação de `Strings` de forma mais eficiente. Ex: 
```java
StringBuilder builder = new StringBuilder("Socorram");
builder.append("-");
builder.append("me");
String texto = builder.toString();
```
- Todas as classes estendem a classe `Object`
- o `println` busca o método `.toString()` automaticamente, portando é possível realizar um `@Override` do método na Classe.