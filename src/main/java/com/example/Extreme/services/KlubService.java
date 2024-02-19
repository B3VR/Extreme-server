package com.example.Extreme.services;

import com.example.Extreme.models.Klub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Extreme.repos.KlubRepository;
import org.springframework.transaction.annotation.Transactional;

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
        return klubRepository.save(klub);
    }

    public List<Klub> pobierzWszystkie() {
        return klubRepository.findAll();
    }

    public void usun(Long id) {
        klubRepository.deleteById(id);
    }
}
