package de.dthomas.marslander.ga;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {
  private List<Gene> chromo;

  public static class Builder {
    private List<Gene> chromo;

    public Builder() { chromo = new ArrayList<>(); }

    public Builder randomize(int size) {
      this.chromo.add(new Gene.Builder().randomize().build());
      for (int i = 1; i < size; i++) {
        this.chromo.add(new Gene.Builder()
            .randomize(chromo.get(i-1).getRotate(), chromo.get(i-1).getPower())
            .build());
      }
      return this;
    }

    public Chromosome build() {
      return new Chromosome(this);
    }
  }

  public Chromosome(List<Gene> chromo) {
    this.chromo = chromo;
  }

  public Chromosome(Builder builder) { this.chromo = builder.chromo; }

  public Chromosome() {
    this.chromo = new ArrayList<>();
  }

  public List<Gene> getChromo() {
    return this.chromo;
  }

  public Gene getGene(int i) {
    return this.chromo.get(i);
  }

  public void setChromo(List<Gene> chromo) {
    this.chromo = chromo;
  }
}
