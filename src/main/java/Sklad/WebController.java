package Sklad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String getHomepage(){
        return "homepage";
    }
    @RequestMapping("/create_arrivaldocument")
    public String createArrivalDocument()
    {
        return "create_arrivaldocument";
    }
}
