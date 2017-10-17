/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareX;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.util.ArrayList;

/**
 * RenderEngine.java Purpose: Manages the rendering process.
 *
 * @author Julian
 */
public class RenderEngine {

    RenderQueue queue;
    RenderWindow window;

    /**
     * Constructs a new RenderEngine Object which is going to render to the
     * given Window.
     *
     * @param window
     */
    public RenderEngine(RenderWindow window) {
        this.window = window;
        window.setEngine(this);
    }

    /**
     * Schedules the engine to render the given RenderQueue.
     *
     * @param queue The queue to render.
     */
    public void render(RenderQueue queue) {
        this.queue = queue;
        window.requestRender();
    }

    protected void renderPanel(Graphics2D g2d) {
        if (queue == null) {
            return;
        }
        ArrayList<RenderObject> objectsqueue = queue.getQueue();
        for (RenderObject obj : objectsqueue) {
            Texture txtr = obj.getTexture();
            Rectangle anchor = obj.getAnchors();
            // If the Texture is an Pattern it is also going to be drawn as an pattern.
            if (txtr.isPattern()) {
                TexturePaint paint = new TexturePaint(txtr.getImage(), new Rectangle(0, 0, txtr.getPatternSize().width, txtr.getPatternSize().height));
                g2d.setPaint(paint);
                g2d.fillRect(anchor.x, anchor.y, anchor.width, anchor.height);
            } else {
                g2d.drawImage(txtr.getImage(), anchor.x, anchor.y, anchor.width, anchor.height, null);
            }
        }
    }

}
