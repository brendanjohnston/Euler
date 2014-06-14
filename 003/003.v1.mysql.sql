DROP PROCEDURE IF EXISTS `sp_003`;

DELIMITER $$

CREATE PROCEDURE `sp_003` (IN `limit` BIGINT UNSIGNED, OUT `solution` INTEGER UNSIGNED)
BEGIN

    DECLARE `inner_limit` BIGINT UNSIGNED;

    SET `inner_limit` = CEIL(SQRT(`limit`));

    SELECT
        MAX(`value`) INTO `solution`
    FROM
    `tbl_integers`
    WHERE
        `value` BETWEEN 2 AND `inner_limit`
        AND
        `limit` % `value` = 0
        AND
        `value` NOT IN (
            SELECT
                i1.`value` * i2.`value` as `non_prime`
            FROM
            `tbl_integers` AS i1
            INNER JOIN `tbl_integers` AS i2
                ON
                    i1.`value` >= i2.`value`
                    AND
                    i2.`value` BETWEEN 2 AND (`inner_limit` / i1.`value`)
            WHERE
                i1.`value` BETWEEN 2 AND `inner_limit`
    );

END

$$

CALL sp_003 (600851475143, @solution);

SELECT @solution as `solution`;