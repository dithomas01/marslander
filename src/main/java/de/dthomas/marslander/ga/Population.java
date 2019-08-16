package de.dthomas.marslander.ga;

import java.util.ArrayList;
import java.util.List;

public class Population {
  private List<Chromosome> popu;
  private int size;

  public Population(List<Chromosome> popu) {
    this.popu = popu;
  }

  public Population() {
    this.popu = new ArrayList<>();
  }

  public void init(int PopSize, int ChromSize) {
    for (int i=0; i < PopSize; i++) {
      popu.add(new Chromosome.Builder().randomize(ChromSize).build());
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
