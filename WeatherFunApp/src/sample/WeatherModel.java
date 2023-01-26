package sample;

public class WeatherModel {
    private String temperature;
    private String description;
    private String feel;
    private String windy;
    private String windytoday;
    private String image;
    private String visibility;
    private String barometer;
    private String humidity;
    private String prcp;
    private String maxtemp;
    private String mintemp;


    public WeatherModel() {

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temp) {
        this.temperature=temp;

    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getWindy() {
        return windy;
    }

    public void setWindy(String windy) {
        this.windy = windy;
    }

    public String getWindytoday() {
        return windytoday;
    }

    public void setWindytoday(String windytoday) {
        this.windytoday = windytoday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getBarometer() {
        return barometer;
    }

    public void setBarometer(String barometer) {
        this.barometer = barometer;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrcp() {
        return prcp;
    }

    public void setPrcp(String prcp) {
        this.prcp = prcp;
    }

    public String getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(String maxtemp) {
        this.maxtemp = maxtemp;
    }

    public String getMintemp() {
        return mintemp;
    }

    public void setMintemp(String mintemp) {
        this.mintemp = mintemp;
    }
}

