package com.coding.soarearth.soarearthspringproject.service;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.exception.SoarEarthException;
import com.coding.soarearth.soarearthspringproject.exception.SoarEarthValidationException;
import com.coding.soarearth.soarearthspringproject.model.response.GenericSuccessResponse;
import com.coding.soarearth.soarearthspringproject.repository.SoarEarthPoisRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SoarEarthPoisService implements SoarEarthPoisServiceInterface {

    @Autowired
    SoarEarthPoisRepository soarEarthPoisRepository;

    @Autowired
    SoarEarthResponseService soarEarthResponseService;

    private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    @Override
    public ResponseEntity<GenericSuccessResponse> getAllSoarEarthPoisWithinRadius(double latitude, double longitude, double radius,HttpServletRequest request) {
        Point pointToLook = factory.createPoint(new Coordinate(longitude, latitude));
        List<SoarEarthPois> soarEarthPois = soarEarthPoisRepository.findPoiWithinDistance(pointToLook, radius).orElseThrow(() -> new SoarEarthValidationException("404","No POI Data within the provided radius"));
        return soarEarthResponseService.createSoarEarthSuccessForGetWithinRadiusResponse(soarEarthPois,request);
    }
    @Override
    public ResponseEntity<GenericSuccessResponse> getSoarEarthPoisById(Integer id,HttpServletRequest request) {
        Optional<SoarEarthPois> soarEarthPois =  soarEarthPoisRepository.findById(id);
        return soarEarthResponseService.createSoarEarthSuccessForGetResponse(soarEarthPois,request);
    }
    @Override
    public ResponseEntity<GenericSuccessResponse> saveSoarEarthPoi(SoarEarthPois soarEarthPoi, HttpServletRequest request) {
        log.info("saveSoarEarthPoi --> Started");
        soarEarthPoi.setLocation((Point)factory.createPoint(new Coordinate(soarEarthPoi.getLongitude(), soarEarthPoi.getLatitude())));
        log.info("The location value is :: "+soarEarthPoi.getLocation());
        soarEarthPoisRepository.save(soarEarthPoi);
        log.info("The POI data has been successfully created");
        return soarEarthResponseService.createSoarEarthSuccessForPostResponse(soarEarthPoi,request);
    }
    @Override
    public ResponseEntity<GenericSuccessResponse> updateSoarEarthPoi(Integer id, SoarEarthPois soarEarthPoi,HttpServletRequest request) {
        log.info("updateSoarEarthPoi --> Started");
        SoarEarthPois soarEarthPoi_tobeupdated = soarEarthPoisRepository.findById(id).orElseThrow(() -> new SoarEarthException("404","SoarEarthPoi Data not found to be updated"));
        double latitude = soarEarthPoi_tobeupdated.getLatitude();
        double longitude = soarEarthPoi_tobeupdated.getLongitude();
        if(!StringUtils.isEmpty(soarEarthPoi.getCategory()))
            soarEarthPoi_tobeupdated.setCategory(soarEarthPoi.getCategory());
        if(!StringUtils.isEmpty(soarEarthPoi.getDescription()))
            soarEarthPoi_tobeupdated.setDescription(soarEarthPoi.getDescription());
        if(!StringUtils.isEmpty(String.valueOf(soarEarthPoi.getLatitude()))){
            if(soarEarthPoi.getLatitude() < -90 || soarEarthPoi.getLatitude() > 90)
                throw new SoarEarthValidationException("422","Latitude is invalid");
            soarEarthPoi_tobeupdated.setLatitude(soarEarthPoi.getLatitude());
            latitude = soarEarthPoi.getLatitude();

        }

        if(!StringUtils.isEmpty(String.valueOf(soarEarthPoi.getLongitude()))) {
            if(soarEarthPoi.getLongitude() < -180 || soarEarthPoi.getLongitude() > 180)
                throw new SoarEarthValidationException("422","Longitude is invalid");
            soarEarthPoi_tobeupdated.setLongitude(soarEarthPoi.getLongitude());
            longitude = soarEarthPoi.getLongitude();
        }
        soarEarthPoi_tobeupdated.setLocation((Point)factory.createPoint(new Coordinate(latitude, longitude)));
        if(!StringUtils.isEmpty(soarEarthPoi.getName()))
            soarEarthPoi_tobeupdated.setName(soarEarthPoi.getName());
        soarEarthPoisRepository.save(soarEarthPoi_tobeupdated);
        log.info("The POI data successfully updated");
        return soarEarthResponseService.createSoarEarthSuccessForUpdateResponse(soarEarthPoi_tobeupdated,request);
    }

    @Override
    public ResponseEntity<Object> deleteSoarEarthPois(Integer id) {
        log.info("deleteSoarEarthPoi --> Started");
        SoarEarthPois SoarEarthPois = soarEarthPoisRepository.findById(id).orElseThrow(() -> new SoarEarthException("404","SoarEarthPoi Data not found to be deleted"));
        soarEarthPoisRepository.delete(SoarEarthPois);
        return ResponseEntity.status(204).build();
    }
}
