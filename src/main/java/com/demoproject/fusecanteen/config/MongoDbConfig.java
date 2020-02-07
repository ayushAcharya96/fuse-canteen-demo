package com.demoproject.fusecanteen.config;

import com.demoproject.fusecanteen.repository.FoodRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = FoodRepository.class)
@Configuration
public class MongoDbConfig {

}
