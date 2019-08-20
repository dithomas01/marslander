package de.dthomas.marslander;

import de.dthomas.marslander.ga.Chromosome;
import de.dthomas.marslander.ga.Darwin;
import de.dthomas.marslander.ga.Population;
import de.dthomas.marslander.model.TerrainData;
import de.dthomas.marslander.model.TestCase;
import de.dthomas.marslander.model.ViewData;
import de.dthomas.marslander.shuttle.Shuttle;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DarwinController {
  private TestCase testCase;
  private Darwin darwin;

  @RequestMapping("/bla")
  public String bla(Model model) {
    List<Integer> terrainX;
    List<Integer> terrainY;
    TestCaseLoader testCaseLoader = new TestCaseLoader(0);
    try {
      testCase = testCaseLoader.loadTestCase();
    } catch(IOException ex) {
      System.err.println(ex);
      return "error";
    }
    terrainX = testCase.getTerrain().getXasList();
    terrainY = testCase.getTerrain().getYasList();
    model.addAttribute("terrainX", terrainX);
    model.addAttribute("terrainY", terrainY);
    return "darwintest2";
  }

  @MessageMapping("/terrain")
  @SendTo("/plot/terrain")
  public TerrainData plotTerrain(String terrain) {
    TestCaseLoader testCaseLoader = new TestCaseLoader(Integer.valueOf(terrain));
    try {
      testCase = testCaseLoader.loadTestCase();
    } catch(IOException ex) {
      System.err.println(ex);
    }
    return new TerrainData(testCase.getTerrain().getXasList(),
        testCase.getTerrain().getYasList());
  }

  @MessageMapping("/simStart")
  @SendTo("/plot/sim")
  public ViewData greeting(){
    Population population = new Population();
    population.init(40, 60);
    String[] lines = new String[population.getPopu().size()];
    Boolean[] crashes = new Boolean[population.getPopu().size()];
    Chromosome chromosome;
    List<Shuttle> shuttles = new ArrayList<>();
    for (int i = 0; i < population.getPopu().size(); i++) {
      chromosome = population.getChromosome(i);
      Shuttle shuttle = new Shuttle(chromosome, testCase.getTerrain(), testCase.getFuel(), testCase.getX(),
          testCase.getY(), testCase.gethSpeed(), testCase.getvSpeed());
      shuttle.computePath();
      lines[i] = shuttle.toPolyLine();
      crashes[i] = shuttle.isCrashed();
      shuttles.add(shuttle);
    }
    return new ViewData(lines, crashes);
  }


}
