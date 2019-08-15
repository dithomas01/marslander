package de.dthomas.marslander.model;

public class TestCase {
  private String name;
  private Terrain terrain;
  private int x;
  private int y;
  private int hSpeed;
  private int vSpeed;
  private int fuel;
  private int rotate;
  private int power;

  public TestCase() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Terrain getTerrain() {
    return terrain;
  }

  public void setTerrain(Terrain terrain) {
    this.terrain = terrain;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int gethSpeed() {
    return hSpeed;
  }

  public void sethSpeed(int hSpeed) {
    this.hSpeed = hSpeed;
  }

  public int getvSpeed() {
    return vSpeed;
  }

  public void setvSpeed(int vSpeed) {
    this.vSpeed = vSpeed;
  }

  public int getFuel() {
    return fuel;
  }

  public void setFuel(int fuel) {
    this.fuel = fuel;
  }

  public int getRotate() {
    return rotate;
  }

  public void setRotate(int rotate) {
    this.rotate = rotate;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }
}
