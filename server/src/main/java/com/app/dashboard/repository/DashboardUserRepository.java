package com.app.dashboard.repository;

import com.app.dashboard.entity.DashboardUserPo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardUserRepository extends MongoRepository<DashboardUserPo, String> {

    @Query("{'userId' : ?0}")
    DashboardUserPo findUserByUserId(String userId);
}
