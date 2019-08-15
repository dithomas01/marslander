package de.dthomas.marslander.model;

import java.util.ArrayList;
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
    List<Integer> xList = Arrays.stream(this.x).boxed().collect(Collectors.toList());
    return xList;
  }

  public List<Integer> getYasList() {
    List<Integer> yList = Arrays.stream(this.y).boxed().collect(Collectors.toList());
    return yList;
  }
}
