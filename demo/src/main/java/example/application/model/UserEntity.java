package example.application.model;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="password")
	private String password;

	@Column(name="email", nullable=false, length=200)
	private String email;

	@Column(name="latitude", precision=9, scale=6)
	private Double latitude;

	@Column(name="longitude", precision=9, scale=6)
	private Double longitude;

	@Column(name="user_name")
	private String username;

	@Column(name="saver_points")
	private int saverPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}


	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSaverPoints() {
		return saverPoints;
	}

	public void setSaverPoints(int saverPoints) {
		this.saverPoints = saverPoints;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName +
				", lastName=" + lastName + ", email=" + email   +
				", latitude=" + latitude + ", longitude=" + longitude +
				", username-" + username + "saverPoints=" + saverPoints + "]";
	}
}
