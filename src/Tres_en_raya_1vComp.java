package holamundo;

import java.util.Random;
import java.util.Scanner;

public class Tres_en_raya_2 {

    private String turno;
    private int jugador;
    private String matriz[][];
    private int tam;

    public Tres_en_raya_2(int n) {
        this.turno = "X";
        this.tam = n;
        this.jugador = 1;
        matriz = new String[n][n];

    }
    
    public void iniciar_matriz() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matriz[i][j] = "";
            }
        }
    }

    public void cambio_turno() {
        if (turno.equals("X")) {
            this.turno = "O";
            jugador = 2;
        } else {
            this.turno = "X";
            jugador = 1;
        }
    }

    public boolean llenar_matriz(int i, int j) {
        if (matriz[i][j].equals("")) {
            matriz[i][j] = turno;
            cambio_turno();
            return true;
        }
        return false;
    }

    public void mostrar_matriz() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("|" + matriz[i][j] + "| \t");
            }
            System.out.println("");
        }
    }
    public boolean es_vacia(){
        boolean sw = false;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (matriz[i][j].equals("")){
                    sw = true;
                }
            }
            
        }
        return sw;
    }
    public void compu() {
    	int numero = (int) (Math.random() * 10);
    	int i=0,j=0;
    	switch (numero) {
			case 1:i = 0;j=0;break;
			case 2:i = 0;j=1;break;
			case 3:i = 0;j=2;break;
			case 4:i = 1;j=0;break;
			case 5:i = 1;j=1;break;
			case 6:i = 1;j=2;break;
			case 7:i = 2;j=0;break;
			case 8:i = 2;j=1;break;
			case 9:i = 2;j=2;break;

		default:
			break;
		}
    	if(llenar_matriz(i, j)) {
    		mostrar_matriz();
    	}else {
    		compu();
    	}
    	
    }

    public boolean hayGanador() {
        // Revisa todas las posibles combinaciones de tres en línea
        for (int i = 0; i < 3; i++) {
            // Revisa las filas
            if (matriz[i][0] != "" && matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2]) {
                return true;
            }
            // Revisa las columnas
            if (matriz[0][i] != "" && matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i]) {
                return true;
            }
        }
        // Revisa las diagonales
        if (matriz[0][0] != "" && matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            return true;
        }
        if (matriz[0][2] != "" && matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
            return true;
        }
        // Si no hay ganador, retorna false
        return false;
    }

    public static void main(String[] args) {
    	Tres_en_raya_2 obj = new Tres_en_raya_2(3);
        obj.iniciar_matriz();
        Scanner leer = new Scanner(System.in);
        int jugador = 1;
        int x, y;
        do {
            System.out.print("jugador: " + " ingrese coordenada:");
            x = leer.nextInt()-1;
            y = leer.nextInt()-1;
            
            if(obj.llenar_matriz(x, y)) {
            	//obj.mostrar_matriz();
	            obj.compu();
	            if (obj.hayGanador()) {
	            	if (jugador == 2) {
	            		System.out.println("¡Felicidades! gano la pc .");
	            	}else {
	            		System.out.println("¡Felicidades! gano el jugador.");
	            	}
	                break;
	            }
	            if(jugador ==1) {
	            	jugador = 2;
	            }else {
	            	jugador = 1;
	            }
            }
	            
        } while (!obj.hayGanador());

    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    

}
