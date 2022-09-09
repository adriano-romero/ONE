# CRUD com JavaScript assíncrono.
 CRUD é um acrônimo para criar, ler, atualizar e deletar dados de uma aplicação.
- Podemos usar o `json-server` para simular uma API REST, podemos ativá-lo com `npx json-server --watch db.json`
- É possível encadear operações assíncronas para que o conteúdo seja carregado na sequência, os chamados callbacks. Uma alternative a isso são as `promisses`
- Podemos criar um evento por exemplo, `onload` depois do `XMLHttpRequest.send` para lidar com a requisição após o `send.` Assim não há risco de se usássemos um evento `load` no lugar e ele carregar durante o processo do `send`.
- Uma `Promisse` tem dois argumentos, `resolve` para resolver o callback e `reject` para rejeitá-las.
- Com o tempo esse tipo de abordagem ficou muito comum, então acabaram se juntando esse tipo de fazer requisição, com XML e lidar com promise, e assim foi criado a `fetch API`.
- Ao invés de usar vários `then` numa sequência de callbacks, podemos usar `Promisse.all([Array])` para executar todas as funções em sequência.
- `fetch` combina o HttpRequest e a Promisse.
- Podemos usar o `browser-sync` para testar múltiplos browsers.
  - `browser-sync start --server --file . --host --port 5000 --startPath admin/telas/lista_cliente.html` rodaria a página lista_cliente na porta 5000.
- JS é single thread, usa da WebAPi e callstack para executar funções.
- `HTMLElement.dataset` é usado para alterar atributos read-only `data-`, como o id.
- `searchParams.get` pega as informações do GET.
- Podemos definir uma função assíncrona com `async` e usando `await` no lugar do then(parará a execução da função e esperará a resolução do async)