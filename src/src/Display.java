package src;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
  private String title;
  private int width;
  private int height;
  private Dimension dim;
  private JFrame frame;
  private GamePanel panel;

  public Display(String title, int width, int height) {
    this.setTitle(title);
    this.width = width;
    this.height = height;
    createDisplay();
  }

  private void createDisplay() {
    dim = new Dimension(width, height);
    frame = new JFrame(title);
    frame.setMinimumSize(dim);
    frame.setSize(dim);
    frame.setMaximumSize(dim);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    panel = new GamePanel(width, height);

    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}
