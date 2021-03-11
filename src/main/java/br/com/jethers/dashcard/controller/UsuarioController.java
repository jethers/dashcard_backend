package br.com.jethers.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jethers.dashcard.dao.UsuarioDAO;
import br.com.jethers.dashcard.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperarTodos(){
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>)dao.findAll();
		return lista;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadosLogin) {
		Usuario resultado = dao.findByEmailOrRacf(dadosLogin.getEmail(), dadosLogin.getRacf());
		if (resultado != null) { // opa, usuario existe, preciso conferir a senha
			if (resultado.getSenha().equals(dadosLogin.getSenha())) {
				// senha confere? retorno o que foi consultado do banco
				return ResponseEntity.status(200).body(resultado);
			}
			// retorno q ele não tem autorização
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.notFound().build();
	
	}

}