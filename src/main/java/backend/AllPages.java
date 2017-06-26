package backend;

public class AllPages {
	public String pages(String wiki) {
		String[] page ;
		switch (wiki) {
		case "http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/":
			page = new String[] { "", "Absatzdateien", "Main Page", "Start", "Tatigkeitsfelder",
					"Betreuungsformulare", "Zufalliger Mitarbeiter", "Modelle", "Veranstaltungen", "Mitarbeiter",
					"Drift-Kurs", "2016/02/04 08:00", "Buromateriallager", "Serviceubersicht" };
			break;
		default:
			page = new String[] { "", "Main Page" };
			break;
		}
		String pages ="";
		for(int i = 0;i<page.length;i++){
			pages += page[i];
		}
		return pages;

	}

}
