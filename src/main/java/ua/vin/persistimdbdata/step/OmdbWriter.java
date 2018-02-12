package ua.vin.persistimdbdata.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.vin.persistimdbdata.model.OmdbUnit;
import ua.vin.persistimdbdata.model.OmdbUnitRepository;
import java.util.List;

public class OmdbWriter implements ItemWriter<OmdbUnit>{

    @Autowired
    public OmdbUnitRepository omdbUnitRepository;

    @Override
    public void write(List<? extends OmdbUnit> items) throws Exception {
        omdbUnitRepository.save(items);
    }
}
