import java.awt.*;
import javax.swing.*;

class Mesa extends JPanel {
    private final int[] estados;

    public Mesa(int n) {
        this.estados = new int[n]; // 0 = pensando, 1 = esperando, 2 = comendo
    }

    public synchronized void setEstado(int id, int estado) {
        estados[id] = estado;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        int r = 200;

        for (int i = 0; i < estados.length; i++) {
            double angle = 2 * Math.PI / estados.length * i;
            int x = (int) (cx + r * Math.cos(angle));
            int y = (int) (cy + r * Math.sin(angle));

            switch (estados[i]) {
                case 0 -> g.setColor(Color.LIGHT_GRAY); // pensando
                case 1 -> g.setColor(Color.ORANGE);     // esperando
                case 2 -> g.setColor(Color.GREEN);      // comendo
            }

            g.fillOval(x - 30, y - 30, 60, 60);
            g.setColor(Color.BLACK);
            g.drawString("F" + i, x - 10, y + 5);
        }
    }
}