package BUU.ZSpider.pageProcess;

import java.io.IOException;
import java.util.List;

import BUU.ZSpider.dao.FileDao;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class CommonPageprocess implements PageProcessor {
	protected Site site = Site
			.me()
			.setRetryTimes(3)
			.setSleepTime(0)
			.setTimeOut(100000)
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.33 Safari/535.11");
	FileDao fileDao;

	public CommonPageprocess() {
		fileDao = new FileDao();
	}

	public void process(Page page) {
//		page.getHtml().nodes().get(0).nodes()
		
		
		
		
		try {
			// page.
			fileDao.WriteTOLocal(page.getHtml().toString());
		} catch (IOException e) {
			System.err.println("文件写入出错！");
			e.printStackTrace();
		}
		List<String> urls = page.getHtml().links().all();

		for (String url : urls) {
			System.out.println(url);
			if (url.endsWith("html"))
				page.addTargetRequest(url);
		}

	}

	public Site getSite() {
		return site;
	}

}
