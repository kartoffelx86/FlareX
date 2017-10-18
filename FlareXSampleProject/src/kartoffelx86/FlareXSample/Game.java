/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareXSample;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import kartoffelx86.FlareX.RenderEngine;
import kartoffelx86.FlareX.RenderObject;
import kartoffelx86.FlareX.RenderQueue;
import kartoffelx86.FlareX.RenderWindow;
import kartoffelx86.FlareX.Texture;

/**
 *
 * @author Julian
 */
public class Game implements GameInterface {

    RenderEngine engine;
    RenderQueue queue;
    RenderWindow window;
    private static Luigi lui;
    Texture luitexture = null;
    GameLoop loop;
    Thread gameThread;

    public Game() {
        window = new RenderWindow(new Dimension(800, 600), new KeyHandler(), null, true);
        engine = new RenderEngine(window);
        queue = new RenderQueue();
        lui = new Luigi(10, 10, 60, 60);
        try {
            luitexture = new Texture(ImageIO.read(this.getClass().getClassLoader().getResource("kartoffelx86/FlareXSample/Luigi1.png")));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        queue.addObject(new RenderObject(luitexture, new Rectangle(lui.getX(), lui.getY(), lui.getWidth(), lui.getHeight()), 0));
        engine.render(queue);
        loop = new GameLoop(60, this);
        gameThread = new Thread(loop);
        gameThread.start();
    }

    @Override
    public void update(double delta) {
        queue.clear();
        RenderObject obj = new RenderObject(luitexture, new Rectangle(lui.getX(), lui.getY(), lui.getWidth(), lui.getHeight()), 0);
        queue.addObject(obj);
    }

    @Override
    public void processKeys() {
        KeyHandler.processKeys();
    }

    @Override
    public void render() {
        engine.render(queue);
    }

    /**
     * @return the lui
     */
    public static Luigi getLui() {
        return lui;
    }

}
