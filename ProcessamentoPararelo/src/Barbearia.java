public class Barbearia {

    final private int TOTAL_CADEIRAS_CLIENTES = 8;

    private int[] cadeirasClientes = new int[TOTAL_CADEIRAS_CLIENTES];

    public Barbearia() {
        initCadeirasClientes();
    }

    public boolean isCadeirasClientesLotada() {

        boolean lotado = true;

        for (int i = 0; i < TOTAL_CADEIRAS_CLIENTES; i++) {
            if (cadeirasClientes[i] == 0) {
                lotado = false;
                break;
            }
        }

        return lotado;
    }

    public void sentarCadeiraCliente(final int idCliente) {

        for (int i = 0; i < TOTAL_CADEIRAS_CLIENTES; i++) {
            if (cadeirasClientes[i] == 0) {
                cadeirasClientes[i] = idCliente;
                break;
            }
        }
    }

    public int getQtdClientesSentados() {

        int qtd = 0;

        for (int i = 0; i < TOTAL_CADEIRAS_CLIENTES; i++) {
            if (cadeirasClientes[i] > 0) {
                qtd++;
            }
        }

        return qtd;
    }

    public int chamarProximoCliente() {

        int idCliente = 0;

        for (int i = 0; i < TOTAL_CADEIRAS_CLIENTES; i++) {

            if (cadeirasClientes[i] > 0) {
                idCliente = cadeirasClientes[i];
                reordenaClientesNaFila(i);
                break;
            }
        }

        return idCliente;
    }

    private void initCadeirasClientes() {

        for (int i = 0; i < TOTAL_CADEIRAS_CLIENTES; i++) {
            cadeirasClientes[i] = 0;
        }
    }

    private void reordenaClientesNaFila(final int firstIndex) {

        for (int aux = firstIndex; aux < (TOTAL_CADEIRAS_CLIENTES - 1); aux++) {
            cadeirasClientes[aux] = cadeirasClientes[aux + 1];
        }

        cadeirasClientes[TOTAL_CADEIRAS_CLIENTES - 1] = 0;
    }
}
