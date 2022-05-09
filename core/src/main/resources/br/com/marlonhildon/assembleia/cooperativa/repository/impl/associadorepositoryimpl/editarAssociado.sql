UPDATE TbAssociado
SET
    nome = :associado.nome,
    flagAtivo = :associado.flagAtivo,
    dataHoraAlteracao = CURRENT_TIMESTAMP(),
    nomeUsuarioAuditoria = 'springboot-db-assembleia-cooperativa'
WHERE cpf = :cpf;