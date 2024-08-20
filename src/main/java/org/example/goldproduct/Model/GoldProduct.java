package org.example.goldproduct.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoldProduct {
    @Id
    @Column(name = "huid")
    private String huid;
    @Column(name = "productcode")
    private String productCode;
    @Column(name = "weight")
    private double weight;
    @Column(name = "description")
    private String Description;
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal Price;
    @Column(name = "stocks")
    private int stocks;
    @Column(name = "available")
    private boolean isAvailable;
    @Column(name = "type")
    private String type;
    @Column(name = "image")
    private String image;

}
