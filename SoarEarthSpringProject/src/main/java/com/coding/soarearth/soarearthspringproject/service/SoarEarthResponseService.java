package com.coding.soarearth.soarearthspringproject.service;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.model.response.GenericSuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SoarEarthResponseService {

    public ResponseEntity<GenericSuccessResponse> createSoarEarthSuccessForPostResponse(SoarEarthPois soarEarthPoi, HttpServletRequest request) {

        GenericSuccessResponse genericSuccessResponse = new GenericSuccessResponse();

        genericSuccessResponse.setMessage("Soar Earth POI data has been successfully created");
        genericSuccessResponse.setCode(HttpStatus.CREATED.value());
        genericSuccessResponse.setData(soarEarthPoi);
        genericSuccessResponse.setErrorMessage(null);
        genericSuccessResponse.setTimestamp(Timestamp.from(Instant.now()));
        genericSuccessResponse.setPath(request.getContextPath());
        genericSuccessResponse.setMethod(request.getMethod());
        log.info("Response  :: {}",genericSuccessResponse.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(genericSuccessResponse);


    }

    public ResponseEntity<GenericSuccessResponse> createSoarEarthSuccessForUpdateResponse(SoarEarthPois soarEarthPoi, HttpServletRequest request) {

        GenericSuccessResponse genericSuccessResponse = new GenericSuccessResponse();

        genericSuccessResponse.setMessage("Soar Earth POI data has been successfully updated");
        genericSuccessResponse.setCode(HttpStatus.OK.value());
        genericSuccessResponse.setData(soarEarthPoi);
        genericSuccessResponse.setErrorMessage(null);
        genericSuccessResponse.setTimestamp(Timestamp.from(Instant.now()));
        genericSuccessResponse.setPath(request.getContextPath());
        genericSuccessResponse.setMethod(request.getMethod());
        log.info("Response  :: {}",genericSuccessResponse.toString());

        return ResponseEntity.status(HttpStatus.OK).body(genericSuccessResponse);


    }


    public ResponseEntity<GenericSuccessResponse> createSoarEarthSuccessForGetResponse(Optional<SoarEarthPois> soarEarthPois, HttpServletRequest request) {
        GenericSuccessResponse genericSuccessResponse = new GenericSuccessResponse();

        genericSuccessResponse.setMessage("Soar Earth Get POI request processed");
        genericSuccessResponse.setCode(HttpStatus.OK.value());
        if(soarEarthPois.isPresent())
            genericSuccessResponse.setData(soarEarthPois.get());
        else
            genericSuccessResponse.setData("No POI Data available for the ID");
        genericSuccessResponse.setErrorMessage(null);
        genericSuccessResponse.setTimestamp(Timestamp.from(Instant.now()));
        genericSuccessResponse.setPath(request.getContextPath());
        genericSuccessResponse.setMethod(request.getMethod());
        log.info("Response  :: {}",genericSuccessResponse.toString());

        return ResponseEntity.status(HttpStatus.OK).body(genericSuccessResponse);

    }

    public ResponseEntity<GenericSuccessResponse> createSoarEarthSuccessForGetWithinRadiusResponse(List<SoarEarthPois> soarEarthPois, HttpServletRequest request) {
        GenericSuccessResponse genericSuccessResponse = new GenericSuccessResponse();

        genericSuccessResponse.setMessage("Soar Earth Get POI request processed");
        genericSuccessResponse.setCode(HttpStatus.OK.value());
        genericSuccessResponse.setData(soarEarthPois);
        genericSuccessResponse.setErrorMessage(null);
        genericSuccessResponse.setTimestamp(Timestamp.from(Instant.now()));
        genericSuccessResponse.setPath(request.getContextPath());
        genericSuccessResponse.setMethod(request.getMethod());
        log.info("Response  :: {}",genericSuccessResponse.toString());

        return ResponseEntity.status(HttpStatus.OK).body(genericSuccessResponse);
    }
}
