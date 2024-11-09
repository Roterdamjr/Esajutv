package modelo;

import java.util.Objects;

public class VaraAno {
	private String vara;
    private int ano;
    private String jurisdicao;
    private int quantidade;
    
    public VaraAno(){
    	
    }
	public VaraAno(String vara, int ano, String jurisdicao, int quantidade) {
		super();
		this.vara = vara;
		this.ano = ano;
		this.jurisdicao = jurisdicao;
		this.quantidade = quantidade;
	}
	
	public VaraAno(String vara,String jurisdicao, int quantidade) {
		super();
		this.vara = vara;
		this.jurisdicao = jurisdicao;
		this.quantidade = quantidade;
	}
	
	public String getVara() {
		return vara;
	}
	public void setVara(String vara) {
		this.vara = vara;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getJurisdicao() {
		return jurisdicao;
	}
	public void setJurisdicao(String jurisdicao) {
		this.jurisdicao = jurisdicao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


   
}
