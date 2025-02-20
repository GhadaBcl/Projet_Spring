package com.example.tp_s1.Service;

import com.example.tp_s1.Entity.Universite;
import com.example.tp_s1.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService{

    UniversiteRepository universiteRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }
}
