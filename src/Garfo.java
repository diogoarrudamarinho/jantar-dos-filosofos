import java.util.concurrent.locks.ReentrantLock;

public class Garfo {
    private final int id;
    private final ReentrantLock lock = new ReentrantLock();

    public Garfo(int id) { 
        this.id = id;
    }

    public void pegar() { 
        lock.lock(); 
    }

    public void liberar() { 
        lock.unlock(); 
    }

    public int getId() { 
        return id; 
    }
}