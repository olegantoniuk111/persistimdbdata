import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.vin.persistimdbdata.model.OmdbItem;
import ua.vin.persistimdbdata.model.Search;

import java.io.IOException;
import java.util.List;

public class Test {

    private static String json = "";

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        Search search = objectMapper.readValue(json, Search.class);
        List<OmdbItem> omdbUnits = search.getSearch();
        System.out.println(omdbUnits.toString());

       //List<OmdbItem> cars1 = objectMapper.readValue(json, new TypeReference<List<OmdbItem>>(){});


        //System.out.println(cars1.toString());



    }
}
