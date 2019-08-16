package de.dthomas.marslander.ga;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {
  private List<Gene> chromo;

  public static class Builder {
    private List<Gene> chromo;

    public Builder() { chromo = new ArrayList<>(); }

    public Builder randomize(int size) {
      for (int i = 0; i < size; i++) {
        this.chromo.add(new Gene.Builder().randomize().build());
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

  public void setChromo(List<Gene> chromo) {
    this.chromo = chromo;
  }
}
