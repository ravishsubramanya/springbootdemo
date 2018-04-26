package co.tracert.demo.data.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import co.tracert.demo.model.Profile;

@EnableScan
public interface ProfileInfoRepository extends CrudRepository<Profile, String> {

	Profile getProfileById(String id);
}
