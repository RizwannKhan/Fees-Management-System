-- fees_management_system.course definition

CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cName` varchar(255) NOT NULL,
  `cost` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fees_management_system.fees_details definition

CREATE TABLE `fees_details` (
  `receipt_no` int NOT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `roll_no` varchar(100) DEFAULT NULL,
  `payment_mode` varchar(100) DEFAULT NULL,
  `cheque_no` varchar(100) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `dd_no` varchar(100) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `gstin` varchar(100) DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `total_in_words` varchar(255) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `year1` int DEFAULT NULL,
  `year2` int DEFAULT NULL,
  PRIMARY KEY (`receipt_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- fees_management_system.signup definition

CREATE TABLE `signup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
