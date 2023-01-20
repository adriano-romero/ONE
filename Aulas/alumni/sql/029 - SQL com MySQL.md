# SQL com MySQL: manipule e consulte dados
- O `SQL` é um padrão de linguagem de consulta e manipulação de dados, que permite a criação, consulta, atualização e remoção de dados em um banco de dados relacional.
- Tem como vantagens:
  - Ser um padrão de linguagem, ou seja, é independente de qualquer banco de dados específico, favorecendo a portabilidade de código.
  - Ser uma linguagem declarativa, ou seja, não é necessário saber como os dados serão armazenados, apenas como eles devem ser manipulados.
  - Ser uma linguagem de alto nível, ou seja, é fácil de aprender e de usar.
- Tem como desvantagens:
  - Não é possível fazer operações de controle de fluxo, como `if` e `for`.
  - Não atende a todas as demandas do mercado, bancos NoSQL foram criados para atender a algumas dessas demandas, como por exemplo, a necessidade de armazenar dados não estruturados.
  - Não é possível fazer operações de entrada e saída de dados.
  - Não é possível fazer operações de manipulação de arquivos.
- DDL, DML, DCL, TCL são os quatro tipos de comandos do `SQL`:
  - `DDL` (Data Definition Language): comandos para definir a estrutura do banco de dados, como tabelas, colunas, índices, etc.
  - `DML` (Data Manipulation Language): comandos para manipular os dados do banco de dados, como inserir, atualizar e remover dados.
  - `DCL` (Data Control Language): comandos para controlar o acesso aos dados do banco de dados, como definir permissões de acesso.
  - `TCL` (Transaction Control Language): comandos para controlar transações, como iniciar, confirmar e cancelar transações.
---
- Um banco de dados é composto por tabelas, que são estruturas bidimensionais, com linhas e colunas.
- Os valores de cada coluna são chamados de campos e seus tipos são definidos na criação da tabela.
- Registros são as linhas da tabela.
- Cada registro possui um identificador único, chamado de chave primária, que pode ser definida por uma ou mais colunas.
- Chave estrángeira é uma coluna ou conjunto de colunas que referencia uma chave primária de outra tabela.
- Schema é o conjunto de tabelas de um banco de dados.
- A integralidade dos dados é garantida por meio de relacionamentos entre as tabelas.
- Views são consultas que podem ser armazenadas e reutilizadas.
- Consultas são comandos para recuperar dados de uma ou mais tabelas.
- Join é uma operação que permite combinar dados de duas ou mais tabelas.
- Procedures são blocos de código que podem ser executados em um banco de dados. São úteis para executar tarefas repetitivas, como exemplo de uso, podemos citar a criação de um usuário e a criação de um banco de dados para esse usuário.
- Trigger é um procedimento que é executado automaticamente quando uma ação é realizada em uma tabela.
- O `MySQL` é case-insensitive, ou seja, não diferencia maiúsculas de minúsculas.
- Para criar um banco de dados, usamos o comando `CREATE DATABASE`:
```sql
CREATE DATABASE IF NOT EXISTS SUCOS;
```
- Os arquivos `.ibd` são os arquivos de dados do banco de dados no MySQL.
- Também é possível criar um banco de dados através de assistentes gráficos, como o `phpMyAdmin` ou o `MySQL Workbench`.
- Para apagar um banco de dados, usamos o comando `DROP DATABASE`:
```sql
DROP DATABASE SUCOS;
```
- Para acessar o mysql por linha de comando, usamos o comando `mysql`, podemos definir um host, usuário e informar que digitaremos a senha:
```bash
mysql -h localhost -u root -p
use SUCOS;
```
- Os principais tipos de dados em MySQL são:
  - `CHAR`: armazena uma cadeia de caracteres de tamanho fixo.
  - `VARCHAR`: armazena uma cadeia de caracteres de tamanho variável.
  - `TEXT`: armazena uma cadeia de caracteres de tamanho variável, com até 65.535 caracteres.
  - `INT`: armazena um número inteiro de 32 bits.
  - `BIGINT`: armazena um número inteiro de 64 bits.
  - `FLOAT`: armazena um número de ponto flutuante de 32 bits, o arrendondamento é feito para 4 casas decimais, especificando o número de casas decimais, o arredondamento é feito para o número de casas decimais especificado.
  - `DOUBLE`: armazena um número de ponto flutuante de 64 bits.
  - `DATE`: armazena uma data.
  - `TIME`: armazena um horário.
  - `DATETIME`: armazena uma data e um horário.
  - `TIMESTAMP`: armazena uma data e um horário, com a diferença de que o valor é atualizado automaticamente quando o registro é alterado.
  - `BLOB`: armazena um arquivo binário de até 65.535 bytes.
  - `ENUM`: armazena uma lista de valores pré-definidos.
  - `SET`: armazena uma lista de valores pré-definidos, com a diferença de que cada registro pode ter mais de um valor.
- A propriedade `unsigned` permite armazenar apenas valores positivos, aumentando o intervalo de valores possíveis.
- A propriedade `AUTO_INCREMENT` permite que o valor do campo seja incrementado automaticamente a cada novo registro.
- A propriedade `NOT NULL` permite que o campo não seja nulo.
- A propriedade `DEFAULT` permite definir um valor padrão para o campo.
- Campos espaciais são campos que armazenam informações geográficas, como por exemplo, latitude e longitude. Esses campos são do tipo `POINT`, `LINESTRING`, `POLYGON`, `MULTIPOINT`, `MULTILINESTRING`, `MULTIPOLYGON` e `GEOMETRYCOLLECTION`.
- `PRIMARY KEY` é uma coluna ou conjunto de colunas que identifica de forma única cada registro de uma tabela.
```sql
CREATE TABLE IF NOT EXISTS SUCOS (
  -- O valor padrão do auto_increment é 1
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT=100,
    NOME VARCHAR(50) NOT NULL,
    PRECO FLOAT(5,3) NOT NULL DEFAULT 0.000,
    ESTOQUE INT UNSIGNED NOT NULL DEFAULT 0,
    ENUM('NATURAL', 'INDUSTRIALIZADO') NOT NULL DEFAULT 'NATURAL',
    PRIMARY KEY (ID),
    UNIQUE (NOME)
);
```
- `INSERT` é um comando para inserir um registro em uma tabela.
- Recuperar dados de uma tabela é feito através de consultas, o comando `SELECT` é usado para recuperar dados de uma ou mais tabelas.
- `UPDATE` é um comando para atualizar um registro em uma tabela.
- A expressão `*` é usada para selecionar todos os campos de uma tabela.
- A exclusão de um registro é feita através do comando `DELETE`.
- `BETWEEN` é usado para selecionar valores entre um intervalo, também pode-se usar `NOT BETWEEN` para selecionar valores que não estão entre um intervalo.
```sql
INSERT INTO SUCOS (NOME, PRECO, ESTOQUE, TIPO) VALUES ('Laranja', 2.50, 10, 'NATURAL');
SELECT * FROM SUCOS;
UPDATE SUCOS SET PRECO = 2.00 WHERE NOME = 'Laranja';
SELECT NOME, PRECO FROM SUCOS WHERE TIPO = 'NATURAL';
SELECT * FROM SUCOS WHERE PRECO BETWEEN 1.00 AND 2.00;
```







