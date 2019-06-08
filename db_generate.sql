-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2019 at 08:06 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_generate`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `id` int(11) NOT NULL,
  `date_achiev` date NOT NULL,
  `description` varchar(50) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `id_employee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `authority`
--

CREATE TABLE `authority` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `is_delete` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authority`
--

INSERT INTO `authority` (`id`, `name`, `is_delete`) VALUES
(1, 'ROLE_ADMIN', '0');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `certification`
--

CREATE TABLE `certification` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `college`
--

CREATE TABLE `college` (
  `id` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `id_village` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `token_id` int(11) NOT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `degree`
--

CREATE TABLE `degree` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(15) NOT NULL,
  `id_province` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `id` varchar(15) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `id_college` varchar(255) NOT NULL,
  `id_degree` varchar(255) NOT NULL,
  `id_major` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `gender` char(1) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `last_name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `id_manager` int(11) DEFAULT NULL,
  `id_region` varchar(255) NOT NULL,
  `id_village` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_certification`
--

CREATE TABLE `employee_certification` (
  `id` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `end_date` date NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `start_date` date NOT NULL,
  `id_certification` int(11) NOT NULL,
  `id_employee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_education`
--

CREATE TABLE `employee_education` (
  `id` int(11) NOT NULL,
  `end_date` date NOT NULL,
  `gpa` float NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `start_date` date NOT NULL,
  `id_education` varchar(255) NOT NULL,
  `id_employee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_language`
--

CREATE TABLE `employee_language` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `id_employee` int(11) NOT NULL,
  `id_language` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_skill`
--

CREATE TABLE `employee_skill` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `rating` varchar(10) NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_skill` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee_training`
--

CREATE TABLE `employee_training` (
  `id` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `end_date` date NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `start_date` date NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_training` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `id` int(11) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `end_date` date NOT NULL,
  `position` varchar(30) NOT NULL,
  `start_date` date NOT NULL,
  `id_employee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

CREATE TABLE `organization` (
  `id` int(11) NOT NULL,
  `end_date` date NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `position` varchar(30) NOT NULL,
  `start_date` date NOT NULL,
  `id_employee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `religion`
--

CREATE TABLE `religion` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subdistrict`
--

CREATE TABLE `subdistrict` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(15) NOT NULL,
  `id_district` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `id` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `is_delete`) VALUES
(1, 'admin', '$2a$10$dyoDWnhaxGvwY8db88kQUO5WFbCRqsSTpQOUXFNFR05aIn0VHuWNm', 'falapubi@gmail.com', '0'),
(2, 'filu', '123456', 'fala.puspita@gmail.com', '0');

-- --------------------------------------------------------

--
-- Table structure for table `users_authority`
--

CREATE TABLE `users_authority` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_authority` int(11) NOT NULL,
  `is_delete` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_authority`
--

INSERT INTO `users_authority` (`id`, `id_user`, `id_authority`, `is_delete`) VALUES
(1, 1, 1, '0');

-- --------------------------------------------------------

--
-- Table structure for table `village`
--

CREATE TABLE `village` (
  `id` varchar(10) NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `name` varchar(15) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `id_subdistrict` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `work_assignment`
--

CREATE TABLE `work_assignment` (
  `id` int(11) NOT NULL,
  `end_date` date NOT NULL,
  `is_delete` char(1) DEFAULT NULL,
  `start_date` date NOT NULL,
  `id_employee` int(11) NOT NULL,
  `id_job` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcqr1tsggi783qn5yd0l7kr3gr` (`id_employee`);

--
-- Indexes for table `authority`
--
ALTER TABLE `authority`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `certification`
--
ALTER TABLE `certification`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `college`
--
ALTER TABLE `college`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK526f2s53qcyhncgv60yr2x3rh` (`id_village`);

--
-- Indexes for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`token_id`),
  ADD KEY `FK_token` (`user_id`);

--
-- Indexes for table `degree`
--
ALTER TABLE `degree`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc056gow4oir83juqx7sf95eo9` (`id_province`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnfvy8bpliuj4ptmn678xx9w2r` (`id_college`),
  ADD KEY `FKjmvggifjw2jv7sgwua66vdmrv` (`id_degree`),
  ADD KEY `FKeyu443daymqh4dpfpiowjx4cq` (`id_major`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnn9cii39wpyx5lcnwdaibex3i` (`id_manager`),
  ADD KEY `FKakjtwm900y7jc2mtfohmlutrx` (`id_region`),
  ADD KEY `FKk0jebn7m1v96kmqojs9ht511d` (`id_village`);

--
-- Indexes for table `employee_certification`
--
ALTER TABLE `employee_certification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsd96u2y7sysk74s688p2rqbvl` (`id_certification`),
  ADD KEY `FK5mdf62dcimco7ahp2u6vri2ni` (`id_employee`);

--
-- Indexes for table `employee_education`
--
ALTER TABLE `employee_education`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4ybt4jeisaws2x20jiaqqho8i` (`id_education`),
  ADD KEY `FKct72hqwfhw27kqig3pu56b50` (`id_employee`);

--
-- Indexes for table `employee_language`
--
ALTER TABLE `employee_language`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlw3fjv67a18bkh9mjcfwst9m3` (`id_employee`),
  ADD KEY `FKmhg7j352gmmrivujlg3iy6aw5` (`id_language`);

--
-- Indexes for table `employee_skill`
--
ALTER TABLE `employee_skill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcjf3nb0pnsvueit127g1kb10` (`id_employee`),
  ADD KEY `FKcui0o4twv54p2uonnd7ta5gx5` (`id_skill`);

--
-- Indexes for table `employee_training`
--
ALTER TABLE `employee_training`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqrdg0jl0qu9s0oa315o5lohot` (`id_employee`),
  ADD KEY `FKfo1y3hxaba1wf6fg8ltbejd6t` (`id_training`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp9p0263xiahdwse8pn4f5f6sa` (`id_employee`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5o1x6st8duo1eb1hdwprsl70b` (`id_employee`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `religion`
--
ALTER TABLE `religion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfkecbkxl3p2j5dwg52j4qalks` (`id_category`);

--
-- Indexes for table `subdistrict`
--
ALTER TABLE `subdistrict`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpoue4a3wk3n773pu4lmdknoeb` (`id_district`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_authority`
--
ALTER TABLE `users_authority`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_users` (`id_user`),
  ADD KEY `FK_Authority` (`id_authority`);

--
-- Indexes for table `village`
--
ALTER TABLE `village`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKikrbye2pu9aeovs29u3mjqchp` (`id_subdistrict`);

--
-- Indexes for table `work_assignment`
--
ALTER TABLE `work_assignment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6euksetx7nwnf987mqfrh274j` (`id_employee`),
  ADD KEY `FK1q2sajvahts7q5ugw8fpcqt43` (`id_job`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `certification`
--
ALTER TABLE `certification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_certification`
--
ALTER TABLE `employee_certification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_education`
--
ALTER TABLE `employee_education`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_language`
--
ALTER TABLE `employee_language`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_skill`
--
ALTER TABLE `employee_skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee_training`
--
ALTER TABLE `employee_training`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `organization`
--
ALTER TABLE `organization`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `training`
--
ALTER TABLE `training`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `work_assignment`
--
ALTER TABLE `work_assignment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD CONSTRAINT `FK_token` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_authority`
--
ALTER TABLE `users_authority`
  ADD CONSTRAINT `FK_Authority` FOREIGN KEY (`id_authority`) REFERENCES `authority` (`id`),
  ADD CONSTRAINT `FK_users` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
