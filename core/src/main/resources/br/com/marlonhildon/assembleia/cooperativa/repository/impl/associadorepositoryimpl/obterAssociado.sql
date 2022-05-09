SELECT
    assoc.id,
    assoc.nome,
    assoc.cpf,
    assoc.flagAtivo,
    assoc.dataHoraInsercao,
    assoc.dataHoraAlteracao,
    assoc.nomeUsuarioAuditoria
FROM Associado AS assoc
WHERE assoc.cpf = :cpf
AND assoc.flagAtivo = 'S';