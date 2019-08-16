package de.dthomas.marslander.ga;

import java.util.ArrayList;
import java.util.List;

public class Population {
  private List<Chromosome> popu;

  public Population(List<Chromosome> popu) {
    this.popu = popu;
  }

  public Population() {
    this.popu = new ArrayList<>();
  }

  public Population init(int size) {
    if (popu.size() > 0) return this;
    popu.add(new Chromosome.Builder().randomize(size).build());
    return this;
  }

  public List<Chromosome> getPopu() {
    return popu;
  }

  public Chromosome getChromosome(int i) {
    return this.popu.get(i);
  }

  public void setPopu(List<Chromosome> popu) {
    this.popu = popu;
  }
}
