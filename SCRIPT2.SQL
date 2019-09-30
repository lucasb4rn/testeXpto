--Parte 3 – PL/SQL Prático

--Crie um segundo script (SCRIPT2.SQL) que possua um bloco de código 
--para que gere registros fictícios para as tabelas criadas. Gere 1000 
--registros para a tabela EXAME_NF. Para cada EXAME_NF gere 3 registros. 
--Faça com que a DATACADASTRO do EXAME_NF comece em 10 dias atrás, 
--fazendo com que a cada 100 registros a data seja aumentada em 1 dia,
-- distribuindo assim os 1000 registros em 10 dias diferentes de cadastro.


--DROP TABLE EXAME_NF;
--DROP TABLE EXAME_ITEMNF;
--SELECT * FROM EXAME_NF;
--SELECT * FROM EXAME_ITEMNF;


DECLARE

   x NUMBER := 100;
   DATACADASTRO DATE := SYSDATE - 10;
   IDPARAITEM NUMBER := 1;
  
   
BEGIN
   FOR i IN 1..1000 LOOP
        IF X < 0 THEN    
         DATACADASTRO :=  DATACADASTRO + 1;     
         X := 100;    
        ELSE 
         X := X -1;
        END IF;
        
        insert into EXAME_NF (IDNF, NUMERO, DATACADASTRO, TOTALGERAL) values (i, i, DATACADASTRO, 0);
        
         FOR b IN 1..3 LOOP
            
            INSERT INTO EXAME_ITEMNF (IDITEMNF, IDNF, IDPRODUTO, QTDE, VALOR) VALUES (IDPARAITEM, i, (SELECT  * FROM  (SELECT IDPRODUTO FROM   produto  ORDER BY  dbms_random.value) where ROWNUM = 1), round(dbms_random.value(1,i)), round(dbms_random.value(1,400)));
            IDPARAITEM := IDPARAITEM + 1;    
        
         END LOOP;
   
     END LOOP;
     
   COMMIT;
END;