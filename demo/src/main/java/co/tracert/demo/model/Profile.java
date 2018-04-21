package co.tracert.demo.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@Data
@Getter
@Setter
public class Profile {

	private @NonNull Sex sex;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull Date dob;
	private @NonNull String aadhaar;
	private Employment employment;
	private List<Interests> interests = new ArrayList<Interests>();
	private List<BooksRead> booksRead;

	enum Sex {
		MALE, FEMALE;
	}

	enum Interests {
		TECHNOLOGY, SELFDEVELOPMENT, POLITICS, ENTREPRENEURSHIP, BOOKS, SPORTS;
	}

	@Getter
	@Setter
	@Data
	class Employment {
		private EmploymentType employmentType;
		private String company;
		private String designation;
		private Date workingSince;
	}

	enum EmploymentType {
		GOVERNMENT, PRIVATE, MILITARY;
	}

	@Getter
	@Setter
	class BooksRead {
		private String title;
		private String author;
		private String genre;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(File.separator);
		builder.append(lastName);
		builder.append(File.separator);
		builder.append(sex);
		builder.append(File.separator);
		builder.append(aadhaar);
		builder.append(File.separator);
		builder.append(employment);
		builder.append(File.separator);
		builder.append(interests);
		builder.append(File.separator);
		builder.append(booksRead);
		log.info("testing logging with lombok- " + builder.toString());
		return builder.toString();
	}

	public static Profile getDefault() {
		Profile profile = new Profile();
		profile.setFirstName("Srikanth");
		profile.setLastName("Kotekar");
		profile.setSex(Sex.MALE);
		profile.setAadhaar("aa0011");

		Profile.Employment employment = new Profile().new Employment();
		employment.setCompany("TCSL");
		employment.setDesignation("Consultant");
		employment.setEmploymentType(EmploymentType.PRIVATE);
		try {
			employment.setWorkingSince(new SimpleDateFormat("dd-MM-yyyy").parse("03-05-2004"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profile.setEmployment(employment);

		profile.getInterests().add(Interests.BOOKS);
		profile.getInterests().add(Interests.TECHNOLOGY);

		System.out.println(profile);

		return profile;
		/*
		 * logging.level.root=WARN logging.level.org.springframework.web=DEBUG
		 * logging.level.org.hibernate=ERROR logging.level.co.tracert=DEBUG
		 */
	}

}