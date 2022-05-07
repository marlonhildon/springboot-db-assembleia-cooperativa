package br.com.marlonhildon.assembleia.cooperativa.controller;

import br.com.marlonhildon.assembleia.cooperativa.domain.AssociadoDomain;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.AssociadoGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.ManipulacaoEntidadeGenerated;
import br.com.marlonhildon.assembleia.cooperativa.gerado.model.NovoNomeStatusGenerated;
import br.com.marlonhildon.assembleia.cooperativa.mapper.AssociadoMapper;
import br.com.marlonhildon.assembleia.cooperativa.service.AssociadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociadoControllerTest {

    @InjectMocks
    private AssociadoController controller;

    @Mock
    private AssociadoMapper associadoMapper;
    @Mock
    private AssociadoService associadoService;

    private final String cpfTeste = "49265778016";

    @Test
    void apagarAssociadoTest() {
        ResponseEntity<ManipulacaoEntidadeGenerated> respostaController = controller.apagarAssociado(cpfTeste);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, respostaController.getStatusCode());
    }

    @Test
    void criarAssociadoTest() {
        when(associadoMapper.paraAssociadoDomain(Mockito.any(AssociadoGenerated.class))).thenReturn(getAssociadoDomainMock());
        when(associadoMapper.paraAssociadoGenerated(Mockito.any(AssociadoDomain.class))).thenReturn(getAssociadoGeneratedMock());
        when(associadoService.criarAssociado(Mockito.any(AssociadoDomain.class))).thenReturn(getAssociadoDomainMock());

        ResponseEntity<AssociadoGenerated> respostaController = controller.criarAssociado(getAssociadoGeneratedMock());

        assertEquals(HttpStatus.CREATED, respostaController.getStatusCode());
        assertNotNull(Objects.requireNonNull(respostaController.getBody()).getCpf());
        assertNotNull(Objects.requireNonNull(respostaController.getBody().getNome()));
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

    private AssociadoDomain getAssociadoDomainMock() {
        AssociadoDomain associadoDomain = AssociadoDomain.builder()
                .cpf(cpfTeste)
                .nome("João das Gemas")
                .build();
        return associadoDomain;
    }

    private NovoNomeStatusGenerated getNovoNomeStatusGeneratedMock() {
        return new NovoNomeStatusGenerated().nome("João das Claras");
    }

}