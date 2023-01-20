# Consultas SQL: avançando no SQL com MySQL
- Entre as vantagens do SQL está a padronização de sintaxe, o que permite que o mesmo código seja executado em diferentes bancos de dados.
- O SQL permite uma fácil migração de um banco de dados para outro, pois a sintaxe é a mesma.
- Um esquema visual no workbench pode ser criado com "Database> Reverse Engineer".
- Consultas condicionais podem ser feitas com `WHERE`.
  - Elas podem ser feitas com `AND` e `OR`.
  - `NOT` pode ser usado para negar uma condição.
  - `IN` pode ser usado para verificar se um valor está em uma lista.
  - `LIKE` pode ser usado para verificar se um valor corresponde a um padrão. O caractere `%` pode ser usado para representar qualquer número de caracteres.
```sql	
SELECT * FROM tabela WHERE coluna = valor AND coluna = valor;
SELECT * FROM tabela WHERE coluna = valor OR coluna = valor;
SELECT * FROM tabela WHERE NOT coluna = valor;
SELECT * FROM tabela WHERE coluna IN (valor1, valor2, valor3);
SELECT * FROM tabela WHERE coluna LIKE 'valor%';
```
- `Distinct` pode ser usado para remover valores duplicados.
```sql
SELECT DISTINCT coluna1, coluna2 FROM tabela WHERE coluna = valor;
SELECT DISTINCT * FROM tabela;
```
- `Limit` pode ser usado para limitar o número de resultados.
- `OFFSET` pode ser usado para pular um número de resultados.
- `ORDER BY` pode ser usado para ordenar os resultados.
- `GROUP BY` pode ser usado para agrupar os resultados.
- As funções agregadas `SUM`, `AVG`, `MIN`, `MAX` e `COUNT` podem ser usadas para calcular valores agregados, requere que o `GROUP BY` seja usado.
- `HAVING` pode ser usado para filtrar os resultados de uma consulta agregada.
- Com `CASE` é possível criar condições dentro de uma consulta. `CASE` é seguido por uma lista de condições, seguido por `ELSE` e por fim `END`.
```sql
SELECT * FROM tabela LIMIT 10;
SELECT * FROM tabela LIMIT 2,3;
SELECT * FROM tabela LIMIT 10 OFFSET 10;
SELECT * FROM tabela ORDER BY coluna1, coluna2;
SELECT * FROM tabela GROUP BY coluna1, coluna2;
SELECT SUM(coluna) FROM tabela GROUP BY coluna2;
SELECT SUM(coluna) FROM tabela GROUP BY coluna2 HAVING SUM(coluna) > 100;
SELECT coluna1, coluna2, CASE WHEN coluna3 = valor1 THEN 'valor1' WHEN coluna3 = valor2 THEN 'valor2' ELSE 'valor3' END AS coluna3 FROM tabela;
```
- `JOIN` pode ser usado para combinar dados de duas ou mais tabelas.
- Entre os tipos de `JOIN` estão `INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`, `CROSS JOIN` e `FULL JOIN`.
  - `INNER JOIN` retorna apenas os registros que possuem correspondência em ambas as tabelas.
  - `LEFT JOIN` retorna todos os registros da tabela da esquerda, mesmo que não haja correspondência na tabela da direita.
  - `RIGHT JOIN` retorna todos os registros da tabela da direita, mesmo que não haja correspondência na tabela da esquerda.
  - `CROSS JOIN` retorna o produto cartesiano de duas tabelas.
  - `FULL JOIN` retorna todos os registros de ambas as tabelas, mesmo que não haja correspondência.
