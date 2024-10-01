package org.example.goldproduct.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    int customerid;
    String customername;
    String customerphone;
    String customeremail;
    String customergender;
    String customercity;
    String customerstate;

    @OneToMany
    GoldProduct product;


}
