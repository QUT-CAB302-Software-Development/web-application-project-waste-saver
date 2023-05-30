package example.application;


import example.application.controllers.MapViewController;
import example.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

	private MapViewController mapViewController;

	@BeforeEach
	void setUp() {
		mapViewController = new MapViewController();
	}

	@Test
	void contextLoads() {
	}
	/*
	@Test
	void  testGetUserRadius() {

		User user = new User("John", "demo", "123", "john@example.com", new double[]{0.0, 0.0});


		String radius = mapViewController.getUserRadius(user);

		assertEquals("80", radius);
	}

	@Test
	void testUpdateUserRadius() {
		// Create a User object

		User user = new User("John", "demo","123", "john@example.com", new double[]{0.0, 0.0});


		// Call the getUserRadius() method to get the initial radius value
		String initialRadius = mapViewController.getUserRadius(user);

		// Assert that the initial radius is "80"
		assertEquals("80", initialRadius);

		// Call a setter method or directly modify the 'dummyRadius' variable to update the radius
		mapViewController.dummyRadius = "100";

		// Call the getUserRadius() method again to get the updated radius value
		String updatedRadius = mapViewController.getUserRadius(user);

		// Assert that the updated radius is "100"
		assertEquals("100", updatedRadius);
	}

	@Test
	void testCalculateDistance() {
		// Coordinates for location 1
		double lat1 = -27.4785;
		double lon1 = 153.0284;

		// Coordinates for location 2
		double lat2 = -27.4783;
		double lon2 = 153.0290;

		// Call the calculateDistance() method to get the actual distance
		double actualDistance = mapViewController.calculateDistance(lat1, lon1, lat2, lon2);
		double tolerance = 0.1;

		assertEquals(63.23, actualDistance, tolerance);
	}

	@Test
	void testWithinBoundary() {
		// Coordinates for location 1
		double [] coords1 = {-27.4785, 153.0284};

		// Coordinates for location 2 within the boundary
		double [] coords2 = {-27.4783, 153.0290};

		// Call the withinBoundary() method to check if location 2 is within the boundary of location 1
		boolean isWithinBoundary = mapViewController.withinDistance(coords1, coords2);

		// Assert that location 2 is within the boundary of location 1
		assertTrue(isWithinBoundary);

		// Coordinates for location 3 outside the boundary
		double lat3 = -27.4795;
		double lon3 = 153.0300;
		double [] coords3 = {-27.4795, 153.0300};

		// Call the withinBoundry() method to check if location 3 is within the boundary of location 1
		isWithinBoundary = mapViewController.withinDistance(coords1, coords3);

		// Assert that location 3 is not within the boundary of location 1
		assertFalse(isWithinBoundary);
	}

	@Test
	void testExpirationDateColor() {
		// Test case 1: time >= 1000, expected result: "Red"
		String result1 = mapViewController.expirationDateColor(1000);
		assertEquals("Red", result1);

		// Test case 2: 500 <= time < 1000, expected result: "Orange"
		String result2 = mapViewController.expirationDateColor(750);
		assertEquals("Orange", result2);

		// Test case 3: 10 <= time < 500, expected result: "Red"
		String result3 = mapViewController.expirationDateColor(100);
		assertEquals("Red", result3);

		// Test case 4: time < 10, expected result: "Black"
		String result4 = mapViewController.expirationDateColor(5);
		assertEquals("Black", result4);
	}
	*/
}
