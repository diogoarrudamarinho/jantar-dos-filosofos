public class Filosofo implements Runnable {
    private final int id;
    private final Garfo garfoEsquerdo, garfoDireito;

    public Filosofo(int id, Garfo garfoEsquerdo, Garfo garfoDireito) {
        this.id = id;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                comer();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filósofo " + id + " interrompido.");
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 5000));
    }

    private void comer() throws InterruptedException {
        Garfo primeiro = garfoEsquerdo, segundo = garfoDireito;
        if (garfoEsquerdo.getId() > garfoDireito.getId()) {
            primeiro = garfoDireito;
            segundo = garfoEsquerdo;
        }

        primeiro.pegar();
        segundo.pegar();

        try {
            System.out.println("Filósofo " + id + " está comendo.");
            Thread.sleep((long) (Math.random() * 5000));
        } finally {
            segundo.liberar();
            primeiro.liberar();
        }
    }
}