package audi.main;

import audi.linha_producao.*;
import audi.view.TelaProducao;

import javax.swing.*;
import java.awt.*;

public class Producao {
    private int MAXIMO_MOTORES;
    private int estoqueMotores;

    private int MAXIMO_CARROCERIAS;
    private int estoqueCarrocerias;

    private int MAXIMO_PNEUS;
    private int estoquePneus;

    private int MAXIMO_BANCOS;
    private int estoqueBancos;

    private int MAXIMO_ELETRONICA;
    private int estoqueEletronica;

    private int MAXIMO_CARROS;
    private int estoqueCarros;

    private int caminhoes;

    private TelaProducao telaProducao;

    private Runnable runnableMotores;
    private Runnable runnableCarroceria;
    private Runnable runnablePneus;
    private Runnable runnableBancos;
    private Runnable runnableEletronica;
    private Runnable runnableCarro;

    private Thread motores;
    private Thread carroceria;
    private Thread pneus;
    private Thread bancos;
    private Thread eletronica;
    private Thread carro;

    public Producao(){
        this.MAXIMO_MOTORES = 10;
        this.estoqueMotores = 0;
        this.MAXIMO_CARROCERIAS = 20;
        this.estoqueCarrocerias = 0;
        this.MAXIMO_PNEUS = 100;
        this.estoquePneus = 0;
        this.MAXIMO_BANCOS = 25;
        this.estoqueBancos = 0;
        this.MAXIMO_ELETRONICA = 8;
        this.estoqueEletronica = 0;
        this.MAXIMO_CARROS = 10;
        this.estoqueCarros = 0;
        this.caminhoes = 0;

        this.telaProducao = new TelaProducao();

        this.iniciarRunnables();
        this.iniciarThreads();
    }

