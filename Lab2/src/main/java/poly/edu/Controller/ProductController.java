package poly.edu.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.entity.product;

import java.util.*;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model) {
        product p = new product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p1", p);
        model.addAttribute("p2", new product());
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save( @ModelAttribute("p2") product p, Model model) {
        model.addAttribute("p1", new product("iPhone 30", 5000.0));
        model.addAttribute("p2", p);
        return "product/form";
    }
    @ModelAttribute("items")
    public List<product> getItems() {
        return Arrays.asList(
                new product("p1", 10.0),
                new product("p2", 20.0),
                new product("p3", 30.0),
                new product("p4", 40.0),
                new product("p5", 50.0),
                new product("p6", 60.0),
                new product("p7", 70.0),
                new product("p8", 80.0),
                new product("p9", 90.0),
                new product("p10", 100.0),
                new product("p11", 110.0),
                new product("p12", 120.0),
                new product("p13", 130.0),
                new product("p14", 140.0),
                new product("p15", 150.0),
                new product("p16", 160.0),
                new product("p17", 170.0),
                new product("p18", 180.0),
                new product("p19", 190.0),
                new product("p20", 200.0)
        );
    }
}
