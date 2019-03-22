package view;

import dados.Dados;
import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class TelaRegistros implements Runnable{
    private JFrame frame;
    private JPanel panel;
    private JButton btnAtualizar;
    private JButton btnZerar;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private DefaultTableModel model;
    private Thread autoInclusao;

    public TelaRegistros(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.btnAtualizar = new JButton("Atualizar");
        this.btnZerar = new JButton("Zerar registros");
        this.model = new DefaultTableModel();
        this.preencheCamposTabela();
        this.barraRolagem = new JScrollPane(this.tabela);

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
    public void atualizaTabela(){
        this.model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();

        for(Cliente c: clienteDAO.selecionaTodosRegistros()){
            this.model.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }
    private void iniciarTela(){
        this.frame.setSize(730, 550);
        this.panel.setSize(730,550);
        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.barraRolagem);
        this.panel.add(this.btnAtualizar);
        this.panel.add(this.btnZerar);
        this.barraRolagem.setBounds(20,10,690,400);
        this.btnAtualizar.setBounds(160,450,130,25);
        this.btnZerar.setBounds(310, 450, 250, 25);
        this.btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);
        this.btnZerar.addActionListener(this::btnZerarActionPerformed);

        this.autoInclusao = new Thread(new Runnable() {
            @Override
            public void run() {
                Dados dados = new Dados();
                int i =0;
                while(i<10){
                    ClienteDAO dao = new ClienteDAO();
                    if(dao.inserirCliente(new Cliente(0,dados.getNomes(), dados.getTelefones(), dados.getEmails(), dados.getSenhas()))){
                        atualizaTabela();
                    }
                    i++;
                }
            }
        });
    }
    private void btnAtualizarActionPerformed(ActionEvent evt){
        this.autoInclusao.run();
        this.atualizaTabela();
    }
    private void btnZerarActionPerformed(ActionEvent evt){
        ClienteDAO dao = new ClienteDAO();
        if(dao.zerarAutoIncremento()) this.atualizaTabela();
    }
    public void run(){
        this.atualizaTabela();
    }
}
