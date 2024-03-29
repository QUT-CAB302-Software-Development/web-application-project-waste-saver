package example.application.model.repository;

import example.application.model.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository
        extends CrudRepository<ReviewEntity, Long> {
}
