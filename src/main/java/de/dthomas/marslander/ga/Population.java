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

  public void init(int popSize, int chromSize) {
    for (int i=0; i < popSize; i++) {
      popu.add(new Chromosome.Builder().randomize(chromSize).build());
    }
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
