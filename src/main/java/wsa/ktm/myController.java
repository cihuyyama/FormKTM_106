/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsa.ktm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author iqbal al habib
 */
@Controller
public class myController {
    @RequestMapping(value = "/getinto")
    public String getForm(
        @RequestParam(value = "name") String isinama,
        @RequestParam(value = "nim") String isinim,
        @RequestParam(value = "locate") String isitempat,
        @RequestParam("date")
        @DateTimeFormat (pattern="yyyy-MM-dd") Date date,
        @RequestParam(value = "major") String isijrsn,
        @RequestParam(value = "email") String isiemail,
        @RequestParam(value = "img") MultipartFile img,
            Model kurir
    ) throws IOException{
        SimpleDateFormat newTanggal = new SimpleDateFormat("dd-MM-yyyy");
        
        String tanggalku = newTanggal.format(date);
        
        String blob = Base64.encodeBase64String(img.getBytes());
        String gmbr = "data:image/*;base64,".concat(blob);
        
        kurir.addAttribute("kname", isinama);
        kurir.addAttribute("knim", isinim);
        kurir.addAttribute("klocate", isitempat);
        kurir.addAttribute("kdate", tanggalku);
        kurir.addAttribute("kmajor", isijrsn);
        kurir.addAttribute("kemail", isiemail);
        kurir.addAttribute("kimg", gmbr);
        
        return "view";
    }
}
