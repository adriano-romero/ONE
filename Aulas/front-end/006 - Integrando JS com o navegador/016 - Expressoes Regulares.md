# Expressões regulares: capturando textos de forma mágica
- Uma expressão regular, ou Regex, são padrões utilizados para identificar determinadas combinações ou cadeias de caracteres em uma string.
- Utiliamos Regex no JS com o construtor `new RegExp(padrão[, flags])`
  - padrão é o texto da empressão regular
  - As flags podem ser adicionadas para adicionar opções. `g` para buscar todas, "global", `i` ignorar case sensitive, etc.
- Há meta-chars que tem significados especiais.
- `*` Corresponde a expressão que o precede repetida 0 ou mais vezes.
- `+` significa uma ou mais vezes. `\s+` por exemplo.
- `.` Corresponde a qualquer caracter, menos o de nova linha
- Podemos "escapar" o caracter com `\`
- `\d` Encontra número
- `?` Significa 0 ou uma vez o caracter.
- Podedemos usar quantifiers com `{n}`, `\d{3}` encontra 3 dígitos em sequência, `\d{0,4}` encontra de 0 a 4, `\d{5,}` pelo menos 5.
  - Assim, podemos definiar o CPF por `\d{3}\.\d{3}\.\d{3}\-\d{2}`
- `[]` significa cadeia de caracteres naquela posição.
  - metachars dentro dele não serão escapados.
  - `[A-Z]` significa uma letra maiúscula.
  - `[a-z]{3,8}` define de 3 até 8 leitras minúsculas.
- `\s` define `whitespace`. `\s{1,}` significa um ou mais, é um atalho para `[ \t\r\n\f]`
- Classes de caracter como `[A-Z]` não pegam caracteres especiais como `ç` ou `ó`, é necessário adicioná-los manualmente. Exemplo: `[A-Zçó]`
- `\w` significa word char e é uma atalho para `[A-Za-z0-9_]` 
- Âncora devolvem posições, não caracteres, por isso não é possível combiná-las com um quantifier.
- `\b` é a word boundary. Exemplo: `\bde\b` encontra "de", mas não "grande" e não seleciona espaços. Ou seja, antes ou depois da sequência, não pode ter um word-char([A-Za-z0-9_])
- `^` significa início da expressão ou linha.
  - `[^]` Dentro de um colchete significa não os seguintes, exemplo: `[^abc]` significa não a, b ou c.
- `$` âncora de final de texto. Por exemplo, `/r$/` não corresponde ao 'r' em "corre", mas acha correspondência em "correr".
  - Dessa forma, `^file.+\.html$` signfica algo com "file" no início e ".html" no final.
- `\B` é non-word boundary, isso é, achar algo dentro da palavra, nunca no início ou no fim. EX: `\Bpor\B` em "português proporcional compor" retornaria apenas "proporcional"
- Usamos `()` para definir grupos. Eles não alteram como a Regex funciona, mas podem retornar só um pedaço dentro dela. `[0123]?\d\s+de\s+[A-Z][a-zç]{1,8}\s+de\s+([12]\d{3})` retorna "1 de Maio de 1993" e o grupo 1993
- `(?:conteudo)` é para Non-capturing groups, ele não altera o conteúdo do grupo, mesmo que o Regex o capture.
- `|` também chamado de pipe serve como "ou"
- Todos os quantifiers (`? + * {n.m}`) são gananciosos por padrão, isso é, aceitarão o máximo que puder, resolvemos isso com `?`. `<h1.+?>` terminaria na primeira tag enquanto `<h1.+>` encontraria o conteúdo até a tag de fechamento. `<h1.+?>([\w\sõãí.]+)</h1>` selecionaria tudo mas retorna o texto dentro do "h1"
- Podemos referenciar grupos com "backreferences", usando `\numero`. Ex: `<(h1|h2).+?>([\w\sõãí.]+)<\/\1>` captura a expressão e aceita `<h1>` e `<h2>` desde que o fechamento seja idêntico.
- As vezes é mais fácil negar tudo que não queremos. Por exemplo. `<h1[^>]+>` Seleciona todo o conteúdo dentro de `<h1 class=teste>` mas nada além disso.
- Podemos iniciar o Regex no JS com `RegExp` ou com a expressão literal. exemplos:
  - `var exp = new RegExp('(\d\d)(\w)', 'g');`
  - `var exp = /(\d\d)(\w)/g;` Essa forma deve ser utilizada quando o pattern é constante, e possui um melhor desempenho.
- Temos flags como `g` para global, `i` para ignorecase e `m` para aplicar ao regex a múltiplas linhas, Nesse caso, as âncoras ^ e $ selecionam o início e o fim de uma linha, e não da string inteira.
- Devemos executar `.exec(alvo)` para continuar retornando os próximos resultados do Regex.
- oda string em JavaScript possui o método `match`. Ele aceita uma expressão regular e retorna em um array todas as partes do alvo que atendem a expressão regular. ex: `var codigosExtraidos = codigos.match(exp);`
- O HTML5 introduziu para as tags input o atributo `pattern`. Mas é importante que o input faça parte de um formulário, caso contrário a validação não será aplicada
- No PHP devemos definir uma regex dentro do caracteres `~regex aqui~`. ex: `$regexp = '~(\d\d)(\w)~';`
- Para executar e encontrar o primeiro match, usamos a função preg_match:`$alvo = '12a34b56c'; $achou = preg_match($regexp, $alvo, $match);`
- Caso desejemos receber os índices, devemos passar mais um parâmetro na função `preg_match`. Ex: `$achou = preg_match($regexp, $alvo, $match, PREG_OFFSET_CAPTURE);`
- Igualmente também tem um método que busca todos os resultados da regex dentro do alvo: `$achou = preg_match_all($regexp, $alvo, $matches)`
  - A função `preg_match_all` cria um array bidimensional. Na primeira posição tem todos os resultados do match inteiro, na segunda posição possui todos os matches do primeiro grupo, e a terceira do segundo grupo
- Em Python é necessário importar o módulo `re`
- O método `search` recebe como primeiro parâmetro o padrão e como segundo uma string que será vasculhada: `resultado = re.search(r'\d\d\w','11a22b33c')`
  - Repare o r na frente do pattern. Essa letra define uma raw string, isto é, uma string que não escapa nenhum caractere por padrão
- Quando chamamos o método `search`, recebemos um resultado que possui a string encontrada junto com os grupos e as posições de cada um, basta chamar os métodos:
```python
>>> resultado = re.search(r'(\d\d)\w','11a22b33c')
>>> resultado.group()
11a
>>> resultado.group(1)
11
>>>resultado.start()
0 
>>>resultado.end()
3
```
- É importante saber que o método search não aplica a regex globalmente e apenas devolve informações sobre o primeiro match. Para aplicar a regex na string inteira e devolver todas as informações, existe o método re.finditer
- Para melhorar o desempenho, o Python também possui uma forma de compilar a regex antes de usá-la:
  - `regex = re.compile(r'(\d\d)\w')`
  - `resultados = regex.finditer('11a22b33c')`
- O método `re.findall` retornará todos os matches, como uma lista de strings.
- No mundo Java, a classe principal para trabalhar com expressões regulares se chama `Pattern` e faz parte do pacote `java.util.regex`
- Bons sites para trabalhar com Regex são:
  - https://regexr.com
  - https://regex101.com