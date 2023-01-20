# Procedures SQL: executando código no MySQL
- Procedures SQL são blocos de código que podem ser executados no MySQL.
- Comandos como `CREATE`, `ALTER`, `DROP` e `TRUNCATE` não podem ser executados dentro de procedures.
- São usados para executar comandos repetitivos, como inserção de dados em tabelas.
- O delimitador `$$` é usado para separar o código da procedure do código do MySQL.
- É necessário definir o delimitador antes de criar a stored procedure e depois de executar a procedure.
- Assim, se evita que o MySQL interprete o código da procedure como comandos do MySQL.
- Não há um comando para alterar stored procedures, apenas para criar e para deletar.
- Para tratar erros, é necessário definir um `EXIT HANDLER` para o tipo de erro que será tratado.
```sql
DELIMITER $$
CREATE PROCEDURE procedure1()
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < 10 DO
        INSERT INTO table1 (column1, column2) VALUES (i, i);
        SET i = i + 1;
    END WHILE;
END$$ 
CALL procedure1();
DROP PROCEDURE procedure1$$
DELIMITER ;
DECLARE EXIT HANDLER FOR SQLEXCEPTION
BEGIN
    ROLLBACK;
    SELECT 'Erro ao executar procedure';
END;
```
- `SELECT INTO` não funciona em consultas que retornam mais de uma linha, devmos usar `CURSOR` para isso.
- Definimos um `CURSOR` com o comando `DECLARE` e o nome do cursor.
- O `CURSOR` é usado para percorrer as linhas retornadas pela consulta.
```sql
DELIMITER $$
CREATE PROCEDURE procedure2()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE id INT;
    DECLARE name VARCHAR(255);
    DECLARE cur CURSOR FOR SELECT id, name FROM table1;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO id, name;
        IF done THEN
            LEAVE read_loop;
        END IF;
        INSERT INTO table2 (column1, column2) VALUES (id, name);
    END LOOP;
    CLOSE cur;
END$$
CALL procedure2();
DROP PROCEDURE procedure2$$
DELIMITER ;
```
- Funções são procedures que retornam um valor.
- É mais vantajoso usar Stored Procedure nas Triggers por facilitar a manutenção.