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
}
