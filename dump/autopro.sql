-- Créer la base de données si elle n'existe pas
CREATE DATABASE IF NOT EXISTS autopro;

-- Sélectionner la base de données
USE autopro;

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `personne_id` int NOT NULL AUTO_INCREMENT,
  `personne_nom` varchar(255) DEFAULT NULL,
  `personne_mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personne_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `personne_vehicule`;
CREATE TABLE IF NOT EXISTS `personne_vehicule` (
  `personne_id` int NOT NULL,
  `vehicule_id` int NOT NULL,
  PRIMARY KEY (`personne_id`,`vehicule_id`),
  KEY `vehicule_id` (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `vehicule_id` int NOT NULL AUTO_INCREMENT,
  `vehicule_marque` varchar(255) DEFAULT NULL,
  `vehicule_modele` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehicule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `personne_vehicule`
  ADD CONSTRAINT `personne_vehicule_ibfk_1` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`),
  ADD CONSTRAINT `personne_vehicule_ibfk_2` FOREIGN KEY (`vehicule_id`) REFERENCES `vehicule` (`vehicule_id`);
COMMIT;
