package dom.com.AudioFeel.controler;

import dom.com.AudioFeel.Data.AudioData;
import dom.com.AudioFeel.Data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;

import static dom.com.AudioFeel.Data.User.checkLogin;
import static dom.com.AudioFeel.controler.SQL.ExecuteImport;

@Controller
public class controler {

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

    @GetMapping("/panel")
    public String getUser() {
        return "panelUser";
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
        model.addAttribute("listaUser", User.listaUser);
        model.addAttribute("konto", new User());
        return "logowanie";
    }

    @GetMapping("/rejestracja")
    public String toRejestracja(Model model) {
        model.addAttribute("konto", new User());
        return "rejestracja";

    }

    @PostMapping("/logowanie")
    public String getLogowanie(@ModelAttribute User user) {

        ResultSet log = ExecuteImport("SELECT login FROM Users");
        if (checkLogin(new User(log))) {

            return "redirect:/aukcje";
        }
        return "redirect:/zasady";

    }



    @PostMapping("/rejestracja")
    public String getRejestracja(@ModelAttribute User user) {
        if (!user.getLogin().equals("") && !user.getPassword().equals("")) {

            User.listaUser.add(user);
            SQL.UpdateExport(user);
            SQL.ImportUsersSQL();

            return "redirect:/logowanie";
        }
        return "errorPage";
    }

    @PostMapping("/audio")
    public String getAudio(@ModelAttribute AudioData audio) {
        if (!audio.getName().equals("") && !audio.getDescription().equals("")
                && !audio.getImage().equals(null)) {

            AudioData.listaAudio.add(audio);
            SQLAudio.UpdateExport(audio);
            SQL.ImportUsersSQL();

            return "redirect:/aukcje";
        }
        return "errorPage";
    }

    public static void main(String[] args) {
        SQL.ImportUsersSQL();
        SQLAudio.UpdateExport();

    }

}
