# IFT232-Project
CREATE TABLE `tbl_courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_code` varchar(6) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `nb_of_credits` int(11) NOT NULL,
  `lab` varchar(45) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
