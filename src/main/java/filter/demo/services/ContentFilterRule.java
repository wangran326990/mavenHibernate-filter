package filter.demo.services;

public class ContentFilterRule implements FilterRule {

	private String content; 
	public ContentFilterRule(String content) {
		this.content = content;
	}
	public boolean check(String content) {
			return content.contains(this.content);
	}
}
