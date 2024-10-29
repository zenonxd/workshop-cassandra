package com.devsuperior.workshopcassandra.model.dtos;

import com.devsuperior.workshopcassandra.model.embedded.Prop;
import com.devsuperior.workshopcassandra.model.entities.Product;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private UUID id;
    private String department;
    private Double price;
    private Instant moment;
    private String name;
    private String description;

    private List<Prop> props = new ArrayList<>();

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.department = entity.getDepartment();
        this.price = entity.getPrice();
        this.moment = entity.getMoment();
        this.name = entity.getName();
        this.description = entity.getDescription();

        this.props.addAll(entity.getProps());
    }



}
