package br.com.marlonhildon.assembleia.cooperativa.exception;

import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ErroGenerated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AssembleiaControllerAdvice {

    @ExceptionHandler(AssembleiaException.class)
    public ResponseEntity<ErroGenerated> tratarResponseEntityAssembleiaException(AssembleiaException assembleiaException) {
        log.error("Erro: {}", assembleiaException.getMessage());

        ErroGenerated erroRetorno = new ErroGenerated()
                .codigo(assembleiaException.getAssembleiaErroEnum().name())
                .mensagem(assembleiaException.getAssembleiaErroEnum().getMensagemErro());

        return new ResponseEntity<>(erroRetorno, assembleiaException.getAssembleiaErroEnum().getStatusCodeErro());
    }

}
