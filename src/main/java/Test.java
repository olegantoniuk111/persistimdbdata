//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import ua.vin.persistimdbdata.model.OmdbItem;
//import ua.vin.persistimdbdata.model.SearchItem;
//
//import java.io.IOException;
//import java.util.List;
//
//public class Test {
//
//    private static String json = "{\"Search\":[{\"Title\":\"ALF\",\"Year\":\"1986–1990\",\"imdbID\":\"tt0090390\",\"Type\":\"series\",\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYmRhNzk2YWUtNWIxNC00YWM3LWI5ODEtN2IwOGQzYWEwMWJjXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg\"},{\"Title\":\"A.L.F.\",\"Year\":\"1987–1989\",\"imdbID\":\"tt0365971\",\"Type\":\"series\",\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTE5OTY4MjA2MV5BMl5BanBnXkFtZTcwNTMwODIzMQ@@._V1_SX300.jpg\"},{\"Title\":\"ALF Tales\",\"Year\":\"1988–1990\",\"imdbID\":\"tt0094413\",\"Type\":\"series\",\"Poster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ0NDg4MTA3NV5BMl5BanBnXkFtZTcwNTYyODIzMQ@@._V1_SX300.jpg\"},{\"Title\":\"The Thoughts of Chairman Alf\",\"Year\":\"1998–\",\"imdbID\":\"tt0185827\",\"Type\":\"series\",\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTg1MTExMzM0Nl5BMl5BanBnXkFtZTcwNDI4MTcxMQ@@._V1_SX300.jpg\"},{\"Title\":\"A Word with Alf\",\"Year\":\"1997–2000\",\"imdbID\":\"tt0187599\",\"Type\":\"series\",\"Poster\":\"N/A\"},{\"Title\":\"Alf Prøysens Barnesanger\",\"Year\":\"2011\",\"imdbID\":\"tt2167868\",\"Type\":\"series\",\"Poster\":\"N/A\"},{\"Title\":\"Alf Lailah Wi Lailah\",\"Year\":\"2005–\",\"imdbID\":\"tt3148442\",\"Type\":\"series\",\"Poster\":\"N/A\"},{\"Title\":\"Mesh Alf Leila We Leila\",\"Year\":\"2010–\",\"imdbID\":\"tt3849178\",\"Type\":\"series\",\"Poster\":\"N/A\"}],\"totalResults\":\"8\",\"Response\":\"True\"}";
//
//    public static void main(String[] args) throws IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//
//        SearchItem search = objectMapper.readValue(json, SearchItem.class);
//        List<OmdbItem> omdbUnits = search.getSearch();
//        System.out.println(omdbUnits.toString());
//
//       //List<OmdbItem> cars1 = objectMapper.readValue(json, new TypeReference<List<OmdbItem>>(){});
//
//
//        //System.out.println(cars1.toString());
//
//
//
//    }
//}
