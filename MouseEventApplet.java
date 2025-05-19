import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseEventSwing extends JFrame implements MouseMotionListener {
    int xcord;
    int ycord;

    public MouseEventSwing() {
        setTitle("Mouse Event Swing Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(this);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("(" + xcord + "," + ycord + ")", xcord, ycord);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xcord = e.getX();
        ycord = e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Required to implement MouseMotionListener, but not used
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseEventSwing::new);
    }
}
