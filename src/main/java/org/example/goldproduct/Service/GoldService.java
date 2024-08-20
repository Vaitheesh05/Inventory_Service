package org.example.goldproduct.Service;
import org.example.goldproduct.Model.GoldProduct;
import org.example.goldproduct.Repository.GoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GoldService {
    @Autowired
    GoldRepository goldRepository;

    public List<GoldProduct> getGoldProducts() {
        return goldRepository.findAll();
    }

    public void deleteGoldProducts(String huid) {
        goldRepository.deleteById(huid);
    }

    public GoldProduct addProduct(GoldProduct product){

        goldRepository.save(product);
        return product;
    }

    public void updateProduct(GoldProduct product) {
        goldRepository.save(product);
    }
}
