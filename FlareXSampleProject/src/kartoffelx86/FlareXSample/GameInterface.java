/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kartoffelx86.FlareXSample;

/**
 *
 * @author Julian
 */
public interface GameInterface {
    public void update(double delta);
    public void processKeys();
    public void render();
}
