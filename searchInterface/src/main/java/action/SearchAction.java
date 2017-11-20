package action;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.Properties;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import jade.wrapper.gateway.JadeGateway;

@Namespace("/")

public class SearchAction extends ActionSupport implements Preparable {

	public Map<String, String> hashMap = new HashMap<String, String>();
	public String message = null;
	public Map<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();

	@Action(value = "/", results = { @Result(name = "success", location = "/index.jsp") })
	public String execute() {

		return SUCCESS;

	}

	@Action(value = "listServices", results = { @Result(name = "success", location = "/listServices.jsp") })
	public String listServices() {
		return "success";
	}

	// @Action(value = "addService", results = {
	// @Result(name = "success", type = "redirectAction", params = {
	// "namespace", "/", "actionName", "/" }) })
	@Action(value = "searchService", results = { @Result(name = "success", location = "/index.jsp") })
	public String searchService() {
		System.out.println(hashMap);

		try {
			// JadeGateway.execute(service);
			ParallelBehaviour behaviour = new ParallelBehaviour();
			behaviour.addSubBehaviour(new OneShotBehaviour() {
				public void action() {
					final ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
					AID client = new AID("search", false);
					msg.addReceiver(client);
					try {
						msg.setContentObject((Serializable) hashMap);
						myAgent.send(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			behaviour.addSubBehaviour(new Behaviour() {
				String res = null;

				@Override
				public boolean done() {
					// TODO Auto-generated method stub
					if (res != null) {
						System.out.println("done = true");
						return true;
					}
					return false;
				}

				public void action() {
					ACLMessage msg = myAgent.receive();
					if (msg != null) {
						// String content = msg.getContent();
						res = msg.getContent();
						message = res;
						System.out.println("action response = " + message);

					} else {
						block();
					}
				}
			});
			JadeGateway.execute(behaviour);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "something wrong try later please thank you ";
		}
		System.out.println(message);
		message = message.replace("\n", "<br>");
		String[] s = message.split(":");
		int i = 1;
		for (String string : s) {
			String[] s2 = string.split(";");
			ArrayList<String> ll = new ArrayList<String>(Arrays.asList(s2));
			ll.add(0,i+"");
			result.put(i + "", ll);
			i++;
			if (ll.size()!=5) {
				if ("".equals(message.trim())) {
					message = "no result for your search";
				}else{
					message = "something wrong try later please thank you ";
				}
				
				result = new HashMap<String, ArrayList<String>>();
				break;
			}else{
				message = null;
			}
		}
		
		return "success";
	}

	public void prepare() throws Exception {
		/*
		 * System.out.println(ConsommateurAgent.class.getName() + "");
		 * Properties p = new Properties(); //
		 * "consommateur@192.168.145.1:1099/JADE" p.put("host",
		 * "192.168.145.1"); p.put("port", "1099"); p.put("container-name",
		 * "consommateur"); p.put("name", "Gateway"); //p.put("services",
		 * "jade.core.migration.InterPlatformMobilityService;jade.core.event.NotificationService"
		 * );
		 */
		// JadeGateway.init(ConsommateurAgent.class.getName(),null);
		// JadeGateway.init(null, null);
	}
}