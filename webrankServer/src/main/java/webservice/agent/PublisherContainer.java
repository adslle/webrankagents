package webservice.agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class PublisherContainer {
	public static void main(String[] args) {
		try {
			Runtime runtime = Runtime.instance();
			ProfileImpl impl = new ProfileImpl(false);
			impl.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			AgentContainer agentContainer = runtime.createAgentContainer(impl);
			AgentController agentController = agentContainer.createNewAgent("publisher",PublisherAgent.class.getName(), new Object[] {});
			agentController.start();
		} catch (ControllerException e) { 
			// TODO: handle exception 
		}
	}

}
