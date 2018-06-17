package co.tracert.service.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Profile {

	static Logger logger = LoggerFactory.getLogger(Profile.class);

	private String id;
	private String sex;
	private String firstName;
	private String lastName;
	private String aadhaar;
	private Employment employment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	public class Employment {

		Logger logger = LoggerFactory.getLogger(Employment.class);

		private EmploymentType employmentType;

		public EmploymentType getEmploymentType() {
			return employmentType;
		}

		public void setEmploymentType(EmploymentType employmentType) {
			this.employmentType = employmentType;
		}

		public Date getWorkingSince() {
			return workingSince;
		}

		public void setWorkingSince(Date workingSince) {
			this.workingSince = workingSince;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		private Date workingSince;
		private String company;
		private String designation;

	}

	enum EmploymentType {
		GOVERNMENT, PRIVATE, MILITARY;
	}

	enum Sex {
		MALE, FEMALE;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(File.separator);
		builder.append(firstName);
		builder.append(File.separator);
		builder.append(lastName);
		builder.append(File.separator);
		builder.append(sex);
		builder.append(File.separator);
		builder.append(aadhaar);
		builder.append(File.separator);
		builder.append(employment != null ? employment.getCompany() : "Employmentnotset");
		builder.append(File.separator);
		builder.append(employment != null ? employment.getDesignation() : "Employmentnotset");
		return builder.toString();
	}

	public static Profile getDefault() {
		Profile profile = new Profile();
		profile.setFirstName("Srikanth");
		profile.setLastName("Kotekar");
		profile.setSex(Sex.MALE.toString());
		profile.setAadhaar("aa0011");

		Employment employment = new Profile().new Employment();
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

		logger.info("profile - " + profile);

		return profile;
		/*
		 * logging.level.root=WARN logging.level.org.springframework.web=DEBUG
		 * logging.level.org.hibernate=ERROR logging.level.co.tracert=DEBUG
		 */
	}

}