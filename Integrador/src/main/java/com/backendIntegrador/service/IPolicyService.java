package com.backendIntegrador.service;

<<<<<<< HEAD
=======
import com.backendIntegrador.model.Category;
import com.backendIntegrador.model.Characteristic;
>>>>>>> 477f01feefd8ac5de7d015c30cd7594127022bb9
import com.backendIntegrador.model.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPolicyService {

    Policy save( Policy policy ) throws Exception;

    boolean delete( String id ) throws Exception;

<<<<<<< HEAD
    Page<Policy> findAll( Pageable pageable ) throws Exception;
=======
    Page<Policy> findAll(Pageable pageable ) throws Exception;
>>>>>>> 477f01feefd8ac5de7d015c30cd7594127022bb9

    List<Policy> findAllPolicies() throws Exception;

    Policy getPolicyById( String id ) throws Exception;

    @Transactional
    Policy getPolicyByPolicyName( String policyName );

<<<<<<< HEAD
    boolean checkPolicyName( String policyName );

    Policy update( Policy policy ) throws Exception;
=======
    boolean checkPolicyName(String policyName );

    Policy update( Policy policy ) throws Exception;

>>>>>>> 477f01feefd8ac5de7d015c30cd7594127022bb9
}
