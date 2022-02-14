MySQL query to create fees_details table
=============================================

CREATE TABLE `fees_details` (
  `reciept_no` int(11) NOT NULL DEFAULT 0,
  `student_name` varchar(50) DEFAULT NULL,
  `payment_mode` char(50) DEFAULT NULL,
  `cheque_no` int(11) DEFAULT NULL,
  `bank_name` varchar(50) DEFAULT NULL,
  `dd_no` int(11) DEFAULT NULL,
  `courses` varchar(100) DEFAULT NULL,
  `gstin` varchar(50) DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `total_in_words` varchar(200) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `year1` int(11) DEFAULT NULL,
  `year2` int(11) DEFAULT NULL,
  PRIMARY KEY (`reciept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
