package com.Prasun.eCom.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL) // Customer delete gareyo bhane address pani delete hunxa. Hamile cascade tye bhayera Product ma use na gareko. If product delete gareyo bhane category delete hunu hudaina.
    @JoinColumn(name = "address_id")

    private Address address;

    @OneToOne(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    private Cart cart;
}
