package com.coding.soarearth.soarearthspringproject.controllers;

import com.coding.soarearth.soarearthspringproject.Validators.SoarEarthValidator;
import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.model.response.GenericSuccessResponse;
import com.coding.soarearth.soarearthspringproject.service.SoarEarthPoisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("soarearth/api")
@Tag(name = "Soar Earth Location-Based Services API's")
public class SoarEarthController {

    @Autowired
    private SoarEarthPoisService soarEarthPoisService;

    @Autowired
    SoarEarthValidator soarEarthValidator;

    @Operation(summary = "Retrieve POIs within a radius", description = "All Location within provided radius would be listed")
    @GetMapping("/pois")
    public ResponseEntity<GenericSuccessResponse> getAllPois(@RequestParam double latitude,@RequestParam double longitude,@RequestParam double radius,HttpServletRequest request) {
        log.info("getAllPoisWithinRadius(-) Started");
        return soarEarthPoisService.getAllSoarEarthPoisWithinRadius(latitude,longitude,radius*1000,request);
    }

    @Operation(summary = "Retrieve POI based on ID", description = "Location data based on POI")
    @GetMapping("/pois/{id}")
    public ResponseEntity<GenericSuccessResponse> getSoarEarthPoisById(@PathVariable Integer id,HttpServletRequest request) {
        log.info("getStudentById(-) Started");
        return soarEarthPoisService.getSoarEarthPoisById(id,request);
    }

    @Operation(summary = "Post Location Detail", description = "Location details would be saved along with Geometry and POI")
    @PostMapping("/pois")
    public ResponseEntity<GenericSuccessResponse> createSoarEarthPoiData(@RequestBody SoarEarthPois soarEarthPois, HttpServletRequest request) {
        log.info("createSoarEarthPois(-) Started");
        soarEarthValidator.validatePostSoarEarthPoi(soarEarthPois);
        return soarEarthPoisService.saveSoarEarthPoi(soarEarthPois,request);
    }

    @Operation(summary = "Update Location Detail", description = "Location details would be updated along with Geometry and POI")
    @PutMapping("/pois/{id}")
    public ResponseEntity<GenericSuccessResponse> updateSoarEarthPoi(@PathVariable Integer id, @RequestBody SoarEarthPois soarEarthPois,HttpServletRequest request){
        log.info("updateSoarEarthPoi(-) Started");
           return soarEarthPoisService.updateSoarEarthPoi(id, soarEarthPois,request);
    }

    @Operation(summary = "Delete Location Detail", description = "Delete location detail based on POI")
    @DeleteMapping("/pois/{id}")
    public ResponseEntity<Object> deleteSoarEarth(@PathVariable Integer id) {
        log.info("deleteSoarEarthPoi --> Started");
            return soarEarthPoisService.deleteSoarEarthPois(id);

    }
}
