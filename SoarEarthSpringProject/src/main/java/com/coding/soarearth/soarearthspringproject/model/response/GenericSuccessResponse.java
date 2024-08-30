package com.coding.soarearth.soarearthspringproject.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericSuccessResponse<T> extends GenericResponse {

    T data;
    String errorMessage;
    String path;
    String method;
}
