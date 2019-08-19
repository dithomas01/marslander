package de.dthomas.marslander;

import de.dthomas.marslander.ga.Chromosome;
import de.dthomas.marslander.ga.Population;
import de.dthomas.marslander.model.TestCase;
import de.dthomas.marslander.shuttle.Shuttle;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@EnableAutoConfiguration
public class Controller {
  int[] x = new int[] {0, 1000, 1500, 3000, 4000, 5500, 6999};
  int[] y = new int[] {100, 500, 1500, 1000, 150, 150, 800};
  int z = 5;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Model model) {
    List<Integer> terrainX;
    List<Integer> terrainY;
    TestCaseLoader testCaseLoader = new TestCaseLoader(0);
    TestCase testCase;
    try {
      testCase = testCaseLoader.loadTestCase();
    } catch(IOException ex) {
      System.err.println(ex);
        return "error";
    }
    terrainX = testCase.getTerrain().getXasList();
    terrainY = testCase.getTerrain().getYasList();
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
    model.addAttribute("terrainX", terrainX);
    model.addAttribute("terrainY", terrainY);
    model.addAttribute("lines", lines);
    model.addAttribute("isCrashed", crashes);
    return "index";
  }

  @RequestMapping("/bla")
  public String bla(Model model) {
    List<Integer> terrainX;
    List<Integer> terrainY;
    TestCaseLoader testCaseLoader = new TestCaseLoader(0);
    TestCase testCase;
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

  @RequestMapping("/bla2")
  public String bla2(Model model) {
    List<Integer> terrainX;
    List<Integer> terrainY;
    TestCaseLoader testCaseLoader = new TestCaseLoader(0);
    TestCase testCase;
    try {
      testCase = testCaseLoader.loadTestCase();
    } catch(IOException ex) {
      System.err.println(ex);
      return "error";
    }
    terrainX = testCase.getTerrain().getXasList();
    terrainY = testCase.getTerrain().getYasList();
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
    model.addAttribute("terrainX", terrainX);
    model.addAttribute("terrainY", terrainY);
    model.addAttribute("lines", lines);
    model.addAttribute("isCrashed", crashes);
    return "darwintest2";
  }

  @MessageMapping("/newData")
  @SendTo("/topic/greetings")
  public Population greeting() throws Exception {
    Thread.sleep(1000); // simulated delay
    Population population = new Population();
    population.init(40, 60);
    return population;
  }
}
