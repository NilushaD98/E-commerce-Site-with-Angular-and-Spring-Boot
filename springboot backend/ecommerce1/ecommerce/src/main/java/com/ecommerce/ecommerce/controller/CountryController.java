package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Entity.Country;
import com.ecommerce.ecommerce.dto.CountryDTO;
import com.ecommerce.ecommerce.dto.StateDTO;
import com.ecommerce.ecommerce.service.CountryService;
import com.ecommerce.ecommerce.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/country/")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("get_all_countries")
    public ResponseEntity<StandardResponse> getAllCountries(){
        List<CountryDTO> countryDTOSList = countryService.getAllCountries();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Countries",countryDTOSList,0),HttpStatus.OK
        );
    }
    @GetMapping(
            value = {"get_all_states_by_code"},
            params = {"code"}
    )
    public ResponseEntity<StandardResponse> getAllStatesByCode(@RequestParam(name = "code")String code) throws NotFoundException {
        List<StateDTO> stateDTOList = countryService.getAllStatesByCode(code);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All States By Code : ", stateDTOList,0),HttpStatus.OK
        );
    }
}
