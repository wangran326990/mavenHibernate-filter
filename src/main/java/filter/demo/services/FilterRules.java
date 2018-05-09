package filter.demo.services;

import java.util.ArrayList;
import java.util.List;

public class FilterRules {
	private List<FilterRule> rules;
	public List<FilterRule> getRules() {
		return rules;
	}

	public void setRules(List<FilterRule> rules) {
		this.rules = rules;
	}

	public FilterRules() {
		
	}
	
	public FilterRules addFilterRule(FilterRule filterRule) {
			if(rules==null) {
				rules = new ArrayList<FilterRule>();
			}
			rules.add(filterRule);
			return this;
	}
	
	public boolean doFilter(String content) {
		if(rules==null || rules.size()==0) {
			return false;
		}
		for(FilterRule rule : rules) {
			if(rule.check(content)==true) {
				return true;
			}
		}
		return false;
	}
}
