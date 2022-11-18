# Inova Asset Management


A **Inova Asset Management** é uma Gestora de fundos de investimento que deseja se posicionar no
mercado de Investimentos. Para auxiliar a empresa no atingimento deste objetivo foi solicitado a você
que crie um projeto web onde será exibido o portfólio da Empresa, que atualmente administra 5 fundos
de investimento. Como forma de ampliar sua base de clientes, deve ser criada uma página no projeto
que dê sugestões de fundos de investimento mais adequados aos clientes, levando-se em conta o perfil
de investidor que pode ser conservador, moderado ou arrojado. Esta página deve exibir as três opções
de perfil de investidor do cliente e após selecionar uma das opções o sistema deve exibir até 3 (três)
fundos mais adequados àquele perfil definido.

Como premissa, consideramos que os clientes são classificados em:
- a. Conservador – Não quer correr nenhum ou poucos riscos;
- b. Moderado – Aceita correr um certo risco nas aplicações;
- c. Arrojado – Aceita correr mais riscos para ter mais rentabilidade.

Para subsidiar a criação do projeto disponibilizamos o arquivo fundos.csv contendo os dados cadastrais
dos fundos de investimento da Inova Asset Management e outro arquivo cotas.csv contendo
respectivamente os valores das cotas destes fundos nos últimos 12 meses.

### Regra de negócio da implementação 

Como regra de recomendação de 3 fundos para cada perfil, primeiro os fundos foram ordenados por nível de risco, do baixo até alto, e em seguida ordenados pelo desvio padrão histórico do fundo. Com os fundos ordenados a página recomenda os 3 primeiros fundos para o perfil Conservador, os 3 fundos mais próximos a mediana para o perfil Moderado e os 3 últimos fundos para o perfil Arrojado.

---
## Frontend 

Para o frontend foi utilizado Angular CLI versão 15.0.0.

### Tela Inicial

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-inicial.PNG)


### Tela Conservador

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-conservador.PNG)

### Tela Moderado

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-moderado.PNG)

### Tela Arrojado

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/tela-arrojado.PNG)


---
## Backend

Para o backend foi utilizado Springboot versão 2.5.5.

### Modelo ER

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/MER.png)

### Diagrama de classes

![alt text](https://github.com/renatoreggiani/inova-asset/blob/main/imagens/diagrama_classes.png)



## DDL

```sql
-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;
-- INOVA.dbo.PERFIL definition

-- Drop table

-- DROP TABLE INOVA.dbo.PERFIL;

CREATE TABLE INOVA.dbo.PERFIL (
	ID_PERFIL tinyint NOT NULL,
	NOME_PERFIL varchar(50) COLLATE Latin1_General_CI_AS NULL,
	CONSTRAINT PERFIL_PK PRIMARY KEY (ID_PERFIL)
);


-- INOVA.dbo.RISCO definition

-- Drop table

-- DROP TABLE INOVA.dbo.RISCO;

CREATE TABLE INOVA.dbo.RISCO (
	ID_RISCO tinyint NOT NULL,
	NOME_RISCO varchar(100) COLLATE Latin1_General_CI_AS NOT NULL,
	CONSTRAINT RISCO_PK PRIMARY KEY (ID_RISCO)
);


-- INOVA.dbo.FUNDO definition

-- Drop table

-- DROP TABLE INOVA.dbo.FUNDO;

CREATE TABLE INOVA.dbo.FUNDO (
	CD_FNDO int NOT NULL,
	NOME_FNDO varchar(100) COLLATE Latin1_General_CI_AS NOT NULL,
	CNPJ_FNDO bigint NOT NULL,
	DT_ABERTURA_FNDO date NOT NULL,
	DT_ENCERRAMENTO_FNDO date NULL,
	ID_RISCO tinyint NOT NULL,
	CONSTRAINT FUNDO_PK PRIMARY KEY (CD_FNDO),
	CONSTRAINT FUNDO_UN UNIQUE (CNPJ_FNDO),
	CONSTRAINT FUNDO_FK FOREIGN KEY (ID_RISCO) REFERENCES INOVA.dbo.RISCO(ID_RISCO)
);
 CREATE NONCLUSTERED INDEX FUNDO_ID_RISCO_IDX ON dbo.FUNDO (  ID_RISCO ASC  )  
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;


-- INOVA.dbo.COTA definition

-- Drop table

-- DROP TABLE INOVA.dbo.COTA;

CREATE TABLE INOVA.dbo.COTA (
	DT_COTA date NOT NULL,
	CD_FNDO int NOT NULL,
	COT_FNDO float NOT NULL,
	CONSTRAINT COTA_PK PRIMARY KEY (DT_COTA,CD_FNDO),
	CONSTRAINT COTA_FK FOREIGN KEY (CD_FNDO) REFERENCES INOVA.dbo.FUNDO(CD_FNDO)
);
 CREATE NONCLUSTERED INDEX COTA_COD_FUNDO_IDX ON dbo.COTA (  CD_FNDO ASC  )  
	 WITH (  PAD_INDEX = OFF ,FILLFACTOR = 100  ,SORT_IN_TEMPDB = OFF , IGNORE_DUP_KEY = OFF , STATISTICS_NORECOMPUTE = OFF , ONLINE = OFF , ALLOW_ROW_LOCKS = ON , ALLOW_PAGE_LOCKS = ON  )
	 ON [PRIMARY ] ;
```
