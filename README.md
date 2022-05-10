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

### Arquitetura planejada

#### Cadastro de Associado
![Cadastro de Associado](https://drive.google.com/uc?export=view&id=1TlYyIPR6rslmcnxfyijsVGXoOifBp2gn)

#### Criação da Sessão de Votação
![Criação da Sessão](https://drive.google.com/uc?export=view&id=1tgDjmpqQwavMY1QbmfZvzifFr8ZkttrD)

#### Voto de Associado
![Voto do Associado](https://drive.google.com/uc?export=view&id=1bvom9jx6V0kr_a2IVF-qItQthE95D1C4)

#### Apuração dos Votos
![Apuração dos votos](https://drive.google.com/uc?export=view&id=1zkjQdkqDZp0uYSfkhw_MpQp6MpVMOvvO)