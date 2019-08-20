package de.dthomas.marslander.model;

public class ViewData {
  String[] lines;
  Boolean[] crashes;

  public ViewData(String[] lines, Boolean[] crashes) {
    this.lines = lines;
    this.crashes = crashes;
  }

  public String[] getLines() {
    return lines;
  }

  public Boolean[] getCrashes() {
    return crashes;
  }
}
