package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.gerado.model.AssociadoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ManipulacaoEntidadeGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.NovoNomeStatusGenerated;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
class AssociadoControllerTest {

    @InjectMocks
    private AssociadoController controller;

    private final String cpfTeste = "49265778016";

    @Test
    void apagarAssociadoTest() {
        ResponseEntity<ManipulacaoEntidadeGenerated> respostaController = controller.apagarAssociado(cpfTeste);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, respostaController.getStatusCode());
    }

    @Test
    void criarAssociadoTest() {
        ResponseEntity<AssociadoGenerated> respostaController = controller.criarAssociado(getAssociadoGeneratedMock());
        assertEquals(HttpStatus.NOT_IMPLEMENTED, respostaController.getStatusCode());
    }

    @Test
    void editarAssociadoTest() {
        ResponseEntity<ManipulacaoEntidadeGenerated> respostaController = controller.editarAssociado(cpfTeste, getNovoNomeStatusGeneratedMock());
        assertEquals(HttpStatus.NOT_IMPLEMENTED, respostaController.getStatusCode());
    }

    @Test
    void obterAssociadoTest() {
        ResponseEntity<AssociadoGenerated> respostaController = controller.obterAssociado(cpfTeste);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, respostaController.getStatusCode());
    }

    private AssociadoGenerated getAssociadoGeneratedMock() {
        return new AssociadoGenerated()
                .cpf(cpfTeste)
                .nome("João das Neves");
    }

    private NovoNomeStatusGenerated getNovoNomeStatusGeneratedMock() {
        return new NovoNomeStatusGenerated().nome("João das Claras");
    }

}