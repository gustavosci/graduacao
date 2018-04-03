package metodosbusca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author Gustavo Luis Silva dos Santos
 */
public class Busca {

    MapaRomenia mapa;
    String cidadePartida;
    String cidadeDestino;
    int idCidadePartida;
    int idCidadeDestino;
        
    
    public Busca(String cidadePartida, String cidadeDestino){
        this.mapa = new MapaRomenia();
        this.cidadePartida = cidadePartida;
        this.cidadeDestino = cidadeDestino;
        this.idCidadePartida = mapa.getIdCidade(cidadePartida);
        this.idCidadeDestino = mapa.getIdCidade(cidadeDestino);        
    }
    
    public void dijkstra(){        
        mensagemInicial("Dijkstra");
        if(!validaCidades()){
            return;
        }
      
        // Listas para controle da lógica Dijkstra        
        Map<Integer, Integer> distancias  = new HashMap<>(); // Lista das distancias visitadas      
        for(int i = 0; i < 20; i++){
            distancias.put(i, 999999);
        }        
        Map<Integer, Integer> prioridades = new HashMap<>(); // Lista de prioridades. OBS: Não pode ser uma lista comum, pois vou remover dado da mesma e não posso perder os índices das cidades        
        for(int i = 0; i < 20; i++){
            prioridades.put(i, i);
        }                
        Map<Integer, Integer> pais = new HashMap<>(); // Lista de cidades pais        
        for(int i = 0; i < 20; i++){
            pais.put(i, 99);
        }        
        Map<Integer, Integer> route  = new HashMap<>(); // Lista da rota utilizada       
        for(int i = 0; i < 20; i++){
            route.put(i, 999999);
        }        

        // Define a posição atual a partir da cidade de partida
        int atual = idCidadePartida;
        distancias.replace(atual, 0);        
        pais.replace(atual, null);        
        
        // Descobre a distância de todas cidades
        while(!prioridades.isEmpty()){                        
            // Define a cidade que terá seus vizinhos verificados
            LinkedHashMap<Integer, Integer> sortedDistancias = ordenaHashMap(distancias);   
            for (int cidade : sortedDistancias.keySet()) {  
                if(prioridades.get(cidade) != null){
                    atual = prioridades.get(cidade);
                    prioridades.remove(cidade);
                    break;                    
                }                                    
            }                                                           
            // Percorre os vizinhos da cidade atual
            Map<Integer, Integer> vizinhos =  mapa.getVizinhos(atual);
            for (int vizinho : vizinhos.keySet()) {                     
                int distanciaVizinho = vizinhos.get(vizinho);
                int distanciaAtual = distancias.get(atual) + distanciaVizinho;
                if(distancias.get(vizinho) > distanciaAtual){                     
                    // Atualiza distância do vizinho e seta seu nodo pai
                    distancias.replace(vizinho, distanciaAtual);
                    pais.put(vizinho, atual);                    
                    // Se o vizinho é a cidade de destino, recria rota
                    if(vizinho == mapa.getIdCidade(cidadeDestino)){
                        route.clear();
                        route.put(vizinho, distancias.get(vizinho));
                        int vizinhoAux = vizinho;                        
                        while (pais.get(vizinhoAux) != null) {
                            route.put(vizinhoAux, distancias.get(vizinhoAux));
                            vizinhoAux = pais.get(vizinhoAux);
                        }                        
                    }
                }
             }                            
        }
        // Reordena a lista de distâncias e imprime o resultado
        buildStringRouteDijkstra(route);                
    }

    private void buildStringRouteDijkstra(Map<Integer, Integer> routeList){
        String route = cidadePartida + " > ";
        LinkedHashMap<Integer, Integer> sortedRoute = ordenaHashMap(routeList);   
        for (int cidade : sortedRoute.keySet()) {  
            route += mapa.getNomeCidade(cidade) + " (" + 
                    sortedRoute.get(cidade) + ")" + 
                    getCaracterEnd(cidade);
        }
        System.out.println(route);
    }                
    
