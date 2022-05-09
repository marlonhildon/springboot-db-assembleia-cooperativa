package br.com.marlonhildon.assembleia.cooperativa.exception;

import br.com.marlonhildon.assembleia.cooperativa.exception.erroenum.AssembleiaErroEnum;
import lombok.Getter;

@Getter
public class AssembleiaException extends RuntimeException {

    private final AssembleiaErroEnum assembleiaErroEnum;

    public AssembleiaException(AssembleiaErroEnum assembleiaErroEnum) {
        super(assembleiaErroEnum.getMensagemErro());
        this.assembleiaErroEnum = assembleiaErroEnum;
    }

    public AssembleiaException(AssembleiaErroEnum assembleiaErroEnum, Exception exception) {
        super(exception.getMessage());
        this.assembleiaErroEnum = assembleiaErroEnum;
    }

}
