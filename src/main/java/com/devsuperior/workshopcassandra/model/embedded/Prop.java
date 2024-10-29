package com.devsuperior.workshopcassandra.model.embedded;

import com.devsuperior.workshopcassandra.model.enums.PropType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@UserDefinedType("prop")
public class Prop {

    private String name;
    private String value;
    private PropType type;
}
