package br.com.marlonhildon.assembleia.cooperativa.util;

import br.com.marlonhildon.assembleia.cooperativa.exception.AssembleiaException;
import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Métodos utilitários para validações das operações com BD.
 */
@Slf4j
@Component
public class ValidacaoUtil {

    public static final int NENHUMA_LINHA_ATUALIZADA = 0;

    /**
     * Valida se a atualização foi bem-sucedida.
     * @param qtdeLinhasAtualizadas a quantidade de linhas atualizadas
     * @throws AssembleiaException caso nenhuma linha seja atualizada.
     */
    public void validarAtualizacaoBD(int qtdeLinhasAtualizadas) {
        if(qtdeLinhasAtualizadas == NENHUMA_LINHA_ATUALIZADA) {
            throw new AssembleiaException(AssembleiaErroEnum.ITEM_NAO_ENCONTRADO);
        } else {
            log.info("Atualização feita com sucesso.");
        }
    }

}
