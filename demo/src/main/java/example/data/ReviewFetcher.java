package example.data;

import example.application.model.ReviewEntity;
import example.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewFetcher {

    @Autowired
    ReviewService service;

    public ReviewFetcher(){}

    public List<ReviewEntity> getAllReviewsTo(Long id){
        return service.getAllReviewTo(id);
    }
}
