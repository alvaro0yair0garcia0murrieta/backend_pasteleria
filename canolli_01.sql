-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 13, 2022 at 04:42 AM
-- Server version: 8.0.31
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `canolli_01`
--

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `idProducto` int NOT NULL,
  `categoria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sabor` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`idProducto`, `categoria`, `sabor`, `cantidad`, `precio`) VALUES
(666, 'choco', 'coco', 3, 180);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `password`) VALUES
('5b150b68-5e35-4733-a4e2-d9cd8bf98069', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('edefa127-cde0-4037-9a86-8bae202f7b4c', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('167c5cca-41ac-4f56-8d57-bb2732dad240', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('faf11694-da0e-4a6b-b629-f476c8e346c7', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('16ea77ba-d254-4c93-990f-a9200b59d84b', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('8d5f8b0c-d3d0-4b72-88ff-69feda94ed28', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('c4585f9f-283f-46ee-b1dc-d15efb6dc7a1', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('338bec43-79f3-4458-8b46-298654c4b61a', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('ee97d221-5ef7-47b5-a3ea-32f0c3b975b3', 'Oscar', 'zS19016350@estudiantes.uv.mx', 'oscar'),
('c1a57527-0194-4746-86ea-d9e481c42913', 's', NULL, 's'),
('4d84f26a-b165-442b-af25-66a88ea2d4e1', 's', NULL, 's'),
('95b8d146-dadd-4ed7-922e-90ad7150c797', 's', 'a-raccoon19@hotmail.com', 'a'),
('a8c662c7-8416-4432-8cb9-12ab6d77eac3', 'salvaro', 'murrieta.alvaro@gmail.com', 'mapache'),
('7e45618f-5531-4ed7-99db-3211e536d536', 'ana', 'ana@mail.com', '123'),
('5d5e6513-fa0f-467b-90ec-98b10f534ea6', 'laura', 'd', 'qwq'),
('c648b11e-ecf3-4a6f-a8b2-1dfe69bfd975', 'lucy', 'lcugb4', '1234'),
('7dfe0116-f83e-4d7a-87a0-9e79eef2d2d8', 'Oscar', 'pereag14@hotmail.com', 'qwerfdsa12'),
('5e2c786b-d3bf-4561-bef8-97c224d8a3cc', 'oscar', 'oscar', 'qwerfdsa12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=667;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
