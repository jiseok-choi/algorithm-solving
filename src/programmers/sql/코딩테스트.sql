
-- 이름 중복 제거, NULL 제거
SELECT COUNT(DISTINCT NAME) FROM ANIMAL_INS WHERE NAME IS NOT NULL;


-- 고양이와 개 타입별 마리수
/*
    ANIMAL_TYPE	count
    Cat	        2
    Dog	        1
 */
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE;


-- 동명 동물 수 찾기
/*
    NAME	COUNT
    Lucy	3
    Raven	2
 */
SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(NAME) > 1
ORDER BY NAME;


-- 입양 시각 구하기(1)
/*
 SQL문을 실행하면 다음과 같이 나와야 합니다.

HOUR	COUNT
9	1
10	2
11	13
12	10
13	14
14	9
15	7
16	10
17	12
18	16
19	2
 */

SELECT DISTINCT HOUR(DATETIME) AS 'HOUR', COUNT(*) AS 'COUNT'
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME);


-- 입양 시각 구하기(2)
SELECT H1.HOUR, IFNULL(COUTS.COUNT, 0) AS 'COUNT'
FROM (
    SELECT 0 AS HOUR
    UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4
    UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8
    UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12
    UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 UNION SELECT 16
    UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20
    UNION SELECT 21 UNION SELECT 22 UNION SELECT 23
) AS H1

LEFT JOIN (
    SELECT HOUR(DATETIME) AS 'HOUR', COUNT(*) AS 'COUNT'
    FROM ANIMAL_OUTS
    GROUP BY HOUR
) AS OUTS ON H1.HOUR = OUTS.HOUR

-----------------------------------------------
SET @HOUR_LIST = -1;
SELECT
    (@HOUR_LIST := @HOUR_LIST + 1) AS 'HOUR',
    (SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @HOUR_LIST) AS 'COUNTS'
FROM ANIMAL_OUTS
WHERE @HOUR_LIST < 23;