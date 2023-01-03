package com.resttemplate.service;

import com.resttemplate.dto.RestTemplateDto;
import org.springframework.stereotype.Service;

@Service
public interface RestTemplateService {
    RestTemplateDto getAllService();

}
