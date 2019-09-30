--Parte 3 – PL/SQL Prático
--Exercício 3

--Crie uma procedure chamada DEFINIR_VALORES para que altere o valor dos itens
--da tabela EXAME_ITEMNF, definindo números inteiros aleatórios entre 1 e 100. 
--Faça com que a linha da tabela EXAME_NF receba o valor da somatória de seus 
--itens na coluna TOTALGERAL. Salve o fonte do script no arquivo SCRIPT3.SQL.


--DROP TABLE EXAME_NF;
--DROP TABLE EXAME_ITEMNF;
--SELECT * FROM EXAME_NF;
--SELECT * FROM EXAME_ITEMNF;

CREATE OR REPLACE PROCEDURE DEFINIR_VALORES(PARAM_IDNF NUMBER)

IS
    VALOR_TOTAL number;

BEGIN

    FOR ITEM IN (
    
        SELECT * FROM EXAME_ITEMNF WHERE IDNF = PARAM_IDNF
        
    ) LOOP   

        UPDATE EXAME_ITEMNF SET VALOR = (SELECT CAST(round(dbms_random.value(1,100)) AS number) FROM dual) WHERE IDITEMNF = ITEM.IDITEMNF;
        
    END LOOP;    
    
    SELECT SUM(VALOR) INTO VALOR_TOTAL FROM EXAME_ITEMNF WHERE IDNF = PARAM_IDNF;

    UPDATE EXAME_NF SET TOTALGERAL = VALOR_TOTAL  WHERE IDNF = PARAM_IDNF;

END;

--EXEC DEFINIR_VALORES(1);