package src;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {
  private int x;
  private int y;
  private int size;
  private Color color;

  public Circle(int x, int y, int size) {
    this.x = x;
    this.y = y;
    this.size = size;
    color = getRandomColor();
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLACK);
    g.drawArc(x - (size / 2), y - (size / 2), size, size, 0, 360);
    g.setColor(color);
    g.fillArc(x - (size / 2), y - (size / 2), size, size, 0, 360);
  }

  private Color getRandomColor() {
    int r = (int) Math.round(Math.random() * 255);
    int g = (int) Math.round(Math.random() * 255);
    int b = (int) Math.round(Math.random() * 255);
    return new Color(r, g, b);
  }
  /**
  Big O Analysis
  This calculation is used to determine if the mouse
  position is within the circle's area. 
  This uses a^2 + b^2 = c^2 formula
  Thus the Big O is f(n) = O(n^2)
   */
  public boolean isCLicked(int mouseX, int mouseY) {
    double a = Math.pow(mouseX - x, 2);
    double b = Math.pow(mouseY - y, 2);
    double c = Math.pow(size / 2, 2);
    return (a + b) <= c;
  }
}