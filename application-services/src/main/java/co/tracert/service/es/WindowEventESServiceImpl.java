package co.tracert.service.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import co.tracert.service.es.repo.WindowEventRepository;
import co.tracert.service.model.WindowEvent;

@Service
public class WindowEventESServiceImpl implements WindowEventESService {

	private WindowEventRepository eventRepository;

	@Autowired
	public void setEventRepository(WindowEventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public Page<WindowEvent> findEventsBySourceName(String source_name, PageRequest pageRequest) {
		return eventRepository.findEventsBySourceName(source_name, pageRequest);
	}

}
