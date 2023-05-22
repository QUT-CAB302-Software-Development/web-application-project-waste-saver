package example.application;

import example.application.exception.RecordNotFoundException;
import example.application.model.ReviewEntity;
import example.application.model.UserEntity;
import example.application.service.ReviewService;
import example.application.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DatabaseTests {
//
//    @Autowired
//    UserService service;
//
//    //@Autowired
//    //ReviewService rservice;
//
//    @Test
//    void testInit() {
//
//    }
//
//    @Test
//    void testGetUser() throws RecordNotFoundException {
//        UserEntity user1 = service.getUserById(1L);
//        System.out.println(user1);
//
//        assertEquals(user1.getFirstName(), "John");
//
//    }
//
////    @Test
////    void testGetReview() throws RecordNotFoundException {
////        ReviewEntity r1 = rservice.getReviewById(1L);
////        System.out.println(r1);
////
////        assertEquals(r1.getAuthorID(), 1);
////    }
//
//    @Test
//    void testGetByUsername() throws RecordNotFoundException {
//        UserEntity u1 = service.getUserByUsername("magicalBella");
//        System.out.println(u1);
//
//        assertEquals(u1.getSaverPoints(), 630);
//
//    }
}
