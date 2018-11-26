package org.mql.platform.business.media;

import java.util.List;

import org.mql.platform.models.Activity;
import org.mql.platform.models.Event;
import org.mql.platform.models.News;

public interface PublicationService {
	
	List<Activity> getAllActivities();

	List<Event> getAllEvents();

	List<News> getAllNews();

	Activity getActivity(Long id);

	Event getEvent(Long id);

	News getNews(Long id);

	boolean addOrUpdateActivity(Activity activity);

	boolean addOrUpdateEvent(Event event);

	boolean addOrUpdateNews(News news);

	void deleteActivity(Long id);

	void deleteEvent(Long id);

	void deleteNews(Long id);
}
