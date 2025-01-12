public class Rectangle {
  private int width;
  private int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(Rectangle other) { // copy constructor
    this.width = other.width;
    this.height = other.height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
