-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 16 mai 2020 à 12:14
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `planning`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID_Cours` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Cours`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID_Cours`, `Nom`) VALUES
(1, 'POO Java'),
(2, 'Traitement du signal 2'),
(3, 'Droit du travail'),
(4, 'Web Dynamique'),
(5, 'Thermodynamique'),
(6, 'English 6'),
(7, 'MOOC Nanotechnologie'),
(8, 'Initiation Reseau'),
(9, 'Anthropologie'),
(10, 'Base de gestion'),
(11, 'LV2');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  KEY `ID_Cours` (`ID_Cours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES
(2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Numero` int(11) NOT NULL,
  `ID_Groupe` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  KEY `#ID_GROUPE` (`ID_Groupe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(4, 565656, 2);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID_Groupe` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `ID_Promotion` int(11) NOT NULL,
  PRIMARY KEY (`ID_Groupe`),
  KEY `#ID_PROMOTION` (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID_Groupe`, `Nom`, `ID_Promotion`) VALUES
(2, 'Groupe 2', 1);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID_Promotion` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Promotion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID_Promotion`, `Nom`) VALUES
(1, 'Ing2022');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID_Salle` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Capacite` int(11) NOT NULL,
  `ID_Site` int(11) NOT NULL,
  PRIMARY KEY (`ID_Salle`),
  KEY `#ID_SITE` (`ID_Site`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID_Seance` int(11) NOT NULL AUTO_INCREMENT,
  `Semaine` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure_Debut` time(6) NOT NULL,
  `Heure_Fin` time(6) NOT NULL,
  `Status` varchar(255) NOT NULL,
  `R` int(11) NOT NULL,
  `V` int(11) NOT NULL,
  `B` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  `ID_Type` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`),
  KEY `#ID_COURS` (`ID_Cours`),
  KEY `#ID_TYPE` (`ID_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID_Seance`, `Semaine`, `Date`, `Heure_Debut`, `Heure_Fin`, `Status`, `R`, `V`, `B`, `ID_Cours`, `ID_Type`) VALUES
(1, 21, '2020-05-17', '08:30:00.000000', '10:00:00.000000', 'En cours de validation', 0, 0, 255, 1, 1),
(2, 21, '2020-05-18', '15:30:00.000000', '17:00:00.000000', 'En cours de validation', 254, 254, 224, 6, 1),
(3, 21, '2020-05-19', '19:00:00.000000', '20:30:00.000000', 'En cours de validation', 254, 231, 240, 3, 1),
(4, 21, '2020-05-19', '19:00:00.000000', '20:30:00.000000', 'En cours de validation', 240, 255, 255, 11, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Utilisateur` int(11) NOT NULL,
  `ID_Cours` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Utilisateur`,`ID_Cours`),
  KEY `ID_UTILISATEUR1` (`ID_Utilisateur`),
  KEY `##ID_Cours` (`ID_Cours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `ID_Groupe` int(11) NOT NULL,
  `ID_Seance` int(11) NOT NULL,
  PRIMARY KEY (`ID_Groupe`,`ID_Seance`),
  KEY `ID_Seance` (`ID_Seance`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_Seance` int(11) NOT NULL,
  `ID_Salle` int(11) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  KEY `#ID_Salle` (`ID_Salle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID_Site` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Site`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID_Type` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_Type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID_Type`, `Nom`) VALUES
(1, 'TD'),
(2, 'TP'),
(3, 'Reunion'),
(4, 'Magistral'),
(5, 'Soutien'),
(6, 'Conference');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_Utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(255) NOT NULL,
  `Passwd` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Droit` int(11) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_Utilisateur`, `Email`, `Passwd`, `Nom`, `Prenom`, `Droit`) VALUES
(1, 'anand_maisuria@yahoo.fr', '159', 'Maisuria', 'Anand', 1),
(2, 'hugo.navillod@edu.ece.fr', '123', 'Navillod', 'Hugo', 2),
(3, 'arthur.jaillard@edu.ece.fr', '456', 'Jaillard', 'Arthur', 3),
(4, 'anand.maisuria@edu.ece.fr', '753', 'Maisuria', 'Anand', 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `##ID_UTILISATEUR` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID_Cours` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID_Cours`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `#ID_GROUPE` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID_Groupe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `#ID_UTILISATEUR` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `utilisateur` (`ID_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `#ID_PROMOTION` FOREIGN KEY (`ID_Promotion`) REFERENCES `promotion` (`ID_Promotion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `#ID_SITE` FOREIGN KEY (`ID_Site`) REFERENCES `site` (`ID_Site`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `#ID_COURS` FOREIGN KEY (`ID_Cours`) REFERENCES `cours` (`ID_Cours`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `#ID_TYPE` FOREIGN KEY (`ID_Type`) REFERENCES `type_cours` (`ID_Type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_enseignants`
--
ALTER TABLE `seance_enseignants`
  ADD CONSTRAINT `##ID_Cours` FOREIGN KEY (`ID_Cours`) REFERENCES `enseignant` (`ID_Cours`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `##ID_Seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID_Seance`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID_UTILISATEUR1` FOREIGN KEY (`ID_Utilisateur`) REFERENCES `enseignant` (`ID_Utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_groupes`
--
ALTER TABLE `seance_groupes`
  ADD CONSTRAINT `ID_Groupe` FOREIGN KEY (`ID_Groupe`) REFERENCES `groupe` (`ID_Groupe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID_Seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID_Seance`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `###ID_Seance` FOREIGN KEY (`ID_Seance`) REFERENCES `seance` (`ID_Seance`),
  ADD CONSTRAINT `#ID_Salle` FOREIGN KEY (`ID_Salle`) REFERENCES `salle` (`ID_Salle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
