package org.example.goldproduct.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.goldproduct.Model.GoldProduct;
import org.example.goldproduct.Service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GoldController {

    GoldService service;
     public String uploadDirectory=System.getProperty("user.dir") + "/src/main/webimage/images";
    @Autowired
    public GoldController(GoldService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<GoldProduct> getGoldProducts() {
        return service.getGoldProducts();
    }
    @PostMapping("/products/add")
    public ResponseEntity<?> addProduct( @RequestParam("product") String productJson,
                                         @RequestParam("image") MultipartFile imageFile){
        try {
            if (imageFile.isEmpty()) {
                return new ResponseEntity<>("Image file is missing", HttpStatus.BAD_REQUEST);
            }

            System.out.println(imageFile);
            ObjectMapper objectMapper = new ObjectMapper();
            GoldProduct product = objectMapper.readValue(productJson, GoldProduct.class);

            String originalFileName = imageFile.getOriginalFilename();
            Path fileNameandPath= Paths.get(uploadDirectory,originalFileName);
            Files.write(fileNameandPath, imageFile.getBytes());
            product.setImage(originalFileName);
            GoldProduct product1 = service.addProduct(product);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/products/update")
    public void updateProduct(@RequestBody GoldProduct product) {
        service.updateProduct(product);
    }
    @DeleteMapping("/products/{huid}")
    public void deleteGoldProduct(@PathVariable String huid) {
        service.deleteGoldProducts(huid);
    }
}
