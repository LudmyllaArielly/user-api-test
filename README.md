# User Test :coffee:

*Esse projeto é uma Api de usuários com aplicação de testes unitários, utlizando Java e Spring framework, o propósito dessa aplicação e práticar e estudar sobre testes unitários com o intuito de aplicar em meus projetos para melhorar a qualidade, eficiência, diminuir o retrabalho da aplicação.*

## Tecnologias usadas
- String Framework
  - Spring Web
  - Spring Data Jpa
  - MapStruct
  - MySQL
  - Lombok
  - Junit5
  - Mockito
  - Maven
  - Java 

## Passos para configuração

**1. Clone a aplicação**

```bash
git clone https://github.com/LudmyllaArielly/user-api-test.git
```
**2. Execute o aplicativo usando maven**

```bash
mvn user-api-test:run
```
**3. Pré-requisitos**
```bash
mvn --version
```
Veja a indicação da versão do maven instalada, bem como a versão do JDK, entre outras. Esses requisitos são obrigátorios, portanto é necessário definir corretamento as variáveis de ambiente JAVA_HOME, M2_HOME.
O aplicativo começará a ser executado em: <http://localhost:8080>

**4. Compila**

```bash
mvn compile
```
Este comando compila o projeto e deposita os resultados no diretório de destino.

**5. Executando a Rest Api**

```bash
java -jar target/api.jar
or
mvn user-api-test:run
```
Neste caminho
A Api foi geradada pelo pacote mvn package -P e esta sendo executada na porta 8080.

Exemplo de endereço: http://localhost:8080/user-api-test

## Exemplo de corpo de solicitações JSON válidos

##### Cria usuário
```json
{
  "firstName": "Maria",
  "lastName": "Silva",
  "cpf": "78985246189",
  "dateOfBirth": "1998-05-21"
 
}
```

#  Teste unitário Java com Junit

##### Teste de usuário

1. Deve retornar sucesso ao criar um usuário.

2. Deve gerar um erro de validação, quando não houver dados suficientes para criar o usuário.

   ​

#####  :warning: A aplicação ainda está em progresso. 