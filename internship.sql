-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2017 at 07:30 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internship`
--

-- --------------------------------------------------------

--
-- Table structure for table `applyinternship`
--

CREATE TABLE `applyinternship` (
  `Company` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `applyinternship`
--

INSERT INTO `applyinternship` (`Company`, `Name`, `Surname`, `Email`) VALUES
('Vestel', 'asdwe', 'ewqa', 'asd'),
('Do?u? Tekno', 'asd', 'qwe', 'sda'),
('HugoBoss', 'student', 'test', 'test@test.com');

-- --------------------------------------------------------

--
-- Table structure for table `evaluationform`
--

CREATE TABLE `evaluationform` (
  `id` varchar(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `faculty` varchar(30) NOT NULL,
  `dept` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `addr` varchar(100) NOT NULL,
  `gsm` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `insname` varchar(20) NOT NULL,
  `insdept` varchar(20) NOT NULL,
  `insaddr` varchar(100) NOT NULL,
  `insphone` varchar(11) NOT NULL,
  `insfax` varchar(11) NOT NULL,
  `insemail` varchar(30) NOT NULL,
  `inssprvsr` varchar(20) NOT NULL,
  `inshrmngr` varchar(20) NOT NULL,
  `q1` varchar(5) NOT NULL,
  `q2` varchar(11) NOT NULL,
  `q3` varchar(11) NOT NULL,
  `q4` varchar(11) NOT NULL,
  `q5` varchar(11) NOT NULL,
  `q6` varchar(11) NOT NULL,
  `q7` varchar(11) NOT NULL,
  `q8` varchar(11) NOT NULL,
  `q9` varchar(11) NOT NULL,
  `q10` varchar(20) NOT NULL,
  `q11` varchar(20) NOT NULL,
  `q12` varchar(20) NOT NULL,
  `q13` varchar(20) NOT NULL,
  `q14` varchar(300) NOT NULL,
  `q15` varchar(300) NOT NULL,
  `q16` varchar(300) NOT NULL,
  `q17` varchar(300) NOT NULL,
  `q18` varchar(300) NOT NULL,
  `q19` varchar(300) NOT NULL,
  `q20` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evaluationform`
--

INSERT INTO `evaluationform` (`id`, `name`, `surname`, `faculty`, `dept`, `type`, `addr`, `gsm`, `email`, `insname`, `insdept`, `insaddr`, `insphone`, `insfax`, `insemail`, `inssprvsr`, `inshrmngr`, `q1`, `q2`, `q3`, `q4`, `q5`, `q6`, `q7`, `q8`, `q9`, `q10`, `q11`, `q12`, `q13`, `q14`, `q15`, `q16`, `q17`, `q18`, `q19`, `q20`) VALUES
('20140601007', 'Hamza Melih', 'Bayrakdar', 'Engineering', 'Software', 'office', 'Ieu', '05389483861', 'hamzamelih61@hotmail.com', 'Hugo', 'Arge', '?zmir', '04542616556', '04542614565', 'hugo@hugo.com', 'Ali Ba?aran', 'Ay?e Kafakoparan', 'No', 'Never', 'Very Much', 'Moderately', 'Moderately', 'Moderately', 'Little', 'Moderately', 'Little', 'Considerably agree', 'Considerably agree', 'Never', 'Partially disagree', 'It was good', 'I had no other option', 'Agile Programming', 'Good meal', 'No transportation', 'Courses : SE320, SE309, Se311', 'Works : Code review, testing'),
('2015', 'ali', 'veli', 'engineerin', 'comp', 'industry', 'ieu', '5200200220', 'ali@ali.com', 'hugo', 'arge', 'izmir', '25066203232', '25063255656', 'hugo@hugo.com', 'ali ba?aran', 'ay?e kafakoparan', 'no', 'Moderately', 'Very Much', 'Never', 'Very Much', 'Never', 'Very Much', 'Little', 'Moderately', 'Partially agree', 'Partially disagree', 'Moderately', 'Totally agree', 'nice', 'no choice', 'good things', 'good meal', 'expensive meal', 'Courses : se320', 'Works : junit testi\n'),
('a', 's', 'd', 'f', 'g', 'office', 'h', 'j', 'k', 'q', 'w', 'e', 'r', 't', 'y', 'u', '?', 'no', 'Never', 'Never', 'Never', 'Never', 'Never', 'Never', 'Never', 'Never', 'No answer', 'No answer', 'No answer', 'No answer', 'z', 'x', 'c', 'v', 'b', 'Courses :n', 'Works :m');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` char(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `isstudent` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `email`, `isstudent`) VALUES
('hmbayrakdar', 'patates', 'hamzabayrakdar@std.ieu.edu.tr', 1),
('student', 'test', 'test@eimail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applyinternship`
--
ALTER TABLE `applyinternship`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `evaluationform`
--
ALTER TABLE `evaluationform`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
