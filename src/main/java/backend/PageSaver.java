package backend;

import java.util.ArrayList;
import java.util.HashMap;

public class PageSaver {
	HashMap<String, Integer> time = new HashMap<String, Integer>();
	HashMap<String, ArrayList<String>> page = new HashMap<String, ArrayList<String>>();

	public int getTime(String wiki) {
		int tempTime = (int) System.currentTimeMillis();
		int re = Integer.MAX_VALUE;
		try {
			re = tempTime - time.get(wiki);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Time since last save"+re);

		return re;
	}

	public void setTime(String wiki) {
		time.put(wiki, (int) System.currentTimeMillis());
	}

	public ArrayList<String> getPages(String wiki) {
		return page.get(wiki);
	}

	public void savePage(String wiki, ArrayList<String> pages) {
		page.put(wiki, pages);
		time.put(wiki, (int) System.currentTimeMillis());
	}

}
