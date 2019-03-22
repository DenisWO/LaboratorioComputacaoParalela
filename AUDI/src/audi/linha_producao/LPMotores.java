package audi.linha_producao;

import audi.view.TelaProducao;

import java.awt.*;

public class LPMotores {
    private static final int TEMPO_PRODUCAO = 12000;
    private static final int PRODUZINDO = 1;
    private static final int AGUARDANDO = 2;
    public static final int IMPOSSIVEL_PRODUZIR = 3;

    private TelaProducao tela;
    private int status;

    public LPMotores(TelaProducao tela){
        this.tela = tela;
        this.setStatus(AGUARDANDO);
    }

    private int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int produzir(){
        this.statusProducao();
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
            this.tela.getPanelProducaoMotores().setBackground(Color.GREEN);
            this.tela.getLabelProducaoMotores().setText("PRODUZINDO MOTORES");
        }
        else if(this.getStatus() == AGUARDANDO){
            this.tela.getPanelProducaoMotores().setBackground(Color.YELLOW);
            this.tela.getLabelProducaoMotores().setText("AGUARDANDO PRODUÇÃO DE MOTORES");
        }
        else{
            this.tela.getPanelProducaoMotores().setBackground(Color.RED);
            this.tela.getLabelProducaoMotores().setText("IMPOSSÍVEL PRODUZIR MOTORES");
        }
    }




}