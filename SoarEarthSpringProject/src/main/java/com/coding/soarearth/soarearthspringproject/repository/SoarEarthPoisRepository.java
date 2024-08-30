package com.coding.soarearth.soarearthspringproject.repository;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoarEarthPoisRepository extends JpaRepository<SoarEarthPois, Integer> {

    @Query(value = "SELECT * FROM soarearthproject_pois where ST_DistanceSphere(location, :p) < :radius", nativeQuery = true)
    Optional<List<SoarEarthPois>> findPoiWithinDistance(Point p, double radius);

}
