package Sklad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private ArrivalDocument arrivalDocument;
    private Product product;
    @Autowired
    public void setArrivalDocument(ArrivalDocument arrivalDocument) {
        this.arrivalDocument = arrivalDocument;
    }
    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }

    @RequestMapping("/")
    public String getHomepage(Model model)
    {
        ArrivalDocument arrivalDocument=new ArrivalDocument();
        model.addAttribute("document",arrivalDocument);
        List<Product> productList=new ArrayList<>();
        model.addAttribute("productList",productList);
        return "homepage";
    }
    @RequestMapping("/create_arrivaldocument")
    public String createArrivalDocument(Model model)
    {
        model.addAttribute("document",arrivalDocument);
        return "create_arrivaldocument";
    }
    @RequestMapping("/show_arrivaldocument")
    public String showArrivalDocument(@ModelAttribute(name = "document")ArrivalDocument document)
    {
        return "show_arrivaldocument";
    }
    @RequestMapping("/add_product")
    public String addProduct(Model model )
    {
        Product product=new Product();
        model.addAttribute("product",product);

        return "add_product";

    }
    @RequestMapping("/create_productlist")
    public String createProductList(Model model,@ModelAttribute(name="product") Product product)
    {

            System.out.println(product.getName());
            arrivalDocument.addProduct(product);
            model.addAttribute("productList",arrivalDocument.getProductList());


        return "create_productlist";
    }



}
