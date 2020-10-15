package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelDb extends JpaRepository<HotelModel,Long> {
    Optional<HotelModel> findById(Long Id);
    List<HotelModel> findAllByOrderByIdDesc();
    void delete(HotelModel hotel);
}