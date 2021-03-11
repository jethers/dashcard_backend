package br.com.jethers.dashcard.dto;

public class TotaisPorStatus {
	private String nomeAgente;
	private float  volumeFinanceiro;
	private int status;
	private long quantidade;
	
	public TotaisPorStatus() {
		super();
	}
	
	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	public float getVolumeFinanceiro() {
		return volumeFinanceiro;
	}

	public void setVolumeFinanceiro(float volumeFinanceiro) {
		this.volumeFinanceiro = volumeFinanceiro;
	}

	public TotaisPorStatus(int status, long quantidade) {
		super();
		this.status = status;
		this.quantidade = quantidade;
	}
		
	public TotaisPorStatus(String nomeAgente, float volumeFinanceiro, int status, long quantidade) {
		super();
		this.nomeAgente = nomeAgente;
		this.volumeFinanceiro = volumeFinanceiro;
		this.status = status;
		this.quantidade = quantidade;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
}
