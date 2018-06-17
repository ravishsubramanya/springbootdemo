package co.tracert.service.data.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import co.tracert.service.model.Profile;

@EnableScan
public interface ProfileInfoRepository extends CrudRepository<Profile, String> {

	Profile getProfileById(String id);
}
