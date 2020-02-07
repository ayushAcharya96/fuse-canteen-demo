package com.demoproject.fusecanteen.repository;

import com.demoproject.fusecanteen.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
}
