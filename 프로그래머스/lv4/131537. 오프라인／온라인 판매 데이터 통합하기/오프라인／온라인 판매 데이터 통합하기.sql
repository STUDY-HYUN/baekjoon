-- 코드를 입력하세요
SELECT 
       *
  FROM (
    SELECT
           DATE_FORMAT(N.SALES_DATE, '%Y-%m-%d') as SALES_DATE
         , N.PRODUCT_ID
         , N.USER_ID
         , N.SALES_AMOUNT
      FROM ONLINE_SALE N
     WHERE DATE_FORMAT(SALES_DATE, '%Y-%m-%d') LIKE '____-03-__'
    UNION ALL
    SELECT
           DATE_FORMAT(F.SALES_DATE, '%Y-%m-%d') as SALES_DATE
         , F.PRODUCT_ID
         , NULL AS USER_ID
         , F.SALES_AMOUNT
      FROM OFFLINE_SALE F
     WHERE DATE_FORMAT(F.SALES_DATE, '%Y-%m-%d') LIKE '____-03-__') T
  ORDER BY T.SALES_DATE , T.PRODUCT_ID, T.USER_ID