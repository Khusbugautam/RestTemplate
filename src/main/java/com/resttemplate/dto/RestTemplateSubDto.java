package com.resttemplate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateSubDto {
    private int timepoint;
    private int cloudcover;
    private int transparency;
    private int lifted_index;
    private int rh2m;
    private Map<String,Object> wind10m;
    private int temp2m;
    private String prec_type;
}
