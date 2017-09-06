Create TABLE `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userGender` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userAddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_IhomeworkNCREMENT=2 DEFAULT CHARSET=utf8;


Insert INTO `homework` VALUES ('1', 'fangxiang', 'man', '24','18358196136','hefei');