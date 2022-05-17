package lt.bit.products.ui.controller;

import lt.bit.products.ui.model.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lt.bit.products.ui.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductsController {

    private ProductService service;

    ProductsController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    String showProducts(Model model) {
        List<Product> products = service.getProducts();
        model.addAttribute("productItems", products);
        return "productList";

    }
    @GetMapping("/products/{id}")
    String editProduct(@PathVariable UUID id, Model model) {
        model.addAttribute("productItem", service.getProduct(id));
        return "productForm";

    }

}
