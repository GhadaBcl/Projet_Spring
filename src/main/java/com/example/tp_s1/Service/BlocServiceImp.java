package com.example.tp_s1.Service;

import com.example.tp_s1.Entity.Bloc;
import com.example.tp_s1.Repository.BlocRepository;
import com.example.tp_s1.Repository.ChambreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImp implements IBlocService{

    BlocRepository blocRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll() ;
    }

    @Override
    public Bloc retrieveChambre(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}
