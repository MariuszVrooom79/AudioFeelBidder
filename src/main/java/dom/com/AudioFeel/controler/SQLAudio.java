package dom.com.AudioFeel.controler;

import dom.com.AudioFeel.Data.AudioData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLAudio {

    public static void UpdateExport(AudioData audio) {




        try {
            File image = audio.getImage();
            FileInputStream stream = new FileInputStream(image);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/audio", "postgres", "kamykpatyk622");
            PreparedStatement aud = con.prepareStatement("INSERT INTO audio(a_name, a_description, a_price, image ) VALUES (?,?,?,?)");
            //stm.executeUpdate(query);

            aud.setString(1, audio.getName());
            aud.setString(2, audio.getDescription());
            aud.setInt(3, audio.getPrice());
            aud.setBinaryStream(4, stream, image.length());
            aud.executeUpdate();
            aud.close();
            stream.close();

            System.out.println(audio.getPrice());
            System.out.println("New Audio :" + audio.getName() + ", " + audio.getDescription() + " " + audio.getPrice());


        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void UpdateExport() {
    }
}
