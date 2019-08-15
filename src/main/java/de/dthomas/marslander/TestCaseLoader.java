package de.dthomas.marslander;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dthomas.marslander.model.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestCaseLoader {
  private ObjectMapper objectMapper;
  private int caseNumber;
  private TestCase testCase;

  public TestCaseLoader(int caseNumber) {
    this.objectMapper = new ObjectMapper();
    this.caseNumber = caseNumber;
  }

  public TestCase loadTestCase() throws IOException {
    File json = new File("./src/main/resources/test.json");
    List<TestCase> tests = objectMapper.readValue(json, new TypeReference<List<TestCase>>(){});
    testCase = tests.get(caseNumber);
    return this.testCase;
  }

  public TestCase getTestCase() {
    return this.testCase;
  }
}
