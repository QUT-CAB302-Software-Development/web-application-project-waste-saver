package example.application.service;

import example.application.exception.RecordNotFoundException;
import example.application.model.ReviewEntity;
import example.application.model.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired

    ReviewRepository repository;

    public List<ReviewEntity> getAllReview()
    {
        System.out.println("getAllReview");
        List<ReviewEntity> result = (List<ReviewEntity>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<ReviewEntity>();
        }
    }

    public ReviewEntity getReviewById(Long id) throws RecordNotFoundException {
        System.out.println("getReviewBYid");
        Optional<ReviewEntity> review = repository.findById(id);

        if(review.isPresent()) {
            return review.get();
        } else {
            throw new RecordNotFoundException("No review exist for given id");
        }
    }

    public ReviewEntity createOrUpdateUser(ReviewEntity entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<ReviewEntity> review = repository.findById(entity.getId());

            if (review.isPresent()) {
                ReviewEntity newEntity = review.get();
                newEntity.setAuthorID(entity.getAuthorID());
                newEntity.setTo_userID(entity.getTo_userID());
                newEntity.setRating(entity.getRating());
                newEntity.setMessage(entity.getMessage());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteReviewId(Long id) throws RecordNotFoundException {
        Optional<ReviewEntity> review = repository.findById(id);

        if(review.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No review exist for given id");
        }
    }

    public List<ReviewEntity> getAllReviewTo(Long toUserID){
        List<ReviewEntity> allReviews = (List<ReviewEntity>) repository.findAll();

        Iterator<ReviewEntity> iterator = allReviews.iterator();
        while (iterator.hasNext()) {
            ReviewEntity review = iterator.next();
            if (review.getTo_userID() != toUserID) {
                iterator.remove();
            }
        }

        return allReviews;
    }
}
