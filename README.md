# FlareX
Sample Usage:
```java
public class FlareXSample {

    RenderEngine engine;
    RenderWindow window;
    RenderQueue queue;


    public static void main(String[] args) {
        new FlareXSample;
    }

    public FlareXSample {
        Texture tex = null;
        Texture tex2 = null;
        window = new RenderWindow(new Dimension(800,600), null, null, true);
        engine = new RenderEngine(window);

        tex = new Texture(ImageIO.read(new File("C:\\YourImageFile.png")));
        Rectangle rect = new Rectangle(0,0,500,500);
        RenderObject obj1 = new RenderObject(tex, rect, 1000);

        tex2 = new Texture(ImageIO.read(new File("C:\\YourImageFile2.png")), true, new Dimension(40,40)); //This is a pattern
        RenderObject obj2 = new RenderObject(tex2, new Rectangle(20,20,500,500),2000);

        queue.addObject(obj1);
        queue.addObject(obj2);
        engine.render(queue);
    }
}
```	
	
