package WeatherApi;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sample.WeatherModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class WeatherWeekly {

    public WeatherModel[] getWeatherWeekly() throws Exception {

        String uri ="https://api.openweathermap.org/data/2.5/forecast?q=Düsseldorf&mode=xml&appid=12b8bf6a5936475736014d3960e23afe";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(uri);

        NodeList times = document.getElementsByTagName("time");

        WeatherModel[] wetterInfos = new WeatherModel[5];
        int counter=0;
        for (int x = 0; x<times.getLength(); x++){
            Node time = times.item(x);
            NamedNodeMap timeAttributes = time.getAttributes();
            String timestamp = timeAttributes.getNamedItem("from").getNodeValue();
            NodeList children = time.getChildNodes();


            if(x%8 == 0){

                WeatherModel newWeather = new WeatherModel();

            for (int y = 0; y < children.getLength(); y++) {
                Node child = children.item(y);
                if(y==0 || y==5){
                    if (child.getNodeName().equals("temperature")) {
                        String tempweek = child.getAttributes().getNamedItem("value").getNodeValue();

                        newWeather.setTemperature(tempweek);
                        counter++;

                    }

                    if (child.getNodeName().equals("symbol")) {
                        String descweek = child.getAttributes().getNamedItem("name").getNodeValue();
                        String imgweek = child.getAttributes().getNamedItem("var").getNodeValue();
                        newWeather.setImage(imgweek);

                        newWeather.setDescription(descweek);

                        wetterInfos[counter] = newWeather;
                    }

                }
            }
            }

        }

        return wetterInfos;

    }
}
