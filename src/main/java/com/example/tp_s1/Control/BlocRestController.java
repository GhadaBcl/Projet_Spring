package com.example.tp_s1.Control;

import com.example.tp_s1.Entity.Bloc;
import com.example.tp_s1.Service.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tp_s1/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }
    // http://localhost:8089/tp_s1/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveChambre(@PathVariable("bloc-id") Long blId) {
        Bloc bloc = blocService.retrieveChambre(blId);
        return bloc;
    }

    // http://localhost:8089/tp_s1/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBlock(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }
    // http://localhost:8089/tp_s1/bloc/remove-bloc/{block-id}
    @DeleteMapping("/remove-block/{block-id}")
    public void removeBlock(@PathVariable("block-id") Long blId) {
        blocService.removeBloc(blId);
    }
    // http://localhost:8089/tp_s1/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }


}
