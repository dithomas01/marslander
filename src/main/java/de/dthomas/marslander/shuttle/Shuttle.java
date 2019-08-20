package de.dthomas.marslander.shuttle;

import de.dthomas.marslander.ga.Chromosome;
import de.dthomas.marslander.ga.Gene;
import de.dthomas.marslander.model.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Shuttle implements Comparable<Shuttle> {
  private Chromosome chromosome;
  private Terrain terrain;
  private List<Integer> x;
  private List<Integer> y;
  private int fuel;
  private int hSpeed;
  private int vSpeed;
  private boolean crashed;
  private boolean wasFlat;

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
    wasFlat = false;
  }

  public void computePath() {
    int lastX;
    int lastY;
    for (int i = 1; i < chromosome.getChromo().size(); i++) {
      Gene gene = chromosome.getGene(i);
      fuel -= gene.getPower();
      if (fuel < -gene.getPower()) {
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
      if (terrainHeight > newY) {
        crashed = true;
        if (isFlat(newX)) wasFlat = true;
        break;
      }
      if (newX < 0 || newX >= 7000 || newY >= 3000) {
        crashed = true;
        break;
      }
      if (terrainHeight == newY && terrain.isFlat(newX) && gene.getRotate() == 0 && vSpeed <= 40 && hSpeed <= 20) {
        System.out.println("Success!!!");
        crashed = false;
        wasFlat = true;
        break;
      }
      crashed = true;
    }

  }

  public boolean isOverFlatGround(int x) {
    return terrain.isFlat(x);
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

  public Chromosome getChromosome() {
    return chromosome;
  }

  public int getFuel() {
    return fuel;
  }

  public int getvSpeed() {
    return vSpeed;
  }

  public int gethSpeed() {
    return hSpeed;
  }

  public String toPolyLine() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i=0; i<this.x.size(); i++) {
      stringBuilder.append(x.get(i) + "," + y.get(i));
      if (i+1 < x.size()) stringBuilder.append(" ");
    }
    return stringBuilder.toString();
  }

  @Override
  public String toString() {
    return "Shuttle for chromosome: " + chromosome.hashCode() + ": fuel = " + fuel + ", hSpeed = "
        + hSpeed + ", vSpeed = " + vSpeed + ", crashed = " + crashed + ", wasFlat = " + wasFlat;
  }

  /*public int compareTo(Shuttle shuttle) {
    if (!shuttle.isCrashed() && !shuttle.isCrashed()) {
      if (this.fuel > shuttle.getFuel()) {
        return 1;
      } else if (this.fuel == shuttle.getFuel()) {
        return 0;
      } else {
        return -1;
      }
    } else if (!this.crashed && shuttle.isCrashed()) {
      return 1;
    } else if (this.crashed && !shuttle.isCrashed()) {
      return -1;
    } else {
      if (wasFlat) {
        return 1;
      }
      return 0;
    }
  }*/

  public boolean isFlat(int x) {
    if (terrain.isFlat(x)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(Shuttle shuttle) {
    if (wasFlat && shuttle.wasFlat) {
      if (!this.crashed && shuttle.isCrashed()) {
        return -1;
      }
      return 0;
    } else if (wasFlat) {
      int returner = 1;
      if (Math.abs(this.chromosome.getGene(this.chromosome.getChromo().size()-1).getRotate()) -
          Math.abs(shuttle.getChromosome().getGene(shuttle.getChromosome().getChromo().size()-1).getRotate()) < 0) {
          returner++;
      }
      //TODO:iscrashed
      /*if (this.vSpeed <= 40) {
        returner++;
      } else if (shuttle.getvSpeed() <= 40) {
        returner--;
      }
      if (this.hSpeed <= 20) {
        returner ++;
      } else if (shuttle.gethSpeed() <= 20) {
        returner --;
      }*/
      return returner;
    } else {
      return -1;
    }
  }
}
