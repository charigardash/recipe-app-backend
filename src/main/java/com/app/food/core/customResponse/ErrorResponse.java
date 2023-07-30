package com.app.food.core.customResponse;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Serializable {

    private String message;
    
}
