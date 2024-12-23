package com.elp.dto;
import java.util.List;

public record GenericResponse<T>(
        int status,
        String messaje,
        List<T> data
) {

}
