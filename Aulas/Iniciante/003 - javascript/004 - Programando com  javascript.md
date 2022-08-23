# JavaScript: programando na linguagem da web
- Javascript é a linguagem de programação nativa da Web. 
- Qualquer navegador dá suporte ao JS, afinal ele é utilizado para dar dinamismo a nossas páginas.
- Recentemente também se expandiu para o lado do servidor com o lançamento do Node.js
- Além do front-end, já há bibliotecas/frameworks para arduíno, banco de dados, aplicativos desktop, etc
- `document` é o objeto que representa toda a página e seu conteúdo. Serve como "ponte" entre o HTML e o JS.
- O JS manipula o "DOM" ous eja, a representação em memória de como a página é renderizada.
- `document.querySelector(seletores)` retorna o primeiro resultado igual aos seletores.
- É uma boa prática deixar o JS no fim da página para que qualquer busca DOM seja feita depois que a página foi carregada.
- `elemento.textContent` terá só o conteúdo do elemento, sem a sua tag e pode ser reatribuído.
- É uma boa prática usar parâmetros menos genéricos, como id e classes no querySelector.
- Outra boa prática é a "separação de mundos" (html, css, js, etc)
- `document.querySelectorAll(seletor)` retorna uma lista com todos os elementos que contém o seletor.
- `numero.toFixed(n)` deixa o número com n casas decimais depois do ponto.
- Ao acessar o `elemento.style` para alterar o css, keys com `-` usam CamelCase no lugar.
- É uma boa prática alterar a classe no css do que adicionar diretamente o elemento no JS.
- `elemento.classList` dá acesso a todas as classes do elemento.
- Os botões dentro de um form por padrão recarregam a página.
- Para impedir que a página seja carregada no submit adicionar um `preventDefault` exemplo:
    ```javascript
    var botaoAdicionar = document.querySelector("#adicionar-paciente");
    botaoAdicionar.addEventListener("click", function(){
            event.preventDefault();
    });
    ```
- Criamos elementos HTML com o `.createElement()`
- Adicionamos ao outro com . `appendChild`
- Uma função anônima possui a estrutura `function () {}`
- Uma boa prática é a separação das funções em arquivos e a criação de objetos quando necessário.
- um Objeto é criaro por `var nome = {key: value}`
- Podemos interagir com array com os métodos `.push()` e `.pop()`
- em `if` simples, poderemos remover as chaves `{}` e colocar o código em uma única linha.
- além do `for` podmeos usar o `.forEach()` para interagir com um array.
- `.innerHTMl` permite controlará as propriedades internas de um elemento.
- `dblclick` é o evento de duplo clique.
- Um evento não será implementado aos novos elementos inseridos na página.
- Para isso é necessário o "Event Bubbling", isso é, ao invés de deixar um evento pra cada item, deixar para o "pai" desses.
- Para remover uma linha na tabela, usariamos o `event.target.parentNode.remove();`
- Podemos usar a `setTimeout(funcao,tempo)` par executar a ação após determinado tempo.
- `var expressao = new RegExp(padrão, [flags]);` Inicia uma expressão regular, com 2valores, o que você quer pesquisar e flags de como.
    - Como exemplo, a flag `i` para `case insensitive`
- `podemos usar expressao.teste(nome)` para comparar a expressão com um pedaço do nome e não ele completo.
- Uma alternative a expressão regulares é o uso do método `substring(inicio, fim)`.
- O `XMLHttpRequest` é um objeto do JS responsável por fazer requisições HTTP. O trecho XML do nome indica que ele era utilizado anteriormente para realizar o transporte de dados do tipo XML, no entanto, atualmente ele consegue trafegar outros tipos de dados, como textos.
- a requisição só é enviada mesmo após chamarmos o método `.send().`