package de.dthomas.marslander.shuttle;

import de.dthomas.marslander.ga.Chromosome;
import de.dthomas.marslander.ga.Gene;
import de.dthomas.marslander.model.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Shuttle {
  private Chromosome chromosome;
  private Terrain terrain;
  private List<Integer> x;
  private List<Integer> y;
  private int fuel;
  private int hSpeed;
  private int vSpeed;
  private boolean crashed;

  public Shuttle(Chromosome chromosome, Terrain terrain, int fuel, int startX, int startY, int hSpeed, int vSpeed) {
    this.chromosome = chromosome;
    this.terrain = terrain;
    x = new ArrayList<>();
    y = new ArrayList<>();
    x.add(startX);
    y.add(startY);
    this.fuel = fuel;
    this.crashed = false;
    this.hSpeed = hSpeed;
    this.vSpeed = vSpeed;
  }

  public void computePath() {
    int lastX, lastY;
    for (int i = 1; i < chromosome.getChromo().size(); i++) {
      Gene gene = chromosome.getGene(i);
      if (fuel < 0) {
        crashed = true;
        break;
      }
      fuel -= gene.getPower();
      if (fuel < 0) {
        crashed = true;
        break;
      }
      lastX = x.get(i-1);
      lastY = y.get(i-1);
      hSpeed -= (int) (0.5*(Math.sin(Math.toRadians(gene.getRotate())) * gene.getPower()));
      vSpeed += (int) (0.5*(Math.cos(Math.toRadians(gene.getRotate())) * gene.getPower() - 3.711));
      int newX = lastX + hSpeed;
      int newY = lastY + vSpeed;
      x.add(newX);
      y.add(newY);
      int terrainHeight = terrain.getHeight(newX);
      if (terrainHeight > newY || newX < 0 || newX >= 7000 || newY >= 3000) {
        crashed = true;
        break;
      }
      if (terrainHeight == newY && terrain.isFlat(newX) && gene.getRotate() == 0 && vSpeed <= 40 && hSpeed <= 20) {
        crashed = false;
        break;
      }
      crashed = true;
    }

  }

  public List<Integer> getX() {
    return this.x;
  }

  public List<Integer> getY() {
    return this.y;
  }

  public boolean isCrashed() {
    return this.crashed;
  }

  public String toPolyLine() {
    String line = "";
    for (int i=0; i<this.x.size(); i++) {
      line += x.get(i) + "," + y.get(i);
      if (i+1 < x.size()) line += " ";
    }
    return line;
  }
}
