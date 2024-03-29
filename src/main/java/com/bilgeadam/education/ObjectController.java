package com.bilgeadam.education;

import com.bilgeadam.dto.WriterDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Log4j2
public class ObjectController {

    //sadece ekranda göstermeye yarar
    //localhost:8080/birinciuygulama
    @GetMapping("/birinciuygulama")
    @ResponseBody
    public String getQuery() {
        return "Yükleniyor ... ";
    }

    //bir sayfaya yönlendirmek için
    //localhost:8080/ikinciuygulama
    @GetMapping("/ikinciuygulama")
    public String secondMethod() {
        return "index";
    }

    //dizin içinde dizin redirect
    //localhost:8080/ucuncuuygulama
    @GetMapping("/ucuncuuygulama")
    public String thirdMethod() {
        return "otherfile/other";
    }

    //şimdiye kadar sadece veri gösterdik artık bizde _2_query sayfasına veri göndererlim.
    //localhost:8080/dorduncuuygulama
    //@GetMapping ==> URL
    //retun ==>gidilecek sayfa
    // Model  <== Controller  ==>   View
    @GetMapping("/dorduncuuygulama")
    public String fourMethod(Model model) {
        model.addAttribute("query_key", "Çağrı Türkmen");
        return "object";
    }

    //Modele bu sefer birden fazla obje ekleyerek _2_query.jsp sayfasında göndereceğim.
    //AdminDto ve static mesaj Model ekliyoruz Controller alıyor bunu View kısmında gösteriyor.
    //localhost:8080/besinciuygulama
//    @GetMapping("/besinciuygulama")
//    public String fiveMethod(Model model) {
//        AdminDto adminDto = AdminDto.builder().adminName("Melih").adminSurname("Dumanlı").build();
//        model.addAttribute("query_admin", adminDto);
//        model.addAttribute("query_key", "Cemil Duman");
//        return "object";
//    }

    //////////////////////////////PATHVARIABLE/////////////////////////////////////////////////////////////
    //url yazacağım sayıyı çalıştırmak @PathVariable çalışmasını sağladım
    //localhost:8080/altinciuygulama/4
    @GetMapping("/altinciuygulama/{param1}")
    public String sixMethod(Model model, @PathVariable(name = "param1") int id44) {
        model.addAttribute("query_key", "Gülten Ulukal ID: " + id44);
        return "object";
    }

    //eğer opsiyonel olara seçim yapacaksasm olsun yada olmasında burada primitive yerine Wrapper class kullanalım
    //çünkü Wrapper class null değer alabilir ancak primitive type null alamaz.
    //Wrapper =Serileştirme yapabiliriz Primitive=Serileştirme yapamayız.
    //localhost:8080/yedinciuygulama <== veya ==> localhost:8080/yedinciuygulama//77
    @GetMapping({"yedinciuygulama", "yedinciuygulama/{param2}"})
    public String sevenMethod(Model model, @PathVariable(name = "param2", required = false) Long id23) {
        if (id23 != null) {
            model.addAttribute("query_key", " Görkem Sönmez ID: " + id23);
        } else {
            model.addAttribute("query_key", " Data Yok ID: ");
        }
        return "object";
    }

    //////////////////////////////REQUESTPARAMETER/////////////////////////////////////////////////////////////
    //localhost:8080/sekinciuygulama?param3=3
    @GetMapping("/sekinciuygulama")
    public String eightMethod(Model model, @RequestParam(name = "param3") long id55) {
        model.addAttribute("query_key", "Mert Can Aydın " + id55);
        return "object";
    }

    //localhost:8080/dokuzuncuuygulama
    // http://localhost:8080/dokuzuncuuygulama?param4=66633
    //@ResponseBody
    //required = true ==>
    @GetMapping("/dokuzuncuuygulama")
    public String nineMethod(Model model, @RequestParam(name = "param4", required = false, defaultValue = "55") Long sayi) {

        model.addAttribute("query_key", "Java Spring Boot" + sayi);
        return "object";
    }

    //localhost:8080/onuncuuygulama?adi=Hamit&soyadi=Mızrak&numara=44
    @GetMapping("/onuncuuygulama")
    public String tenMethod(Model model, @RequestParam(name = "adi") String name, @RequestParam(name = "soyadi") String surname, @RequestParam(name = "numara", required = false, defaultValue = "99") Long number) {
        String temp = name.toLowerCase();
        model.addAttribute("query_key", " Selamlar  " + temp + " soydınız: " + surname + " " + number);
        return "object";
    }

    ////////////////////////////Form////////////////////////////////////////////////////////////////////////////////
    //Ctrl+Alt+L =formatter
    //localhost:7777/writer
    //Bu metot: default değerleri almak istediğimizde oluştururuz
    @GetMapping("/writer")
    public String getWriter(Model model) {
        //Database select
        WriterDto writerDto = WriterDto.builder().writerName("adınızı girmediniz").writerSurname("Soyadınızı girmediniz").writerAddress("address girmediniz").writerTelephoneNumber(11122233).build();
        model.addAttribute("form_key", writerDto);
        return "form";
    }

    //client yazdıklarını almak istiyorum
    @PostMapping("/writer")
    public String postWriter(Model model, WriterDto writerDto) {
        log.info(writerDto.getId() + " " + writerDto.getWriterName() + " " + writerDto.getWriterSurname() + " " + writerDto.getWriterAddress() + " " + writerDto.getWriterTelephoneNumber());
        //dosyaya yazdırma
        //Database Create işlemleri burada yapacağız.
        model.addAttribute("form_key", writerDto);
        return "form";
    }

    ////////////////////////////Form Validation////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////



}
