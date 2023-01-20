-- criando banco de dados para vendas de sucos
CREATE DATABASE IF NOT exists vendas_sucos CHARACTER SET utf8 COLLATE utf8_general_ci;

-- criando tabela de produtos
CREATE TABLE PRODUTOS
(CODIGO VARCHAR(10) NOT NULL,
DESCRITOR VARCHAR(100) NULL,
SABOR VARCHAR(50) NULL,
TAMANHO VARCHAR(50) NULL,
EMBALAGEM VARCHAR(50) NULL,
PRECO_LISTA FLOAT NULL,
PRIMARY KEY (CODIGO));

-- criando tabela de vendodores
CREATE TABLE VENDEDORES
(MATRICULA VARCHAR(5) NOT NULL,
NOME VARCHAR(100) NULL,
BAIRRO VARCHAR(50) NULL,
COMISSAO FLOAT NULL,
DATA_ADIMISSAO DATE NULL,
FERIAS BIT(1) NULL,
PRIMARY KEY (MATRICULA));

-- criando tabela de vendas
CREATE TABLE TABELA_DE_VENDAS
(NUMERO VARCHAR(5) NOT NULL,
DATA_VENDA DATE NULL,
CPF VARCHAR(11) NOT NULL,
MATRICULA VARCHAR(5) NOT NULL,
IMPOSTO FLOAT NULL,
PRIMARY KEY (NUMERO));

-- renomeando coluna
ALTER TABLE VENDEDORES RENAME COLUMN DATA_ADIMISSAO TO DATA_ADMISSAO;


-- Adicionando constraints de chave estrangeira na tabela de notas
ALTER TABLE itens_notas ADD CONSTRAINT FK_VENDAS
FOREIGN KEY (NUMERO)
REFERENCES VENDAS (NUMERO);

ALTER TABLE itens_notas ADD CONSTRAINT FK_PRODUTOS
FOREIGN KEY (CODIGO)
REFERENCES PRODUTOS (CODIGO);


-- criando a tabela clientes
CREATE TABLE clientes
(CPF VARCHAR(11) NOT NULL,
NOME VARCHAR(100) NULL,
ENDERECO VARCHAR(100) NULL,
BAIRRO VARCHAR(50) NULL,
CIDADE VARCHAR(50) NULL,
ESTADO VARCHAR(2) NULL,
CEP VARCHAR(8) NULL,
DATA_NASCIMENTO DATE NULL,
IDADE INT NULL,
SEXO VARCHAR(1) NULL,
LIMITE_CREDITO FLOAT NULL,
VOLUME_COMPRA FLOAT NULL,
PRIMEIRA_COMPRA BIT(1) NULL,
PRIMARY KEY (CPF));

-- inclusão de clientes
INSERT INTO clientes
(CPF,NOME,ENDERECO,BAIRRO,CIDADE,ESTADO,CEP,DATA_NASCIMENTO,IDADE,SEXO,LIMITE_CREDITO,VOLUME_COMPRA,PRIMEIRA_COMPRA)
VALUES 
('1471156710','Érica Carvalho','R. Iriquitia','Jardins','São Paulo','SP','80012212','19900901',27,'F',170000,24500,0),
('19290992743','Fernando Cavalcante','R. Dois de Fevereiro','Água Santa','Rio de Janeiro','RJ','22000000','20000212',18,'M',100000,20000,1),
('2600586709','César Teixeira','Rua Conde de Bonfim','Tijuca','Rio de Janeiro','RJ','22020001','20000312',18,'M',120000,22000,0)

-- incluindo todos os clientes basedo em outra tabela e que não estou na base de dados.
INSERT INTO clientes
(CPF,NOME,ENDERECO,BAIRRO,CIDADE,ESTADO,CEP,DATA_NASCIMENTO,IDADE,SEXO,LIMITE_CREDITO,VOLUME_COMPRA,PRIMEIRA_COMPRA)

