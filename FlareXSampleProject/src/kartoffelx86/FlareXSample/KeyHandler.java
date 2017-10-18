/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareXSample;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler implements KeyListener {

    public static final Set<Integer> KEYS_PRESSED = new HashSet<>();

    static void processKeys() {
        if (KEYS_PRESSED.size() > 0) {
            for (int c : KEYS_PRESSED) {
                if (c == KeyEvent.VK_W) {
                    w_pressed();
                }
                if (c == KeyEvent.VK_S) {
                    s_pressed();
                }
                if (c == KeyEvent.VK_A) {
                    a_pressed();
                }
                if (c == KeyEvent.VK_D) {
                    d_pressed();
                }
                if (c == KeyEvent.VK_P) {
                    KEYS_PRESSED.remove(KeyEvent.VK_P);
                    p_pressed();
                }
            }

        }
    }

    private static void w_pressed() {
        Game.getLui().setY(Game.getLui().getY() - 2);
    }

    private static void s_pressed() {
        Game.getLui().setY(Game.getLui().getY() + 2);
    }

    private static void a_pressed() {
        Game.getLui().setX(Game.getLui().getX() - 2);
    }

    private static void d_pressed() {
        Game.getLui().setX(Game.getLui().getX() + 2);
    }

    private static void p_pressed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KEYS_PRESSED.add(e.getKeyCode());

    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        KEYS_PRESSED.remove(e.getKeyCode());
    }

}
