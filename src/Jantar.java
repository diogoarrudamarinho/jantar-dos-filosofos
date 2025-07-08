//Classe Jantar.java
import javax.swing.*;
public class Jantar {
    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 7;
        Mesa mesa = new Mesa(NUM_FILOSOFOS);

        Hashi[] hashis = new Hashi[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            hashis[i] = new Hashi(i);
        }

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Hashi esquerdo = hashis[i];
            Hashi direito = hashis[(i + 1) % NUM_FILOSOFOS];
            Filosofo f = new Filosofo(i, esquerdo, direito, mesa);
            new Thread(f, "Filosofo " + i).start();
        }

        JFrame frame = new JFrame("Jantar dos Filósofos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setContentPane(mesa);
        frame.setVisible(true);
    }
}