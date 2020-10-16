package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);

        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }


//    @PostMapping("/kamar/change/")
//    public String changeHotelFormSubmit(
//            @ModelAttribute HotelModel hotel,
//            Model model
//    ){
//        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
//        model.addAttribute("hotel", hotel);
//        return "form-update-kamar";
//    }
    @RequestMapping(value="kamar/change/{noKamar}", method=RequestMethod.GET)
    public String changeKamrFormPage(@PathVariable Long noKamar, Model model) {
    KamarModel existingKamarModel = kamarService.getKamarByNoKamar(noKamar);
    if (existingKamarModel == null) {
        return "kamar-tidak-ada";
    }
    model.addAttribute("kamar", existingKamarModel);
    return "form-update-kamar";
}

    @PostMapping("/kamar/change")
    public String changeHotelFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamarUpdated);
        return "update-kamar";
    }

    @GetMapping(value="/kamar/remove/{noKamar}")
    public String removeKamarByNoKamar(@PathVariable Long noKamar,@ModelAttribute KamarModel kamarModel, Model model){
        KamarModel existKamarModel = kamarService.getKamarByNoKamar(noKamar);
        kamarService.removeKamar(existKamarModel);
        return "remove-kamar-by-nokamar";

    }
    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());

        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.removeKamar(kamar);
        }

        return "delete-kamar";
    }
}