import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> fila = new LinkedList<>();
        
        System.out.println("\nBem vindo ao jogo da Cadeira Musical Virtual! ");
        System.out.print("Insira o número de participantes: ");

        try (Scanner input = new Scanner(System.in)) {
            // PArticipantes do jogo
            int participantes = input.nextInt();
            if (participantes <= 0) {
                System.out.println("Insira um número válido de participantes!");
                return;
            }
            for (int i = 1; i <= participantes; i++) {
                fila.add(i);
            }
            
            // Fila com os participantes do jogo
            System.out.println("Fila de participantes: " + fila);
            
            // Batidas do jogo
            System.out.print("Indique o número de batidas: ");
            int batidas = input.nextInt();
            if (batidas <= 0) {
                System.out.println("Insira um número válido de batidas!");
                return;
            }
            
            // Vencedor do jogo
            int vencedor = cadeiraMusical(fila, batidas);
            System.out.println("\nVencedor do jogo: " + vencedor);
        }
    }

    private static Integer cadeiraMusical(Queue<Integer> fila, int batidas) {
        int rodada = 1;
        while (fila.size() != 1) {
            System.out.println("\nRodada: " + rodada);
            System.out.println("Atuais jogadores: " + fila);
            for (int i = 1; i <= batidas; i++) {
                Integer primeiro = fila.remove();
                if (i == batidas) {
                    System.out.println("Após " + batidas + " batidas, o participante " + primeiro + " é eliminado.");
                } else {
                    fila.add(primeiro);
                }
            }
            System.out.println("Jogadores restantes após a eliminação: " + fila);
            rodada++;
        }
        return fila.element();
    }
}
