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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(value = "products")
public class Product {

    @PrimaryKey
    private UUID id;
    private String department;
    private Double price;
    private Timestamp moment;
    private String name;
    private String description;


    private List<@Frozen Prop> props = new ArrayList<>();
}
