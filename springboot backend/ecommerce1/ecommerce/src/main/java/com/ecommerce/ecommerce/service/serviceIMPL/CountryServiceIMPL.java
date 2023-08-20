package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.Country;
import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.Entity.State;
import com.ecommerce.ecommerce.dto.CountryDTO;
import com.ecommerce.ecommerce.dto.StateDTO;
import com.ecommerce.ecommerce.repositoy.CountryRepo;
import com.ecommerce.ecommerce.repositoy.StateRepo;
import com.ecommerce.ecommerce.service.CountryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceIMPL implements CountryService {
    @Autowired
    private CountryRepo countryRepo;
    private StateRepo stateRepo;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> all = countryRepo.findAll();
        return all.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }
    private CountryDTO convertEntityToDTO(Country country){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setCode(countryDTO.getCode());
        return countryDTO;
    }

    @Override
    public List<StateDTO> getAllStatesByCode(String code) throws NotFoundException {

        List<Country> countryObservable = countryRepo.findByCode(code);
            List<State> stateList = stateRepo.findStatesByCountry_IdEquals(countryObservable.get(0).getId());
            return stateList.stream().map(this::convert).collect(Collectors.toList());
     }

     private StateDTO convert(State state){
        StateDTO stateDTO = new StateDTO();
        stateDTO.setId(state.getId());
        stateDTO.setName(state.getName());
        return stateDTO;
     }
}
