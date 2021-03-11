package br.com.jethers.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.jethers.dashcard.dto.TotaisPorStatus;
import br.com.jethers.dashcard.model.AgenteFinanceiro;
import br.com.jethers.dashcard.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer> {
	public ArrayList<Transacao> findAllByAgente(AgenteFinanceiro agente);

	@Query(" SELECT new br.com.jethers.dashcard.dto.TotaisPorStatus(a.nome, a.volume, t.status, count(t.status)) "
			+ " FROM Transacao t INNER JOIN AgenteFinanceiro a ON t.agente.id = a.id "
			+ " WHERE t.agente.id = :idAgente " + " GROUP BY t.status" + " ORDER BY t.status")
	public ArrayList<TotaisPorStatus> recuperarTotaisPeloAgente(@Param(value = "idAgente") int idAgente);

}
