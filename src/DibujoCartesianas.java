

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.lang.reflect.Method;

public class DibujoCartesianas {

    //Método a modificar. x e y están entre 0 y 1.
    //El origen (0,0) está en la esquina inferior izquierda




    private static Color devuelveColor(double x, double y) {

        if (x > 0.40 && y < 0.50) {
            return new Color(251, 9, 9);
        }
        if (x > 0.40 && y > 0.50) {
            return new Color(4, 75, 255);
        }
        if (y < 0.11 && y > 0) {
            return new Color(251, 247, 9);
        }
        if (y < 0.22 && y > 0.11) {
            return new Color(251, 9, 9);
        }
        if (y < 0.33 && y > 0.22) {
            return new Color(251, 247, 9);
        }
        if (y < 0.44 && y > 0.33) {
            return new Color(251, 9, 9, 255);
        }
        if (y < 0.55 && y > 0.44) {
            return new Color(251, 247, 9);
        }
        if (y < 0.66 && y > 0.55) {
            return new Color(251, 9, 9);
        }
        if (y < 0.77 && y > 0.66) {
            return new Color(251, 247, 9);
        }
        if (y < 0.88 && y > 0.77) {
            return new Color(251, 9, 9);
        }
        if (y < 1 && y > 0.88) {
            return new Color(251, 247, 9);
        }
        return new Color(4, 75, 255);
    }


    //NO MODIFICAR A PARTIR DE AQUÍ

    public static int ANCHO = 400;
    public static int ALTO = 400;
    public static int diagonal = (int) Math.sqrt(ANCHO * ANCHO + ALTO * ALTO);

    public static void repinta(Canvas cnvs) {
        Graphics g = cnvs.getGraphics();
        Dimension dimension = cnvs.getSize();
        ANCHO = dimension.width;
        ALTO = dimension.height;
        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Color color = devuelveColor(x / (double) ANCHO, y / (double) ALTO);
                g.setColor(color);
                g.drawOval(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(ANCHO, ALTO + 50);

        final Canvas cnvs = new Canvas();
        cnvs.setSize(ANCHO, ALTO);

        frmMain.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                repinta(cnvs);
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {
            }
        });
        frmMain.add(cnvs);
        frmMain.setVisible(true);
        repinta(cnvs);
    }
}
