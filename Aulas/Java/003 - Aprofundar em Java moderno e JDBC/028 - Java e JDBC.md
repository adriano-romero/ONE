# Java e JDBC: trabalhando com um banco de dados
- Conectamos no `SQL`via shell pelo comando `mysql -u USERNAME -pPASSWORD -h HOSTNAME DATABASENAME `
- o `JDBC (Java Database Connectivity) ` é o `java.sql.*`, define uma camada de abstração entre a  aplicação e o driver do banco de dados.
- Formamos uma conexão no JDBC com `Connection connection = DriverManager.getConnection(url, user, password);`
- `Statement` serve para executar queries SQL.
- `ResultSet` representa o retorno de uma pesquisa
- `Factory Methods` ou `Factory Pattern` tem por objetivo encapsular um código que criará um objeto.
- O método `execute` de `java.sql.Statement`  envia o comando para o banco de dados, devolve `true` quando o seu resultado é um `java.sql.ResultSet` e false caso contrário (update, delete, etc)
- `getUpdateCount` retorna quantas linhas foram modificadas no `Statement`
- `prepareStatement` cria um objeto `SQLServerPreparedStatement` para enviar instruções SQL com parâmetros ao banco de dados e assim evita  SQL Injection.
- O `PreparedStatement` mantém a consulta compilada no banco de dados, para o usuário que necessitar realizar a mesma consulta, diversas vezes, com parâmetros diferentes.
- No `sql` os `indexes` começam em 1 ao invés d e0.
- O JDBC usa `autocommit`, usamos `setAutoCommit` da interface `Connection` para alterar isso.
- Podemos colocar as execuções num `try/catch` e executar um `Connection.rollback´ caso haja algum erro
- Se colocarmos o `PreparedStatement` e o `ResultSet` dentro do `try()` não precisamos nos preocupar com o `.close()` pois eles estendem `Autoclosable` 
- `DataSource` é uma alternative ao `DriverManager` já que permite a implementação de um pool de conexões.
- `c3p0` é uma biblioteca que permite controlar esss conexões. O método `setMaxPoolSize();` permite colocar um limite no pool, outras conexões ficarão em espera.
- O pattern `Data Access Object `é quem trabalha com as informações do nosso objeto no banco de dados. Geralmente chamado de `DAO`, tudo o que é referente a acesso ao banco de dados para trabalhar com as informações do meu objeto vão ficar nessa classe, tudo relacionado a persistência do objeto/CRUD.
- Devemos evitar queries `n+1` pois aumentam a quantidade de acessos ao banco de dados.
- `INNER JOIN `é uma cláusula no SQL que permite a junção entre duas ou mais tabelas, desde que hajam entrelaçamento entre todas e assim evitando Queries `N + 1`
- `Swing` serve para desenvolvermos aplicações desktop, não é tão comum hoje em dia.
- Uma opção para tratamento de exceções é trocar uma exceção `checked` e no `catch` lançar uma `RuntimeException`, ou seja, `unchecked`.
- uma aplicação é escrita em camadas
  - camadas clássicas são view, controller, modelo e persistência
  - o fluxo entre as camadas segue a ordem: view <--> controller <--> persistencia



