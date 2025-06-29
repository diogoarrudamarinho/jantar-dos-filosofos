public class Jantar {
      public static void main(String[] args) {

        final int NUM_FILOSOFOS = 5;
        Garfo[] garfos = new Garfo[NUM_FILOSOFOS];

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            garfos[i] = new Garfo(i);
        }

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Garfo esquerdo = garfos[i];
            Garfo direito = garfos[(i + 1) % NUM_FILOSOFOS];
            Filosofo f = new Filosofo(i, esquerdo, direito);
            new Thread(f, "Filosofo " + i).start();
        }
    }
}
