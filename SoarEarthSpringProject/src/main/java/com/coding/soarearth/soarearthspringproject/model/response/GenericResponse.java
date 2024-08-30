package com.coding.soarearth.soarearthspringproject.model.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenericResponse {

    int code;
    Timestamp timestamp;
    String message;
}
