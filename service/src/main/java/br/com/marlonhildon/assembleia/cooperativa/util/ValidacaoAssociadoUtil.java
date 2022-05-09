package br.com.marlonhildon.assembleia.cooperativa.util;

import br.com.marlonhildon.assembleia.cooperativa.exception.AssociadoException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssociadoErroEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Métodos utilitários para validações das operações com o Associado.
 */
@Slf4j
@Component
public class ValidacaoAssociadoUtil {

    public static final int NENHUMA_LINHA_ATUALIZADA = 0;

    /**
     * Valida se a atualização do Associado foi bem-sucedida.
     * @param qtdeLinhasAtualizadas a quantidade de linhas atualizadas
     * @throws AssociadoException caso nenhuma linha seja atualizada.
     */
    public void validarAtualizacaoAssociado(int qtdeLinhasAtualizadas) {
        if(qtdeLinhasAtualizadas == NENHUMA_LINHA_ATUALIZADA) {
            throw new AssociadoException(AssociadoErroEnum.ASSOCIADO_NAO_ENCONTRADO);
        } else {
            log.info("Atualização de Associado feita com sucesso.");
        }
    }

}
