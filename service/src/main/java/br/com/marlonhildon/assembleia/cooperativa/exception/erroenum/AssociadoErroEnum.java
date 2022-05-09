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
public enum AssociadoErroEnum {

    ASSOCIADO_NAO_ENCONTRADO("O Associado não foi encontrado.", HttpStatus.UNPROCESSABLE_ENTITY),
    ASSOCIADO_JA_EXISTE("O Associado já existe.", HttpStatus.UNPROCESSABLE_ENTITY),
    ASSOCIADO_ERRO_INTERNO_BD("Erro interno no Banco de Dados de Associado.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String mensagemErro;
    private final HttpStatus statusCodeErro;

}
