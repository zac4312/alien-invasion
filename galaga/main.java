import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;

public class main {
    public static void main(String[] args) {
        // Create a GameObject representing a square at position (100, 100) with size 50x50
        GameObject square1 = new GameObject(700, 650, 105, 100);
        GameObject square2 = new GameObject(795, 50, 105, 105
        );
        // Create a JFrame to display the game
        JFrame frame = new JFrame("Game with Square");
        
        // Create a custom JPanel to override the paintComponent method
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Call the superclass's paintComponent to ensure proper rendering
                square1.render(g); // Call the render method of the square to draw it
                square2.render(g); 
            }
        };

          // Timer to update the square's position every 1000 milliseconds (1 second)
          Timer timer = new Timer(250, e -> {
            square2.moveDown(); // Move the square down every 1 second
            
            // Check for collision between the moving square and the stationary square
            if (square2.checkCollision(square1)) {
                square2.stopMoving(); // Stop the moving square if a collision is detected
            }

            
            panel.repaint(); // Repaint the panel to update the display
        });
        timer.start(); // Start the timer

        
        // Set up the JFrame settings
        frame.add(panel); // Add the custom panel to the JFrame
        frame.setSize(400, 400); // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setVisible(true); // Make the window visible
    }
}

