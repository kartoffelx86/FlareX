/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareX;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 * Texture.java Purpose: As the name already implies, this class manages the
 * images and settings for the texture.
 *
 * @author Julian
 */
public class Texture {

    private final BufferedImage image;
    private boolean pattern = false;
    private Dimension patternSize = new Dimension(0, 0);

    /**
     * Creates a new Texture Object.
     *
     * @param texture The Image for this texture
     */
    public Texture(BufferedImage texture) {
        this.image = texture;
    }

    /**
     * Creates a new Texture Object which can be a pattern.
     *
     * @param texture
     * @param isPattern
     * @param patternSize The size the source image is supposed to have in this
     * texture.
     */
    public Texture(BufferedImage texture, boolean isPattern, Dimension patternSize) {
        this.image = texture;
        this.pattern = isPattern;
        this.patternSize = patternSize;
    }

    /**
     * @return the texture
     */
    public BufferedImage getImage() {
        return image;
    }

    public boolean isPattern() {
        return pattern;
    }

    /**
     * @return the patternSize
     */
    public Dimension getPatternSize() {
        return patternSize;
    }

}
