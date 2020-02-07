package com.demoproject.fusecanteen.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestedFood {

    private User user;
    private Food food;
}
