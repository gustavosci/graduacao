public class Barbeiro extends Thread {

    private Barbearia barbearia;

    public Barbeiro(final Barbearia barbearia, final String nome) {
        super(nome);
        this.barbearia = barbearia;
    }

    public void cortarCabelo() {

        synchronized (barbearia){

            if (barbearia.getQtdClientesSentados() > 0) {

                final int cliente = barbearia.chamarProximoCliente();
                System.out.println("|Barbeiro|- " + this.getName()+"\t - Chamou cliente " + cliente);
            } else {

                try {
                    System.out.println("|Barbeiro|- " + this.getName()+"\t - Esperando por novos clientes. Vou dormir :)");
                    barbearia.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){

        while (true) {

            this.cortarCabelo();

            try{
                Thread.sleep((int)(Math.random() * 1000));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