- `UNION` pode ser usado para combinar os resultados de duas ou mais consultas.
- É necessário que as tabelas que serão unidas tenham o mesmo número e tipo de campo.
- A diferença entre `UNION` e `UNION ALL` é que `UNION` remove valores duplicados, enquanto `UNION ALL` não.
```sql
SELECT * FROM tabela1 INNER JOIN tabela2 ON tabela1.coluna = tabela2.coluna;
SELECT * FROM tabela1 LEFT JOIN tabela2 ON tabela1.coluna = tabela2.coluna;
SELECT * FROM tabela1 RIGHT JOIN tabela2 ON tabela1.coluna = tabela2.coluna;
SELECT * FROM tabela1 FULL JOIN tabela2 ON tabela1.coluna = tabela2.coluna;
SELECT * FROM tabela1 CROSS JOIN tabela2;
SELECT * FROM tabela1 UNION SELECT * FROM tabela2;
```
- Subconsultas podem ser usadas para retornar resultados de uma consulta dentro de outra consulta.
- Podemos usar `IN` para verificar se um valor está em uma lista de resultados de uma consulta.
```sql	
SELECT X, Y FROM tab1 WHERE Y IN (1,2);
SELECT X, Y FROM tab1 WHERE Y IN (SELECT Y FROM tab2);
```
- Views podem ser usadas para criar uma consulta que pode ser usada como uma tabela.
- Podemos usar `CREATE VIEW` para criar uma view e acessá-las posteriormente.
```sql
CREATE VIEW view1 AS SELECT * FROM tabela;
SELECT * FROM view1;
```
- Funções variam conforme o SGBD, apesar que `DISTINCT` e `JOIN` tem um comportamento similar em todos.
- Há várias funções que manipulam strings, como `LENGTH`, `LOWER`, `UPPER`, `REPLACE`, `SUBSTRING`, `TRIM`, `CONCAT` e `CONCAT_WS`.
```sql
SELECT LENGTH(coluna) FROM tabela;
SELECT LOWER("SQL Tutorial is FUN!") FROM tabela;
SELECT UPPER(coluna) FROM tabela;
SELECT REPLACE(coluna, 'valor1', 'valor2') FROM tabela;
SELECT LTRIM("     SQL Tutorial") AS LeftTrimmedString;
SELECT RTRIM("SQL Tutorial     ") AS RightTrimmedString;
SELECT TRIM("     SQL Tutorial     ") AS TrimmedString;
SELECT SUBSTRING("coluna", 1, 3) FROM tabela;
SELECT CONCAT("SQL ", "Tutorial ", "is ", "fun!") AS ConcatenatedString;
```
- Algumas funções que manipulam datas são: `ADDDATE`, `ADDTIME`, `CURDATE`, `DATEDIFF`.
```sql
SELECT ADDTIME("2017-06-15 09:34:21", "2");
SELECT CURDATE();
SELECT CURRENT_TIMESTAMP();
SELECT DATEDIFF("2017-06-25", "2017-06-15");
SELECT DAYNAME("2017-06-15");
SELECT MONTHNAME("2017-06-15");
SELECT NOW();
```
- Funções numéricas/matemáticas incluem `SUM`, `AVG`, `MIN`, `MAX`, `ABS`, `CEIL`, `FLOOR`, `ROUND`, `RAND`, `POWER`, `SQRT`.
```sql	
SELECT SUM(coluna) FROM tabela;
SELECT AVG(coluna) FROM tabela;
SELECT MIN(coluna) FROM tabela;
SELECT MAX(coluna) FROM tabela;
SELECT ABS(-10);
SELECT CEIL(10.2);
```
- Conversão de dados serve para converter dados de um tipo para outro. Funções que fazem isso são `CAST`, `CONVERT` e `TRUNCATE`. 
- A função `CONCAT` realiza uma conversão implícita.
```sql
SELECT CONCAT('O dia de hoje é: ',  DATE_FORMAT(CURRENT_TIMESTAMP(),'%Y') ) AS RESULTADO;
SELECT CAST('10' AS UNSIGNED);
SELECT CONVERT('10', UNSIGNED);
SELECT CONVERT(23.3, CHAR) AS RESULTADO;
SELECT SUBSTRING(CONVERT(23.3, CHAR),1,1) AS RESULTADO;
SELECT TRUNCATE(10.2, 0);
```
- Ao realizar o `JOIN`, para não repetir campos iguais, podemos utilizar `MAX` ou `MIN` para selecionar o maior ou menor valor ao invés de `SUM`.
