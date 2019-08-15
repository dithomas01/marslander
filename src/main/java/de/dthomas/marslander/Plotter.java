package de.dthomas.marslander;

public class Plotter {
  private final int[] terrainX;
  private final int[] terrainY;

  public Plotter(int[] terrainX, int[] terrainY) {
    this.terrainX = terrainX;
    this.terrainY = terrainY;
  }

  public int[] getTerrainX() {
    return terrainX;
  }

  public int[] getTerrainY() {
    return terrainY;
  }
}
