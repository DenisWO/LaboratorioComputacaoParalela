public class Main {
    private static boolean contagem;
    public static void main(String[] args) {
        Tela tela = new Tela();
        int i =0;
        contagem = false;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!contagem){
            contagem = tela.isFlag();
            System.out.println(tela.isFlag());
        }

        while(contagem){
            Thread thread = new Thread();
            try {
                thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tela.atualizaTela();
            contagem = tela.isFlag();
            System.out.println(tela.isFlag());
            tela.setLabel(String.valueOf(i));
            tela.corAleatoria();
            i++;
        }
    }
}
