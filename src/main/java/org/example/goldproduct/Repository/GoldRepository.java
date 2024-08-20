package org.example.goldproduct.Repository;

import org.example.goldproduct.Model.GoldProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoldRepository extends JpaRepository<GoldProduct, String> {

}
