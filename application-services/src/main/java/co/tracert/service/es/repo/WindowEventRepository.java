package co.tracert.service.es.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.tracert.service.model.WindowEvent;

public interface WindowEventRepository extends ElasticsearchRepository<WindowEvent, Integer> {

	@Query("{\"bool\": {\"must\": [{\"match\": {\"hits.hit.source.source_name\": \"?0\"}}]}}")
	Page<WindowEvent> findEventsBySourceName(String source_name, Pageable pageable);
}
