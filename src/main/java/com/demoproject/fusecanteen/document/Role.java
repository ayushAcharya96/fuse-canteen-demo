package com.demoproject.fusecanteen.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
    @Id
    @Getter
    private String id;
    @NonNull
    @Getter@Setter
    private String role;


}
