-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 15 avr. 2025 à 07:17
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `autopro`
--

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `personne_id` int NOT NULL AUTO_INCREMENT,
  `personne_nom` varchar(255) DEFAULT NULL,
  `personne_mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personne_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `personne_vehicule`
--

DROP TABLE IF EXISTS `personne_vehicule`;
CREATE TABLE IF NOT EXISTS `personne_vehicule` (
  `personne_id` int NOT NULL,
  `vehicule_id` int NOT NULL,
  PRIMARY KEY (`personne_id`,`vehicule_id`),
  KEY `vehicule_id` (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `vehicule_id` int NOT NULL AUTO_INCREMENT,
  `vehicule_marque` varchar(255) DEFAULT NULL,
  `vehicule_modele` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `personne_vehicule`
--
ALTER TABLE `personne_vehicule`
  ADD CONSTRAINT `personne_vehicule_ibfk_1` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`),
  ADD CONSTRAINT `personne_vehicule_ibfk_2` FOREIGN KEY (`vehicule_id`) REFERENCES `vehicule` (`vehicule_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
