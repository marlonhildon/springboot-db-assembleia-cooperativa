SELECT
    id,
    nomePauta,
    dataHoraInicioSessao,
    dataHoraFimSessao,
    nomeUsuarioAuditoria
FROM SessaoPauta
WHERE id = :id;
