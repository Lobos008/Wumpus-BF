package wumpus_best_first;

public class Board {

    private int N, M;
    private Position[][] board;
    private Agent agent;
    private int initial_x, initial_y, current_x, current_y, final_x, final_y, wumpus_x, wumpus_y;

    public Board(int N, int M) {
        this.N = N;
        this.M = M;
        this.board = new Position[N][M];
        this.initial_x = generateValue(0, N - 1);
        this.initial_y = generateValue(0, M - 1);
        this.final_x = generateValue(0, N - 1);
        this.final_y = generateValue(0, M - 1);
        this.wumpus_x = generateValue(0, N - 1);
        this.wumpus_y = generateValue(0, M - 1);
        this.agent = new Agent(initial_x, initial_y);
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getValue(int x, int y) {
        return board[x][y].getTipo();
    }

    public int getM() {
        return M;
    }

    public void setM(int M) {
        this.M = M;
    }

    public Position[][] getBoard() {
        return board;
    }

    public void setBoard(Position[][] board) {
        this.board = board;
    }
    
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getInitial_x() {
        return initial_x;
    }

    public void setInitial_x(int initial_x) {
        this.initial_x = initial_x;
    }

    public int getInitial_y() {
        return initial_y;
    }

    public void setInitial_y(int initial_y) {
        this.initial_y = initial_y;
    }

    public int getCurrent_x() {
        return current_x;
    }

    public void setCurrent_x(int current_x) {
        this.current_x = current_x;
    }

    public int getCurrent_y() {
        return current_y;
    }

    public void setCurrent_y(int current_y) {
        this.current_y = current_y;
    }

    public int getFinal_x() {
        return final_x;
    }

    public void setFinal_x(int final_x) {
        this.final_x = final_x;
    }

    public int getFinal_y() {
        return final_y;
    }

    public void setFinal_y(int final_y) {
        this.final_y = final_y;
    }

    public int getWumpus_x() {
        return wumpus_x;
    }

    public void setWumpus_x(int wumpus_x) {
        this.wumpus_x = wumpus_x;
    }

    public int getWumpus_y() {
        return wumpus_y;
    }

    public void setWumpus_y(int wumpus_y) {
        this.wumpus_y = wumpus_y;
    }

    public void initBorad() {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = generarValor(50, i, j, flag);
                flag = !flag;
            }
        }
        this.setAgent(initial_x, initial_y);
        this.setWumpus(wumpus_x, wumpus_y);
        this.setGold(final_x, final_y);
    }

    public void setAgent(int x, int y) {
        Position posAgent = new Position(x, y, "A");
        this.board[x][y] = posAgent;
        this.current_x = x;
        this.current_y = y;
    }

    public void setWumpus(int x, int y) {
        Position posWumpues = new Position(x, y, "W");
        this.board[x][y] = posWumpues;
    }

    public void setGold(int x, int y) {
        Position posGold = new Position(x, y, "O");
        this.board[x][y] = posGold;
    }

   

    public int generateValue(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public Position generarValor(int max, int i, int j, boolean flag) {
        int rango = (max - 0) + 1;
        int valor = (int) (Math.random() * rango + 0);
        if (valor >= 25) {
            return new Position(i, j, "L");
        } else if (valor >= 10 && valor <= 20) {
            return new Position(i, j, "B");
        } else if (valor >= 21 && valor <= 24) {
            return new Position(i, j, "M");
        } else {
            return new Position(i, j, "H");
        }
    }

    public void printBoard() {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j].getTipo() + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("-------------------------------------------------");
    }

    public boolean isLimit(int x, int y) {
        if (x < 0 || x >= this.N) {
            return false;
        }
        if (y < 0 || y >= this.M) {
            return false;
        }
        return true;
    }

    public boolean isEnd(int x, int y) {
        return this.board[x][y].getTipo().equalsIgnoreCase("O");
    }

    public boolean isAceptable(int x, int y) {
        if (this.board[x][y].getTipo().equalsIgnoreCase("L")) {
            return true;
        }
        if (this.board[x][y].getTipo().equalsIgnoreCase("B")) {
            return true;
        }
        if (this.board[x][y].getTipo().equalsIgnoreCase("M")) {
            return true;
        }
        return false;
    }

    public void marcarCasilla(int x, int y) {
        this.board[x][y] = new Position(x, y, "V");
    }

    public void symbology() {
        System.out.println("---------------------------------------------------");
        System.out.println("Simbologia");
        System.out.println("WUMPUS: W");
        System.out.println("AGENTE: A");
        System.out.println("BRISA: B");
        System.out.println("HOYO: H");
        System.out.println("MAL OLOR: M");
        System.out.println("LIMPIO: L");
        System.out.println("ORO: O");
        System.out.println("---------------------------------------------------");
    }

}
