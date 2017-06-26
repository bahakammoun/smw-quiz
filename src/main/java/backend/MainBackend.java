package backend;


public class MainBackend {
	public static void main(String[] args) {
		
	PageSaver page = new PageSaver();
	MyServer server = new MyServer(page);
}
}