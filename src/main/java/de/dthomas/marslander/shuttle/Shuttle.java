package de.dthomas.marslander.shuttle;

import de.dthomas.marslander.ga.Chromosome;
import de.dthomas.marslander.ga.Gene;

import java.util.ArrayList;
import java.util.List;

public class Shuttle {
  private Chromosome chromosome;
  private List<Integer> x;
  private List<Integer> y;
  private int fuel;
  private int hSpeed;
  private int vSpeed;
  private boolean crashed;

  public Shuttle(Chromosome chromosome, int fuel, int startX, int startY, int hSpeed, int vSpeed) {
    this.chromosome = chromosome;
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
    for (int i = 1; i < x.size(); i++) {
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
      x.add(lastX + hSpeed);
      y.add(lastY + vSpeed);
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
}
