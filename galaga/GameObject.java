import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;


// This is the GameObject class that represents a square
public class GameObject {
    private int x, y, width, height;
    private boolean isMoving = true; // Track if the object is moving


    // Constructor to initialize the square's position and size
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Method to render (draw) the square on the screen
    public void render(Graphics g) {
        // Set the color for the square
        g.setColor(Color.BLUE);
        // Draw the square as a filled rectangle
        g.drawRect(x, y, width, height);
    }

    public void moveDown() {
        if (isMoving) {
        this.y += 20;
    }
}   

 // Method to stop the movement of the square
 public void stopMoving() {
    isMoving = false;
}

  // Method to check if the square collides with another square
  public boolean checkCollision(GameObject other) {
    // Check for overlap between the two rectangles (squares)
    return this.x < other.x + other.width &&
           this.x + this.width > other.x &&
           this.y < other.y + other.height &&
           this.y + this.height > other.y;
}


}


