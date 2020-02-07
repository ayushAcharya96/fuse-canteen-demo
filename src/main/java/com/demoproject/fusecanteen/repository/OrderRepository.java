package com.demoproject.fusecanteen.repository;

import com.demoproject.fusecanteen.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
