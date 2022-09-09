# JavaScript: programando a Orientação a Objetos
- A ideia da OO é criar um "molde", já que algumas informações serão repetidas sempre.
- `class Nome {key:value,k:v}` é como se declara classes em JS.
- Criamos um novo objeto da classe atribuindo com com `= new Classe()`
- Acessamos as propriedades do objeto através de `objeto.atributo`
- Uma vantagem é que alterações na declaração da Classe afetarão todo o projeto.
- Podemos adicionar métodos as Classes para evitar a repetição de funções.
- Atributos e méotodos privados podem ser criados usando `#` na declaração.
- A convenção antes de existir o `#` é que elementos com `_` no início são privados
- Early return é o conceito diz que você deve se preocupar em retornar o resultado da função o quanto antes, ou seja, você irá estruturar o código da função de forma que retorne o mais rápido possível o valor esperado.
- Arquivos com letras maiúscula são para representar classes.
- Temos que definir os módulos do node no `package.json` ou ele será definido como um script.
- Podemos escrever um script com o comando que colocaríamos no terminal, por exemplo:
  ```
  "scripts": {
    "start": "node index.js"}
  ```
- E ao invés de escrever esse comando podemos chamar o script com o comando npm start
- As especificações do `package.json` no npm podem ser encotnradas [aqui](https://docs.npmjs.com/cli/v8/configuring-npm/package-json)
- Podemos adicionar atributos dinamicamente no JS.
- Quando passamos tipos primitivos para uma função, estamos trabalhando com uma "cópia" dela, em compensação, o Objeto é passado como referêcia, então qualquer alteração refletirá nele.
- `constructor()` é uma função que define os atributos recebidos para criar um objeto.
- `static` é um método para toda a classe e não para cada instância.