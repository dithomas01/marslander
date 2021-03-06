package de.dthomas.marslander.ga;

import java.util.Random;

public class Gene {
  private int rotate;
  private int power;

  public static class Builder {
    private int rotate;
    private int power;
    private Random random;

    public Builder() {
      random = new Random();
    }

    public Builder setRotatePower(int rotate, int power) {
      this.rotate = rotate;
      this.power = power;
      return this;
    }

    public Builder randomize() {
      this.rotate = 0;
      this.power = random.nextInt(4);
      return this;
    }

    public Builder randomize(int lastRotate, int lastPower) {
      int tmp;
      do {
        tmp = random.nextInt(31) - 15 + lastRotate;
      } while(90 < Math.abs(tmp));
      this.rotate = tmp;
      do {
        tmp = random.nextInt(2) - 1 + lastPower;
      } while (0 > tmp && tmp > 4);
      this.power = tmp;
      return this;
    }

    public Gene build() {
      return new Gene(this);
    }
  }

  public Gene(Builder builder) {
    this.rotate = builder.rotate;
    this.power = builder.power;
  }

  public int getRotate() {
    return rotate;
  }

  public int getPower() {
    return power;
  }
}
