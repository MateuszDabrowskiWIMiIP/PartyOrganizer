package pl.dabrowski.partyOrganizer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dabrowski.partyOrganizer.model.Party;
import pl.dabrowski.partyOrganizer.repository.PartyRepository;

import java.util.List;


@Service("partyService")
@Transactional
public class PartyService {

    @Autowired
    private PartyRepository repo;

    public List<Party> listAll() {
        return repo.findAll();
    }

    public void save(Party party) {
        repo.save(party);
    }

    public Party get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
