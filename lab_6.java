import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConeCupFrame extends JFrame {
    private ConeCup cupPanel;
    private JTextField d1Field;
    private JTextField d2Field;
    private JTextField hField;
    private JTextField kField;

    public ConeCupFrame() {
        setTitle("Динамический стакан");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLocationRelativeTo(null);

        cupPanel = new ConeCup(50, 100, 200, 50);
        add(cupPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                    double d1 = Double.parseDouble(d1Field.getText());
                    double d2 = Double.parseDouble(d2Field.getText());
                    double h = Double.parseDouble(hField.getText());
                    double k = Double.parseDouble(kField.getText());
                    cupPanel.updateCup(d1, d2, h, k);
            }
        };

        panel.add(new JLabel("d1 (низ):"));
        d1Field = new JTextField("50");
        d1Field.addKeyListener(keyAdapter);
        panel.add(d1Field);

        panel.add(new JLabel("d2 (верх):"));
        d2Field = new JTextField("100");
        d2Field.addKeyListener(keyAdapter);
        panel.add(d2Field);

        panel.add(new JLabel("Высота (h):"));
        hField = new JTextField("200");
        hField.addKeyListener(keyAdapter);
        panel.add(hField);

        panel.add(new JLabel("Заполнение (k%):"));
        kField = new JTextField("50");
        kField.addKeyListener(keyAdapter);
        panel.add(kField);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ConeCupFrame();
    }

    static class ConeCup extends JPanel {

        private double d1;
        private double d2;
        private double h;
        private double k;

        public ConeCup(double d1, double d2, double h, double k) {
            this.d1 = d1;
            this.d2 = d2;
            this.h = h;
            this.k = k;
            setPreferredSize(new Dimension(200, 250));
        }

        public void updateCup(double d1, double d2, double h, double k) {
            this.d1 = d1;
            this.d2 = d2;
            this.h = h;
            this.k = k;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int height = getHeight();
            int width = getWidth();

            int x0 = width / 2;
            int y0 = height - 30;

            double r1 = d1 / 2.0;
            double r2 = d2 / 2.0;

            int hCone = (int) h;


            g.drawLine(x0 - (int) r1, y0, x0 - (int) r2, y0 - hCone);
            g.drawLine(x0 + (int) r1, y0, x0 + (int) r2, y0 - hCone);
            g.drawOval(x0 - (int) r2 - 1, y0 - hCone - ((int) r2 / 4), (int) (2 * r2), (int) r2 / 2);

            g.setColor(Color.BLUE);


            int filledHeight = (int) (hCone * (k / 100.0));
            int startY = y0 - filledHeight;
            for (int i = startY; i < y0; i++) {
                double hRatio = (double) (y0 - i) / hCone;
                int currentWidth = (int) ((r2 - r1) * hRatio + r1);
                g.drawLine(x0 - currentWidth, i, x0 + currentWidth, i);
            }

            g.setColor(Color.BLACK);
        }
    }
}
