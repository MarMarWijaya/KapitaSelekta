-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2020 at 08:32 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas_ks`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun_bank`
--

CREATE TABLE `akun_bank` (
  `ID_user` varchar(45) NOT NULL,
  `Nama` varchar(45) NOT NULL,
  `Rekening` varchar(20) NOT NULL,
  `Nomor_Kartu` varchar(20) NOT NULL,
  `PIN` varchar(6) NOT NULL,
  `Saldo` bigint(20) NOT NULL,
  `ID` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun_bank`
--

INSERT INTO `akun_bank` (`ID_user`, `Nama`, `Rekening`, `Nomor_Kartu`, `PIN`, `Saldo`, `ID`) VALUES
('1', 'Mario Wijaya', '1234567890', '1234 5678 9012 3456', '123123', 10000000, 'P1');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `ID` varchar(45) NOT NULL,
  `Nama` varchar(45) NOT NULL,
  `Telfon` varchar(13) NOT NULL,
  `email` varchar(45) NOT NULL,
  `ID_user` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`ID`, `Nama`, `Telfon`, `email`, `ID_user`) VALUES
('P1', 'Mario Wijaya', '085315823366', 'mariowijaya31@gmail.com', '1'),
('P2', 'Bebas', '086', 'mar', '2');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_trans` varchar(45) NOT NULL,
  `Jenis` varchar(45) NOT NULL,
  `Nominal` bigint(20) NOT NULL,
  `Tanggal` date NOT NULL,
  `Rekening_tujuan` varchar(20) NOT NULL,
  `ID_user` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`ID_trans`, `Jenis`, `Nominal`, `Tanggal`, `Rekening_tujuan`, `ID_user`) VALUES
('TR1', 'Transfer', 100000, '2020-10-10', '987654321', '1'),
('TR2', 'Terima', 100000, '2020-11-10', '8790612345', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun_bank`
--
ALTER TABLE `akun_bank`
  ADD PRIMARY KEY (`ID_user`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_trans`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
