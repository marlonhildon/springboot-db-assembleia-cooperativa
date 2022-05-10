SELECT
    sessao.id AS idSessaoPauta,
    sessao.nomePauta AS nomePauta,
    SUM(CASE WHEN voto.flagVotoAssociado = 'S' THEN 1 ELSE 0 END) AS qtdeVotosSim,
    SUM(CASE WHEN voto.flagVotoAssociado = 'N' THEN 1 ELSE 0 END) AS qtdeVotosNao
FROM DBAssembleia.SessaoPauta AS sessao

LEFT JOIN DBAssembleia.Votacao as voto
ON voto.idSessaoVotacao = sessao.id

WHERE sessao.id = :idSessaoPauta
AND CURRENT_TIMESTAMP() NOT BETWEEN sessao.dataHoraInicioSessao AND sessao.dataHoraFimSessao
GROUP BY sessao.id, sessao.nomePauta;