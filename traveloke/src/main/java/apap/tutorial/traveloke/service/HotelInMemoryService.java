package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{
    private List<HotelModel> listHotel;
//constructor
public  HotelInMemoryService(){
    listHotel = new ArrayList<>();
}

    @Override
    public void  addHotel(HotelModel hotel){
    listHotel.add(hotel);
}

    @Override
    public List<HotelModel> getHotelList(){
    return listHotel;
}

    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        for (HotelModel a: listHotel){
            if (a.getIdHotel().equals(idHotel)){
                 return a;
        }

        }
        return null;
    }
    @Override
    public void removeHotel(HotelModel hotel){
    listHotel.remove(hotel);
    }
}
