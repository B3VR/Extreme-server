package com.example.Extreme.services;

import com.example.Extreme.models.Klub;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.Extreme.repos.KlubRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class KlubService {
    private final KlubRepository klubRepository;

    @Autowired
    public KlubService(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    @Transactional
    public Klub dodajKlub(Klub klub) {

        if (klub.getGlowny()) {
            klubRepository.findKlubByGlownyTrue().ifPresent(glownyKLub -> {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Klub o nazwie: " + glownyKLub.getNazwa() + " jest już zapisany jako klub główny");
            });
        }

        return klubRepository.save(klub);
    }

    public List<Klub> pobierzWszystkie() {
        return klubRepository.findAll();
    }

    public void usun(Long id) {
        klubRepository.deleteById(id);
    }
}
