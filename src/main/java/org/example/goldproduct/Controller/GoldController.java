package org.example.goldproduct.Controller;

import org.example.goldproduct.Model.GoldProduct;
import org.example.goldproduct.Service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GoldController {

    private final GoldService service;

    @Autowired
    public GoldController(GoldService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<GoldProduct> getGoldProducts() {
        return service.getGoldProducts();
    }

    @PostMapping("/products/add")
    public ResponseEntity<?> addProduct(@ModelAttribute GoldProduct productJson) {
        try {
            GoldProduct product1 = service.addProduct(productJson);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/{huid}")
    public Optional<GoldProduct> searchProductById(@PathVariable String huid) {
        return service.searchproductid(huid);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable Long productId,
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("price") double price,
            @RequestParam("discount") double discount,
            @RequestParam("specialPrice") double specialPrice,
            @RequestParam("category") String categoryName,
            @RequestParam("image_url") List<String> imageUrl) {

        // Call the service layer to handle the business logic
        GoldProduct updatedProduct = service.updateProduct(
                productId, productName, description, quantity, price, discount, specialPrice, categoryName, imageUrl
        );

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }



    @DeleteMapping("/products/{huid}")
    public void deleteGoldProduct(@PathVariable String huid) {
        service.deleteGoldProducts(huid);
    }
}
