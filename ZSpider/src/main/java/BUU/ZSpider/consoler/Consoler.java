package BUU.ZSpider.consoler;

import BUU.ZSpider.pageProcess.CommonPageprocess;
import us.codecraft.webmagic.Spider;

public class Consoler {
	public static void main(String[] args) {
		Spider.create(new CommonPageprocess()).addUrl("http://focus.tianya.cn//")
				.run();
	}
}
