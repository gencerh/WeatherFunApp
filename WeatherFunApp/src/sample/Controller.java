package sample;

import WeatherApi.WeatherApi;
import WeatherApi.WeatherWeekly;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    public Label  city, temperature, desc, windSpeed, feel, visibility, barometer, humidity,
            prcp, max_mintemp, windToday, temperature_day2, temperature_day3, temperature_day4,
            temperature_day5, desc_day2, desc_day3, desc_day4, desc_day5,
            day2, day3, day4, day5;
    @FXML
    public ImageView img, imgtoday, img_day2, img_day3, img_day4, img_day5;

    public void showWeather() throws Exception {
        WeatherApi wapi = new WeatherApi("Hamburg");
        float newTemperatur=Math.round(Float.valueOf(wapi.loads().getTemperature()));
        int newtemp = (int)newTemperatur-273;
        float newFeels=Math.round(Float.valueOf(wapi.loads().getFeel()));
        int newFell=(int)newFeels-273;
        float newmaxt=Math.round(Float.valueOf(wapi.loads().getMaxtemp()));
        int newmaxtmp=(int)newmaxt-273;
        float newmint=Math.round(Float.valueOf(wapi.loads().getMintemp()));
        int newmintmp=(int)newmint-273;
        String imgg=wapi.loads().getImage();

        temperature.setText(Integer.toString(newtemp) + "°");

        desc.setText(wapi.loads().getDescription());

        feel.setText("Feels like "+Integer.toString(newFell) + "° C");

        img.setImage(new Image("http://openweathermap.org/img/w/"+imgg+".png"));

        imgtoday.setImage(new Image("http://openweathermap.org/img/w/"+imgg+".png"));

        windToday.setText(wapi.loads().getWindytoday());

        windSpeed.setText("Wind Speed "+wapi.loads().getWindy() + " km");

        visibility.setText("Visibility "+ wapi.loads().getVisibility() + " m");

        barometer.setText("Barometer "+ wapi.loads().getBarometer() + " mb");

        humidity.setText("Humidity "+ wapi.loads().getHumidity() + "%");

        prcp.setText("Precipitation  "+ wapi.loads().getPrcp());

        max_mintemp.setText("H:" +newmaxtmp+ "°" + "   " + "L:" +newmintmp + "°");

        WeatherWeekly wetter = new WeatherWeekly();
        WeatherModel[] newInfos =wetter.getWeatherWeekly();

        Calendar calendar = Calendar.getInstance();
        Date dt=new Date();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE,1);
        dt= calendar.getTime();
        String day_2=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dt.getTime());
        calendar.add(Calendar.DATE,1);
        dt= calendar.getTime();
        String day_3=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dt.getTime());
        calendar.add(Calendar.DATE,1);
        dt= calendar.getTime();
        String day_4=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dt.getTime());
        calendar.add(Calendar.DATE,1);
        dt= calendar.getTime();
        String day_5=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dt.getTime());


        float newTmpdy2=Math.round(Float.valueOf(newInfos[1].getTemperature()));
        int newtmpdy2=(int)newTmpdy2-273;
        temperature_day2.setText(String.valueOf(newtmpdy2) + "° C");
        day2.setText(day_2);
        String imgday2 = newInfos[1].getImage();
        img_day2.setImage(new Image("http://openweathermap.org/img/w/"+imgday2+".png"));
        desc_day2.setText(newInfos[1].getDescription());

        float newTmpdy3=Math.round(Float.valueOf(newInfos[2].getTemperature()));
        int newtmpdy3=(int)newTmpdy3-273;
        temperature_day3.setText(String.valueOf(newtmpdy3) + "° C");
        day3.setText(day_3);
        String imgday3 = newInfos[2].getImage();
        img_day3.setImage(new Image("http://openweathermap.org/img/w/"+imgday3+".png"));
        desc_day3.setText(newInfos[2].getDescription());

        float newTmpdy4=Math.round(Float.valueOf(newInfos[3].getTemperature()));
        int newtmpdy4=(int)newTmpdy4-273;
        temperature_day4.setText(String.valueOf(newtmpdy4) + "° C");
        day4.setText(day_4);
        String imgday4 = newInfos[3].getImage();
        img_day4.setImage(new Image("http://openweathermap.org/img/w/"+imgday4+".png"));
        desc_day4.setText(newInfos[3].getDescription());

        float newTmpdy5=Math.round(Float.valueOf(newInfos[4].getTemperature()));
        int newtmpdy5=(int)newTmpdy5-273;
        temperature_day5.setText(String.valueOf(newtmpdy5) + "° C");
        day5.setText(day_5);
        String imgday5 = newInfos[4].getImage();
        img_day5.setImage(new Image("http://openweathermap.org/img/w/"+imgday5+".png"));
        desc_day5.setText(newInfos[4].getDescription());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showWeather();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
