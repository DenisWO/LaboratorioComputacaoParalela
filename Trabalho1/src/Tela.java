import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import static java.lang.Boolean.TRUE;

public class Tela {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JButton iniciaContagem;
    private JButton pararContagem;
    private boolean flag;

    public Tela(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.button = new JButton("Mudar cor");
        this.label = new JLabel("0000");
        this.iniciaContagem = new JButton("Iniciar contagem");
        this.pararContagem = new JButton("Parar contagem");

        try {
            this.iniciaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Funçao que inicia a tela e adiciona os componentes
    private void iniciaTela() throws Exception{
        this.adicionaComponentes();
        this.posicionaComponentes();
        this.criaAcaoComponentes();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(TRUE);
        this.frame.setResizable(false);

//        Thread thread = new Thread(runnable);
//        for(int i=0; i<100; i++){
//            thread.run();
//            thread.sleep(100);
//        }
    }
    public void criaAcaoComponentes(){
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(alteraCor);
                thread.run();
            }
        });
        this.iniciaContagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFlag(true);
                iniciaContagem.setEnabled(false);
            }
        });
        this.pararContagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setFlag(false);
                pararContagem.setEnabled(false);
            }
        });
    }
    public void atualizaTela(){
        this.setFlag(this.isFlag());
    }
    public void posicionaComponentes(){
    	this.label.setBounds(290,10,80,25);
        this.button.setBounds(230,40,180,25);
        this.iniciaContagem.setBounds(230,70,180,25);
        this.pararContagem.setBounds(230,100,180,25);
    }
    public void adicionaComponentes(){
        this.frame.setSize(600,200);
        this.panel.setSize(600,200);
        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.button);
        this.panel.add(this.label);
        this.panel.add(this.iniciaContagem);
        this.panel.add(this.pararContagem);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            corAleatoria();
        }
    };
    private Runnable stopContagem = new Runnable() {
        @Override
        public void run() {
            setFlag(false);
        }
    };
    private Runnable alteraCor = new Runnable() {
        @Override
        public void run() {
            Random r = new Random();
            alteraTela(r.nextInt(5));
        }
    };

    public void corAleatoria(){
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(5);

        if(num == 0){
            this.panel.setBackground(Color.CYAN);
        }
        else if (num == 1){
            this.panel.setBackground(Color.PINK);
        }
        else if (num == 2){
            this.panel.setBackground(Color.YELLOW);
        }
        else if(num == 3){
            this.panel.setBackground(Color.RED);
        }
        else if(num == 4){
            this.panel.setBackground(Color.GREEN);
        }
    }
    public void alteraTela(int num){
        if(num == 0){
            this.panel.setBackground(Color.CYAN);
        }
        else if (num == 1){
            this.panel.setBackground(Color.PINK);
        }
        else if (num == 2){
            this.panel.setBackground(Color.YELLOW);
        }
        else if(num == 3){
            this.panel.setBackground(Color.RED);
        }
        else if(num == 4){
            this.panel.setBackground(Color.GREEN);
        }
    }
    public void setLabel(String text){
    	while (text.length() < 4) {
    		text = "0" + text;
    	}
        this.label.setText(text);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