    public void emLargura(){        
        mensagemInicial("emLargura");
        if(!validaCidades()){
            return;
        }
        
        // Listas para controle da lógica em largura
        Map<Integer, Integer> routeMap = new HashMap<>(); // Rota (cidade, sequência da rota)
        routeMap.put(idCidadePartida, 0);        
        Map<Integer, String> control = new HashMap<>(); // branco - não visitado, cinza - estão na estrutura da fila, preto - todos vizinhos já foram enfileirados e marcados
        for(int i = 0; i < 20; i++){
            control.put(i, "branco");
        }                
        Map<Integer, Integer> pais = new HashMap<>(); // Cidades pais
        for(int i = 0; i < 20; i++){
            pais.put(i, null);
        }                        
        LinkedList<Integer> fila = new LinkedList<Integer>(); // Fila do processamento
        fila.add(idCidadePartida);                        
                
        // Percorre fila de cidades a conferir
    	while (!fila.isEmpty()) {
            // Define cidade a verificar e analisa seus vizinhos
            int atual = fila.remove();
            control.replace(atual, "preto");
            Map<Integer, Integer> vizinhos =  mapa.getVizinhos(atual);
            for (int vizinho : vizinhos.keySet()) {                     
                if(control.get(vizinho).equals("branco")){                    
                    control.replace(vizinho, "cinza");
                    pais.replace(vizinho, atual);
                    if (vizinho == idCidadeDestino) {
                        break;
                    }
                    fila.add(vizinho);                    
                }
            }
    	}
        
        /**
        *
        * Monta e imprime rota
        * Lógica: Busca todas as cidades pai, a partir do destino até a partida, montando a lista
                  da rota de trás para frente. Após isso, essa lista é reordenada para que possamos
                  extrair a rota na ordem correta                
        *
        */
        int cidadeRota = idCidadeDestino;
        int ordRoute = 99;
        while( pais.get(cidadeRota) != null){
            routeMap.put(cidadeRota, ordRoute);
            cidadeRota = pais.get(cidadeRota);
            ordRoute -= 1;
        }
        List<Integer> route = new ArrayList<>();
        LinkedHashMap<Integer, Integer> sortedRoute = ordenaHashMap(routeMap);   
        for ( int i : sortedRoute.keySet()) {  
            route.add(i);
        }                
        buildStringRouteList(route);        
    }

    public void aEstrela(){
        mensagemInicial("aEstrela");
        if(!validaCidades()){
            return;
        }
        
        int atual = idCidadePartida; // Define a posição atual a partir da cidade de partida        
        double distanciaPartidaAtual = 0; // Distância da partida para testes do destino atual
        double distanciaPartidaDestino = 0; // Distância da partida até destino final, acumulada a cada passo
        
        // Inicia definição da rota
        List<Integer> route = new ArrayList<>(); 
        route.add(idCidadePartida);
        
        // Inicia busca da rota
        boolean finalizou = false;        
        while(!finalizou){            
            // Percorre os vizinhos da cidade atual
            Map<Integer, Integer> vizinhos =  mapa.getVizinhos(atual);            
            boolean primeiroV = true;
            for (int vizinho : vizinhos.keySet()) {                     
                if(mapa.getNomeCidade(vizinho).equals(cidadeDestino)){
                    atual = vizinho;
                    finalizou = true;
                    break;
                } else {
                    // Se a cidade ainda não foi visitada
                    if( !cidadeJaFoiVisitadaEstrela(route, vizinho) ){
                        double distanciaVizinho = vizinhos.get(vizinho);
                        double distanciaVizinhoTotal =  distanciaPartidaDestino + 
                                                        distanciaVizinho + 
                                                        mapa.getDistanciaLinhaReta(vizinho, idCidadeDestino);
                        if(primeiroV ||(distanciaPartidaAtual > distanciaVizinhoTotal)){
                            distanciaPartidaAtual = distanciaVizinhoTotal;
                            atual = vizinho;
                            primeiroV = false;
                        }                                            
                    }
                }                                
            }                                
            route.add(atual);            
        }        
        // Imprime rota encontrada
        buildStringRouteList(route);
    }

    private boolean cidadeJaFoiVisitadaEstrela(List<Integer> route, int cidade){
        for (int cidadeVisitada : route) {
            if (cidadeVisitada == cidade) {
                return true;
            }
        }
        return false;
    }    
    
    private void buildStringRouteList(List<Integer> route){
        String strRoute = "";
        for (int cidade : route) {
            strRoute += mapa.getNomeCidade(cidade) + getCaracterEnd(cidade); 
        }
        System.out.println(strRoute);
    }

    private LinkedHashMap<Integer, Integer> ordenaHashMap(Map<Integer, Integer> map){        
        return  map.entrySet().stream().
                sorted(Entry.comparingByValue()).
                collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));            

    }
   
    private void mensagemInicial(String metodo){
        System.out.println(metodo + ":\n" + cidadePartida + " até " + cidadeDestino);    
    }

    private boolean validaCidades(){
        if(idCidadePartida == 99){
            System.out.println("Cidade de partida inválida :( \n");
            return false;
        }        
        if(idCidadeDestino == 99){
            System.out.println("Cidade de destino inválida :( \n");
            return false;
        }
        return true;
    }
    
    private String getCaracterEnd(int cidade){
        if(cidade == idCidadeDestino){
            return "\n";
        } else {
            return " > ";
        }                
    }    
}
