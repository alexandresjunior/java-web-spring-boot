SELECT * FROM meuprimeirobanco.pessoa;

INSERT INTO meuprimeirobanco.pessoa (nome, sobrenome, cpf)
VALUES ("Álvaro", "Simões", "123456778");

SELECT * FROM meuprimeirobanco.pessoa WHERE cpf="123456778";

UPDATE meuprimeirobanco.pessoa
SET idade = 23, ativa = 1
WHERE cpf="123456778";

DELETE FROM meuprimeirobanco.pessoa WHERE cpf="123456778";
