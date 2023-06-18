CREATE DATABASE IF NOT EXISTS java_crud_swing;
USE java_crud_swing;
CREATE TABLE IF NOT EXISTS estudante
(
    id               int AUTO_INCREMENT PRIMARY KEY,
    nomeCompleto     VARCHAR(255) NOT NULL,
    anoMatricula     VARCHAR(4)          NOT NULL,
    email            VARCHAR(120) NOT NULL,
    endereco         VARCHAR(200) NOT NULL,
    cep              VARCHAR(200),
    telefone         VARCHAR(11),
    usuario          VARCHAR(50)  NOT NULL,
    senha            VARCHAR(100) NOT NULL,
    curso            VARCHAR(200) NOT NULL,
    observacoes      VARCHAR(300),
    ativo            boolean      NOT NULL
);