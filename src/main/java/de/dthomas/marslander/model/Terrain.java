package de.dthomas.marslander.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Terrain {
  private int[] x;
  private int[] y;

  public Terrain() {}

  public int[] getX() {
    return x;
  }

  public void setX(int[] x) {
    this.x = x;
  }

  public int[] getY() {
    return y;
  }

  public void setY(int[] y) {
    this.y = y;
  }

  public List<Integer> getXasList() {
    return Arrays.stream(this.x).boxed().collect(Collectors.toList());
  }

  public List<Integer> getYasList() {
    return Arrays.stream(this.y).boxed().collect(Collectors.toList());
  }

  public int getHeight(int xCoordi) {
    int yCoordi = 0;
    for (int i = 1; i < x.length; i++) {
      if (xCoordi < x[i]) {
        double h = x[i] - x[i-1];
        double m = ((double) y[i] - (double) y[i-1]) / h;
        yCoordi = (int) (y[i-1] + (xCoordi - x[i-1])*m);
        break;
      }
    }
    return yCoordi;
  }

  public boolean isFlat(int xCoordi) {
    for (int i = 1; i < x.length; i++) {
      if (xCoordi < x[i]) {
        double h = x[i] - x[i-1];
        double m = ((double) y[i] - (double) y[i-1]) / h;
        if (m==0) return true;
        break;
      }
    }
    return false;
  }
}
