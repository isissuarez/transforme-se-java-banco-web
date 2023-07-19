-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Maio-2023 às 21:57
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `banco`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(65) DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `estado_civil` enum('casado','solteiro','divorciado') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`codigo`, `nome`, `sexo`, `email`, `estado_civil`) VALUES
(1, 'Emerson Luis da Rocha', 'M', 'emerson.luis@email.com', 'casado'),
(2, 'João Sidnei Arcanjo', 'M', 'joao.arcanjo@email.com', 'casado'),
(3, 'Fatima Xavier', 'F', 'fatima.xavier@email.com', 'casado'),
(4, 'Débora Cristtina', 'F', 'debora.cristina@email.com', 'casado'),
(9, 'Isis Suarez', 'F', 'isissuarez@email.com', 'casado'),
(11, 'Hellena souza', 'M', 'hellenasouza@email.com', 'casado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contas`
--

CREATE TABLE `contas` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `numero` varchar(15) NOT NULL,
  `saldo` double NOT NULL,
  `cliente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `contas`
--
ALTER TABLE `contas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cliente_codigo` (`cliente_codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `contas`
--
ALTER TABLE `contas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `contas`
--
ALTER TABLE `contas`
  ADD CONSTRAINT `contas_ibfk_1` FOREIGN KEY (`cliente_codigo`) REFERENCES `clientes` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
