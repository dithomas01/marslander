package de.dthomas.marslander.ga;

import de.dthomas.marslander.shuttle.Shuttle;

import java.util.List;

public class Darwin {
  private List<Shuttle> oldShuttles;
  private Population newPopu;
  private int size;
  private int bestNumber;
  private int rndNumber;

  public Population populateNew() {
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
    this.bestNumber = Math.round(size*3/10);
    this.rndNumber = Math.round(size*1/5) + this.bestNumber;
  }

  public Population getNewPopu() {
    return this.newPopu;
  }
}