    private void iniciarRunnables(){
        this.runnableCarro = new Runnable() {
            @Override
            public synchronized void run() {
                int totalCarros = 0;
                long tempoInicial = System.currentTimeMillis();
                long tempo = 0;
                System.out.println("Tempo inicial na producao: " + tempoInicial);
                while (true) {
                    while (estoqueCarros < MAXIMO_CARROS) {
                        if (estoqueMotores >= 1 && estoqueCarrocerias >= 1 && estoquePneus >= 4 &&
                                estoqueBancos >= 5 && estoqueEletronica >= 1) {
                            estoqueCarros++;
                            if(estoqueCarros == 1){
                                tempo = System.currentTimeMillis() - tempoInicial;
                                System.out.println("Tempo total: " + tempo);
                            }
                            estoqueMotores -= 1;
                            estoqueCarrocerias -= 1;
                            estoquePneus -= 4;
                            estoqueBancos -= 5;
                            estoqueEletronica -= 1;

                            System.out.println("CARRO PRODUZIDO!");
                            System.out.println("------------------------------------------------------------------------------------");


                            telaProducao.getLabelEstoqueMotores().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueMotores(), estoqueMotores));
                            telaProducao.getLabelEstoqueCarroceria().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueCarroceria(), estoqueCarrocerias));
                            telaProducao.getLabelEstoquePneus().setText(atualizaLabelEstoque(telaProducao.getLabelEstoquePneus(), estoquePneus));
                            telaProducao.getLabelEstoqueBancos().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueBancos(), estoqueBancos));
                            telaProducao.getLabelEstoqueEletrica().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueEletrica(), estoqueEletronica));
                            telaProducao.getLabelCarros().setText(atualizaLabelEstoque(telaProducao.getLabelCarros(), estoqueCarros));
                            totalCarros++;
                            telaProducao.getTotalCarrosPrduzidos().setText(atualizaLabelEstoque(telaProducao.getTotalCarrosPrduzidos(), totalCarros));
                        }
                        //imprimeTodosEstoques();
                    }
                    caminhoes++;
                    estoqueCarros -= MAXIMO_CARROS;
                    telaProducao.getLabelCarros().setText(atualizaLabelEstoque(telaProducao.getLabelCarros(), estoqueCarros));
                    telaProducao.getLabelCaminhoes().setText(atualizaLabelEstoque(telaProducao.getLabelCaminhoes(), caminhoes));
                    imprimeTodosEstoques();
                }
            }
        };
        this.runnableMotores = new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    LPMotores motor = new LPMotores(telaProducao);

                    while (estoqueMotores < MAXIMO_MOTORES) {
                        telaProducao.getPanelEstoqueMotores().setBackground(Color.CYAN);
                        estoqueMotores += motor.produzir();
                        telaProducao.getLabelEstoqueMotores().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueMotores(),
                                estoqueMotores));
                    }
                    motor.setStatus(LPMotores.IMPOSSIVEL_PRODUZIR);
                    motor.statusProducao();
                    telaProducao.getPanelEstoqueMotores().setBackground(Color.RED);
                }
            }
        };

        this.runnableCarroceria = new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    LPCarroceria carroceria = new LPCarroceria(telaProducao);

                    while (estoqueCarrocerias < MAXIMO_CARROCERIAS) {
                        telaProducao.getPanelEstoqueCarroceria().setBackground(Color.CYAN);
                        estoqueCarrocerias += carroceria.produzir();
                        telaProducao.getLabelEstoqueCarroceria().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueCarroceria(),
                                estoqueCarrocerias));
                    }
                    carroceria.setStatus(LPCarroceria.IMPOSSIVEL_PRODUZIR);
                    carroceria.statusProducao();
                    telaProducao.getPanelEstoqueCarroceria().setBackground(Color.RED);
                }
            }
        };

        this.runnablePneus = new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    LPPneus pneus = new LPPneus(telaProducao);

                    while (estoquePneus < MAXIMO_PNEUS) {
                        telaProducao.getPanelEstoquePneus().setBackground(Color.CYAN);
                        estoquePneus += pneus.produzir();
                        telaProducao.getLabelEstoquePneus().setText(atualizaLabelEstoque(telaProducao.getLabelEstoquePneus(),
                                estoquePneus));
                    }
                    pneus.setStatus(LPPneus.IMPOSSIVEL_PRODUZIR);
                    pneus.statusProducao();
                    telaProducao.getPanelEstoquePneus().setBackground(Color.RED);
                }
            }
        };

        this.runnableBancos = new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    LPBancos bancos = new LPBancos(telaProducao);

                    while (estoqueBancos < MAXIMO_BANCOS) {
                        telaProducao.getPanelEstoqueBancos().setBackground(Color.CYAN);
                        estoqueBancos += bancos.produzir();
                        telaProducao.getLabelEstoqueBancos().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueBancos(),
                                estoqueBancos));
                    }
                    bancos.setStatus(LPBancos.IMPOSSIVEL_PRODUZIR);
                    bancos.statusProducao();
                    telaProducao.getPanelEstoqueBancos().setBackground(Color.RED);
                }
            }
        };

        this.runnableEletronica = new Runnable() {
            @Override
            public synchronized void run() {
                while (true) {
                    LPEletronica eletronica = new LPEletronica(telaProducao);

                    while (estoqueEletronica < MAXIMO_ELETRONICA) {
                        telaProducao.getPanelEstoqueEletrica().setBackground(Color.CYAN);
                        estoqueEletronica += eletronica.produzir();
                        telaProducao.getLabelEstoqueEletrica().setText(atualizaLabelEstoque(telaProducao.getLabelEstoqueEletrica(),
                                estoqueEletronica));
                    }
                    eletronica.setStatus(LPEletronica.IMPOSSIVEL_PRODUZIR);
                    eletronica.statusProducao();
                    telaProducao.getPanelEstoqueEletrica().setBackground(Color.RED);
                }
            }
        };

    }
    private void iniciarThreads(){
        this.carro = new Thread(this.runnableCarro);
        this.motores = new Thread(this.runnableMotores);
        this.carroceria = new Thread(this.runnableCarroceria);
        this.pneus = new Thread(this.runnablePneus);
        this.bancos = new Thread(this.runnableBancos);
        this.eletronica = new Thread(this.runnableEletronica);
    }

    public void iniciaProducao(){
        this.telaProducao.initComponents();

        this.carro.start();
        this.motores.start();
        this.carroceria.start();
        this.pneus.start();
        this.bancos.start();
        this.eletronica.start();
    }
    private void imprimeTodosEstoques(){
//        System.out.println("ESTOQUE DE MOTORES: " + this.estoqueMotores);
//        System.out.println("ESTOQUE DE CARROCERIAS: " + this.estoqueCarrocerias);
//        System.out.println("ESTOQUE DE PNEUS: " + this.estoquePneus);
//        System.out.println("ESTOQUE DE BANCOS: " + this.estoqueBancos);
//        System.out.println("ESTOQUE DE ELETRONICA: " + this.estoqueEletronica);
//        System.out.println("ESTOQUE DE CARROS: " + this.estoqueCarros);
//        System.out.println("NUMERO DE CAMINHOES QUE SAIRAM: " + this.caminhoes);
//        System.out.println("==================================================================");
    }

    private String atualizaLabelEstoque(JLabel label, int estoque){
        String text = label.getText();
        String numero;

        if(estoque < 10)
            numero = "00" + estoque;
        else if(estoque >= 100)
            numero = String.valueOf(estoque);
        else
            numero = "0" + estoque;

        if(text.endsWith(":")){
            text = text + "   " + numero;
            return text;
        }
        else{
            text = text.substring(0, text.length()-6) + "   " + numero;
            return text;
        }
    }



}