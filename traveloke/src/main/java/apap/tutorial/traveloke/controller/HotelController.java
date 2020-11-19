package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home() {
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model) {
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model) {
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }



    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        System.out.println(listKamar);
        for (int i = 0; i < listKamar.size(); i++) {
            System.out.println(listKamar.get(i).getNamaKamar());
        }
        boolean hasKamar = listKamar.size() > 0;
        model.addAttribute("hasKamar", hasKamar);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }


    @GetMapping("hotel/viewall")
    public String viewAllHotel(
            Model model
    ){
        List<HotelModel> hotel = hotelService.findAllByOrderByIdDesc();
        model.addAttribute("listHotel", hotel);
        return "viewall-hotel";
    }

    @RequestMapping(value="hotel/remove/{idHotel}", method=RequestMethod.GET)
    public String removeHotelByIdHotel(@PathVariable Long idHotel,@ModelAttribute HotelModel hotelModel, Model model){


        HotelModel existHotelModel = hotelService.getHotelByIdHotel(idHotel);

        if(existHotelModel == null){
            return "no-id-hotel";
        }

        List<KamarModel> listKamar = existHotelModel.getListKamar();

        if(listKamar.size() != 0 ){

            return "remove-hotel-gagal";

        }else {
            hotelService.removeHotel(existHotelModel);
            return "remove-hotel-berhasil";
        }

    }
}