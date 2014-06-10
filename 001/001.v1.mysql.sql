CALL `sp_populate_integers` (1, 1000);

SELECT
    SUM(`value`) as `solution`
FROM
`tbl_integers`
WHERE
    `value` BETWEEN 0 AND 999
    AND
    (
        MOD(`value`, 3) = 0
        OR
        MOD(`value`, 5) = 0
    );
