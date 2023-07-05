# TaskManagement - Desafio Treina Recife
```
PROF. ALEXANDRE DE SOUZA JR
DESAFIO TÉCNICO: JAVA EXPERIENCE
Nome do projeto: Sistema de Gerenciamento de Tarefas
Descrição do projeto:
O objetivo deste projeto é desenvolver um sistema de gerenciamento de tarefas
simples, onde os usuários possam criar, atualizar, visualizar e excluir suas tarefas.
Requisitos técnicos:

1. O sistema deve ser implementado usando o framework Spring Boot e Java.

2. As tarefas devem ter os seguintes campos: título, descrição, data de criação e status
(concluída ou não concluída).

3. Os usuários devem ser capazes de se registrar e fazer login no sistema.

4. Cada usuário deve ter acesso apenas às suas próprias tarefas.

5. O sistema deve fornecer APIs RESTful para realizar as seguintes operações:

5.1. Criar uma nova tarefa.

5.2. Atualizar uma tarefa existente.

5.3. Excluir uma tarefa.

5.4. Obter uma lista de todas as tarefas do usuário.

5.5. Marcar uma tarefa como concluída.

6. O sistema deve ser protegido por autenticação JWT para garantir que apenas usuários
autenticados possam acessar as APIs (exceto as de login e cadastro).

7. As tarefas devem ser armazenadas em um banco de dados relacional (MySQL).

8. O projeto deve ser configurado usando o Maven para gerenciamento de
dependências.

9. O código-fonte deve ser hospedado em um repositório GitHub:

9.1. O repositório do projeto deve conter um histórico de commits relevante,
com mensagens de commit claras e concisas.

9.2. Os candidatos devem criar um arquivo README.md com informações sobre
como executar o projeto localmente.
Sugestões adicionais:

Além dos requisitos básicos, os candidatos podem adicionar recursos extras para
mostrar suas habilidades, como paginação na listagem de tarefas, pesquisa por título ou
descrição, ordenação por data, etc. A interface do usuário não precisa ser implementada
para este desafio, mas os candidatos podem criar uma documentação Swagger para
facilitar o teste das APIs.
```


## Link de acesso Swagger
```
Copie e cole o link abaixo no navegador apos a inicialização da API
http://localhost:8080/swagger-ui.html#/user-controller
```

## Aplication.properties
Para alterar o ambiente deve mudar a variavel dev para prod ou test
```
spring.profiles.active=${APP_PROFILE:dev}
spring.jpa.open-in-view=false

security.oauth2.client.client-id=${CLIENT_ID:taskManagement}
security.oauth2.client.client-secret=${CLIENT_SECRET:taskManagement}

jwt.secret=${JWT_SECRET:MY-JWT-SECRET}
jwt.duration=${JWT_DURATION:86400}
```

## Configuracao do banco H2 no navegador
Link http://localhost:8080/h2-console/

![image](https://github.com/vitorhla/taskManagement/assets/78744972/3db6edc4-537d-4fbf-a80d-0424884b8179)


## Para o banco MYSQL
```
Deve criar o SCHEMA com nome taskmanagement  com acesso para usuario: root senha: root
```

## SQL para seed da base de dados de teste

```sql
INSERT INTO  USER (EMAIL,NAME,PASSWORD) VALUES ('vitor@gmail.com','vitor','$2a$12$M0MZT.cs2NfePHC4ZIfEpukYtY2rb1a4RtBZTeqFH5yO7H8rRPVYO');
INSERT INTO  USER (EMAIL,NAME,PASSWORD) VALUES ('rodrigo@gmail.com','rodrigo','$2a$12$M0MZT.cs2NfePHC4ZIfEpukYtY2rb1a4RtBZTeqFH5yO7H8rRPVYO');
INSERT INTO  USER (EMAIL,NAME,PASSWORD) VALUES ('admin@gmail.com','admin','$2a$12$M0MZT.cs2NfePHC4ZIfEpukYtY2rb1a4RtBZTeqFH5yO7H8rRPVYO');

INSERT INTO ROLE (AUTHORITY) VALUES ('ROLE_ADMIN');

INSERT INTO  USER_ROLE (user_id,role_id) VALUES('1','1');
INSERT INTO  USER_ROLE (user_id,role_id) VALUES('2','1');
INSERT INTO  USER_ROLE (user_id,role_id) VALUES('3','1');

INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('1','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('2','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('3','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('4','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('5','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');

INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('6','2',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('7','2',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('8','2',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('9','2',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('10','2',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','CONCLUIDA');

INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('11','3',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('12','3',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('13','3',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('14','3',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('15','3',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');

INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('16','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('17','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('18','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('19','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
INSERT INTO TASK (ID,COD_USER,DATA_CRIACAO,DESCRICAO,TITULO,STATUS) VALUES ('20','1',TO_DATE('23/06/2023','DD/MM/YYYY'),'TAREFA TREINA RECIFE IPI', 'TAREFA TREINA RECIFE','NAO CONCLUIDA');
```
