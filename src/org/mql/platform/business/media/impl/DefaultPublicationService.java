package org.mql.platform.business.media.impl;

import java.util.List;

import org.mql.platform.business.media.PublicationService;
import org.mql.platform.dao.ActivityRepository;
import org.mql.platform.dao.EventRepository;
import org.mql.platform.dao.NewsRepository;
import org.mql.platform.models.Activity;
import org.mql.platform.models.Event;
import org.mql.platform.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DefaultPublicationService implements PublicationService {

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	public List<Activity> getAllActivities() {
		return activityRepository.findAll();
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public List<News> getAllNews() {
		return newsRepository.findAll();
	}

	public Activity getActivity(Long id) {
		return  activityRepository.getOne(id);
	}

	public Event getEvent(Long id) {
		return eventRepository.getOne(id);
	}

	public News getNews(Long id) {
		return newsRepository.getOne(id);
	}

	@Transactional
	public boolean addOrUpdateActivity(Activity activity) {
		return activityRepository.save(activity) != null;
	}

	@Transactional
	public boolean addOrUpdateEvent(Event event) {
		return eventRepository.save(event) != null;
	}

	@Transactional
	public boolean addOrUpdateNews(News news) {
		return newsRepository.save(news) != null;
	}

	@Transactional
	public void deleteActivity(Long id) {
		activityRepository.deleteById(id);
	}

	@Transactional
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	@Transactional
	public void deleteNews(Long id) {
		newsRepository.deleteById(id);
	}

}
