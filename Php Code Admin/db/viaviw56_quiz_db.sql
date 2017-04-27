-- phpMyAdmin SQL Dump
-- version 4.1.8
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 21, 2014 at 04:38 PM
-- Server version: 5.1.73-cll
-- PHP Version: 5.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `viaviw56_quiz_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id`, `username`, `password`, `email`) VALUES
(1, 'admin', 'adminq1w2', 'viaviwebtech@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_levels`
--

CREATE TABLE IF NOT EXISTS `tbl_levels` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(255) NOT NULL,
  `required_points` int(11) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `tbl_levels`
--

INSERT INTO `tbl_levels` (`lid`, `level_name`, `required_points`) VALUES
(7, 'Level 1', 0),
(8, 'Level 2', 30),
(9, 'Level 3', 50),
(10, 'Level 4', 70),
(11, 'Level 5', 90);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_question`
--

CREATE TABLE IF NOT EXISTS `tbl_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `option_1` varchar(255) NOT NULL,
  `option_2` varchar(255) NOT NULL,
  `option_3` varchar(255) NOT NULL,
  `option_4` varchar(255) NOT NULL,
  `ans` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=84 ;

--
-- Dumping data for table `tbl_question`
--

INSERT INTO `tbl_question` (`id`, `level_id`, `question`, `option_1`, `option_2`, `option_3`, `option_4`, `ans`) VALUES
(34, 7, 'For which of the following disciplines is Nobel Prize awarded?', 'Physics and Chemistry', 'Physiology or Medicine', 'Literature and Economics', 'All of the above', 'All of the above'),
(35, 7, 'Hitler party which came into power in 1933 is known as', 'Labour Party', 'Nazi Party', 'Ku-Klux-Klan', 'Democratic Party', 'Nazi Party'),
(36, 7, 'Brass gets discoloured in air because of the presence of which of the following gases in air?', 'Oxygen', 'Carbon dioxide', 'Hydrogen Sulphide', 'Nitrogen', 'Hydrogen Sulphide'),
(37, 7, 'Which of the following is a non metal that remains liquid at room temperature?', 'Phosphorous', 'Bromine', 'Chlorine', 'Helium', 'Bromine'),
(38, 7, 'Chlorophyll is a naturally occurring chelate compound in which central metal is', 'Copper', 'Iron', 'Magnesium', 'Calcium', 'Magnesium'),
(39, 7, 'Which of the following metals forms an amalgam with other metals?', 'Tin', 'Mercury', 'Lead', 'Zinc', 'Mercury'),
(40, 7, 'Eritrea, which became the 182nd member of the UN in 1993, is in the continent of', 'Asia', 'Europe', 'Africa', 'Australia', 'Africa'),
(41, 7, 'Garampani sanctuary is located at', 'Gangtok, Sikkim', 'Junagarh, Gujarat', 'Kohima, Nagaland', 'Diphu, Assam', 'Diphu, Assam'),
(42, 7, 'Fastest shorthand writer was', 'J.M. Tagore', 'Khudada Khan', 'Dr. G. D. Bist', 'J.R.D. Tata', 'Dr. G. D. Bist'),
(43, 7, 'Epsom (England) is the place associated with', 'Horse Racing', 'Shooting', 'Snooker', 'Polo', 'Horse Racing'),
(44, 8, 'Eritrea, which became the 182nd member of the UN in 1993, is in the continent of', 'Asia', 'Africa', 'Europe', 'Australia', 'Africa'),
(45, 8, 'Golf player Vijay Singh belongs to which country?', 'USA', 'Fiji', 'India', 'UK', 'Fiji'),
(46, 8, 'First Afghan War took place in', '1843', '1839', '1833', '1848', '1839'),
(47, 8, 'First China War was fought between', 'China and France', 'China and Egypt', 'China and Greek', 'China and Britain', 'China and Britain'),
(48, 8, 'For the Olympics and World Tournaments, the dimensions of basketball court are', '26 m x 14 m', '28 m x 15 m', '27 m x 16 m', '28 m x 16 m', '28 m x 15 m'),
(49, 8, 'Each year World Red Cross and Red Crescent Day is celebrated on', 'June 18', 'June 8', 'May 8', 'May 18', 'May 8'),
(50, 8, 'Famous sculptures depicting art of love built some time in 950 AD u2013 1050 AD are', 'Mahabalipuram temples', 'Khajuraho temples', 'ama Masjid', 'Sun temple', 'Khajuraho temples'),
(51, 8, 'Gravity setting chambers are used in industries to remove', 'NOx', 'SOx', 'CO', 'Suspended Particulate Matter', 'Suspended Particulate Matter'),
(52, 8, 'Fire temple is the place of worship of which of the following religion?', 'udaism', 'Taoism', 'Shintoism', 'Zoroastrianism', 'Zoroastrianism'),
(53, 8, 'Film and TV institute of India is located at', 'Rajkot (Gujarat)', 'Perambur (Tamilnadu)', 'Pune (Maharashtra)', 'Pimpri (Maharashtra)', 'Pune (Maharashtra)'),
(54, 9, 'FFC stands for"', 'Foreign Finance Cor', 'Film Finance Cor', 'Federation of Football Council', 'None of the above', 'Film Finance Cor'),
(55, 9, 'In which year of First World War Germany declared war on Russia and France?', '1914', '1915', '1916', '1917', '1914'),
(56, 9, 'In a normal human body, the total number of red blood cells is', '15 trillion', '20 trillion', '30 trillion', '25 trillion', '30 trillion'),
(57, 9, 'With which sport is the Jules Rimet trophy associated?', 'Basketball', 'Football', 'Hockey', 'Golf', 'Football'),
(58, 9, 'Name the instrument used to measure relative humidity', 'Mercury Thermometer', 'Hygrometer', 'Hydrometer', 'Barometer', 'Hydrometer'),
(59, 9, 'Neil Armstrong and Edwin Aldrin were the first to', 'Circle the Moon', 'Step on the Moon', 'Walk in Space', 'Space Journey', 'Step on the Moon'),
(60, 9, 'The 2006 World Cup Football Tournament held in', 'France', 'China', 'Brazil', ' Germany', 'Germany'),
(61, 9, 'Queensland and Northern Territory Aerial Service is an International Airline of', 'Australia', 'East Africa', 'Belgium', 'Afghanistan', 'Australia'),
(62, 9, 'Sonia Nazario of "Los Angeles Times" was awarded Pulitzer Prize in 2003 for', 'Commentary', 'Feature Writing', 'Editorial Writing', 'Music', 'Feature Writing'),
(63, 9, 'Pan - American Highway, north-west Alaska to Southernmost Chile is the worlds', 'Highest Road', 'Busiest Road', 'Longest Road', 'None of the Above', 'Longest Road'),
(64, 10, 'The first meeting of the UN General Assembly was held in which of the following cities?', 'New York', 'San Francisco', 'Teheran', 'London', 'London'),
(65, 10, 'The department of Atomic Energy was established in', '1948', '1956', '1963', '1971', '1956'),
(66, 10, 'Wright Brothers are regarded inventors of the', 'Balloon', 'Bicycle', 'Aeroplane', 'None of the above', 'Aeroplane'),
(67, 10, 'The blood pressure of a young male human being is', '110/70', '135/90', '120/80', '140/100', '120/80'),
(68, 10, 'The headquarter of United Nations Fund for Programmes Population Activities (UNFA) are at', 'London', 'New York', 'Washington', 'Rome', 'New York'),
(69, 10, 'The headquarter of the Organization of Petroleum Exporting Countries are at', 'Algiers', 'Lagos', 'Kuwait', 'Vienna', 'Vienna'),
(70, 10, 'The king of Macedonia, who conquered most of Asia Minor and defeated Porus (India) in 327 B. C. was', 'Adolf Hitler', 'Chandragupta Maurya', 'Alexander the Great', 'Christopher Columbus', 'Alexander the Great'),
(71, 10, 'The headquarter of Asian Development Bank is located in which of the following cities', 'Jakarta', 'Singapore', 'Manila', 'Bangkok', 'Manila'),
(72, 10, 'The lower limit of perpetual snow in mountains such as the Himalayas is termed as the', 'Tree Line', 'Timber Line', 'Snow Line', 'Boundary Line', 'Snow Line'),
(73, 10, 'The headquarter of ECA (Economic Commission for Africa) are situated at', 'Addis Ababa', 'Geneva', 'Baghdad', 'Bangkok', 'Addis Ababa'),
(74, 11, 'The National Sports Festival for women was, for the first time, organized in', '1970', '1975', '1980', '1985', '1975'),
(75, 11, 'The Secretary-General is required to submit an annual report on the work of the UN to', 'General Assembly', 'Security Council', 'Trusteeship Council', 'All of the above', 'General Assembly'),
(76, 11, 'The site of the third oldest civilisation after the Sumerian and Egyption, Mohenjo-daro, was Built in', '2000 BC', '2700 BC', '2500 BC', '2300 BC', '2500 BC'),
(77, 11, 'The news agency Reuters belongs to which of the following country?', 'Palestine', 'Yugoslavia', 'Vietnam', 'UK', 'UK'),
(78, 11, 'The number of judges is European Court of Human Rights are', '21', '22', '18', '15', '21'),
(79, 11, 'The scientist who first discovered that the earth revolves round the sun was', 'Einstein', 'Newton', 'Dalton', 'Copernicus', 'Copernicus'),
(80, 11, 'The Olympic Flame was lit for the first time at the Amsterdam stadium in', '1981', '1928', '1938', '1948', '1928'),
(81, 11, 'The significance of peace is denoted by which of the following symbol?', 'Olive Branch', 'Green Light', 'Lotus', 'Red Fag', 'Olive Branch'),
(82, 11, 'The number of chromosomes in human body is', '42', '50', '48', '46', '46'),
(83, 11, 'The purest form of water can be obtained from', 'Deep Tubewell', 'Running Stream', 'Hot Water Spring', 'Heavy Shower of Rain', 'Heavy Shower of Rain');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
