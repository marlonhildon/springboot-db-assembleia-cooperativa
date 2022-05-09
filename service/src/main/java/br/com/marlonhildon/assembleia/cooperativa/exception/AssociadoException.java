package br.com.marlonhildon.assembleia.cooperativa.exception;

import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssociadoErroEnum;
import lombok.Getter;

@Getter
public class AssociadoException extends RuntimeException {

    private final AssociadoErroEnum associadoErroEnum;

    public AssociadoException(AssociadoErroEnum associadoErroEnum) {
        super(associadoErroEnum.getMensagemErro());
        this.associadoErroEnum = associadoErroEnum;
    }

    public AssociadoException(AssociadoErroEnum associadoErroEnum, Exception exception) {
        super(exception.getMessage());
        this.associadoErroEnum = associadoErroEnum;
    }

}
