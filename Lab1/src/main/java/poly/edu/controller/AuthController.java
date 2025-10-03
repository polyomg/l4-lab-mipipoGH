package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    HttpServletRequest request;
    HttpServletResponse resp;
    @GetMapping("/poly/form")
    public String form() {
        return "form";
    }
    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

            if ("ngocanhngu".equals(username) && "honcho".equals(password)) {
                return "redirect:/poly/chuvi";
            } else {
                model.addAttribute("message", "Sai username hoặc password, vui lòng thử lại!");
                return "form";
            }

    }
}