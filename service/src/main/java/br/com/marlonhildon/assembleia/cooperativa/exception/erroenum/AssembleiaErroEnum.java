package br.com.marlonhildon.assembleia.cooperativa.exception.erroenum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Abriga os códigos e mensagens de erro.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AssembleiaErroEnum {

    ITEM_NAO_ENCONTRADO("O item informado não foi encontrado.", HttpStatus.UNPROCESSABLE_ENTITY),
    ASSOCIADO_JA_EXISTE("O Associado já existe.", HttpStatus.UNPROCESSABLE_ENTITY),
    SESSAO_INICIO_FIM_VALIDOS("Insira data e hora válidos para início e fim da sessão.", HttpStatus.UNPROCESSABLE_ENTITY),
    SESSAO_AINDA_VIGENTE("Não foi possível apurar os votos pois a sessão ainda está em curso.", HttpStatus.UNPROCESSABLE_ENTITY),
    SESSAO_JA_FINALIZADA_OU_JA_VOTOU("Não foi possível votar pois a sessão está finalizada ou o Associado já votou.", HttpStatus.UNPROCESSABLE_ENTITY),
    ERRO_INTERNO_BD("Erro interno no Banco de Dados.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String mensagemErro;
    private final HttpStatus statusCodeErro;

}
