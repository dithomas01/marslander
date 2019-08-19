package de.dthomas.marslander;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
  @RequestMapping("/error")
  public ModelAndView handleError(HttpServletRequest request, Model model) {
    Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
    ModelAndView errorPage = new ModelAndView("error");
    String errorMsg = "";

    switch (statusCode) {
      case 400: {
        errorMsg = "Http Error Code: 400. Bad Request";
        break;
      }
      case 401: {
        errorMsg = "Http Error Code: 401. Unauthorized";
        break;
      }
      case 404: {
        errorMsg = "Http Error Code: 404. Resource not found";
        break;
      }
      case 500: {
        errorMsg = "Http Error Code: 500. Internal Server Error";
        break;
      }
    }
    errorPage.addObject("errorMsg", errorMsg);
    errorPage.addObject("exception", exception);
    return errorPage;
  }


  @Override
  public String getErrorPath() {
    return "error";
  }
}
