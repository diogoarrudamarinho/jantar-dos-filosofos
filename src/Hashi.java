import java.util.concurrent.locks.ReentrantLock;

public class Hashi {
    private final int id;  
    private final ReentrantLock lock = new ReentrantLock(); 

    public Hashi(int id) { 
        this.id = id;  
    }

    // Bloqueia o acesso ao garfo
    public void pegar() { 
        lock.lock(); 
    }

    // Libera o garfo para outros filósofos
    public void liberar() { 
        lock.unlock();  
    }

    public int getId() { 
        return id; 
    }
}




