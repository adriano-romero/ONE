# HTML5 e CSS3 - Parte I: HTML
- Para realizar as marções em HTMl são necessárias as `<tags>` fechadas por `</tags>`. 
- Para títulos, usa-se heading de `<h1>` até `<h6>`.
- Com título usamos `<p>`
- `<strong>`adiciona o negrito
- `<em>`adiciona ênfase, itálico
- As tags podem ser encadeadas sem nenhum problema.
- a tag `!DOCTYPE` especifica a versão do html, por padrão em maiúsclo.
- `!DOCTYPE html` diz que usará a última versão html disponível
- A tag `meta` é escrita da seguinte forma dentro do nosso HTML: `<meta charset=”UTF8>”` 
- `charset="UTF8"` define o unicode, adiciona acentos e suporta maior partes dos idiomas.
- O HTML é dividido em duas partes. A primeira delas é o head, e a segunda é o body. Se pensarmos em um documento, a cabeça são as informações que estamos passando para o navegador e o corpo são as informações que queremos exibir na página
- Podemos definir a linguagem da página com a propriedade `lang=` dentro da tag `<html>`
- Há tags mais especificas para cada parte do conteúdo como `header`, `main` e `footer`

## Html e CSS - Parte II: CSS
- A propriedade `style=` permite a alteração inline, dentro da tag.
- é definido por `propriedade: valor;`
- Também podemos realizar a estilizzação CSS na tag `<style>`no próprio documento-
- Ou usando um documento externo e incluirmos no `head` ` <link rel="stylesheet" href="style.css">`
- Também podemos definir estilo encadeados:
    ```css 
    em strong {
    color: red;
    }

- A representação de cor pode ser nominal, em hexadecimal e em RGB.
- O espaçamento interno dos elementos é ajustado com `padding` e o externo com `margin`.
- Identificamos classes em CSS com ponto `.nome`
- Para dividir conteúdo, usamos a tag `<div>`
- `display:inline-block` respeita top/bottom margin/padding, não é o caso com `display:inline`
- `display:block` adiciona uma quebra de linha depois do elemento
- É ideal a customização com classes ao invés de tags, por ser menos genérica
- Aumentos a expessura (negrito) do texto com `font-weight: 700`
- Deixamos o texto em maiuscúlo com `text-transform:uppercase`
- Removemos a decoração(sublinhado) de um link com `text-decoration:none`
- Os navegadores tem um estilo padrão, para remover isso, usamos o [reset.css](http://meyerweb.com/eric/tools/css/reset/)
- `position:absolut` serve para posicionar o elemento em qualquer lguar da página
- o `position:relative` no elemento pai é necessário pq o absolut é relativo a página.
- Para centralizar, fazemos `margin:0 auto`
- `border-sizing: border-box` permite que a % se aplique só ao tamanho interno
- também podemos alterar comportamento em ações em elementos filhos.
    ```css
     .produtos li:hover h2 {
        font-size: 34px;
        }
- :hover, :active e similares são chamadas pseudo-classes
- ao usar `background: url("img.jpg");` a imagem é repetida pro todo o conteúdo

## Html e CSS - Parte III: trabalhando com formulários e tabelas
- Nos formulários, label e input andam juntos.
    - Usando o identificador, facilita ao clicar no label redireciona para o input.
- Os elemtentos do `form` são `inline`.
- Para que todos os `input radio` tenham somente uma seleção, unificamos-os pelo `name`
- Para termos as mesmas configurações em 2 seletores, basta usar a vírgula.
- O seletor aplicado no css será o mais específico
- http://mobileinputtypes.com Mostra o resultado esperado ao usar html5 inputs num celular.
    - Sempre bom considerar isso ao criar os inputs (password, email, etc)
- Para tornar um input obrigatório, a palavra é `required`
- `placeholder` para uma mensagem exemoki antes de digitar
- `checked`para deixar um checkbox ou radio pré-marcado
- Usamos `fieldset`e `legend`no lugar de `div` e `p` em campos relacionados num formulário.
- `transition: tempo elemento` para indicar o tempo e onde uma animação será realizada.
- `transform` pode aumentar, rotacionar, entre outras propriedades
-Também podemos seprarar `<table>`com tags específicas, como `<thead>`, `<th>`, `<tbody>` e `<tfoot>`
- `<td colspan="X">` serve para agrupar X células

## Html e CSS - Parte IV: avançando no CSS
- Sempre que queremos falar de estilo, usamos classe. Sempre que queremos falar de comportamento, usamos id.
- Font-size pode ser proporcional, para isso usamos `em`
- `float` diz como um elemento será "levantado" e como o conteúdo agirá em volta dele. 
    - Afeta toda a página, necessário `clear`subsequente caso queira eliminar o efeito em outro elemento.
- Podemos usar mais fontes atravels do Google Fonts e importar estilos através do `import`
- Geralmnte acessos externos são feitos através do `<iframe>`
- `inline-block` reflete até os espaços em brancos no documento, portanto precisam ser colados.
- Podemos usar `background:linear-gradiant(cor1, cor2)` para criarmos um gradiente de n cores
- `elemento::after{content:valor}` para adicionarmos algo depois do elemento.
- Podemos usar `elemento-a>element-b` para selecionar o elemento filho direto
- Podemos usar `elemento-a+element-b` para selecionar o elemento irmão (o seguinte.)
- Podemos usar `elemento-a~element-b` para selecionar todos os depois do elemento-a
- Podemos usar `propriedade:not (element-a)` para selecionar todos os elementos com uma propriedade que não sejam element-a.
- Para controlar a opacidade de todos elementos e todas as cores, usa-se `rgba()`, de camada alfa do RGB.
- `box-shadow:` pode usar várias sombras, basta separá-las por vírgulas.
    - `inset` para criar uma sombra interna ao elemento.
- As sombras também se aplicam às letras dos elementos.
- Para adaptar o CSS a telas diferentes, usamos as media-queries.