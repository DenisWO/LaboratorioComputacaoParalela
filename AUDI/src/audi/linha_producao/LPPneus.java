package audi.linha_producao;

import audi.view.TelaProducao;

import java.awt.*;

public class LPPneus {
    private static final int TEMPO_PRODUCAO = 9000;
    private static final int PRODUZINDO = 1;
    private static final int AGUARDANDO = 2;
    public static final int IMPOSSIVEL_PRODUZIR = 3;

    private TelaProducao tela;
    private int status;

    public LPPneus(TelaProducao tela){
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
            this.tela.getPanelProducaoPneus().setBackground(Color.GREEN);
            this.tela.getLabelProducaoPneus().setText("PRODUZINDO PNEUS");
        }
        else if(this.getStatus() == AGUARDANDO){
            this.tela.getPanelProducaoPneus().setBackground(Color.YELLOW);
            this.tela.getLabelProducaoPneus().setText("AGUARDANDO PRODUÇÃO DE PNEUS");
        }
        else{
            this.tela.getPanelProducaoPneus().setBackground(Color.RED);
            this.tela.getLabelProducaoPneus().setText("IMPOSSÍVEL PRODUZIR PNEUS");
        }
    }
}