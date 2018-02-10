package ua.vin.persistimdbdata.step;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemProcessor;
import ua.vin.persistimdbdata.model.OmdbUnit;

import java.util.LinkedList;
import java.util.List;

public class Processor implements ItemProcessor<List<String>,List<OmdbUnit> > {
    private  List<OmdbUnit> ombdList;
    private ObjectMapper mapper = new ObjectMapper();
    public Processor() {
        ombdList = new LinkedList<>();
    }


    @Override
    public List<OmdbUnit> process(List<String> item) throws Exception {
        for(String str: item){
            ombdList.add(mapper.readValue(str, OmdbUnit.class));
        }
        return ombdList;
    }
}
