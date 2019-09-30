--Parte 3 – PL/SQL Prático
--Exercício 4

--Crie uma consulta SELECT que exiba o total de linhas da tabela
--EXAME_NF por dia. Exiba somente as linhas que possuam ao menos 
--um item (EXAME_ITEMNF) com valor inferior a 50. Salve a consulta
--no arquivo SCRIPT4.SQL.

SELECT DATACADASTRO, COUNT(*) FROM EXAME_NF ENF join EXAME_ITEMNF ITEMNF on ENF.IDNF = ITEMNF.IDNF
WHERE ITEMNF.VALOR < 50 GROUP BY DATACADASTRO ORDER BY DATACADASTRO DESC
