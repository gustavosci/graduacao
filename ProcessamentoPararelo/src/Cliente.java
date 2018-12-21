public class Cliente extends Thread {

    private Barbearia barbearia;

    public Cliente(final Barbearia barbearia, final String nome) {
        super(nome);
        this.barbearia = barbearia;
    }

    public void receberCorteCabelo() {

        synchronized (barbearia) {

            if (barbearia.isCadeirasClientesLotada()) {
                System.out
                    .println("|Cliente|- " + this.getName() + "\t - Todas cadeiras lotadas. Está saindo da barbearia.");
            } else {

                final int idClienteFicticio = (int) (Math.random() * 10000);
                this.barbearia.sentarCadeiraCliente(idClienteFicticio);

                System.out.println(
                    "|Cliente|- " + this.getName() + "\t - Sentou na cadeira do cliente - ID: " + idClienteFicticio);

                barbearia.notifyAll();
            }
        }
    }

    public void run() {

        while (true) {

            this.receberCorteCabelo();

            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
