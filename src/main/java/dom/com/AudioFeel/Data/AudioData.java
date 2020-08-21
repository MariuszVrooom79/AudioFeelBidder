package dom.com.AudioFeel.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AudioData {

    private String name;
    private String description;
    private int price;
    private File image;
    public static List<AudioData> listaAudio = new ArrayList<>();

    public AudioData(File image){}

    public AudioData(String name, String descripion, int price, File image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public AudioData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() { this.price = price; }

    public File getImage() {return image;}

    public void setImage(File image) {this.image = image;}


    @Override
    public String toString() {
        return "AudioData{" +
                "aname='" + name + '\'' +
                ", adescription='" + description + '\'' +
                ", aprice = " + price +
                '}';
    }


}
