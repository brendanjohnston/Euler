-- I really don't feel like doing this ...
CALL `sp_populate_integers` (1, 4000000);

-- Wikipedia explains how to identify a Fibonacci number nicely:
-- http://en.wikipedia.org/wiki/Fibonacci_number#Recognizing_Fibonacci_numbers
SELECT
    SUM(`q`.`even_fibonacci`) as `solution`
FROM
(
    SELECT
        `value` AS `even_fibonacci`
    FROM
    (
        SELECT
            `value`,
            SQRT(5 * `value` * `value` + 4) AS `is_fibonacci_tmp1`,
            SQRT(5 * `value` * `value` - 4) AS `is_fibonacci_tmp2`
        FROM
        tbl_integers
        WHERE
            `value` BETWEEN 0 AND 3999999
            AND
            MOD(`value`, 2) = 0
    ) AS `q`
    WHERE
        -- alternatives include round, floor and div 1
        CAST(`q`.`is_fibonacci_tmp1` AS SIGNED) = `q`.`is_fibonacci_tmp1`
        OR
        CAST(`q`.`is_fibonacci_tmp2` AS SIGNED) = `q`.`is_fibonacci_tmp2`
) AS `q`;
