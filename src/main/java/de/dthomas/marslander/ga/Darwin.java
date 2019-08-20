package de.dthomas.marslander.ga;

import de.dthomas.marslander.shuttle.Shuttle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Darwin {
  private List<Shuttle> oldShuttles;
  private Population newPopu;
  private int size;
  private int bestNumber;
  private int rndNumber;

  public Population populateNew() {
    Collections.sort(oldShuttles, Collections.reverseOrder());
    List <Chromosome> list = new ArrayList<>();
    for (int i = 0; i < bestNumber; i++) {
      list.add(oldShuttles.remove(0).getChromosome());
    }
    Random random = new Random();
    for (int i=bestNumber; i<rndNumber; i++) {
      list.add(oldShuttles.remove(random.nextInt(oldShuttles.size())).getChromosome());
    }
    int rest = size - list.size();
    int rndChromo;
    double rndGene;
    Chromosome chromosome01;
    Chromosome chromosome02;
    for (int i = 0; i < rest; i++) {
      rndChromo = random.nextInt(rndNumber);
      chromosome01 = list.get(rndChromo);
      int tmp = random.nextInt(rndNumber);
      while (tmp==rndChromo) {
        tmp = random.nextInt(rndNumber);
      }
      chromosome02 = list.get(tmp);
      rndGene = random.nextInt(11) / 10.0;
      list.add(new Chromosome.Builder().weight(chromosome01, chromosome02,
          list.get(i).getChromo().size(), rndGene).build());
    }
    newPopu.setPopu(list);
    return newPopu;
  }

  public static class Builder {
    private List<Shuttle> oldShuttles;

    public Builder(List<Shuttle> oldShuttles) {
      this.oldShuttles = oldShuttles;
    }

    public Darwin build() {
      return new Darwin(this);
    }
  }

  private Darwin(Builder builder) {
    this.oldShuttles = builder.oldShuttles;
    this.newPopu = new Population();
    this.size = oldShuttles.size();
    this.bestNumber = Math.round((float) size*3/10);
    this.rndNumber = Math.round((float) size*1/5) + this.bestNumber;
  }

  private void sortOldShuttles() {
    oldShuttles.sort((Shuttle shuttle1, Shuttle shuttle2) -> {
      return shuttle2.compareTo(shuttle1);
    });
  }

  public Population getNewPopu() {
    return this.newPopu;
  }
}
