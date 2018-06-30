package co.tracert.service.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import co.tracert.service.model.WindowEvent;

public interface WindowEventESService {

	Page<WindowEvent> findEventsBySourceName(String source_name, PageRequest pageRequest);

}
