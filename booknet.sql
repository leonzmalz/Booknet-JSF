-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Jun 20, 2015 as 04:43 PM
-- Versão do Servidor: 5.5.8
-- Versão do PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `booknet`
--
CREATE DATABASE `booknet` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `booknet`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluguel`
--

CREATE TABLE IF NOT EXISTS `aluguel` (
  `idAluguel` int(11) NOT NULL AUTO_INCREMENT,
  `idNegociacao` int(11) NOT NULL,
  `dataVencimento` date DEFAULT NULL,
  PRIMARY KEY (`idAluguel`),
  KEY `fk_Aluguel_Operacoes1_idx` (`idNegociacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `aluguel`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `generos`
--

CREATE TABLE IF NOT EXISTS `generos` (
  `idGenero` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=32 ;

--
-- Extraindo dados da tabela `generos`
--

INSERT INTO `generos` (`idGenero`, `nome`, `id`) VALUES
(15, 'Aventura', 0),
(22, 'Auto-ajuda', 0),
(23, 'Culinária', 0),
(25, 'Informática', 0),
(26, 'Contos', 0),
(27, 'Educação', 0),
(28, 'Crônicas', 0),
(29, 'Saúde', 0),
(30, 'Outros', 0),
(31, 'Gênero Teste', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

CREATE TABLE IF NOT EXISTS `livros` (
  `idLivro` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `idGenero` int(11) NOT NULL,
  `permiteAluguel` varchar(45) DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `editora` varchar(50) DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `nacionalidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLivro`),
  KEY `fk_Livro_Genero_idx` (`idGenero`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`idLivro`, `nome`, `idGenero`, `permiteAluguel`, `foto`, `ISBN`, `editora`, `autor`, `nacionalidade`) VALUES
(45, 'Dominando o Android', 25, 'S', 'livro1.png', '9999999', 'Novatec', 'Joaquim José da Silva Xavier', 'Nacional'),
(47, 'Quebre a cabeça! Padrões de Projeto', 25, 'S', 'livro2.jpg', '123131', 'Desconhecida', 'Alguem', 'Internacional'),
(48, 'Pai Rico Pai Pobre', 22, 'S', 'livro7.png', '98918231', 'Campus', 'Robert T. KyrsoSak', 'Nacional'),
(51, 'Pizza do Faustão', 23, 'S', 'livro3.jpg', '988123131', 'Globo', 'Faustão', 'Nacional'),
(52, 'O fascinante império de steve jobs', 15, 'N', 'livro4.jpg', '8989898', 'Desconhecida', 'Michael Mortiz', 'Internacional'),
(53, 'A música do silêncio', 26, 'N', 'livro5.jpg', '8718726318', 'Arqueiro', 'Patrick Rothfuss', 'Nacional'),
(54, 'Percy Jackson e o ladrão de raios', 15, 'S', 'livro6.jpg', '89898989', 'Desconhecida', 'Rick Riordan', 'Internacional'),
(55, 'As crônicas de gelo e fogo: A guerra dos tronos', 15, 'N', 'livro8.png', '989898', 'Leya', 'Geroge R. R. Martin', 'Internacional'),
(56, 'Dicionário Jurídico', 22, 'N', 'livro9.png', '9898989', 'Cronus', 'Thais Hae', 'Nacional'),
(57, 'Jardim Secreto', 30, 'N', 'images.livrariasaraiva.com.br.png', '9788543101637', 'Não informado', 'Basford, Johanna', 'Internacional'),
(58, 'Guerra Civil', 15, 'S', 'guerracivil.png', '9788542804126', 'Marvel', 'Moore, Stuart ', 'Internacional'),
(59, 'Teste', 23, 'S', 'Baymax-Poster-e1416440487417.jpg', '123123', '31231', '123123', '31231');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros_valores`
--

CREATE TABLE IF NOT EXISTS `livros_valores` (
  `idLivroValores` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorVenda` decimal(10,2) DEFAULT NULL,
  `valorAluguel` decimal(10,2) DEFAULT NULL,
  `taxaRenovacao` decimal(5,2) DEFAULT NULL,
  `multa` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`idLivroValores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `livros_valores`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `negociacoes`
--

CREATE TABLE IF NOT EXISTS `negociacoes` (
  `idNegociacao` int(11) NOT NULL AUTO_INCREMENT,
  `idLivro` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `dataNegociacao` date NOT NULL,
  PRIMARY KEY (`idNegociacao`),
  KEY `fk_Aluguel_Livro_idx` (`idLivro`),
  KEY `fk_Aluguel_Usuario1_idx` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `negociacoes`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_fisica`
--

CREATE TABLE IF NOT EXISTS `pessoa_fisica` (
  `idPessoaFisica` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `identidade` varchar(20) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `dataNascimento` date NOT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `homePage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPessoaFisica`),
  KEY `fk_Pessoa_Fisica_Usuarios1_idx` (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `pessoa_fisica`
--

INSERT INTO `pessoa_fisica` (`idPessoaFisica`, `idUsuario`, `nome`, `identidade`, `cpf`, `dataNascimento`, `endereco`, `telefone`, `celular`, `email`, `homePage`) VALUES
(1, 1, 'Leonardo', '111111111', '05148021381', '0000-00-00', 'Rua 15, Quadra 26, Cohatrac IV, São Luis, MA, 65054460', '9999999', '999999999', 'leonardo_pinheiro12@hotmail.com', 'leonardo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa_juridica`
--

CREATE TABLE IF NOT EXISTS `pessoa_juridica` (
  `idPessoaJuridica` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `CNPJ` varchar(20) NOT NULL,
  `razaoSocial` varchar(100) NOT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `homePage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPessoaJuridica`),
  KEY `fk_Pessoa_Juridica_Usuarios1_idx` (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `pessoa_juridica`
--

INSERT INTO `pessoa_juridica` (`idPessoaJuridica`, `idUsuario`, `CNPJ`, `razaoSocial`, `endereco`, `telefone`, `celular`, `email`, `homePage`) VALUES
(1, 2, '1231231', 'teste', 'teste, teste, teste, MG, 1231231', '123123', '21312321', 'teste@teste.com', 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `reservas`
--

CREATE TABLE IF NOT EXISTS `reservas` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idLivro` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reservas_Livros1_idx` (`idLivro`),
  KEY `fk_Reservas_Usuarios1_idx` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `reservas`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `user`, `senha`, `tipo`) VALUES
(1, 'leo', '$2a$08$NDc3MTU3NjA1NTU1NWYwYu0Wrko30qj8gG06msw6tvHk7L8Ut.Hwe', 'ADMIN'),
(2, 'teste', '$2a$08$MzYwNDEyODIxNTU1NjEwYOUC4oTEcOeQ8JmT1/vRG3hfOmbPT6hDi', 'PESSOA'),
(3, 'admin', '$2a$08$MjI5NzU1NDU1NWRjM2I3NeLaaXJaK8NS5T4h6OsBU.If2aDArqz7G', 'ADMIN');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `fk_Aluguel_Operacoes1` FOREIGN KEY (`idNegociacao`) REFERENCES `negociacoes` (`idNegociacao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `livros`
--
ALTER TABLE `livros`
  ADD CONSTRAINT `fk_Livro_Genero` FOREIGN KEY (`idGenero`) REFERENCES `generos` (`idGenero`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
--
-- Restrições para a tabela `negociacoes`
--
ALTER TABLE `negociacoes`
  ADD CONSTRAINT `fk_Aluguel_Livro` FOREIGN KEY (`idLivro`) REFERENCES `livros` (`idLivro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluguel_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `pessoa_fisica`
--
ALTER TABLE `pessoa_fisica`
  ADD CONSTRAINT `fk_Pessoa_Fisica_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `pessoa_juridica`
--
ALTER TABLE `pessoa_juridica`
  ADD CONSTRAINT `fk_Pessoa_Juridica_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `fk_Reservas_Livros1` FOREIGN KEY (`idLivro`) REFERENCES `livros` (`idLivro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Reservas_Usuarios1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
