package metodosbusca;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gustavo Luis Silva dos Santos
 */
public class MapaRomenia {

    /*
     Oradea = 0
     Zerind = 1
     Arad = 2
     Timisoara = 3
     Lugoj = 4
     Mehadla = 5
     Dobreta = 6
     Craiova = 7
     Rimnicu Vilcea = 8
     Sibiu = 9
     Fagaras = 10
     Pitesti = 11
     Giurgiu = 12
     Bucharest = 13
     Urziceni = 14
     Hirsova = 15
     Eforie = 16
     Vaslui = 17
     Iasi = 18
     Neamt = 19    
     */
    int distancias[][] = new int[20][20];
    double latitude[] = new double[20];
    double longitude[] = new double[20];

    public MapaRomenia() {
        // Oradea
        distancias[0][1] = 71;
        distancias[0][9] = 151;
        latitude[0] = 47.06667;
        longitude[0] = 21.93333;
        // Zerind
        distancias[1][0] = 71;
        distancias[1][2] = 75;
        latitude[1] = 46.6166642;
        longitude[1] = 21.5166646;
        // Arad
        distancias[2][1] = 75;
        distancias[2][9] = 140;
        distancias[2][3] = 118;
        latitude[2] = 46.18333;
        longitude[2] = 21.31667;
        // Timisoara
        distancias[3][2] = 118;
        distancias[3][4] = 111;
        latitude[3] = 45.75372;
        longitude[3] = 21.22571;
        // Lugoj
        distancias[4][3] = 111;
        distancias[4][5] = 70;
        latitude[4] = 45.68861;
        longitude[4] = 21.90306;
        // Mehadia
        distancias[5][4] = 70;
        distancias[5][6] = 75;
        latitude[5] = 44.90083;
        longitude[5] = 22.36694;
        // Dobreta
        distancias[6][5] = 75;
        distancias[6][7] = 120;
        latitude[6] = 44.63194;
        longitude[6] = 22.65611;
        // Craiova
        distancias[7][6] = 120;
        distancias[7][8] = 146;
        distancias[7][11] = 138;
        latitude[7] = 44.31667;
        longitude[7] = 23.8;
        // Rimnicu Vilcea
        distancias[8][7] = 146;
        distancias[8][9] = 80;
        distancias[8][11] = 97;
        latitude[8] = 45.1;
        longitude[8] = 24.36667;
        // Sibiu
        distancias[9][0] = 151;
        distancias[9][2] = 140;
        distancias[9][8] = 80;
        distancias[9][10] = 99;
        latitude[9] = 45.8;
        longitude[9] = 24.15;
        // Fagaras
        distancias[10][9] = 99;
        distancias[10][13] = 211;
        latitude[10] = 45.85;
        longitude[10] = 24.96667;
        // Pitesti
        distancias[11][8] = 97;
        distancias[11][7] = 138;
        distancias[11][13] = 101;
        latitude[11] = 44.85;
        longitude[11] = 24.86667;
        // Giurgiu
        distancias[12][13] = 90;
        latitude[12] = 43.88333;
        longitude[12] = 25.96667;
        // Bucharest
        distancias[13][12] = 90;
        distancias[13][10] = 211;
        distancias[13][11] = 101;
        distancias[13][14] = 85;
        latitude[13] = 44.439663;
        longitude[13] = 26.096306;
        // Urziceni
        distancias[14][13] = 85;
        distancias[14][17] = 145;
        distancias[14][15] = 98;
        latitude[14] = 44.71667;
        longitude[14] = 26.63333;
        // Hirsova
        distancias[15][14] = 98;
        distancias[15][16] = 86;
        latitude[15] = 44.68574;
        longitude[15] = 27.94819;
        // Eforie
        distancias[16][15] = 86;
        latitude[16] = 44.02294;
        longitude[16] = 28.64943;
        // Vaslui
        distancias[17][14] = 142;
        distancias[17][18] = 92;
        latitude[17] = 46.63333;
        longitude[17] = 27.73333;
        // Iasi
        distancias[18][17] = 91;
        distancias[18][19] = 87;
        latitude[18] = 47.16667;
        longitude[18] = 27.6;
        // Neamt
        distancias[19][18] = 87;
        latitude[19] = 46.91667;
        longitude[19] = 26.33333;
    }

    public Map<Integer, Integer> getVizinhos(int cidade) {
        Map<Integer, Integer> vizinhos = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            if (distancias[cidade][i] != 0) {
                vizinhos.put(i, distancias[cidade][i]);
            }
        }
        return vizinhos;
    }

    public double getDistanciaLinhaReta(int cidadeA, int cidadeB) {
        double latitudeIni = latitude[cidadeA];
        double latitudeFin = latitude[cidadeB];
        double longitudeIni = longitude[cidadeA];
        double longitudeFin = longitude[cidadeB];

        double earthRadius = 6371; //kilometers
        double dlon = Math.toRadians(longitudeFin - longitudeIni);
        double dlat = Math.toRadians(latitudeFin - latitudeIni);
        double sindLat = Math.sin(dlat / 2);
        double sindLng = Math.sin(dlon / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(latitudeIni))
                * Math.cos(Math.toRadians(latitudeFin));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = earthRadius * c;
        return distancia;
    }

    public int getIdCidade(String cidade) {
        switch (cidade) {
            case "Oradea":
                return 0;
            case "Zerind":
                return 1;
            case "Arad":
                return 2;
            case "Timisoara":
                return 3;
            case "Lugoj":
                return 4;
            case "Mehadla":
                return 5;
            case "Dobreta":
                return 6;
            case "Craiova":
                return 7;
            case "Rimnicu Vilcea":
                return 8;
            case "Sibiu":
                return 9;
            case "Fagaras":
                return 10;
            case "Pitesti":
                return 11;
            case "Giurgiu":
                return 12;
            case "Bucharest":
                return 13;
            case "Urziceni":
                return 14;
            case "Hirsova":
                return 15;
            case "Eforie":
                return 16;
            case "Vaslui":
                return 17;
            case "Iasi":
                return 18;
            case "Neamt":
                return 19;
            default:
                return 99;
        }
    }

    public String getNomeCidade(int cidade) {
        switch (cidade) {
            case 0:
                return "Oradea";
            case 1:
                return "Zerind";
            case 2:
                return "Arad";
            case 3:
                return "Timisoara";
            case 4:
                return "Lugoj";
            case 5:
                return "Mehadla";
            case 6:
                return "Dobreta";
            case 7:
                return "Craiova";
            case 8:
                return "Rimnicu Vilcea";
            case 9:
                return "Sibiu";
            case 10:
                return "Fagaras";
            case 11:
                return "Pitesti";
            case 12:
                return "Giurgiu";
            case 13:
                return "Bucharest";
            case 14:
                return "Urziceni";
            case 15:
                return "Hirsova";
            case 16:
                return "Eforie";
            case 17:
                return "Vaslui";
            case 18:
                return "Iasi";
            case 19:
                return "Neamt";
            default:
                return "Cidade inexistente";
        }
    }
}
