    package metodosbusca;

/**
 *
 * @author Gustavo Luis Silva dos Santos
 */
public class MetodosBusca {

    public static void main(String[] args) {
        Busca busca;
        
        busca = new Busca("Arad", "Bucharest");
        chamaBuscas(busca);

        busca = new Busca("Bucharest", "Arad");
        chamaBuscas(busca);        
        
        busca = new Busca("Fagaras", "Bucharest");
        chamaBuscas(busca);
        
        busca = new Busca("Fagaras", "XXX");
        chamaBuscas(busca);
        
        busca = new Busca("XXX", "Fagaras");
        chamaBuscas(busca);

        busca = new Busca("Lugoj", "Neamt");
        chamaBuscas(busca);

        busca = new Busca("Neamt", "Lugoj");
        chamaBuscas(busca);
        
        busca = new Busca("Lugoj", "Vaslui");
        chamaBuscas(busca);
        
        busca = new Busca("Bucharest", "Zerind");
        chamaBuscas(busca);        
    }
    
    private static void chamaBuscas(Busca busca){
        busca.dijkstra();
        busca.aEstrela();
        busca.emLargura();             
    }
    
}
