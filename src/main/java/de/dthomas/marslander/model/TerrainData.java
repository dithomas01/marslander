package de.dthomas.marslander.model;

import java.util.List;

public class TerrainData {
  List<Integer> terrainX;
  List<Integer> terrainY;

  public TerrainData(List<Integer> terrainX, List<Integer> terrainY) {
    this.terrainX = terrainX;
    this.terrainY = terrainY;
  }

  public List<Integer> getTerrainX() {
    return terrainX;
  }

  public List<Integer> getTerrainY() {
    return terrainY;
  }
}
