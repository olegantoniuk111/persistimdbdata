package ua.vin.persistimdbdata.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OmdbUnitRepository extends CrudRepository<OmdbUnit, Long> {

}
