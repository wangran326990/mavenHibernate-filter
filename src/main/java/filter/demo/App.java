package filter.demo;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import filter.demo.daos.ClubUsageDao;
import filter.demo.db.HibernateUtil;
import filter.demo.models.ClubUsage;
import filter.demo.services.ErrorTypes;
import filter.demo.services.FilterService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FilterService filterService = new FilterService();
    	Map<ErrorTypes, List<ClubUsage>> results = filterService.listErrorByTypes();
    	for(Map.Entry<ErrorTypes, List<ClubUsage>> result : results.entrySet()) {
    		System.out.println(result.getKey().toString()+": " + result.getValue().size());
    	}
    }
}
