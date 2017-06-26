package backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class MyHandler extends AbstractHandler {
	PageSaver pageSaver;
	public MyHandler(PageSaver page){
		pageSaver = page;
	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		String command = request.getParameter("do");
		String[] commandList = command.split(",");
		long startTime = System.currentTimeMillis();
		switch (commandList[0]) {
		case "statSet":
			if (commandList.length != 8) {
				response.getWriter().println("false");
				break;
			}
			int a = Integer.parseInt(commandList[1]);
			int b = Integer.parseInt(commandList[2]);
			int c = Integer.parseInt(commandList[3]);
			int d = Integer.parseInt(commandList[4]);
			int e = Integer.parseInt(commandList[5]);

			Stat statt = new Stat();
			statt.set(a, b, c, d, e, commandList[6], commandList[7]);
			response.getWriter().println("I did IT");
			break;
		case "stat":
			Stat stat = new Stat();
			String sendStats = stat.status(commandList[1]);
			response.getWriter().println(sendStats);
			break;
		case "badQuest":
			if (commandList.length != 4) {
				response.getWriter().println("false");
				break;
			}
			Stat bad = new Stat();
			bad.setBadQuest(commandList[1], commandList[2], commandList[3]);
			response.getWriter().println("Add new bad quest");
			break;
		case "quest":
			if (commandList.length != 4) {
				response.getWriter().println("da stimmt was nicht");
			} else {

				Builder builder = new Builder( pageSaver);
				int quest = Integer.parseInt(commandList[2]);
				int answ = Integer.parseInt(commandList[3]);
				String sendBack = builder.buildQuest(commandList[1], quest, answ);
				response.getWriter().println(sendBack);
			}
			break;
		case "help":
			response.getWriter().println("Hello if you're trying to build your own quiz app you can take use of this server.");
			response.getWriter().println("There are a few commands you can use:");
			response.getWriter().println("1. Build a Question: The server can build you a question with multiple answers as you like.");
			response.getWriter().println("the methodcall is \"?do=quest,yourSMW,numberOfQuestions,numberOfPossibelAnswers\"");
			response.getWriter().println("Please note that a wrong SMW Link will result in an NullpointerException!!");
			response.getWriter().println("");
			response.getWriter().println("2. Get the % of Correct answerd Question listed by age or gender");
			response.getWriter().println("the methodcall is \"?do=stat,age\" for getting the results listed by age or \"?do=stat,gender\" for the gender results.");
			response.getWriter().println("age will give you the groups 0-20,21-30,31-40,41+ and gender will give male,female,undef,all");
			response.getWriter().println("");
			response.getWriter().println("3. Save a played game to the server.");
			response.getWriter().println("The methodcall here is \"?do=statSet,numberOfQuestions,numberOfCorrectAnswers,nummberOfPossibleAnswers,ageGroup,genderGroup,yourSMW,yourFeedback\"");
			response.getWriter().println("please pay attation for sending this as a correct HTTPGET request if there are any illigal chars the server can't save your game.");
			response.getWriter().println("to send the Correct age and gender group yu just need to send a number 0-20 send 1, 21-30 send 2... and so on ");
			response.getWriter().println("to set the gender you can type: male is 1, female is 2, undef is 3 and if sb. doesn't want to tell you you can send 4");
			response.getWriter().println("If you want to report a bad generated question use \"?do=badQuest,badAnswer,yourSMW\"");
			response.getWriter().println("If you have any questions or bugs to report you can contact me on github: https://github.com/blinor ");
			break;
		default:
			response.getWriter().println("Du hast da was falsch verstanden");
		}
		long endTime = System.currentTimeMillis();
		System.out.println(command);
		System.out.println(endTime-startTime);
		
	}

}
