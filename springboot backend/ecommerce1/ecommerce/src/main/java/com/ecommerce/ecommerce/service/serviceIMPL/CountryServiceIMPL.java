package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.Country;
import com.ecommerce.ecommerce.Entity.State;
import com.ecommerce.ecommerce.dto.CountryDTO;
import com.ecommerce.ecommerce.dto.StateDTO;

import com.ecommerce.ecommerce.repositoy.CountriesRepo;
import com.ecommerce.ecommerce.repositoy.StateRepo;
import com.ecommerce.ecommerce.service.CountryService;
import com.google.common.base.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryServiceIMPL implements CountryService {

    @Autowired
    private CountriesRepo countriesRepo;
    @Autowired
    private StateRepo stateRepo;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> all = countriesRepo.findAll();
        return all.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }
    private CountryDTO convertEntityToDTO(Country country){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setCode(country.getCode());
        return countryDTO;
    }
    @Override
    public List<StateDTO> getAllStatesByCode(String code) throws NotFoundException {
        Optional<Country> countryOptional=  countriesRepo.findByCodeEquals(code);
        if(countryOptional.isPresent()){
            List<State> stateList = stateRepo.findAllByCountry_Id(countryOptional.get().getId());
            return stateList.stream().map(this::convert).collect(Collectors.toList());
        }else {
            throw new NotFoundException("No country in database");
        }
     }

     private StateDTO convert(State state){
        StateDTO stateDTO = new StateDTO();
        stateDTO.setId(state.getId());
        stateDTO.setName(state.getName());
        return stateDTO;
     }
}
