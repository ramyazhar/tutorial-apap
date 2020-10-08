package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KamarDb extends JpaRepository<KamarModel,Long> {
    List<KamarModel> findByHotelId(Long hotelId);
//    Optional<KamarModel> findByNoKamar(Long nomorKamar);
    KamarModel findByNoKamar(long noKamar);
}
