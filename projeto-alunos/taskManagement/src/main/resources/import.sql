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