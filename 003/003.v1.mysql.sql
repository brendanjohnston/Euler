
DROP PROCEDURE IF EXISTS `sp_003`;

DELIMITER $$

CREATE PROCEDURE `sp_003` (IN `limit` INTEGER)
BEGIN

    SELECT
        MAX(`value`) as `solution`
    FROM
    `tbl_integers`
    WHERE
        `value` BETWEEN 2 AND `limit`
        AND
        MOD(`limit`, `value`) = 0
        AND
        `value` NOT IN (
            SELECT
                i1.`value` * i2.`value`
            FROM
            `tbl_integers` AS i1
            INNER JOIN `tbl_integers` AS i2
                ON
                    i1.`value` >= i2.`value`
                    AND
                    i2.`value` BETWEEN 2 AND (`limit` / i1.`value`)
            WHERE
                i1.`value` BETWEEN 2 AND (`limit` / 2)
    );

END

$$