package de.dthomas.marslander;

import de.dthomas.marslander.model.TestCase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
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
    model.addAttribute("terrainX", terrainX);
    model.addAttribute("terrainY", terrainY);
    return "index";
  }

}
