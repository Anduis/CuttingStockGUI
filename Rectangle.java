public class Rectangle {
  int width;
  int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public Rectangle(Rectangle other) { // copy constructor
    this.width = other.width;
    this.height = other.height;
  }
}
