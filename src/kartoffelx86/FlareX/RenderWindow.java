/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareX;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * RenderWindow.java Purpose: This is the class of a window the RenderEngine is
 * going to render to.
 *
 * @author Julian
 */
public class RenderWindow extends JFrame {

    private final boolean antialisingEnabled;
    private final Dimension size;
    private KeyListener keylistener = null;
    private MouseListener mouselistener = null;
    private PaintPanel panel;
    private RenderEngine engine;

    /**
     *
     * @param windowsize The size this window is supposed to have.
     * @param keylistener You can pass a KeyListener to this Window. If you
     * don't need one, pass null.
     * @param mouselistener You can pass a MouseListener to this Window. If you
     * don't need one, pass null.
     * @param antialising Antialising enabled?
     */
    public RenderWindow(Dimension windowsize, KeyListener keylistener, MouseListener mouselistener, boolean antialising) {
        antialisingEnabled = antialising;
        size = windowsize;
        this.keylistener = keylistener;
        this.mouselistener = mouselistener;
        init();
        setPanelSize(size);
    }

    private void init() {
        setLocationRelativeTo(null);//Objekt wird in die Mitte geschoben
        setVisible(false);
        getContentPane().setLayout(new java.awt.GridLayout());
        setTitle("Renderframe");
        setResizable(false);
        requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel = new PaintPanel();
        panel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(panel);
        addKeyListener(keylistener);
        addMouseListener(mouselistener);
        pack();
        this.setVisible(true);
    }

    /**
     * Sets the Title of the Frame
     *
     * @param title
     */
    public void setWindowTitle(String title) {
        setTitle(title);
    }

    /**
     * Sets the size of the inner PaintPanel and enforces the Window to resize
     * itself to fit the panel. It also centers the Window.
     *
     * @param size
     */
    public void setPanelSize(Dimension size) {
        panel.setPreferredSize(size);
        this.pack();
        setLocationRelativeTo(null);
    }

    protected void requestRender() {
        panel.repaint();
    }

    /**
     * Experimental.. Forces the Panel to skip the Swing event queue.
     */
    protected void forceRequestRender() {
        panel.paintComponent(panel.getGraphics());
    }

    protected void setEngine(RenderEngine engine) {
        this.engine = engine;
    }

    private void renderFrame(Graphics2D g2d) {
        engine.renderPanel(g2d);
    }

    protected class PaintPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if (antialisingEnabled) {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            } else {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            }
            renderFrame(g2d);
        }
    }

}
