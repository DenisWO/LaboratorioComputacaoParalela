package audi.view;

import javax.swing.*;
import java.awt.*;

public class TelaProducao {
    private JFrame frame;
    private JPanel panel;
    private JPanel panelProducaoMotores;
    private JLabel labelProducaoMotores;
    private JPanel panelEstoqueMotores;
    private JLabel labelEstoqueMotores;
    private JPanel panelProducaoCarroceria;
    private JLabel labelProducaoCarroceria;
    private JPanel panelEstoqueCarroceria;
    private JLabel labelEstoqueCarroceria;
    private JPanel panelProducaoPneus;
    private JLabel labelProducaoPneus;
    private JPanel panelEstoquePneus;
    private JLabel labelEstoquePneus;
    private JPanel panelProducaoBancos;
    private JLabel labelProducaoBancos;
    private JPanel panelEstoqueBancos;
    private JLabel labelEstoqueBancos;
    private JPanel panelProducaoEletrica;
    private JLabel labelProducaoEletrica;
    private JPanel panelEstoqueEletrica;
    private JLabel labelEstoqueEletrica;
    private JPanel panelCarros;
    private JPanel panelCaminhoes;
    private JLabel labelCarros;
    private JLabel labelCaminhoes;
    private JLabel totalCarrosPrduzidos;
    //private JButton btnIniciar;

