package com.backendIntegrador.repository;


import com.backendIntegrador.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


<<<<<<< HEAD

=======
>>>>>>> 477f01feefd8ac5de7d015c30cd7594127022bb9
@Repository
public interface PolicyRepository extends MongoRepository<Policy, String> {
    @Query(value = "{'policyName' : ?0 }")
    Policy findByPolicyName ( String policyName);


}
