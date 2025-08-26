package app;

import java.util.Scanner;
import dados.BancoDeDados;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BancoDeDados.inicializarMock();
    }
}
