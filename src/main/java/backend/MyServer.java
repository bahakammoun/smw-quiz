package backend;


import org.eclipse.jetty.server.Server;
 
public class MyServer {
	public MyServer(PageSaver page){
		Server server = new Server(8080);
		server.setHandler(new MyHandler(page));
		try{
			server.start();
			server.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

