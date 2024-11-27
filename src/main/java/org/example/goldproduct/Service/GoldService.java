package org.example.goldproduct.Service;
import org.example.goldproduct.Model.Category;
import org.example.goldproduct.Model.GoldProduct;
import org.example.goldproduct.Repository.CategoryRepository;
import org.example.goldproduct.Repository.GoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoldService {
    @Autowired
    GoldRepository goldRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<GoldProduct> getGoldProducts() {
        return goldRepository.findAll();
    }

    public void deleteGoldProducts(String huid) {
        goldRepository.deleteById(huid);
    }

    public Optional<GoldProduct> searchproductid(String huid){
        Optional<GoldProduct> one=goldRepository.findById(huid);
        return one;
    }

    public GoldProduct addProduct(GoldProduct product){

        goldRepository.save(product);
        return product;
    }


    public GoldProduct updateProduct(Long productId, String productName, String description, Integer quantity,
                                       double price, double discount, double specialPrice, String categoryName,
                                       List<String> imageUrl) {

        // Step 1: Find the existing Category or create a new one if it doesn't exist
        Category category = categoryRepository.findByCategoryName(categoryName);
        if (category == null) {
            category=new Category();
            category.setName(categoryName);
            category = categoryRepository.save(category);
        }

        // Step 2: Create the GoldProduct instance and set the fields
        GoldProduct goldProduct = new GoldProduct();
        goldProduct.setProductId(productId);
        goldProduct.setProductName(productName);
        goldProduct.setDescription(description);
        goldProduct.setQuantity(quantity);
        goldProduct.setPrice(price);
        goldProduct.setDiscount(discount);
        goldProduct.setSpecialPrice(specialPrice);
        goldProduct.setCategory(category);
        goldProduct.setImage_url(imageUrl);

        // Step 3: Save GoldProduct to the database
        return goldRepository.save(goldProduct);
    }
}
