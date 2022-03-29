import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;

public class TestFindNearestPoints {
  Scanner scanner = new Scanner(System.in);

  @Test
  // Credit to Johnny Zheng for helping me figure out issues with assertions concerning double types
  public final void testCalcDistanceBetweenPoints() {
    double x1 = 5.5;
    double x2 = -7.0;
    double y1 = -3.0;
    double y2 = 6.2;
    double z1 = 3.2;
    double z2 = -1.8;
    double expected =
        Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * z2 - z1);
    double actual = FindNearestPoints.calcDistanceBetweenPoints(x1, y1, z1, x2, y2, z2);

    Assert.assertEquals(expected, actual, 0.001);
  }

  @Test
  // Credit to Johnny Zheng for helping me figure out issues with assertions concerning array types
  public final void testFindClosestPoints() {
    double[][] testPointsArray = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, {2, 0.5, 9}, {3.5, 2, -1},
        {3, 1.5, 3}, {-1.5, 4, 2}, {5.5, 4, -0.5}};
    int[] expected = {3, 6};
    int[] actual = FindNearestPoints.findClosestPoints(testPointsArray);

    assertArrayEquals(expected, actual);
  }
}
