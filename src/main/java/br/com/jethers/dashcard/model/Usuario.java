package br.com.jethers.dashcard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                      // indica que a classe Usuário será armazenada em banco
@Table(name = "tbl_usuario") // especifico o nome da tabela
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int id;
	
	@Column(name="nome_usuario", length = 80, nullable =  false)
	private String nome;
	
	@Column(name="email_usuario", length = 80, nullable = false, unique = true)
	private String email;
	
	@Column(name="racf_usuario", length = 7, nullable = false, unique = true)
	private String racf;
	
	@Column(name="senha", length = 20, nullable = false)
	private String senha;
	
	@Column(name="ramal", length = 10)
	private String ramal;
	
	@Column(name="link_foto", length = 255)
	
	private String linkFoto;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
}
