package com.devsuperior.workshopcassandra.model.entities;

import com.devsuperior.workshopcassandra.model.embedded.Prop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(value = "products")
public class Product {

    @Setter
    @PrimaryKey
    private UUID id;
    private String department;
    private Double price;
    private Instant moment;
    private String name;

    private String description;

    public List<@Frozen Prop> props = new ArrayList<>();

    public Product(UUID id, String department, Double price, Instant moment, String name, String description) {
        this.id = id;
        this.department = department;
        this.price = price;
        this.moment = moment;
        this.name = name;
        this.description = description;
    }
}
