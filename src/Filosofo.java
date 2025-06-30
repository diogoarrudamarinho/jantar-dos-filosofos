public class Filosofo implements Runnable {
    private final int id;  
    private final Hashi HashiEsquerdo, HashiDireito;  

    public Filosofo(int id, Hashi HashiEsquerdo, Hashi HashiDireito) {
        this.id = id;
        this.HashiEsquerdo = HashiEsquerdo;
        this.HashiDireito = HashiDireito;
    }

    @Override
    public void run() {
        try {
            while (true) { 
                meditar();
                comer();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  
            System.out.println("Filósofo " + id + " interrompido.");
        }
    }

    private void meditar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 5000));  // Espera aleatória
    }

    private void comer() throws InterruptedException {
        // Estratégia anti-deadlock: ordenação por ID
        Hashi primeiro = HashiEsquerdo;
        Hashi segundo = HashiDireito;
        
        // Sempre pega o garfo de MENOR ID primeiro
        if (HashiEsquerdo.getId() > HashiDireito.getId()) {
            primeiro = HashiDireito;
            segundo = HashiEsquerdo;
        }

        primeiro.pegar();  // Adquire o primeiro garfo
        segundo.pegar();   // Adquire o segundo garfo

        try {
            System.out.println("Filósofo " + id + " está comendo.");
            Thread.sleep((long) (Math.random() * 5000));  // Simula tempo de refeição
        } finally {
            segundo.liberar();  // Libera na ordem inversa
            primeiro.liberar();  // Garante liberação mesmo com exceções
        }
    }
}



