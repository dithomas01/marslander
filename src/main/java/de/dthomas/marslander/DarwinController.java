package de.dthomas.marslander;

import de.dthomas.marslander.ga.Darwin;
import de.dthomas.marslander.ga.Population;
import de.dthomas.marslander.model.TestCase;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DarwinController {
  private TestCase testCase;
  private Darwin darwin;


}
