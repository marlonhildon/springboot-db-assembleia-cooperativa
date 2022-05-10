# Sessões de Votação - Pautas de Cooperativas
## Solução em Spring Boot, jdbi3, Maven e Java 11

### Endpoints:
![Endpoints](https://drive.google.com/uc?export=view&id=1nzBAkLMOsHG7SQZy31XhcnOWvpgZovmk)

### Testes locais:
1. Na raiz do repositório:
    ```
    mvn clean install -U
    ```
2. Em seguida, ao executar o comando abaixo o microsserviço ficará disponível na porta 8080:
    ```
    mvn spring-boot:run
    ```
3. Confira em detalhes as requisições REST no [contrato Swagger do microsserviço.](./core/src/main/resources/contratos/springboot-db-assembleia-cooperativa.yaml)

### Tabelas MySQL usadas e seus relacionamentos
![Endpoints](https://drive.google.com/uc?export=view&id=1PkMjxVtV17fKK23NnLvSXoyei94h5mT3)

### Procedure usada para criação do banco de dados e suas tabelas:
```
DROP PROCEDURE proc_database_tabelas_assembleia_cooperativista IF EXISTS;

DELIMITER $$

CREATE PROCEDURE `proc_database_tabelas_assembleia_cooperativista`()
BEGIN
    DECLARE `_rollback` BOOL DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
    START TRANSACTION;
    	
		DROP DATABASE DBAssembleia IF EXISTS;
		CREATE DATABASE DBAssembleia;
	
		DROP TABLE DBAssembleia.Associado IF EXISTS;
		DROP TABLE DBAssembleia.Votacao IF EXISTS;
		DROP TABLE DBAssembleia.SessaoPauta IF EXISTS;
	
		CREATE TABLE DBAssembleia.Associado(
			id INT PRIMARY KEY AUTO_INCREMENT,
			cpf VARCHAR(11) 				NOT NULL,
			nome VARCHAR(255) 				NOT NULL,
			flagAtivo CHAR(1) 				NOT NULL,
			dataHoraInsercao DATETIME 		NOT NULL,
			dataHoraAlteracao DATETIME,
			nomeUsuarioAuditoria VARCHAR(50) NOT NULL,
		
			INDEX index_cpf_assoc(cpf),
			CONSTRAINT constr_flagAtivo_assoc CHECK(flagAtivo IN ('S', 'N'))
		);
	
		CREATE TABLE DBAssembleia.SessaoPauta(
			id INT PRIMARY KEY AUTO_INCREMENT,
			nomePauta VARCHAR(255) 			NOT NULL,
			dataHoraInicioSessao DATETIME 	NOT NULL,
			dataHoraFimSessao DATETIME 		NOT NULL,
			nomeUsuarioAuditoria 			NOT NULL
		);
	
		CREATE TABLE DBAssembleia.Votacao(
			id INT PRIMARY KEY AUTO_INCREMENT,
			idAssociado INT 					NOT NULL,
			idSessaoVotacao INT 				NOT NULL,
			flagVotoAssociado CHAR(1) 			NOT NULL,
			dataHoraInsercao DATETIME 			NOT NULL,
			nomeUsuarioAuditoria VARCHAR(255) 	NOT NULL,
			
			INDEX index_associado(idAssociado),
			INDEX index_sessao_vot_assoc(idSessaoVotacao),
			CONSTRAINT fk_idAssociado_votacao(idAssociado) REFERENCES Associado(id),
			CONSTRAINT fk_idSessaoVotacao_votacao(idSessaoVotacao) REFERENCES SessaoPauta(id),
			CONSTRAINT constr_flagVotoAssociado_votacao CHECK(flagVotoAssociado IN ('S', 'N'))
		);
   
    IF `_rollback` THEN
        ROLLBACK;
    ELSE
        COMMIT;
    END IF;
END$$

DELIMITER ;

CALL proc_database_tabelas_assembleia_cooperativista();
DROP PROCEDURE proc_database_tabelas_assembleia_cooperativista;
```

### Arquitetura planejada

#### Cadastro de Associado
![Cadastro de Associado](https://drive.google.com/uc?export=view&id=1TlYyIPR6rslmcnxfyijsVGXoOifBp2gn)

#### Criação da Sessão de Votação
![Criação da Sessão](https://drive.google.com/uc?export=view&id=1tgDjmpqQwavMY1QbmfZvzifFr8ZkttrD)

#### Voto de Associado
![Voto do Associado](https://drive.google.com/uc?export=view&id=1bvom9jx6V0kr_a2IVF-qItQthE95D1C4)

#### Apuração dos Votos
![Apuração dos votos](https://drive.google.com/uc?export=view&id=1zkjQdkqDZp0uYSfkhw_MpQp6MpVMOvvO)
