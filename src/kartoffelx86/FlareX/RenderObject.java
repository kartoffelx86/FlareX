/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareX;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * RenderObject.java Purpose: This is the class of an object renderable by the
 * engine.
 *
 * @author Julian
 */
public class RenderObject implements Comparable<RenderObject> {

    private final Texture texture;
    private final Rectangle anchor;
    private final int depth;

    /**
     * Constructs a new RenderObject Object.
     * 
     * @param texture
     * @param anchor The bounds and location represented by an Rectangle
     * @param depth The depth/z-Axis of this Object. Higher gets rendered first.
     */
    public RenderObject(Texture texture, Rectangle2D anchor, int depth) {
        this.texture = texture;
        this.anchor = (Rectangle) anchor;
        this.depth = depth;
    }

    /**
     * @return the texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * @return the anchor
     */
    public Rectangle getAnchors() {
        return anchor;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    @Override
    public int compareTo(RenderObject o) {
        int comparedepth = o.getDepth();
        return getDepth() - comparedepth;
    }

}
