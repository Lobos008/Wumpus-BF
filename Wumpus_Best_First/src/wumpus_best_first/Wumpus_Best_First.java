package wumpus_best_first;

public class Wumpus_Best_First {

    public static Board map;
    public static int[][] movimientos = {{-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}};

    public static void bestFirst() {
        int currentPosX = map.getCurrent_x();
        int currentPosY = map.getCurrent_y();
        map.marcarCasilla(currentPosX, currentPosY);
        boolean sol = true;
        while (currentPosX != map.getFinal_x() || currentPosY != map.getFinal_y()) {
            int[] coordenadas = calculateMovement(currentPosX, currentPosY);
            if (coordenadas[0] == -1 && coordenadas[1] == -1) {
                sol = false;
                break;
            } else {
                System.out.println("---------------------tablero actual------------------------");
                map.printBoard();
                System.out.println("-----------------------------------------------------------");
                currentPosX = coordenadas[0];
                currentPosY = coordenadas[1];
                map.marcarCasilla(currentPosX, currentPosY);
                System.out.println("Movimiento: (" + (currentPosX + 1) + "," + (currentPosY + 1) + ")");
                map.getAgent().addMovement(currentPosX, currentPosY);
            }
        }

        if (sol) {
            System.out.println("Solución Completa");
        } else {
            System.out.println("Sin Solcución");
        }
    }

    public static int[] calculateMovement(int x, int y) {
        int posXsucess = -1;
        int posYsucess = -1;
        int menor = 9999;

        for (int i = 0; i < 4; i++) {
            int fila = x + movimientos[i][0];
            int columna = y + movimientos[i][1];
            if (map.isLimit(fila, columna)) {
                String valor = map.getValue(fila, columna);
                if (!valor.equalsIgnoreCase("O")) {
                    if (!valor.equalsIgnoreCase("V")) {
                        if (map.isAceptable(fila, columna)) {
                            int costo = getValueByTipo(valor);
                            if (costo < menor) {
                                menor = costo;
                                posXsucess = fila;
                                posYsucess = columna;
                            }
                        }
                    }
                } else {
                    menor = 0;
                    posXsucess = fila;
                    posYsucess = columna;
                    break;
                }
            }
        }

        if (menor != 9999) {
            map.setAgent(posXsucess, posYsucess);
        }

        int[] coordenadas = {posXsucess, posYsucess};
        return coordenadas;
    }

    public static int getValueByTipo(String tipo) {
        int value = 0;

        switch (tipo) {
            case "L":
                value = 1;
                break;
            case "B":
                value = 3;
                break;
            case "M":
                value = 2;
                break;
        }

        return value;
    }

    public static void main(String[] args) {
        map = new Board(5, 5);
        map.symbology();
        map.initBorad();
        bestFirst();
        map.printBoard();
        System.out.println(map.getAgent().getSolution().toString());
    }
}
