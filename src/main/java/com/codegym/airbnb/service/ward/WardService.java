package com.codegym.airbnb.service.ward;

import com.codegym.airbnb.model.District;
import com.codegym.airbnb.model.Ward;
import com.codegym.airbnb.repository.IWardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class WardService implements IWardService {
   @Autowired
   private IWardRepo wardRepo;
    @Override
    public Iterable<Ward> findAll() {
        return wardRepo.findAll();
    }

    @Override
    public Optional<Ward> findById(Long id) {
        return wardRepo.findById(id);
    }

    @Override
    public Ward save(Ward ward) {
        return wardRepo.save(ward);
    }

    @Override
    public void delete(Long id) {
        wardRepo.deleteById(id);
    }

    @Override
    public Iterable<Ward> findAllByDistrict(District district) {
        return wardRepo.findAllByDistrict(district);
    }
}
