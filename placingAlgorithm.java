import java.util.*;

class Rectangle {
    int id;
    int width;
    int height;

    public Rectangle(int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    int getHeight() {
        return height;
    }
}

public class placingAlgorithm {

    public static void main(String[] args) {
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(1, 2, 4),
                new Rectangle(2, 9, 3),
                new Rectangle(3, 5, 2));

        rectangles.sort(Comparator.comparingInt(Rectangle::getHeight).reversed());

        int materialWidth = 10;
        int materialHeight = 10;
        int[][] material = new int[materialHeight][materialWidth];

        for (Rectangle rectangle : rectangles) {
            placeRectangles(material, rectangle);
        }

        printMaterial(material);
    }

    private static void placeRectangles(int[][] material, Rectangle rectangle) {
        int rectWidth = rectangle.width;
        int rectHeight = rectangle.height;
        for (int i = 0; i <= material.length - rectHeight; i++) {
            for (int j = material[0].length - rectWidth; j >= 0; j--) {
                if (fits(material, i, j, rectWidth, rectHeight)) {
                    placeRectangle(material, i, j, rectWidth, rectHeight, rectangle.id);
                    return;
                }
            }
        }
    }

    private static boolean fits(int[][] material, int row, int col, int rectWidth, int rectHeight) {
        for (int i = row; i < row + rectHeight; i++) {
            for (int j = col; j < col + rectWidth; j++) {
                if (material[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void placeRectangle(int[][] material, int row, int col, int rectWidth, int rectHeight,
            int rectangleId) {
        for (int i = row; i < row + rectHeight; i++) {
            for (int j = col; j < col + rectWidth; j++) {
                material[i][j] = rectangleId;
            }
        }
    }

    private static void printMaterial(int[][] material) {
        for (int i = 0; i < material.length; i++) {
            for (int j = 0; j < material[0].length; j++) {
                System.out.print(material[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
