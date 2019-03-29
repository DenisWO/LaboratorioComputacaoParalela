package model.bean;

public class Produto {
	private String nome;
	private float quantidade;
	private float valor;
	private int id;
	
	public Produto( int id, String nome, float quantidade, float valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.id = id;
	}
	
	public Produto() {
		this.nome = null;
		this.quantidade = 0;
		this.valor = 0;
		this.id = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
}
