package view;

import dados.Dados;
import dados.DadosProduto;
import model.bean.Cliente;
import model.bean.Produto;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class TelaRegistros implements Runnable{
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JButton btnAtualizar;
    private JButton btnZerar;
    private JTable tabela;
    private JTable tabelaProdutos;
    private JScrollPane barraRolagem;
    private JScrollPane barraRolagemProduto;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private Thread autoInclusao;

    public TelaRegistros(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.panel2 = new JPanel();
        this.btnAtualizar = new JButton("Atualizar");
        this.btnZerar = new JButton("Zerar registros");
        this.model = new DefaultTableModel();
        this.model2 = new DefaultTableModel();
        this.preencheCamposTabela();
        this.preencheCamposTabelaProdutos();
        this.barraRolagem = new JScrollPane(this.tabela);
        this.barraRolagemProduto = new JScrollPane(this.tabelaProdutos);
        iniciarTela();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

        Thread thread = new Thread(this::run);
        thread.start();
    }
    private void preencheCamposTabela(){
        this.tabela = new JTable(this.model);
        this.model.addColumn("Id");
        this.model.addColumn("Nome");
        this.model.addColumn("Email");
        this.model.addColumn("Telefone");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(3);

        this.model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();

        for(Cliente c : clienteDAO.selecionaTodosRegistros()){
            this.model.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }
    private void preencheCamposTabelaProdutos() {
    	this.tabelaProdutos = new JTable(this.model2);
    	this.model2.addColumn("Nome Produto");
    	this.model2.addColumn("Quantidade");
    	this.model2.addColumn("Valor Produto");
    	tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(3);
    	
    	this.model2.setNumRows(0);
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	
    	for( Produto p : produtoDAO.selecionaTodosRegistros()) {
    		this.model2.addRow(new Object[] {p.getId(), p.getNome(), p.getQuantidade(), p.getValor()});
    	}
    	
    }
    public void atualizaTabela(){
        this.model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();

        for(Cliente c: clienteDAO.selecionaTodosRegistros()){
            this.model.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }
    public void atualizaTabelaProduto() {
    	this.model2.setNumRows(0);
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	
    	for ( Produto p: produtoDAO.selecionaTodosRegistros()) {
    		this.model2.addRow(new Object[] {p.getId(), p.getNome(), p.getQuantidade(), p.getValor()});
    	}
    }
    
    private void iniciarTela(){
        this.frame.setSize(1300, 550);
        this.panel.setSize(730,550);
        this.panel2.setSize(400, 550);
        
        this.frame.add(this.panel);
        this.frame.add(this.panel2);
        this.panel.setLayout(null);
        this.panel2.setLayout(null);
        this.panel.add(this.barraRolagem);
        this.panel2.add(this.barraRolagemProduto);
        this.panel.add(this.btnAtualizar);
        this.panel.add(this.btnZerar);
        
        this.panel.setBounds(0, 0, 730, 550);
        this.panel2.setBounds(731, 0, 400, 550);
        
        this.barraRolagem.setBounds(20,10,690,400);
        this.barraRolagemProduto.setBounds(770, 10, 480, 400);
        this.btnAtualizar.setBounds(160,450,130,25);
        this.btnZerar.setBounds(310, 450, 250, 25);
        this.btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);
        this.btnZerar.addActionListener(this::btnZerarActionPerformed);

        this.autoInclusao = new Thread(new Runnable() {
            @Override
            public void run() {
                Dados dados = new Dados();
                DadosProduto dadosProduto = new DadosProduto();
                int i =0;
                int j = 0;
                while(i<10){
                    ClienteDAO dao = new ClienteDAO();
                    if(dao.inserirCliente(new Cliente(0,dados.getNomes(), dados.getTelefones(), dados.getEmails(), dados.getSenhas()))){
                        atualizaTabela();
                    }
                    i++;
                }
                while(j < 10) {
                	ProdutoDAO produtoDAO = new ProdutoDAO();
                	if( produtoDAO.inserirProduto(new Produto(0, dadosProduto.getNomes(), dadosProduto.getQuantidade(), dadosProduto.getValor()))) {
                		atualizaTabelaProduto();
                	}
                	j++;
                }
            }
        });
    }
    private void btnAtualizarActionPerformed(ActionEvent evt){
        this.autoInclusao.run();
        this.atualizaTabela();
        this.atualizaTabelaProduto();
    }
    private void btnZerarActionPerformed(ActionEvent evt){
        ClienteDAO dao = new ClienteDAO();
        ProdutoDAO produtoDAO =new ProdutoDAO();
        
        if(dao.zerarAutoIncremento()) this.atualizaTabela();
        
        if(produtoDAO.zerarAutoIncremento()) this.atualizaTabelaProduto();
    }
    public void run(){
        this.atualizaTabela();
        this.atualizaTabelaProduto();
    }
}
