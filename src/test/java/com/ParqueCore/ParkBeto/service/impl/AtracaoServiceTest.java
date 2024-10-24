package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.enums.AtracaoTipo;
import com.ParqueCore.ParkBeto.exceptions.BadRequestException;
import com.ParqueCore.ParkBeto.exceptions.NoContentException;
import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.model.Evento;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.ParqueCore.ParkBeto.enums.AtracaoTipo.MONTANHA_RUSSA;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AtracaoServiceTest {

	@Mock
	private AtracaoRepository atracaoRepository;

	@Mock
	private EventoRepository eventoRepository;

	@InjectMocks
	private AtracaoService atracaoService;

	@Test
	public void deveCadastrarAtracao() {
		// Cenario
		var atracao = mock(Atracao.class);

		// Simulando os dados da atração
		given(atracao.getId()).willReturn(1L);
		given(atracao.getNome()).willReturn("Montanha Russa");
		given(atracao.getDescricao()).willReturn("Uma incrivel montanha russa!");
		given(atracao.getTipo()).willReturn(MONTANHA_RUSSA);
		given(atracao.getCapacidadeMaxima()).willReturn(50);

		// Simula a ação de salvar a atração no repositório
		given(atracaoRepository.save(atracao)).willReturn(atracao);

		// Quando
		var result = atracaoService.createAtracao(atracao);

		// Validação
		assertEquals(1L, result.getId());
		assertEquals("Montanha Russa", result.getNome());
		assertEquals("Uma incrivel montanha russa!", result.getDescricao());
		assertEquals(MONTANHA_RUSSA, result.getTipo());
		assertEquals(50, result.getCapacidadeMaxima());
	}


	@Test
	public void deveVerificarSeONomeEUnico() {
		// Cenário: Nome da atração não está registrado no banco de dados
		var nomeUnico = "Montanha Russa Inédita";

		// Simulação: existsByNome retorna false para o nome informado
		given(atracaoRepository.existsByNome(nomeUnico)).willReturn(false);

		// Criação de nova atração com o nome configurado
		var novaAtracao = new Atracao();
		novaAtracao.setNome(nomeUnico);

		// Simulação: save retorna a atração que está sendo passada
		given(atracaoRepository.save(novaAtracao)).willReturn(novaAtracao);

		// Quando: Tentamos criar uma nova atração
		Atracao resultado = atracaoService.createAtracao(novaAtracao);

		// Então: O nome deve ser o nome que configuramos e único
		assertEquals(nomeUnico, resultado.getNome());
		assertFalse(atracaoRepository.existsByNome(nomeUnico));
	}

	@Test
	public void deveRetornarErroNomeNaoUnico() {

		// Simula uma instância da classe Atracao, permitindo que métodos desta instância sejam mockados
		var atracao = mock(Atracao.class);

		// Simula o comportamento do método getNome() da atração para que sempre retorne "jhon"
		given(atracao.getNome()).willReturn("jhon");

		// Simula o comportamento do atracaoRepository.save() para retornar a própria atração mockada
		given(atracaoRepository.save(atracao)).willReturn(atracao);

		// Simula o comportamento do método existsByNome() para retornar true, indicando que o nome "jhon" já existe no repositório (nome não é único)
		given(atracaoRepository.existsByNome(atracao.getNome())).willReturn(true);

		// Verifica que, ao tentar criar uma nova atração com nome duplicado, o método createAtracao() deve lançar uma exceção do tipo BadRequestException
		thenThrownBy(() -> atracaoService.createAtracao(atracao))
				.isInstanceOf(BadRequestException.class);
	}

	@Test
	public void deveRetornarTrueSeEventoAssociado() {
		// Cenário: ID da atração
		var atracaoId = 1L;

		// Simulação: O repositório retorna uma lista não vazia, indicando que há eventos associados à atração
		given(eventoRepository.findByAtracaoId(atracaoId)).willReturn(List.of(mock(Evento.class)));

		// Quando: O método hasAssociatedEvents é chamado com o ID da atração
		var resultado = atracaoService.hasAssociatedEvents(atracaoId);

		// Então: O resultado deve ser true, pois existem eventos associados
		assertTrue(resultado);
	}


	@Test
	public void deveRetornarErroAoDeletarAtracaoComEventosAssociados() {
		// Cenário: ID da atração e eventos associados
		var atracaoId = 1L;

		// Simulação: O repositório retorna uma lista não vazia, indicando que há eventos associados
		given(eventoRepository.findByAtracaoId(atracaoId)).willReturn(List.of(mock(Evento.class)));

		// Quando/Então: Tentar deletar a atração deve lançar uma exceção devido aos eventos associados
		thenThrownBy(() -> atracaoService.deleteAtracao(atracaoId))
				.isInstanceOf(EntityNotFoundException.class);
	}

	@Test
	public void deveRetornarListaDeAtracoes() {

		//Criacao de algumas atracoes para simular o retorno do repositorio
		var atracao1 = mock(Atracao.class);
		var atracao2 = mock(Atracao.class);

		//O repositorio retorna uma lista de atrações
		given(atracaoRepository.findAll()).willReturn(List.of(atracao1, atracao2));

		//Quando o metodo listaAtracoes é chamado
		List<Atracao> resultado = atracaoService.listaAtracoes();
		//entao verifica se o resultado contém as atracoes simuladas
		assertEquals(2, resultado.size());//deve conter 2 atracoes
		assertEquals(atracao1, resultado.get(0));
		assertEquals(atracao2, resultado.get(1));

	}

	@Test
	public void deveRetornarListaVaziaSeNaoTiverAtracoes() {
		given(atracaoRepository.findAll()).willReturn(List.of());
		List<Atracao> result = atracaoService.listaAtracoes();
		assertTrue(result.isEmpty());

	}

	@Test
	public void deveRetornarAtracoesDoTipoEspecificado() {
		AtracaoTipo tipo = MONTANHA_RUSSA;

		var atracao1 = mock(Atracao.class);
		var atracao2 = mock(Atracao.class);

		given(atracaoRepository.findByTipo(tipo)).willReturn(List.of(atracao1, atracao2));

		List<Atracao> result = atracaoService.buscarPorTipo(tipo);

		assertEquals(2, result.size());
		assertEquals(atracao1, result.get(0));
		assertEquals(atracao2, result.get(1));
	}

	@Test
	public void deveLancarExcecaoSeAtracaoTipoNaoEncontrada() {
		// Cenário: Tipo de atração sem nenhuma atração associada
		AtracaoTipo tipo = AtracaoTipo.MONTANHA_RUSSA;

		// Simulação: O repositório retorna uma lista vazia
		given(atracaoRepository.findByTipo(tipo)).willReturn(List.of());

		// Quando/Então: Verifica se a exceção NoContentException é lançada ao não encontrar atrações do tipo especificado
		thenThrownBy(() -> atracaoService.buscarPorTipo(tipo))
				.isInstanceOf(NoContentException.class)
				.hasMessageContaining("Nenhuma atração do tipo 'MONTANHA_RUSSA' foi encontrada no sistema.");

	}

	@Test
	public void deveRetornarExceptionAoDeletarAtracaoAssociadaEvento() {
		// Cenário: Atração com ID 1 e eventos associados
		Long atracaoId = 1L;

		// Simulação: Atração existe
		Atracao atracao = new Atracao();
		atracao.setId(atracaoId);
		given(atracaoRepository.findById(atracaoId)).willReturn(Optional.of(atracao));

		// Simulação: Eventos associados à atração
		List<Evento> eventos = List.of(new Evento()); // Suponha que exista um evento associado
		given(eventoRepository.findByAtracaoId(atracaoId)).willReturn(eventos); // Ajuste para o repositório certo

		// Quando: Tentativa de deletar atração associada a eventos
		assertThatThrownBy(() -> atracaoService.deleteAtracao(atracaoId))
				.isInstanceOf(BadRequestException.class)
				.hasMessageContaining("Erro ao deletar atração: Atração com ID " + atracaoId + " não pode ser deletada, pois está associada a um ou mais eventos.");

		// Então: Verifica que o método deleteById não foi chamado
		then(atracaoRepository).should(never()).deleteById(atracaoId);
	}

	@Test
	public void deveDeletarAtracaoQuandoNaoHouverEventosAssociados() {
		// Cenário: Atração com ID 1 e sem eventos associados
		Long atracaoId = 1L;

		// Simulação: Atração existe
		Atracao atracao = new Atracao();
		atracao.setId(atracaoId);
		given(atracaoRepository.findById(atracaoId)).willReturn(Optional.of(atracao));

		// Simulação: Nenhum evento associado à atração
		List<Evento> eventosVazios = Collections.emptyList(); // Não há eventos associados
		given(eventoRepository.findByAtracaoId(atracaoId)).willReturn(eventosVazios);

		// Quando: Deletar atração
		atracaoService.deleteAtracao(atracaoId);

		// Então: O método delete(atracao) deve ser chamado
		then(atracaoRepository).should().delete(atracao);

	}

}
