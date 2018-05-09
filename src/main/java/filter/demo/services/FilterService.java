package filter.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import filter.demo.daos.ClubUsageDao;
import filter.demo.models.ClubUsage;





public class FilterService {
		Map<ErrorTypes, FilterRules> filters;
		public FilterService() {
			filters = new HashMap<ErrorTypes, FilterRules>();
			filters.put(ErrorTypes.API_JOIN, 
					new FilterRules().addFilterRule(new ContentFilterRule("API JOIN")));
			filters.put(ErrorTypes.ERROR_REMINDER, 
					new FilterRules().addFilterRule(new ContentFilterRule("Error reminder")));
			filters.put(ErrorTypes.SYSYEM_ACCESS_ERROR, 
					new FilterRules().addFilterRule(new ContentFilterRule("System Access")));
		}
		
		public void addFilter(ErrorTypes errorType, FilterRules filterRules) {
				if(filters.containsKey(errorType)) {
					for(FilterRule rule:filterRules.getRules())
						filters.get(errorType).addFilterRule(rule);
				}else {
					filters.put(errorType, filterRules);
				}	
		}
		
		public Map<ErrorTypes, List<ClubUsage>> listErrorByTypes(){
			Map<ErrorTypes, List<ClubUsage>> result = new HashMap<ErrorTypes, List<ClubUsage>>(); 
			ClubUsageDao clubUsageDao = new ClubUsageDao();
			List<ClubUsage> list = clubUsageDao.list();
			if(list ==null ||list.size() ==0) {
				return result;
			}
			for(ClubUsage clubUsage: list) {
				for(Map.Entry<ErrorTypes, FilterRules> filter : filters.entrySet()) {
					if(filter.getValue().doFilter(clubUsage.getPageId())) {
						if(!result.containsKey(filter.getKey())) {
							result.put(filter.getKey(), new ArrayList<ClubUsage>());
						}
						result.get(filter.getKey()).add(clubUsage);
					}
				}
			}
			return result;
		}
		
}
