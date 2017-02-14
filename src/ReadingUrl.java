import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadingUrl implements Iterable<String>{
    private LinkedList<String> links = new LinkedList<>();
    //    private ReadXMLFile listOfCities = new ReadXMLFile();
    private List<String> cities = new LinkedList<>();



    public ReadingUrl(){
        try {
            File file = new File("C:\\Users\\trzew\\Desktop\\miasta.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine())!=null){
                line.replaceAll("\\s+","");
                cities.add(line);
            }
            fr.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String city: cities) {
            String link = "http://api.openweathermap.org/data/2.5/forecast?q="+city+",pol&APPID=71ad073f87383bd799851e6388bfcc8a";
            links.add(link);
        }
    }

    private class UrlIterator implements Iterator<String>{
        int index = 0;

        @Override
        public boolean hasNext() {
            return index<links.size();
        }

        @Override
        public String next() {
            StringBuilder sb = new StringBuilder();
            try{
                URL url = new URL(links.get(index));
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while((line=br.readLine())!=null){
                    sb.append(line);
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
            return sb.toString();
        }

        @Override
        public void remove() {
            links.remove(index);

        }
    }
    @Override
    public Iterator<String> iterator() {
        return new UrlIterator();
    }
}
