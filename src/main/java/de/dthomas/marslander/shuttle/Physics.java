package de.dthomas.marslander.shuttle;

public final class Physics {
  private static final float GRAVITY = -3.711f;
  private static final int MAXSPEED = 500;
  static final int SAFE_DISTANCE = 50;

  public static boolean speedWithinLimit(int hs, int vs) {
    return Math.abs(hs) < MAXSPEED && Math.abs(vs) < MAXSPEED;
  }

  public static int calcAngle(int hs, int vs) {
    double speed = Math.sqrt(hs*hs + vs*vs);
    double angle = Math.asin((double) hs / speed);
    return (int)Math.toDegrees(angle);
  }
}
