CREATE TABLE IF NOT EXISTS tb_projetos (
    idProjeto BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    idUsuario BIGINT NOT NULL,
    PRIMARY KEY(idProjeto),
    FOREIGN KEY(idUsuario) REFERENCES tb_usuarios(idUsuario)
);