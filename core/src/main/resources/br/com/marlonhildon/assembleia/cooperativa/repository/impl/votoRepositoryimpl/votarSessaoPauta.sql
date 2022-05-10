INSERT INTO Votacao(
    idAssociado,
    idSessaoVotacao,
    flagVotoAssociado,
    dataHoraInsercao,
    nomeUsuarioAuditoria
)
SELECT
    :voto.idAssociado,
    :voto.idSessaoVotacao,
    :voto.flagVotoAssociado,
    CURRENT_TIMESTAMP(),
    'springboot-db-assembleia-cooperativa'
FROM dual

WHERE :voto.idSessaoVotacao IN (
    SELECT sessao_pauta.id
    FROM SessaoPauta AS sessao_pauta

    LEFT JOIN Votacao as voto_pauta
    ON voto_pauta.idSessaoVotacao = sessao_pauta.id

    WHERE sessao_pauta.id = :voto.idSessaoVotacao   -- Sessao a ser votada
    AND (voto_pauta.idAssociado IS NULL OR voto_pauta.idAssociado != :voto.idAssociado) -- Associado nao deve votar mais de uma vez
    AND CURRENT_TIMESTAMP() BETWEEN sessao_pauta.dataHoraInicioSessao AND sessao_pauta.dataHoraFimSessao -- Intervalo de tempo vigente da sessao
);
