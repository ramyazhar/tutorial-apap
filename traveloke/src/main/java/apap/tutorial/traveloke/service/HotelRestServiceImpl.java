package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class HotelRestServiceImpl implements HotelRestService{
    private final WebClient webClient;

    @Autowired
    private HotelDb hotelDb;

    @Override
    public HotelModel createHotel(HotelModel hotel) {
        return hotelDb.save(hotel);
    }

    @Override
    public List<HotelModel> retrieveListHotel() {
        return hotelDb.findAll();
    }

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel){
        Optional<HotelModel> hotel = hotelDb.findById(idHotel);
        if(hotel.isPresent()){
            return hotel.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public HotelModel changeHotel(Long idHotel, HotelModel hotelUpdate){
        HotelModel hotel = getHotelByIdHotel(idHotel);
        hotel.setNamaHotel(hotelUpdate.getNamaHotel());
        hotel.setAlamat(hotelUpdate.getAlamat());
        hotel.setNomorTelepon(hotelUpdate.getNomorTelepon());
        return hotelDb.save(hotel);
    }

    @Override
    public void deleteHotel(Long idHotel){
        HotelModel hotel = getHotelByIdHotel(idHotel);
        if(hotel.getListKamar().size()==0){
            hotelDb.delete(hotel);
        }else {
            throw new UnsupportedOperationException();
        }
    }

    public HotelRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.hotelUrl).build();
    }

    @Override
    public Mono<String> getStatus(Long idHotel) {
        return  this.webClient.get().uri("/rest/hotel/"+idHotel+"/status/").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<HotelDetail> postStatus() {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("alamat", "juju");
        data.add("nomorTelepon", "123321");
        return this.webClient.post().uri("/rest/hotel/full")
                .syncBody(data)
                .retrieve()
                .bodyToMono(HotelDetail.class);
    }

    @Override
    public Mono<String> getHotelApiList(String kota){
        WebClient webClient1 = WebClient.builder().baseUrl(Setting.apiUrl).build();
        return webClient1.get().uri(uriBuilder -> uriBuilder.queryParam("locale", "en_US").queryParam("query", kota).build())
                .header("x-rapidapi-key", "7c26045138msh360d9e3696f7c58p147a5fjsn1d679e30be8c")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .header("useQueryString", "true")
                .retrieve().bodyToMono(String.class);
    }


//    @Override
//    public Mono<String> getHotelApiList(String kota) {
//        return this.webClient.post().uri(uriBuilder -> uriBuilder.queryParam("locale", "en_US").queryParam("query",kota).build())
//                .header("x-rapidapi-key", "7c26045138msh360d9e3696f7c58p147a5fjsn1d679e30be8c")
//                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
//                .header("useQueryString","true")
//                .retrieve()
//                .bodyToMono(String.class);
//    }
}