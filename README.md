# Cadastro de Usuario
Trata-se de um microssistema para cadastro de usuários e geração de dígitos únicos, sendo que cada usuário poderá ser cadastrado mais de um dígito, e para geração deste digito o usuário devera informar o Número (n) e o número de vezes que ele ira repetir (k).

## Executar/Compilar

**Utilizados**
- IDE: eclipse (2020-06 (4.16.0) + Spring tools 4
- Sistema Operacional Windows 10
- Git (2.27.0.windows.1)
- Spring Boot (2.3.1.RELEASE)
- Java (1.8)
- Bootstrap (4.0.0-2)
- jquery (2.1.4)
- Datatables (1.10.19)
- Banco de dados H2

**Compilar**

clone o projeto para seu local e execute o comando.

```
mvn package exec:java
```
## Executar Aplicação 

**Cadastrar Usuário**

Para cadastrar novos usuários, o utilizador devera clicar no botão “Adicionar Usuário”, preencher os campos “Nome” e “e-mail ” no modal que será exibido e clicar em salvar.

OBS: não foram colocados condições para validação dos campos “Nome” e “e-mail ”

**Editar Usuário**

Para editar usuários basta clicar no botão “Editar”, na coluna ação da tabela de usuários, que ira exibir um modal para o utilizador alterar os dados, após isso basta clicar em editar para gravar os novos dados do usuário.

**Excluir Usuário**

Para excluir um usuário basta clicar no botão “Apagar”, na coluna ação da tabela de usuários.

OBS: Caso o usuário possua dígitos cadastrados, eles também serão apagados da base de dados.

(cascade implementado)

**Visualizar Usuário**

Para consultar um usuário existem duas formas, na tela principal, que já vem com os dados e no botão “Visualizar” que ira abrir um modal para visualização do usuário.

**Cadastro Digito Único**

Para cadastrar um novo digito único para um usuário, basta clicar no botão “+”, na coluna Digito Único, e preenches os campos “ Numero (n): ” e “Num. Repetições (k):”, logo após o usuário poderá calcular e salvar clicando em “Calcular Digito”.

OBS: não foram inseridas tratamentos para valores negativos e campos vazios.

**Listar Digito Único**

Para listar os dígitos únicos e um usuário basta clicar em “Listar Dígitos”, na coluna Digito Único, que será aberto uma tabela com todos os dígitos únicos cadastrados para o usuário que esta naquela linha.

```

```


## links úteis
 
 Acessar Banco de dado H2.


- **Driver Class:** org.h2.Driver
- **JDBC URL:** jdbc:h2:mem:testdb
- **User Name:** sa
- **Password:**

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)


Pagina inicial da aplicação.

[http://localhost:8080/](http://localhost:8080/)

Acessar Swagger

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
