package com.demoproject.fusecanteen.document;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Foods")
@Data public class Food {

    @Id
    private String id;
    @NonNull
    private String food;
    @NonNull
    private double price;


}
