# JavaScript na Web: validação de Formulários e HTML5
- O atributo `password` em HTMl apenas mascara o que está sendo digitado, sem nenhuma validação além disso.
- `min-length` adiciona um número mínimo para ser válido, `man-length` funciona de forma similar
- O atributo `pattern` permite o uso de Regex para atribuir uma verificação à senha.
- O atributo `title` pode ser usado como dica para informar como a senha deve ser feita.
- https://regexr.com fornece uma tabela com exemplos, um cheatsheet com algumas regras e também um validador explicando tudo o que está acontecendo durante a escrita.
- Usamos a ValidationAPI, com `validity` para verificar requerimentos diferentes e organizar de acordo
- [SimpleMaskMoney](https://github.com/codermarcos/simple-mask-money) é uma extensão para adicionar máscara monetária.