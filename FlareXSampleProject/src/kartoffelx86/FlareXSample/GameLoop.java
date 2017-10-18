/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareXSample;

import java.util.logging.Logger;

/**
 * GameLoop.java Zweck: Beinhaltet die Loop die über einen Thread gestartet
 * wird.
 *
 * @author Julian Blazek
 */
public class GameLoop implements Runnable {

    private final Game game;
    private boolean running = true;
    private final int targetFPS;
    private boolean debug = false;
    private static final Logger LOG = Logger.getLogger(GameLoop.class.getName());

    public GameLoop(int targetFPS, Game game) {
        this.game = game;
        this.targetFPS = targetFPS;

    }

    private void updateGame(double delta) {
        game.update(delta);
    }

   
    private void render() {
        game.render();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        // Optimale Laufzeit der Loop in Nanosekunden sodass die Loop targetFPS mal in der Sekunde läuft. (0x3B9ACA00 = 1 Milliarde)
        final long optimalTime = 0x3B9ACA00 / targetFPS;
        int n = 0;
        // Eigentliche Loop
        while (isRunning()) {
            long nowTime = System.nanoTime();
            long loopLength = nowTime - lastTime;
            double delta = loopLength / (double) 33333332; // DeltaZeit als Faktor für die Berechnung der Physik und anderem.
            lastTime = nowTime;
            double accuracy = loopLength / ((double) optimalTime); // Prüfwert.. Umso näher an 1 umso besser war die Loop in der Zeit.

            // Die eigentlichen Aktionen in der Loop
            processKeys();
            updateGame(delta);
            render();

            // Berechnung der Optimalen Zeit die der Thread dann schläft. Die 0xF4240 (1'000'000) dienen zur Konvertierung der ns in ms.
            long sleepTime = (lastTime - System.nanoTime() + optimalTime) / 0xF4240;
            try {
                try {
                    Thread.sleep(sleepTime);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Fehler im LoopThread.. Aber nicht schlimm.. (:");
                    ex.printStackTrace();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Nur zum Debuggen...
            if (n == 60 && isDebug() == true) {
                System.out.println("" + accuracy + ";" + delta + ";" + optimalTime + ";" + lastTime);
                n = 0;
            }
            n++;
        }
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private void processKeys() {
        game.processKeys();
    }

}
