# Comandos DML: manipulação de dados com MySQL
- DML(Data Manipulation Language) é a linguagem de manipulação de dados, que permite a inserção, alteração e remoção de dados em uma tabela.
- DEFAULT CHARACTER SET é o conjunto de caracteres padrão para o armazenamento de dados.
- InnoDB e MyISAM são os motores de armazenamento de dados mais utilizados, o InnoDB é mais seguro e mais rápido, mas não suporta tabelas temporárias.
- PK é a abreviação de Primary Key, que é a chave primária de uma tabela, que é única e não nula.
- FK é a abreviação de Foreign Key, que é a chave estrangeira de uma tabela, que é uma chave primária de outra tabela.
- Geralmente adicionamos Constraints do tipo FK com o nome da tabela e do campo, por exemplo: FK_tabela_campo.
- Para inserir dados em uma tabela, usamos o comando INSERT INTO, que recebe o nome da tabela e os valores a serem inseridos.
- Se os dados são campos de texto, devemos colocar aspas simples em volta do valor.
- Para alterar dados em uma tabela, usamos o comando UPDATE, que recebe o nome da tabela, os campos a serem alterados e a condição para a alteração.
- Podemos utilizar update com `FROM` para alterar dados de uma tabela com base em dados de outra tabela.
- Exclusão de dados é feita com o comando DELETE, que recebe o nome da tabela e a condição para a exclusão.
- É recomendado usar o `WHERE` ao fazer alterações e exclusões de dados, para evitar perda de dados.
- `COMMIT` é o comando para confirmar as alterações feitas no banco de dados.
- `ROLLBACK` é o comando para desfazer as alterações feitas no banco de dados.
```sql
START TRANSACTION;
INSERT INTO tabela (campo1, campo2, campo3) VALUES (valor1, valor2, valor3);
INSERT INTO tabela VALUES (valor1, valor2, valor3);
UPDATE tabela SET campo1 = valor1, campo2 = valor2, campo3 = valor3 WHERE campo4 = valor4;
UPDATE tabela SET campo1 = valor1, campo2 = valor2, campo3 = valor3 FROM tabela2 WHERE tabela.campo4 = tabela2.campo4;
DELETE FROM tabela WHERE campo1 = valor1;
COMMIT;
ROLLBACK;
```
- Campos com `AUTO_INCREMENT` são campos que são preenchidos automaticamente com um valor sequencial.
- Campos com `DEFAULT` são campos que são preenchidos automaticamente com um valor padrão.
- Campos com `NOT NULL` são campos que não podem ser nulos.
- Triggers são comandos que são executados automaticamente quando uma ação é feita em uma tabela.
- Pode ser `BEFORE` ou `AFTER` a ação, e `INSERT`, `UPDATE` ou `DELETE`.
```sql
CREATE TABLE tabela (
    campo1 INT AUTO_INCREMENT PRIMARY KEY,
    campo2 VARCHAR(255) NOT NULL,
    campo3 VARCHAR(255) DEFAULT 'valor'
);
CREATE TRIGGER trigger1 BEFORE INSERT ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
CREATE TRIGGER trigger2 AFTER INSERT ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
CREATE TRIGGER trigger3 BEFORE UPDATE ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
CREATE TRIGGER trigger4 AFTER UPDATE ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
CREATE TRIGGER trigger5 BEFORE DELETE ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
CREATE TRIGGER trigger6 AFTER DELETE ON tabela FOR EACH ROW SET NEW.campo2 = 'valor';
DROP TRIGGER trigger1;
```
