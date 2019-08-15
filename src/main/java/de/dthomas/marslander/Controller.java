package de.dthomas.marslander;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    List<Integer> terrainX = new ArrayList<Integer>();
    List<Integer> terrainY = new ArrayList<Integer>();
    for (int i = 0; i<x.length; i++) {
      terrainX.add(x[i]);
      terrainY.add(y[i]);
    }
    model.addAttribute("terrainX", terrainX);
    model.addAttribute("terrainY", terrainY);
    return "index";
  }

}
