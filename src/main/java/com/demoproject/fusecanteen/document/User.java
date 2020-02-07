package com.demoproject.fusecanteen.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Users")
@Data
public class User {

    @Id
    private String id;
    @NonNull
    private String userName;
    @NonNull
    private String role;
    @NonNull
    private String password;
}
