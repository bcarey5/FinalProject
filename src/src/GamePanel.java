package src;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements MouseListener {
  private int circlesClicked = 0;
  private final int maxCircleCount = 20;
  private long startTime;
  private long endTime;
  private boolean isGameOver = false;
  private Circle circle;
  private int width;
  private int height;

  public GamePanel(int width, int height) {
    this.width = width;
    this.height = height;
    startTime = System.currentTimeMillis();
    Dimension dim = new Dimension(width, height);
    setMinimumSize(dim);
    setPreferredSize(dim);
    setMaximumSize(dim);
    createRandomCircle();
    addMouseListener(this);
  }

  private void checkMouseClick(int mouseX, int mouseY) {
    if (circle.isCLicked(mouseX, mouseY)) {
      circlesClicked++;
      createRandomCircle();
    }

    if (isGameOver) {
      isGameOver = false;
      startTime = System.currentTimeMillis();
      circlesClicked = 0;
    }

    if (!isGameOver && circlesClicked >= maxCircleCount) {
      isGameOver = true;
      endTime = System.currentTimeMillis();
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    g.clearRect(0, 0, width, height);
    if (isGameOver)
      paintEnding(g);
    else
      paintGame(g);
  }

  private void paintGame(Graphics g) {
    circle.paint(g);

  }

  private void paintEnding(Graphics g) {
    Font font = new Font("Arial", Font.BOLD, 20);
    g.setFont(font);
    long elapsedTime = endTime - startTime;
    g.drawString("Time spent is " + elapsedTime + " milliseconds", maxCircleCount, circlesClicked);
  }

  private void createRandomCircle() {
    int randomX = (int) Math.round(Math.random() * (width - 10) + 5);
    int randomY = (int) Math.round(Math.random() * (height - 10) + 5);
    circle = new Circle(randomX, randomY, 10);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    checkMouseClick(e.getX(), e.getY());
    repaint();
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
