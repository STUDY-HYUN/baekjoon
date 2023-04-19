-- 코드를 입력하세요
SELECT
       P1.ID
     , P1.NAME
     , P1.HOST_ID
  FROM PLACES P1
  WHERE P1.HOST_ID IN ( SELECT
                               P.HOST_ID
                          FROM PLACES P
                         GROUP BY P.HOST_ID
                         HAVING COUNT(P.HOST_ID) > 1);