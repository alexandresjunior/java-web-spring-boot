INSERT INTO 
    `tb_tipousuario` (`nome`)
VALUES
    ("CLIENTE"),
    ("PRESTADOR");

INSERT INTO
    `tb_usuario` (`nome`, `sobrenome`, `email`, `senha`, `id_tipo_usuario`)
VALUES
    ("Usuário", "Cliente", "cliente@agendapp.com.br", "cliente", 1),
    ("Usuário", "Prestador", "prestador@agendapp.com.br", "prestador", 2);