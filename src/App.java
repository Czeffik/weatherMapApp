public class App {


    public static void main(String[] args) {
//        ReadXMLFile file = new ReadXMLFile();
//        List<String> list = file.getCities();
//        System.out.println(list);
        ReadingUrl readfile = new ReadingUrl();
        for (String url:readfile) {
            System.out.println(url);
        }

    }
}
