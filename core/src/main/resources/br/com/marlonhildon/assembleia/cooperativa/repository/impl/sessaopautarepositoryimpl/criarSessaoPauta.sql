INSERT INTO SessaoPauta(
    nomePauta,
    dataHoraInicioSessao,
    dataHoraFimSessao,
    nomeUsuarioAuditoria
) VALUES (
    :sessao.nomePauta,
    :sessao.dataHoraInicioSessao,
    :sessao.dataHoraFimSessao,
    'springboot-db-assembleia-cooperativa'
);