SELECT CPF, NOME, ENDERECO_1 AS ENDERECO, BAIRRO, CIDADE, ESTADO, CEP,DATA_DE_NASCIMENTO AS  DATA_NASCIMENTO, IDADE, SEXO,LIMITE_DE_CREDITO AS LIMITE_CREDITO, VOLUME_DE_COMPRA AS VOLUME_COMPRA,PRIMEIRA_COMPRA 
 FROM sucos_vendas.tabela_de_clientes 
 WHERE CPF NOT IN (SELECT CPF FROM clientes);


-- incluindo todos cprodutos de produto basedo em outra tabela e que não estou na base de dados.
INSERT INTO produtos

SELECT CODIGO_DO_PRODUTO AS CODIGO, NOME_DO_PRODUTO AS DESCRITOR,

SABOR, TAMANHO, EMBALAGEM,  PRECO_DE_LISTA AS PRECO_LISTA

FROM sucos_vendas.tabela_de_produtos

WHERE CODIGO_DO_PRODUTO NOT IN (SELECT CODIGO FROM produtos);

-- atualizando dados de clientes
UPDATE CLIENTES
SET ENDERECO = 'R. Jorge Emilio 23',
BAIRRO = 'Santo Amaro',
CIDADE = 'São Paulo',
ESTADO = 'SP',
CEP = '8833223'
WHERE CPF = '19290992743 '

-- aumentando em 30% o volume de compras dos clientes onde o seu bairro possua um vendedor.
UPDATE CLIENTES A INNER JOIN VENDEDORES B
ON A.BAIRRO = B.BAIRRO
SET A.VOLUME_COMPRA = A.VOLUME_COMPRA * 1.30

-- Consultando e depois excluindo notas de clients menores de 18 anos
SELECT A.NUMERO FROM NOTAS A
INNER JOIN CLIENTES B ON A.CPF = B.CPF
WHERE B.IDADE <= 18

DELETE A FROM NOTAS A
INNER JOIN CLIENTES B ON A.CPF = B.CPF
WHERE B.IDADE <= 18

-- inserindo vários clientes
  INSERT INTO PRODUTOS (CODIGO,DESCRITOR,SABOR,TAMANHO,EMBALAGEM,PRECO_LISTA)

     VALUES ('1001001','Sabor dos Alpes 700 ml - Manga','Manga','700 ml','Garrafa',7.50),

         ('1001000','Sabor dos Alpes 700 ml - Melão','Melão','700 ml','Garrafa',7.50),

         ('1001002','Sabor dos Alpes 700 ml - Graviola','Graviola','700 ml','Garrafa',7.50),

         ('1001003','Sabor dos Alpes 700 ml - Tangerina','Tangerina','700 ml','Garrafa',7.50),

         ('1001004','Sabor dos Alpes 700 ml - Abacate','Abacate','700 ml','Garrafa',7.50),

         ('1001005','Sabor dos Alpes 700 ml - Açai','Açai','700 ml','Garrafa',7.50),

         ('1001006','Sabor dos Alpes 1 Litro - Manga','Manga','1 Litro','Garrafa',7.50),

         ('1001007','Sabor dos Alpes 1 Litro - Melão','Melão','1 Litro','Garrafa',7.50),

         ('1001008','Sabor dos Alpes 1 Litro - Graviola','Graviola','1 Litro','Garrafa',7.50),

         ('1001009','Sabor dos Alpes 1 Litro - Tangerina','Tangerina','1 Litro','Garrafa',7.50),

         ('1001010','Sabor dos Alpes 1 Litro - Abacate','Abacate','1 Litro','Garrafa',7.50),

         ('1001011','Sabor dos Alpes 1 Litro - Açai','Açai','1 Litro','Garrafa',7.50);


-- comando com transação
START TRANSACTION;

UPDATE VENDEDORES SET COMISSAO = COMISSAO * 1.15;

SELECT * FROM VENDEDORES;
COMMIT;

-- Criando um Trigger para calcular a idade do cliente
CREATE TRIGGER TG_CLIENTES_IDADE_INSERT BEFORE INSERT ON CLIENTES

FOR EACH ROW

BEGIN

SET NEW.IDADE = timestampdiff(YEAR, NEW.DATA_NASCIMENTO, NOW());


