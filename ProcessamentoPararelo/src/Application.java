public class Application {

    public static void main(String[] args) {

        final Barbearia barbearia = new Barbearia();

        final Cliente c1 = new Cliente(barbearia, "Gustavo");
        final Cliente c2 = new Cliente(barbearia, "Ana Claudia");
        final Cliente c3 = new Cliente(barbearia, "Dani");
        final Cliente c4 = new Cliente(barbearia, "Guilherme");
        final Barbeiro b1 = new Barbeiro(barbearia, "Carol");
        final Barbeiro b2 = new Barbeiro(barbearia, "Myleide");

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        b1.start();
        b2.start();
    }
}
