package com.example.tp_s1.Control;

import com.example.tp_s1.Entity.Foyer;
import com.example.tp_s1.Entity.Universite;
import com.example.tp_s1.Service.IFoyerService;
import com.example.tp_s1.Service.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    IUniversiteService universiteService;

    // http://localhost:8089/tp_s1/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getAlluniversites() {
        List<Universite> listuniversites = universiteService.retrieveAllUniversites();
        return listuniversites;
    }
    // http://localhost:8089/tp_s1/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveuniversite(@PathVariable("universite-id") Long unId) {
        Universite universite = universiteService.retrieveUniversite(unId);
        return universite;
    }

    // http://localhost:8089/tp_s1/universite/add-universite
    @PostMapping("/add-universite")
    public Universite adduniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }
    // http://localhost:8089/tp_s1/universite/remove-universite/{universite-id}
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeuniversite(@PathVariable("universite-id") Long unId) {
        universiteService.removeUniversite(unId);
    }
    // http://localhost:8089/tp_s1/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyuniversite(@RequestBody Universite u) {
        Universite universite = universiteService.modifyUniversite(u);
        return universite;
    }
}
