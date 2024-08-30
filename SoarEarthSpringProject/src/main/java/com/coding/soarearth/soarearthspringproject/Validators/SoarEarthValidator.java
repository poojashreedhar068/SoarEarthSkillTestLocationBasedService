package com.coding.soarearth.soarearthspringproject.Validators;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.exception.SoarEarthValidationException;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SoarEarthValidator implements SoarEarthValidatorInterface {

    public void validatePostSoarEarthPoi(SoarEarthPois soarEarthPois){

        double longitude = soarEarthPois.getLongitude();
        double latitude = soarEarthPois.getLatitude();
        String name = soarEarthPois.getName();
        String description = soarEarthPois.getDescription();
        //Optional<String> category = Optional.of(soarEarthPois.getCategory());
        if(longitude < -180 || longitude > 180)
            throw new SoarEarthValidationException("422","Longitude is invalid");
        if(latitude < -90 || latitude > 90)
            throw new SoarEarthValidationException("422","Latitude is invalid");
        if(StringUtils.isBlank(name))
            throw new SoarEarthValidationException("422","Name is mandatory field");
        if(StringUtils.isBlank(description))
            throw new SoarEarthValidationException("422","Description is mandatory field");


    }
}
