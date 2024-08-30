package com.coding.soarearth.soarearthspringproject.service;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.model.response.GenericSuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface SoarEarthPoisServiceInterface {

    public ResponseEntity<GenericSuccessResponse> getAllSoarEarthPoisWithinRadius(double latitude, double longitude, double radius, HttpServletRequest request);
    public ResponseEntity<GenericSuccessResponse> getSoarEarthPoisById(Integer id,HttpServletRequest request);
    public ResponseEntity<GenericSuccessResponse> saveSoarEarthPoi(SoarEarthPois soarEarthPoi, HttpServletRequest request);
    public ResponseEntity<GenericSuccessResponse> updateSoarEarthPoi(Integer id, SoarEarthPois soarEarthPoi,HttpServletRequest request);
    public ResponseEntity<Object> deleteSoarEarthPois(Integer id);


}
