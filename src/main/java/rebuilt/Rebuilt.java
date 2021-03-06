package rebuilt;

import java.io.IOException;
import java.util.List;

import crawler.SearchResultEntry;
import edu.net.itsearch.crawler.crawlers.UrlCollector;
import edu.net.itsearch.crawler.dao.impl.CrawlListWriter;
import edu.net.itsearch.elasticsearch.dao.impl.EsCreatIndex;
/**
 * 
 * @author 12858
 * @data 2020/01/09
 */
public class Rebuilt {
	public static void main(String[] args) {
		System.out.println("正在重构...");
		EsCreatIndex index = new EsCreatIndex();
		try {
			index.deleteIndex();
			UrlCollector.setResultWriter(new CrawlListWriter());
			List<SearchResultEntry> re = UrlCollector.crawl();
			System.out.println("本次共爬取到" + re.size() + "条数据");
			System.out.println("正在插入到Elasticsearch...");
			EsCreatIndex creat = new EsCreatIndex();
			try {
				creat.bulkIndex(re);
				System.out.println("插入成功！！！");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("插入失败！！！");
				System.exit(1);
			}
			System.out.println("重构完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
