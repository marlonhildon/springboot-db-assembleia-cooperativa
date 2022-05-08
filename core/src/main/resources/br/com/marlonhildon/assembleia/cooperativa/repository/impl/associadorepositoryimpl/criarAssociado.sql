INSERT INTO Associado(
    nome,
    cpf,
    flagAtivo,
    dataHoraInsercao,
    nomeUsuarioAuditoria
) VALUES (
    :associado.nome,
    :associado.cpf,
    'S',
    CURRENT_TIMESTAMP(),
    'springboot-db-assembleia-cooperativa'
);