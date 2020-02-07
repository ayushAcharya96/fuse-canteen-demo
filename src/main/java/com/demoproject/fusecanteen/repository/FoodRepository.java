package com.demoproject.fusecanteen.repository;

import com.demoproject.fusecanteen.document.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Food, String> {
}
