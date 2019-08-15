package de.dthomas.marslander;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
@EnableAutoConfiguration
public class Controller {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Model model) {
    return "index";
  }

}
