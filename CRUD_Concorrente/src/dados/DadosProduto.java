package dados;

import java.util.ArrayList;
import java.util.Random;

public class DadosProduto {
	private ArrayList<String> nomes;
    private ArrayList<Float> quantidade;
    private ArrayList<Float> valor;
    
    private Random random;
    private int indexNome;

    public DadosProduto(){
        this.nomes = new ArrayList<>();
        this.quantidade = new ArrayList<>();
        this.valor = new ArrayList<>();
        this.random = new Random();
        indexNome = 0;
        this.setNomes();
        this.setQuantidade();
        this.setValor();
    }
    public String getNomes() {
        this.indexNome = random.nextInt(10);
        return nomes.get(this.indexNome);
    }

    public void setNomes() {
        this.nomes.add("Televisao");
        this.nomes.add("Geladeira");
        this.nomes.add("Microondas");
        this.nomes.add("Fogao");
        this.nomes.add("Celular");
        this.nomes.add("Notebook");
        this.nomes.add("Monitor");
        this.nomes.add("Video Game");
        this.nomes.add("DVD Player");
        this.nomes.add("Teclado");
    }

    public float getQuantidade() {
        return quantidade.get(this.indexNome);
    }

    public void setQuantidade() {
        this.quantidade.add( (float) 50.00);
        this.quantidade.add( (float) 40.00);
        this.quantidade.add( (float) 80.00);
        this.quantidade.add( (float) 10.00);
        this.quantidade.add( (float) 60.00);
        this.quantidade.add( (float) 30.00);
        this.quantidade.add( (float) 70.00);
        this.quantidade.add( (float) 90.00);
        this.quantidade.add( (float) 100.00);
        this.quantidade.add( (float) 20.00);
    }

    public float getValor() {
        return valor.get(random.nextInt(10));
    }

    public void setValor() {
        this.valor.add( (float) 1500.00);
        this.valor.add( (float) 2300.00);
        this.valor.add( (float) 400.00);
        this.valor.add( (float) 550.00);
        this.valor.add( (float) 1070.00);
        this.valor.add( (float) 2510.00);
        this.valor.add( (float) 200.00);
        this.valor.add( (float) 1600.00);
        this.valor.add( (float) 250.00);
        this.valor.add( (float) 100.00);
    }
}