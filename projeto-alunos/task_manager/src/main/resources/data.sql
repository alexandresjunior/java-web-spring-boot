INSERT
    IGNORE INTO tb_usuarios (
        idUsuario,
        nome,
        sobrenome,
        email,
        senha
    )
VALUES
    (
        1,
        "Teste",
        "Teste",
        "teste@task-manager.com.br",
        "$2a$10$d0.ajLVR6wyXTZEJurGtyO6wGwwL8RCFKRsFADv765E7xOFUC8S1W"
    );