package de.dthomas.marslander.model;

public class ViewData {
  String[] lines;
  Boolean[] crashes;
  int loopNumber;

  public ViewData(String[] lines, Boolean[] crashes, int loopNumber) {
    this.lines = lines;
    this.crashes = crashes;
    this.loopNumber = loopNumber;
  }

  public String[] getLines() {
    return lines;
  }

  public Boolean[] getCrashes() {
    return crashes;
  }

  public int getLoopNumber() {
    return loopNumber;
  }
}
