import java.util.Scanner;

public class FindNearestPoints {
  // // Returns the number of points that the user wants to enter:
  // public static int inputArrLength(Scanner scanner) {
  //
  // return numPoints;
  // }

  // Returns an array containing the two line numbers of the closest points:
  public static void inputArrPoints(Scanner scanner, double[][] userCoords) {
    System.out.println("Enter " + userCoords.length + " points:");
    for (int i = 0; i < userCoords.length; i++) {
      userCoords[i][0] = scanner.nextDouble();
      userCoords[i][1] = scanner.nextDouble();
      userCoords[i][2] = scanner.nextDouble();
    }
  }

  // Uses the distance formula to calculate the distance between 2 points:
  public static double calcDistanceBetweenPoints(double x1, double y1, double z1, double x2,
      double y2, double z2) {
    // Distance formula - ((x2 - x1)^2 + (y2 - y1)^2)^(1/2)
    double distance =
        Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * z2 - z1);
    return distance;
  }

  // Compares all points in 2d array userCoords to find the closest point(s):
  public static int[] findClosestPoints(double[][] userCoords) {
    double closestDistance = calcDistanceBetweenPoints(userCoords[0][0], userCoords[0][1],
        userCoords[0][2], userCoords[1][0], userCoords[1][1], userCoords[1][2]);
    double tempDistance;
    int[] closestArrIndex = new int[2];
    for (int i = 0; i < userCoords.length; i++) {
      for (int j = i + 1; j < userCoords.length; j++) {
        tempDistance = calcDistanceBetweenPoints(userCoords[i][0], userCoords[i][1],
            userCoords[i][2], userCoords[j][0], userCoords[j][1], userCoords[j][2]);
        if (tempDistance < closestDistance) {
          closestDistance = tempDistance;
          closestArrIndex[0] = i;
          closestArrIndex[1] = j;
        }
      }
    }
    return closestArrIndex;
  }

  // Prints all of the points that are the closest to each other:
  public static void displayClosestPoints(int p1, int p2, double[][] userCoords) {
    System.out.println("The closest points are: (" + userCoords[p1][0] + ", " + userCoords[p1][1]
        + ", " + userCoords[p1][2] + ") and (" + userCoords[p2][0] + ", " + userCoords[p2][1] + ", "
        + userCoords[p2][2] + ")");
  }

  // This is the main method. It executes all other methods:
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of points:");
    int numArrPoints = scanner.nextInt();
    double[][] userCoords = new double[numArrPoints][3];
    inputArrPoints(scanner, userCoords);
    int[] closestArrIndex = findClosestPoints(userCoords);
    displayClosestPoints(closestArrIndex[0], closestArrIndex[1], userCoords);
    scanner.close();
  }
}
