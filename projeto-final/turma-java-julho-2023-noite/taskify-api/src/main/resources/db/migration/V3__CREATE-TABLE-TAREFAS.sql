CREATE TABLE IF NOT EXISTS tb_tarefas (
    idTarefa BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    dataDeCriacao DATE NOT NULL,
    dataDeConclusao DATE,
    prioridade VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    idUsuario BIGINT,
    idProjeto BIGINT NOT NULL,
    PRIMARY KEY(idTarefa),
    FOREIGN KEY (idUsuario) REFERENCES tb_usuarios(idUsuario),
    FOREIGN KEY (idProjeto) REFERENCES tb_projetos(idProjeto)
);