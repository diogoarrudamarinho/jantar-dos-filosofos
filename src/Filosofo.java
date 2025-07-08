class Filosofo implements Runnable {
    private final int id;
    private final Hashi hashiEsquerdo;
    private final Hashi hashiDireito;
    private final Mesa mesa;

    public Filosofo(int id, Hashi hashiEsquerdo, Hashi hashiDireito, Mesa mesa) {
        this.id = id;
        this.hashiEsquerdo = hashiEsquerdo;
        this.hashiDireito = hashiDireito;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                mesa.setEstado(id, 0); // pensando
                dormirAleatorio();

                mesa.setEstado(id, 1); // esperando
                pegarHashis();

                mesa.setEstado(id, 2); // comendo
                dormirAleatorio();
                
                soltarHashis();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filósofo " + id + " interrompido.");
        }
    }

    private void dormirAleatorio() throws InterruptedException {
        // Thread.sleep is intentionally used here to simulate thinking/eating time in the philosopher's loop.
        Thread.sleep((long) (Math.random() * 5000));
    }

    private void pegarHashis() {
        Hashi primeiro = hashiEsquerdo.getId() < hashiDireito.getId() ? hashiEsquerdo : hashiDireito;
        Hashi segundo = hashiEsquerdo.getId() > hashiDireito.getId() ? hashiEsquerdo : hashiDireito;
        primeiro.pegar();
        segundo.pegar();
    }

    private void soltarHashis() {
        hashiEsquerdo.liberar();
        hashiDireito.liberar();
    }
}