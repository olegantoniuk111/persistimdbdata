package ua.vin.persistimdbdata.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vin.persistimdbdata.model.OmdbItem;
import ua.vin.persistimdbdata.model.OmdbItemRepository;
import java.util.List;

public class OmdbWriter implements ItemWriter <List<OmdbItem>>{

    @Autowired
    public OmdbItemRepository omdbUnitRepository;


    @Override
    public void write(List<? extends List<OmdbItem>> items) throws Exception {
        for(List<OmdbItem>units:items){
            omdbUnitRepository.save(units);
        }
    }
}
