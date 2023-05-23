package example.application.service;

import example.application.exception.RecordNotFoundException;
import example.application.model.FoodEntity;
import example.application.model.UserEntity;
import example.application.model.repository.FoodRepository;
import example.application.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    FoodRepository repository;
    public List<FoodEntity> getAllFood()
    {
        System.out.println("getAllFood");
        List<FoodEntity> result = (List<FoodEntity>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<FoodEntity>();
        }
    }
    public FoodEntity getFoodById(Long id) throws RecordNotFoundException {
        System.out.println("getFoodBYid");
        Optional<FoodEntity> food = repository.findById(id);

        if(food.isPresent()) {
            return food.get();
        }
        else {
            throw new RecordNotFoundException("No food record exist for given id");
        }
    }

    public FoodEntity createOrUpdateUser(FoodEntity entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<FoodEntity> food = repository.findById(entity.getId());

            if (food.isPresent()) {
                FoodEntity newEntity = food.get();
                newEntity.setFoodName(entity.getFoodName());
                newEntity.setFoodType(entity.getFoodType());
                newEntity.setExpiry(entity.getExpiry());
                newEntity.setWeight(entity.getWeight());
                newEntity.setState(entity.getState());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }
    public void deleteFoodId(Long id) throws RecordNotFoundException {
        Optional<FoodEntity> food = repository.findById(id);

        if(food.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }

}
