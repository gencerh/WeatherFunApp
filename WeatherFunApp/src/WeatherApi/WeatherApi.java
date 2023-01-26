package WeatherApi;




import org.w3c.dom.*;
import sample.WeatherModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherApi {
    private String city;

    public WeatherApi(String city) {
        this.city = city;
    }

    public WeatherModel loads() throws Exception{
        String uri ="https://api.openweathermap.org/data/2.5/weather?q=Düsseldorf&mode=xml&appid=12b8bf6a5936475736014d3960e23afe";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(uri);

        NodeList temperature = document.getElementsByTagName("temperature");
        WeatherModel newWeather=new WeatherModel();

        for (int a=0;a<temperature.getLength();a++){
            Node child=temperature.item(a);
            String temp = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setTemperature(temp);

        }
        NodeList desc = document.getElementsByTagName("weather");

        for (int a=0;a<desc.getLength();a++){
            Node child=desc.item(a);
            String descc = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setDescription(descc);

        }

        NodeList feel = document.getElementsByTagName("feels_like");

        for (int a=0;a<feel.getLength();a++){
            Node child=feel.item(a);
            String feell = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setFeel(feell);

        }
        NodeList windtoday = document.getElementsByTagName("speed");

        for (int a=0;a<windtoday.getLength();a++){
            Node child=windtoday.item(a);
            String wind = child.getAttributes().getNamedItem("name").getNodeValue();
            newWeather.setWindytoday(wind);

        }
        NodeList windspeed = document.getElementsByTagName("speed");

        for (int a=0;a<windspeed.getLength();a++){
            Node child=windspeed.item(a);
            String speed = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setWindy(speed);

        }

        NodeList image = document.getElementsByTagName("weather");

        for (int a=0;a<image.getLength();a++){
            Node child=image.item(a);
            String imagee = child.getAttributes().getNamedItem("icon").getNodeValue();
            newWeather.setImage(imagee);

        }
        NodeList visibility = document.getElementsByTagName("visibility");

        for (int a=0;a<visibility.getLength();a++){
            Node child=visibility.item(a);
            String vsbl = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setVisibility(vsbl);

        }
        NodeList barometer = document.getElementsByTagName("pressure");

        for (int a=0;a<barometer.getLength();a++){
            Node child=barometer.item(a);
            String mb = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setBarometer(mb);

        }
        NodeList humidity = document.getElementsByTagName("humidity");

        for (int a=0;a<humidity.getLength();a++){
            Node child=humidity.item(a);
            String hmdt = child.getAttributes().getNamedItem("value").getNodeValue();
            newWeather.setHumidity(hmdt);

        }

        NodeList maxtemp = document.getElementsByTagName("temperature");

        for (int a=0;a<maxtemp.getLength();a++){
            Node child=maxtemp.item(a);
            String maxt = child.getAttributes().getNamedItem("max").getNodeValue();
            newWeather.setMaxtemp(maxt);

        }
        NodeList mintemp = document.getElementsByTagName("temperature");

        for (int a=0;a<mintemp.getLength();a++){
            Node child=mintemp.item(a);
            String mint = child.getAttributes().getNamedItem("min").getNodeValue();
            newWeather.setMintemp(mint);

        }
        NodeList prcp = document.getElementsByTagName("precipitation");

        for (int a=0;a<prcp.getLength();a++) {
            Node child = prcp.item(a);

           if( child.getAttributes().getNamedItem("mode").getNodeValue().equals("no")){
               newWeather.setPrcp("0%");
           }
           else{
               String pr = child.getAttributes().getNamedItem("value").getNodeValue();
               newWeather.setPrcp(pr);
           }

        }
        return newWeather;

    }

}

