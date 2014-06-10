DROP TABLE IF EXISTS `tbl_integers`;

CREATE TABLE `tbl_integers` (
  `value` int(10) signed NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP PROCEDURE IF EXISTS `sp_populate_integers`;

DELIMITER //
CREATE PROCEDURE `sp_populate_integers` (X INT, Y INT)
BEGIN
	DELETE FROM `tbl_integers`;
	WHILE (X <= Y) DO
		INSERT INTO `tbl_integers` VALUES(X);
		SET X=X+1;
	END WHILE;
END //
DELIMITER;
