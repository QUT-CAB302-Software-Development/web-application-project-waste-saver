package example.application.service;

import example.application.model.UserEntity;
import example.application.model.repository.UserRepository;
import example.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.application.exception.RecordNotFoundException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired

    UserRepository repository;
    public List<UserEntity> getAllUser()
    {
        System.out.println("getAllUser");
        List<UserEntity> result = (List<UserEntity>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<UserEntity>();
        }
    }
    public UserEntity getUserById(Long id) throws RecordNotFoundException {
        System.out.println("getUserBYid");
        Optional<UserEntity> user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        }
        else {
            throw new RecordNotFoundException("No User record exist for given id");
        }

    }

    public UserEntity getUserByUserName(String username) {
        System.out.println("getAllusername");
        List<UserEntity> result = (List<UserEntity>) repository.findAll();
        for(UserEntity user: result)
        {
            if(user.getUsername() == null) return null;
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }
    public UserEntity createOrUpdateUser(UserEntity entity) {
        if (entity.getId() == null) {
            entity = repository.save(entity);

            return entity;
        } else {
            Optional<UserEntity> user = repository.findById(entity.getId());

            if (user.isPresent()) {
                UserEntity newEntity = user.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity.setPass(entity.getPass());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }
    public void deleteUserId(Long id) throws RecordNotFoundException {
        Optional<UserEntity> user = repository.findById(id);

        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id");
        }
    }
}
