package pl.sda.zdjavapol131.zdjavapol131.repository.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "price")

public class PricingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private int price;

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public int getId() {
        return id;
    }
}
