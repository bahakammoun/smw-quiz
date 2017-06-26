package backend;

public class AllPropertys {
	public String[] category(String wiki) {
		String cat[] = null;

		switch (wiki) {
		case "http://aifb-ls3-vm2.aifb.kit.edu/smw-seminar2/":
			cat = new String[] { "", "_SKEY", "_ASK", "_MDAT", "_SOBJ", "_SF_PDF", "Wintersemester", "Sommersemester",
					"Is_product", "_INST", "_ERRP", "Hat_Bild", "Hat_Video" };
			break;

		default:
			cat = new String[] { "", "_SKEY", "_ASK", "_SF_PDF", "_MDAT", "_INST" };

			break;
		}

		return cat;
	}

}
