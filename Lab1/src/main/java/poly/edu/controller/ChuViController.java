package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChuViController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/poly/chuvi")
    public String showForm() {
        return "chuvi";
    }

    @PostMapping("/rectangle/calc")
    public String calculate(Model model) {

        try {
            double length = Double.parseDouble(request.getParameter("length"));
            double width = Double.parseDouble(request.getParameter("width"));
            if (length < 0 || width < 0) {
                model.addAttribute("error", "Vui lòng nhập số dương!");
            }
            else {
                if(length < width) {
                    Double length2 = length;
                    Double width2 = width;
                    length = width2;
                    width = length2;
                }
                double area = length * width;
                double perimeter = 2 * (length + width);
                model.addAttribute("area", length + "*" + width +"="+area);
                model.addAttribute("perimeter", 2+"*"+"("+ length + "+" + width + ")="+perimeter);
                model.addAttribute("length", length);
                model.addAttribute("width", width);
            }
        } catch (Exception e) {
            model.addAttribute("area", null);
            model.addAttribute("perimeter", null);
            model.addAttribute("error", "Vui lòng nhập số hợp lệ!");
        }

        return "chuvi";
    }
}
