package br.com.jethers.dashcard.dao;

import br.com.jethers.dashcard.model.Usuario;


import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	/*              select
	 *                ^       where email = ? or racf = ?
	 * 				  |	       ^
	 *                |        |
	               ------ ----------                 */              
	public Usuario findByEmailOrRacf(String email, String racf);
}
