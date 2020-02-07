package com.demoproject.fusecanteen.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "Orders")
@Data
public class Order {
    @Id
    private String id;
    private String userId;
    private List<Food> orders;
    private String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
    private double totalPrice;
    private String schedule;
    private String status = "PENDING";
}
