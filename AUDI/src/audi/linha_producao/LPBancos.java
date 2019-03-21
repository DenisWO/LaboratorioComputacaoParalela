package audi.linha_producao;

import audi.view.TelaProducao;

import java.awt.*;

public class LPBancos {
    private static final int TEMPO_PRODUCAO = 1000;
    private static final int PRODUZINDO = 1;
    private static final int AGUARDANDO = 2;
    public static final int IMPOSSIVEL_PRODUZIR = 3;

    private TelaProducao tela;
    private int status;

    public LPBancos(TelaProducao tela){
        this.setStatus(AGUARDANDO);
        this.tela = tela;
    }

    private int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int produzir(){
        try {
            this.setStatus(PRODUZINDO);
            this.statusProducao();
            Thread.sleep(TEMPO_PRODUCAO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setStatus(AGUARDANDO);
        this.statusProducao();

        return 1;
    }
    public void statusProducao(){
        if(this.getStatus() == PRODUZINDO){
            //System.out.println("Status da Produção: PRODUZINDO BANCOS");
            tela.getPanelProducaoBancos().setBackground(Color.GREEN);
            tela.getLabelProducaoBancos().setText("PRODUZINDO BANCOS");
        }
        else if(this.getStatus() == AGUARDANDO){
            //System.out.println("Status da Produção: AGUARDANDO PRODUÇÃO DE BANCOS");
            tela.getPanelProducaoBancos().setBackground(Color.YELLOW);
            tela.getLabelProducaoBancos().setText("AGUARDANDO PRODUÇÃO DE BANCOS");
        }
        else{
            //System.out.println("Status da Produção: IMPOSSIVEL PRODUZIR BANCOS");
            tela.getPanelProducaoBancos().setBackground(Color.RED);
            tela.getLabelProducaoBancos().setText("IMPOSSÍVEL PRODUZIR BANCOS");
        }
    }

}