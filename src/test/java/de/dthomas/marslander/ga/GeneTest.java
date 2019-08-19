package de.dthomas.marslander.ga;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneTest {

  @Test
  public void buildGene() {
    Gene gene01 = new Gene.Builder().randomize().build();
    Assert.assertTrue(testPower(gene01.getPower()));
    Assert.assertEquals(gene01.getPower(), 0);
  }

  public boolean testPower(int power) {
    return (0 <= power && power <= 4);
  }

  public boolean testPower(int power, int lastPower) {
    return testPower(power) && Math.abs(power - lastPower) <= 1;
  }

  public boolean testRotate(int rotate) {
    return Math.abs(rotate) <= 90;
  }

  public boolean testRotate(int rotate, int lastRotate) {
    return testRotate(rotate) && Math.abs(rotate - lastRotate) <= 15;
  }
}
