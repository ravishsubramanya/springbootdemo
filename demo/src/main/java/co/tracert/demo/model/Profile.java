package co.tracert.demo.model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@DynamoDBTable(tableName = "ProfileInfo")
@Getter
@Setter
public class Profile {

	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	private @NonNull String id;

	@DynamoDBAttribute(attributeName = "sex")
	private @NonNull String sex;

	@DynamoDBAttribute(attributeName = "firstName")
	private @NonNull String firstName;

	@DynamoDBAttribute(attributeName = "lastName")
	private @NonNull String lastName;

	@DynamoDBAttribute(attributeName = "aadhaar")
	private @NonNull String aadhaar;

	@DynamoDBTypeConverted(converter = EmployeeTypeConverter.class)
	private @NonNull Employment employment;

	static public class EmployeeTypeConverter implements DynamoDBTypeConverter<String, Employment> {

		@Override
		public String convert(Employment e) {
			Employment employment = (Employment) e;
			String emp = null;
			try {
				if (employment != null) {
					emp = String.format("%s x %s x %s x %s", employment.getCompany(), employment.getDesignation(),
							employment.getEmploymentType(),
							new SimpleDateFormat("dd-MM-yyyy").format(employment.getWorkingSince()));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return emp;
		}

		@Override
		public Employment unconvert(String s) {
			Employment employment = new Profile().new Employment();

			try {
				if (s != null && s.length() != 0) {
					String[] data = s.split("x");
					employment.setCompany(data[0].trim());
					employment.setDesignation(data[1].trim());
					employment.setEmploymentType(EmploymentType.valueOf(data[2].trim()));
					employment.setWorkingSince(new SimpleDateFormat("dd-MM-yyyy").parse(data[3].trim()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return employment;
		}

	}

	@Getter
	@Setter
	public class Employment {

		@DynamoDBAttribute(attributeName = "employmentType")
		private EmploymentType employmentType;

		@DynamoDBAttribute(attributeName = "workingSince")
		private Date workingSince;

		@DynamoDBAttribute(attributeName = "company")
		private String company;

		@DynamoDBAttribute(attributeName = "designation")
		private String designation;

	}

	enum EmploymentType {
		GOVERNMENT, PRIVATE, MILITARY;
	}

	enum Sex {
		MALE, FEMALE;
	}

	@DynamoDBIgnore
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

	@DynamoDBIgnore
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

		System.out.println(profile);

		return profile;
		/*
		 * logging.level.root=WARN logging.level.org.springframework.web=DEBUG
		 * logging.level.org.hibernate=ERROR logging.level.co.tracert=DEBUG
		 */
	}

}