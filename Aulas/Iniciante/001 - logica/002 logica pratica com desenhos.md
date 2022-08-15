# Curso de Lógica de programação II: pratique com desenhos, animações e um jogo
- Recapitulando: O canvas (tag html) é uma área da tela onde podemos desenhar, escrever com um pincel.
- para desenhar uma forma pomos seguir os passos:
- pincel(de var tela = document.querySelector("canvas");
    var pincel = tela.getContext("2d");
)
- pincel.beginPath();
- pincel.moveTo( coordenadas para iniciar);
- pincle.lineTo (cordenadas para traçar linha);
- pincel.fill(); para preencher a forma.
- Mais info: https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D
- Não atribuímos paranteses as funções se não quisermos que elas sejam executadas imediatamente.
- Na função para mudar o menu de contexto em programa3.html. o return false é para não exibir o menu de contexto padrão (oncontextmenu)
- A função `setInterval(funcao,tempo)` serve para definirmos em milisegundos o intervalo que uma função será executada novamente
- Sempre manter o escopo dos parâmetros (global ou local) em mente ao construir as funções.