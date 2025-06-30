public class Jantar {
    public static void main(String[] args) {

        final int NUM_FILOSOFOS = 5;
        Hashi[] Hashis = new Hashi[NUM_FILOSOFOS];

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Hashis[i] = new Hashi(i);
        }

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Hashi esquerdo = Hashis[i];
            Hashi direito = Hashis[(i + 1) % NUM_FILOSOFOS];
            Filosofo f = new Filosofo(i, esquerdo, direito);
            new Thread(f, "Filosofo " + i).start();
        }
    }
}



