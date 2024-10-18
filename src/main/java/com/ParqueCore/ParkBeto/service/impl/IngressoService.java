package com.ParqueCore.ParkBeto.service.impl;

import com.ParqueCore.ParkBeto.model.Atracao;
import com.ParqueCore.ParkBeto.model.Ingresso;
import com.ParqueCore.ParkBeto.model.Visitante;
import com.ParqueCore.ParkBeto.repository.AtracaoRepository;
import com.ParqueCore.ParkBeto.repository.IngressoRepository;
import com.ParqueCore.ParkBeto.repository.VisitanteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class IngressoService {

	private final IngressoRepository ingressoRepository;
	private final VisitanteRepository visitanteRepository;
	private final AtracaoRepository atracaoRepository;

	public IngressoService(IngressoRepository ingressoRepository, VisitanteRepository visitanteRepository, AtracaoRepository atracaoRepository) {
		this.ingressoRepository = ingressoRepository;
		this.visitanteRepository = visitanteRepository;
		this.atracaoRepository = atracaoRepository;
	}

	public Ingresso emitirIngresso(Ingresso ingressoRequest) {
		var visitante = visitanteRepository.findById(ingressoRequest.getVisitante().getId())
				.orElseThrow(() -> new ObjectNotFoundException("Visitante não encontrado", Visitante.class));

		var atracao = atracaoRepository.findById(ingressoRequest.getAtracao().getId())
				.orElseThrow(() -> new ObjectNotFoundException("Atracao nao encontrada", Atracao.class));

		var ingresso = new Ingresso();

		ingresso.setVisitante(visitante);
		ingresso.setAtracao(atracao);
		ingresso.setDataEmissao(new Date());
		ingresso.setTipo(ingressoRequest.getTipo());
		ingresso.setStatus(ingressoRequest.getStatus());
		ingresso.setCodigo(UUID.randomUUID().toString());
		ingresso.setDataVisita(ingressoRequest.getDataVisita());

		return ingressoRepository.save(ingresso);

	}

	public void cancelarIngresso(Long id) {
		var ingresso = ingressoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ingresso não encontrado"));

		if (!ingresso.getStatus().equals("ativo")) {
			throw new RuntimeException("Ingresso não pode ser cancelado");
		}
		ingresso.setStatus("cancelado");
		ingressoRepository.save(ingresso);
	}

	public List<Ingresso> listarIngressos() {
		return ingressoRepository.findAll();
	}
}
