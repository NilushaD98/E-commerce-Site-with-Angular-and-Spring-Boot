package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.CountryDTO;
import com.ecommerce.ecommerce.dto.StateDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CountryService {
    List<CountryDTO> getAllCountries();

    List<StateDTO> getAllStatesByCode(String code) throws NotFoundException;
}
