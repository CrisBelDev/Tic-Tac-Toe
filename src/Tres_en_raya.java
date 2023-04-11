
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CHICHO
 */
public class Tres_en_raya {

    private String turno;
    private int jugador;
    private String matriz[][];
    private int tam;

    public Tres_en_raya(int n) {
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

    public void llenar_matriz(int i, int j) {
        if (matriz[i][j].equals("")) {
            matriz[i][j] = turno;
            cambio_turno();
        }
    }

    public void mostrar_matriz() {
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("|" + matriz[i][j] + "|");
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
        Tres_en_raya obj = new Tres_en_raya(3);
        obj.iniciar_matriz();
        Scanner leer = new Scanner(System.in);
        int jugador = 1;
        int x, y;
        do {
            System.out.print("jugador: " + jugador + " ingrese coordenada:");
            x = leer.nextInt()-1;
            y = leer.nextInt()-1;
            if (jugador == 1) {
                jugador = 2;
            } else {
                jugador = 1;
            }
            obj.llenar_matriz(x, y);
            obj.mostrar_matriz();
            if (obj.hayGanador()) {
                System.out.println("¡Felicidades! Jugador " + jugador + " ha ganado.");
                break;
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
