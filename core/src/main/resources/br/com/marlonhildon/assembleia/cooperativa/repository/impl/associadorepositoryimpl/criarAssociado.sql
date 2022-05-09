INSERT INTO DBAssembleia.Associado(
    nome,
    cpf,
    flagAtivo,
    dataHoraInsercao,
    nomeUsuarioAuditoria
)
SELECT
    :associado.nome,
    :associado.cpf,
    'S',
    CURRENT_TIMESTAMP(),
    'springboot-db-assembleia-cooperativa'
FROM dual WHERE :associado.cpf NOT IN(
	SELECT associado_cadastro.cpf
	FROM DBAssembleia.Associado AS associado_cadastro
	WHERE associado_cadastro.cpf = :associado.cpf
);