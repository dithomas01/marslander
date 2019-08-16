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

  public Chromosome init(int size) {
    if (popu.size() > 0) return popu.get(popu.size() - 1);
    this.size = size;
    popu.add(new Chromosome.Builder().randomize(size).build());
    return popu.get(0);
  }

  public Chromosome randNext() {
    //TODO:next angle +/-15°; next power +/-1
    return new Chromosome();
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
