package dom.com.AudioFeel.controler;

import dom.com.AudioFeel.Data.AudioData;
import dom.com.AudioFeel.Data.User;
import dom.com.AudioFeel.UserService;
import dom.com.AudioFeel.WebSecurityConfig;
import dom.com.AudioFeel.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.sql.SQLException;

import static dom.com.AudioFeel.controler.SQL.ExecuteImport;

@Controller
public class controler {

    private UserService userService;

    public controler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("listaUser", User.listaUser);
        return "index";
    }

    @GetMapping("/aukcje")
    public String getOnas() {
        return "aukcje";
    }

    @GetMapping("/zasady")
    public String getZasady() {
        return "zasady";
    }

    @GetMapping("/kontakt")
    public String getKontat() {
        return "kontakt";
    }

    @GetMapping("/trial")
    public String getTaial() {
        return "trial";
    }

    @GetMapping("/panel")
    public String getUser() {
        return "panelUserNiewiem";
    }

    @GetMapping("/user")
    public String getPanelUser(Principal principal,Model model) {
        model.addAttribute("username", principal.getName());
        return "panelUser";
    }

    @PostMapping("/user")
    public String postLogowanie(@ModelAttribute AppUser appUser ){
        return "panelUser";
    }

    @GetMapping("/admin")
    public String getPanelAdmin(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "panelAdmin";
    }

    @GetMapping("/article")
    public String getArticle() {
        return "article";
    }

    //  @GetMapping("/audio")
    //  public String audioToDB() { return "audio"; }

    @GetMapping("/audio")
    public String toAudio(Model model) {
        model.addAttribute("audio", new AudioData());
        return "audio";

    }

    @GetMapping("/logowanie")
    public String toLogowanie(Model model) {
        //model.addAttribute("listaUser", User.listaUser);
        model.addAttribute("konto", new AppUser());
        return "logowanie";
    }

    @PostMapping("/logowanie")
    public String getLogowanie(@ModelAttribute AppUser appUser ){
         return "redirect:/user";
    }


    @GetMapping("/rejestracja")
    public String toRejestracja(Model model) {
        model.addAttribute("konto", new AppUser());
        return "rejestracja";
    }

    @PostMapping("/rejestracja")       //TODO: wysayłanie rejestraci do bd
    public String getRejestracja(AppUser appUser) {

        userService.addUser(appUser);
        return "panelUser";
    }


   // @PostMapping("/audio")
   // public String getAudio(@ModelAttribute AudioData audio) {
   //     if (!audio.getName().equals("") && !audio.getDescription().equals("")
   //             && !audio.getImage().equals(null)) {
   //
   //         AudioData.listaAudio.add(audio);
   //         SQLAudio.UpdateExport(audio);
   //         SQL.ImportUsersSQL();
   //
   //         return "redirect:/aukcje";
   //     }
   //     return "errorPage";
   // }

    public static void main(String[] args) {
        SQL.ImportUsersSQL();
        SQLAudio.UpdateExport();

    }

}