package ua.vin.persistimdbdata.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vin.persistimdbdata.model.OmdbUnit;
import ua.vin.persistimdbdata.model.OmdbUnitRepository;
import java.util.List;

public class Writer implements ItemWriter<List<OmdbUnit>>{

    @Autowired
    public OmdbUnitRepository omdbUnitRepository;

    public Writer() {
    }

    @Override
    public void write(List<? extends List<OmdbUnit>> items) throws Exception {


        items.stream().forEach(item ->omdbUnitRepository.save(item));

    }
}
