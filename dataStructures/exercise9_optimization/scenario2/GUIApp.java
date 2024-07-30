package dataStructures.exercise9_optimization.scenario2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIApp {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int RECT_COUNT = 900000;
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("GUI Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            frame.setSize(WIDTH, HEIGHT);
            frame.add(new CustomPanel());
            frame.pack();
            frame.setVisible(true);
        });
    }

    static class CustomPanel extends JPanel {
        private final ArrayList<Rectangle> rectangles;
        private BufferedImage image;

        public CustomPanel() {
            rectangles = new ArrayList<>();
            Random random = new Random();

            long startTime = System.nanoTime();
            for (int i = 0; i < RECT_COUNT; i++) {
                int x = random.nextInt(WIDTH);
                int y = random.nextInt(HEIGHT);
                int width = random.nextInt(50);
                int height = random.nextInt(50);
                rectangles.add(new Rectangle(x, y, width, height));
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;  // convert to milliseconds
            System.out.println("Time taken to add rectangles: " + duration + " ms");

            // Create an image and draw the rectangles onto it
            image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);  // Set the color to white
            g2d.fillRect(0, 0, WIDTH, HEIGHT);  // Fill the entire image with the white color
            g2d.setColor(Color.BLACK); // Set the color to black for the rectangles
            for (Rectangle rectangle : rectangles) {
                g2d.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
            g2d.dispose();
            repaint();
        }

        // @Override
        // protected void paintComponent(Graphics g) {
        //     super.paintComponent(g);
        //     long startTime = System.nanoTime();
        //     for (Rectangle rectangle : rectangles) {
        //         g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        //     }
        //     long endTime = System.nanoTime();
        //     long duration = (endTime - startTime) / 1_000_000;  // convert to milliseconds
        //     System.out.println("Time taken to draw rectangles: " + duration + " ms");
        // }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            long startTime = System.nanoTime();
            // Draw the pre-rendered image onto the panel
            g.drawImage(image, 0, 0, null);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000;  // convert to milliseconds
            System.out.println("Time taken to draw rectangles: " + duration + " ms");
        }
    }
}















/*GitHub Copilot
Sure, here's a simple Java GUI application that uses a basic data structure (ArrayList) to store and render a large number of rectangles. 
The application creates a JFrame and adds a custom JPanel to it. 
The JPanel overrides the paintComponent method to draw all the rectangles in the ArrayList.

This code can be optimized in several ways. 
For example, the rendering process could be improved by using a more efficient data structure to store the rectangles, 
or by optimizing the way the rectangles are drawn. */