    public TelaProducao(){
        this.frame = new JFrame();
        this.panel = new JPanel();

        /*Iniciando os panels de producao*/
        this.panelProducaoMotores = new JPanel();
        this.panelProducaoBancos = new JPanel();
        this.panelProducaoCarroceria = new JPanel();
        this.panelProducaoEletrica = new JPanel();
        this.panelProducaoPneus = new JPanel();

        /*Iniciando os panels de estoque*/
        this.panelEstoqueBancos = new JPanel();
        this.panelEstoquePneus = new JPanel();
        this.panelEstoqueEletrica = new JPanel();
        this.panelEstoqueMotores = new JPanel();
        this.panelEstoqueCarroceria = new JPanel();

        /*Iniciando todos os labels*/
        this.labelProducaoEletrica = new JLabel("PRODUCAO ELETRONICA");
        this.labelProducaoBancos = new JLabel("PRODUCAO BANCOS");
        this.labelProducaoCarroceria = new JLabel("PRODUCAO CARROCERIA");
        this.labelProducaoMotores = new JLabel("PRODUCAO MOTORES");
        this.labelProducaoPneus = new JLabel("PRODUCAO PNEUS");

        this.labelEstoqueCarroceria = new JLabel("ESTOQUE CARROCERIA:");
        this.labelEstoqueBancos = new JLabel("ESTOQUE BANCOS:");
        this.labelEstoqueEletrica = new JLabel("ESTOQUE ELETRONICA:");
        this.labelEstoqueMotores = new JLabel("ESTOQUE MOTORES:");
        this.labelEstoquePneus = new JLabel("ESTOQUE PNEUS:");


        this.panelCarros = new JPanel();
        this.panelCaminhoes = new JPanel();

        this.labelCarros = new JLabel("CARROS:");
        this.labelCaminhoes = new JLabel("CAMINHOES:");

        this.totalCarrosPrduzidos = new JLabel("Total Carros Produzidos:");

        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void initComponents(){
        this.adicionandoPaneisSecundarios();
        this.adicionandoLaebelsPaineisSecundarios();
        this.posicionandoComponentes();
    }
    private void adicionandoPaneisSecundarios(){
        this.frame.setSize(1400,400);
        this.panel.setSize(1400,400);

        this.frame.add(this.panel);
        this.panel.setLayout(null);

        this.panel.add(this.panelProducaoMotores);
        this.panel.add(this.panelEstoqueMotores);
        this.panel.add(this.panelProducaoCarroceria);
        this.panel.add(this.panelEstoqueCarroceria);
        this.panel.add(this.panelProducaoPneus);
        this.panel.add(this.panelEstoquePneus);
        this.panel.add(this.panelProducaoBancos);
        this.panel.add(this.panelEstoqueBancos);
        this.panel.add(this.panelProducaoEletrica);
        this.panel.add(this.panelEstoqueEletrica);
        this.panel.add(this.panelCarros);
        this.panel.add(this.panelCaminhoes);
        this.panel.add(this.totalCarrosPrduzidos);
    }

    private void adicionandoLaebelsPaineisSecundarios(){
        this.panelProducaoMotores.setSize(400,50);
        this.panelProducaoMotores.setBackground(Color.CYAN);
        this.panelProducaoMotores.setLayout(null);
        this.panelProducaoMotores.add(this.labelProducaoMotores);

        this.panelEstoqueMotores.setSize(400,50);
        this.panelEstoqueMotores.setBackground(Color.CYAN);
        this.panelEstoqueMotores.setLayout(null);
        this.panelEstoqueMotores.add(this.labelEstoqueMotores);

        this.panelProducaoCarroceria.setSize(400,50);
        this.panelProducaoCarroceria.setBackground(Color.CYAN);
        this.panelProducaoCarroceria.setLayout(null);
        this.panelProducaoCarroceria.add(this.labelProducaoCarroceria);

        this.panelEstoqueCarroceria.setSize(400,50);
        this.panelEstoqueCarroceria.setBackground(Color.CYAN);
        this.panelEstoqueCarroceria.setLayout(null);
        this.panelEstoqueCarroceria.add(this.labelEstoqueCarroceria);

        this.panelProducaoPneus.setSize(400,50);
        this.panelProducaoPneus.setBackground(Color.CYAN);
        this.panelProducaoPneus.setLayout(null);
        this.panelProducaoPneus.add(this.labelProducaoPneus);

        this.panelEstoquePneus.setSize(400,50);
        this.panelEstoquePneus.setBackground(Color.CYAN);
        this.panelEstoquePneus.setLayout(null);
        this.panelEstoquePneus.add(this.labelEstoquePneus);

        this.panelProducaoBancos.setSize(400,50);
        this.panelProducaoBancos.setBackground(Color.CYAN);
        this.panelProducaoBancos.setLayout(null);
        this.panelProducaoBancos.add(this.labelProducaoBancos);

        this.panelEstoqueBancos.setSize(400,50);
        this.panelEstoqueBancos.setBackground(Color.CYAN);
        this.panelEstoqueBancos.setLayout(null);
        this.panelEstoqueBancos.add(this.labelEstoqueBancos);

        this.panelProducaoEletrica.setSize(400,50);
        this.panelProducaoEletrica.setBackground(Color.CYAN);
        this.panelProducaoEletrica.setLayout(null);
        this.panelProducaoEletrica.add(this.labelProducaoEletrica);

        this.panelEstoqueEletrica.setSize(400,50);
        this.panelEstoqueEletrica.setBackground(Color.CYAN);
        this.panelEstoqueEletrica.setLayout(null);
        this.panelEstoqueEletrica.add(this.labelEstoqueEletrica);

        this.panelCarros.setSize(400,100);
        this.panelCarros.setBackground(Color.CYAN);
        this.panelCarros.setLayout(null);
        this.panelCarros.add(this.labelCarros);

        this.panelCaminhoes.setSize(400,100);
        this.panelCaminhoes.setBackground(Color.CYAN);
        this.panelCaminhoes.setLayout(null);
        this.panelCaminhoes.add(this.labelCaminhoes);
    }

    private void posicionandoComponentes(){
        this.panelProducaoMotores.setBounds(20, 20, 400,50);
        this.panelEstoqueMotores.setBounds(440,20,400,50);
        this.panelProducaoCarroceria.setBounds(20,80,400,50);
        this.panelEstoqueCarroceria.setBounds(440,80,400,50);
        this.panelProducaoPneus.setBounds(20,140,400,50);
        this.panelEstoquePneus.setBounds(440,140,400,50);
        this.panelProducaoBancos.setBounds(20,200,400,50);
        this.panelEstoqueBancos.setBounds(440,200,400,50);
        this.panelProducaoEletrica.setBounds(20,260,400,50);
        this.panelEstoqueEletrica.setBounds(440,260,400,50);
        this.panelCarros.setBounds(860,20,400,100);
        this.panelCaminhoes.setBounds(860,140,400,100);
        this.totalCarrosPrduzidos.setBounds(860, 240, 400, 100);

        this.labelProducaoMotores.setBounds(20, 10,360,30);
        this.labelEstoqueMotores.setBounds(20,10,360,30);
        this.labelProducaoCarroceria.setBounds(20,10,360,30);
        this.labelEstoqueCarroceria.setBounds(20,10,360,30);
        this.labelProducaoPneus.setBounds(20,10,360,30);
        this.labelEstoquePneus.setBounds(20,10,360,30);
        this.labelProducaoBancos.setBounds(20,10,360,30);
        this.labelEstoqueBancos.setBounds(20,10,360,30);
        this.labelProducaoEletrica.setBounds(20,10,360,30);
        this.labelEstoqueEletrica.setBounds(20,10,360,30);
        this.labelCarros.setBounds(20,10,360,30);
        this.labelCaminhoes.setBounds(20,10,360,30);
    }
    public JPanel getPanelProducaoMotores() {
        return panelProducaoMotores;
    }

    public JLabel getLabelProducaoMotores() {
        return labelProducaoMotores;
    }

    public JPanel getPanelEstoqueMotores() {
        return panelEstoqueMotores;
    }

    public JLabel getLabelEstoqueMotores() {
        return labelEstoqueMotores;
    }

    public JPanel getPanelProducaoCarroceria() {
        return panelProducaoCarroceria;
    }

    public JLabel getLabelProducaoCarroceria() {
        return labelProducaoCarroceria;
    }

    public JPanel getPanelEstoqueCarroceria() {
        return panelEstoqueCarroceria;
    }

    public JLabel getLabelEstoqueCarroceria() {
        return labelEstoqueCarroceria;
    }

    public JPanel getPanelProducaoPneus() {
        return panelProducaoPneus;
    }

    public JLabel getTotalCarrosPrduzidos() {
        return totalCarrosPrduzidos;
    }

    public JLabel getLabelProducaoPneus() {
        return labelProducaoPneus;
    }

    public JPanel getPanelEstoquePneus() {
        return panelEstoquePneus;
    }

    public JLabel getLabelEstoquePneus() {
        return labelEstoquePneus;
    }

    public JPanel getPanelProducaoBancos() {
        return panelProducaoBancos;
    }

    public JLabel getLabelProducaoBancos() {
        return labelProducaoBancos;
    }

    public JPanel getPanelEstoqueBancos() {
        return panelEstoqueBancos;
    }

    public JLabel getLabelEstoqueBancos() {
        return labelEstoqueBancos;
    }

    public JPanel getPanelProducaoEletrica() {
        return panelProducaoEletrica;
    }

    public JLabel getLabelProducaoEletrica() {
        return labelProducaoEletrica;
    }

    public JPanel getPanelEstoqueEletrica() {
        return panelEstoqueEletrica;
    }

    public JLabel getLabelEstoqueEletrica() {
        return labelEstoqueEletrica;
    }

    public JLabel getLabelCarros() {
        return labelCarros;
    }

    public JLabel getLabelCaminhoes() {
        return labelCaminhoes;
    }

    public void setTotalCarrosPrduzidos(JLabel totalCarrosPrduzidos) {
        this.totalCarrosPrduzidos = totalCarrosPrduzidos;
    }
}