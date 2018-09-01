import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : Madhulika, 20186015
 */
final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    //not used
  }
  /**
   * Function to round the
   * elements of a matrix to the nearest 100.
   *
   * @param      a     Matrix of which the elements to be rounded
   * @param      r     Number of rows
   * @param      c     Number of columns
   *
   * @return     Matrix of the rounded elements
   */
  static int[][] roundHundred(final int[][] a, final int r, final int c) {

    // write your code here
    // final int strt = 0;
    // final int strt1 = 50;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        final int strt = 0;
        final int strt1 = 50;
        final int strt2 = 150;
        final int strt3 = 250;
        final int strt4 = 350;
        final int strt5 = 450;
        final int strt6 = 550;

        if (a[i][j] > strt && a[i][j] <= strt1) {
          a[i][j] = 0;
        } else if (a[i][j] > strt1 && a[i][j] <= strt2) {
          a[i][j] = 100;
        } else if (a[i][j] > strt2 && a[i][j] <= strt3) {
          a[i][j] = 200;
        } else if (a[i][j] > strt3 && a[i][j] <= strt4) {
          a[i][j] = 300;
        } else if (a[i][j] > strt4 && a[i][j] <= strt5) {
          a[i][j] = 400;
        } else if (a[i][j] > strt5 && a[i][j] <= strt6) {
          a[i][j] = 500;
        }
      }
    }
    return a;
  }
  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int m = scan.nextInt();
    int n = scan.nextInt();
    int[][] a = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = scan.nextInt();
      }
    }
    int[][] b = roundHundred(a, m, n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n - 1; j++) {
        System.out.print(b[i][j] + " ");
      }
      System.out.println(b[i][n - 1]);
    }
  }
}
