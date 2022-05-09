UPDATE Associado
SET
    flagAtivo = 'N'
WHERE cpf = :cpf
AND flagAtivo = 'S';