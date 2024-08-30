package com.coding.soarearth.soarearthspringproject.Validators;

import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import org.springframework.stereotype.Component;

@Component
public interface SoarEarthValidatorInterface {

    public void validatePostSoarEarthPoi(SoarEarthPois soarEarthPois);

}
