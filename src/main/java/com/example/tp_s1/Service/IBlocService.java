package com.example.tp_s1.Service;

import com.example.tp_s1.Entity.Bloc;
import com.example.tp_s1.Entity.Chambre;

import java.util.List;

public interface IBlocService {

    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveChambre(Long idBloc);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long idBloc);
    public Bloc modifyBloc(Bloc bloc);
}
