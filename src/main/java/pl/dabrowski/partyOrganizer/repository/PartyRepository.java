package pl.dabrowski.partyOrganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dabrowski.partyOrganizer.model.Party;

@Repository("partyRepository")
public interface PartyRepository extends JpaRepository<Party, Long> {
}
