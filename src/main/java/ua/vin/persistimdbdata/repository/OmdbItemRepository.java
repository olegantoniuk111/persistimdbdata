package ua.vin.persistimdbdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.vin.persistimdbdata.model.OmdbItem;


@Repository
public interface OmdbItemRepository extends CrudRepository<OmdbItem, String> {

}
