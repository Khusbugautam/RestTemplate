package com.resttemplate.service.serviceimpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resttemplate.dto.RestTemplateDto;
import com.resttemplate.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RestTemplateImpl implements RestTemplateService {
    private final ObjectMapper objectMapper;

    public RestTemplateImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public RestTemplateDto getAllService() {
        String url = "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        log.info("Response from third party :{}", responseEntity);

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {
            log.error("Request failed with error: {}", responseEntity);
            throw new RuntimeException("Request failed");
        }

//        RestTemplateDto restTemplateDto = modelMapper.convertValue(responseEntity.getBody(), RestTemplateDto.class);
//        RestTemplateDto restTemplateDto=modelMapper.map(responseEntity.getBody(),RestTemplateDto.class);
        return objectMapper.convertValue(responseEntity.getBody(),
                new TypeReference<RestTemplateDto>()
        {
        });
    }
}
