package br.com.jethers.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jethers.dashcard.dao.TransacaoDAO;
import br.com.jethers.dashcard.dto.TotaisPorStatus;
import br.com.jethers.dashcard.model.AgenteFinanceiro;
import br.com.jethers.dashcard.model.Transacao;

@RestController
@CrossOrigin("*")
public class TransacaoController {

	@Autowired
	private TransacaoDAO dao;

	@GetMapping("/transacao")
	public ArrayList<Transacao> recuperarTudo() {
		ArrayList<Transacao> lista;
		lista = (ArrayList<Transacao>) dao.findAll();
		return lista;
	}

	@GetMapping("/transacao/{idAgente}")
	public ArrayList<TotaisPorStatus> recuperarPorIdAgente(@PathVariable int idAgente) {
		ArrayList<Transacao> lista;
		AgenteFinanceiro agente = new AgenteFinanceiro();
		agente.setId(idAgente);
		lista = dao.findAllByAgente(agente);
		// agora que tenho a lista de transações, quero ver quantas de cada tipo foram
		// feitas
		int qtdSucesso = 0;
		int qtdFalha = 0;
		int qtdFraude = 0;
		for (Transacao t : lista) {
			if (t.getStatus() == 0) {
				qtdSucesso++;
			} else if (t.getStatus() == 1) {
				qtdFalha++;
			} else {
				qtdFraude++;
			}
		}
		System.out.println("Sucesso: " + qtdSucesso + "  Falha:" + qtdFalha + "  Fraude:" + qtdFraude);
		ArrayList<TotaisPorStatus> resultado = new ArrayList<TotaisPorStatus>();

		TotaisPorStatus totSucesso = new TotaisPorStatus();
		totSucesso.setStatus(0);
		totSucesso.setQuantidade(qtdSucesso);

		TotaisPorStatus totFalha = new TotaisPorStatus();
		totFalha.setStatus(1);
		totFalha.setQuantidade(qtdFalha);

		TotaisPorStatus totFraude = new TotaisPorStatus();
		totFraude.setStatus(2);
		totFraude.setQuantidade(qtdFraude);

		resultado.add(totSucesso);
		resultado.add(totFalha);
		resultado.add(totFraude);

		return resultado;
	}

	@GetMapping("/transacao/totais/{idAgente}")
	public ArrayList<TotaisPorStatus> recuperarConsolidadoPorAgente(@PathVariable int idAgente) {
		return dao.recuperarTotaisPeloAgente(idAgente);
	}

}