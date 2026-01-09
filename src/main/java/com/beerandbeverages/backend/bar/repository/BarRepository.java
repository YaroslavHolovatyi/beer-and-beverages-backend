package com.beerandbeverages.backend.bar.repository;
import com.beerandbeverages.backend.bar.entity.Bar;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, String>, JpaSpecificationExecutor<Bar> {
}
