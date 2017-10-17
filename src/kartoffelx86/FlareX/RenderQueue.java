/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareX;

import java.util.ArrayList;
import java.util.Collections;

/**
 * RenderQueue.java Purpose: This class represents the queue of RenderObjects
 * the engine is supposed to draw.
 *
 * @author Julian
 */
public class RenderQueue {

    private ArrayList<RenderObject> objects;

    public RenderQueue() {
        objects = new ArrayList();
    }

    /**
     * Adds an Object to the RenderQueue.
     * @param renderobject 
     */
    public void addObject(RenderObject renderobject) {
        objects.add(renderobject);
    }

    /**
     * Returns the RenderQueue. Sorted by the descending depth.
     * @return 
     */
    public ArrayList<RenderObject> getQueue() {
        ArrayList<RenderObject> sortedobjects = new ArrayList(objects);
        Collections.sort(sortedobjects);
        return sortedobjects;
    }

    /**
     * Clears the RenderQueue.
     */
    public void clear() {
        objects.clear();
    }
}
