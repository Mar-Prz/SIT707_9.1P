package web.handler;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.service.LoginService;
import web.service.MathQuestionService;
import web.service.ValidationException;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    private static final Logger logger = LoggerFactory.getLogger(RoutingServlet.class);

    @GetMapping("/")
    public String welcome() {
        return "view-welcome";
    }

    @GetMapping("/pass")
    public String pass() {
        return "view-pass";
    }

    @GetMapping("/login")
    public String loginView() {
        return "view-login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        logger.debug("Login attempt with username: {}, dob: {}", username, dob);

        if (username == null || username.isEmpty() || password == null || password.isEmpty() || dob == null || dob.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "All fields are required.");
            return "redirect:/login";
        }

        if (LoginService.login(username, password, dob)) {
            return "redirect:/q1";
        } else {
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
            return "redirect:/login";
        }
    }

    @GetMapping("/q1")
    public String q1View() {
        return "view-q1";
    }

    @PostMapping("/q1")
    public String q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        logger.debug("Q1 attempt with number1: {}, number2: {}, resultUser: {}", number1, number2, resultUser);

        try {
            Double calculatedResult = MathQuestionService.q1Addition(number1, number2);
            logger.debug("Calculated result for Q1: {}", calculatedResult);
            if (!calculatedResult.equals(Double.valueOf(resultUser))) {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return "redirect:/q1";
            } else {
                return "redirect:/q2";
            }
        } catch (ValidationException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/q1";
        }
    }

    @GetMapping("/q2")
    public String q2View() {
        return "view-q2";
    }

    @PostMapping("/q2")
    public String q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        logger.debug("Q2 attempt with number1: {}, number2: {}, resultUser: {}", number1, number2, resultUser);

        try {
            Double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
            logger.debug("Calculated result for Q2: {}", calculatedResult);
            if (!calculatedResult.equals(Double.valueOf(resultUser))) {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return "redirect:/q2";
            } else {
                return "redirect:/q3";
            }
        } catch (ValidationException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/q2";
        }
    }

    @GetMapping("/q3")
    public String q3View() {
        return "view-q3";
    }

    @PostMapping("/q3")
    public String q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        logger.debug("Q3 attempt with number1: {}, number2: {}, resultUser: {}", number1, number2, resultUser);

        try {
            Double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
            logger.debug("Calculated result for Q3: {}", calculatedResult);
            if (!calculatedResult.equals(Double.valueOf(resultUser))) {
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
                return "redirect:/q3";
            } else {
                return "redirect:/pass";
            }
        } catch (ValidationException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/q3";
        }
    }
}