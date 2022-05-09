package br.com.marlonhildon.assembleia.cooperativa.exception;

import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ErroGenerated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AssociadoControllerAdvice {

    @ExceptionHandler(AssociadoException.class)
    public ResponseEntity<ErroGenerated> tratarResponseEntityAssociadoException(AssociadoException associadoException) {
        log.error("Erro de associado: {}", associadoException.getMessage());

        ErroGenerated erroRetorno = new ErroGenerated()
                .codigo(associadoException.getAssociadoErroEnum().name())
                .mensagem(associadoException.getAssociadoErroEnum().getMensagemErro());

        return new ResponseEntity<>(erroRetorno, associadoException.getAssociadoErroEnum().getStatusCodeErro());
    }

}
