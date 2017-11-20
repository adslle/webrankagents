package webservice.agent;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.wrapper.gateway.GatewayAgent;
import webservicerank.servicePublish.ServicePublish;
import webservicerank.uiAppInterface.PublisherInterface;
import webservicerank.uiAppInterface.ServiceDetail;

public class PublisherAgent extends GatewayAgent {
	@Override
	protected void setup() {
		ParallelBehaviour behaviour = new ParallelBehaviour();
		addBehaviour(behaviour);
		behaviour.addSubBehaviour(new CyclicBehaviour() {

			public void action() {

				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					String message = "-";
					ACLMessage msg2 = msg.createReply();
					// String content = msg.getContent();

					try {
						Map<String, String> hashMap = (Map<String, String>) msg.getContentObject();
						System.out.println("Content hashMap= " + hashMap);
						ServiceDetail serviceDetail = new ServiceDetail();
						String[] categories = hashMap.get("category").split("\\,");
						serviceDetail.setCategory(categories);
						serviceDetail.setName(hashMap.get("name"));
						serviceDetail.setWsdlURL(hashMap.get("wsdl"));
						serviceDetail.setProperties(hashMap.get("properties").split("\\;"));
						serviceDetail.setHomeURL(hashMap.get("homeUrl"));
						serviceDetail.setOwlURL(hashMap.get("owl"));
						serviceDetail.setCost(Float.valueOf(hashMap.get("cost")));
						serviceDetail.setDescription(hashMap.get("description"));
						long serviceDuration[] = new long[1];
						int[] invoke_counts = new int[] { 0, 0, 0 };
						int publisherId = 2;
						ServicePublish servicePublish = null;
						boolean validate[] = new boolean[2];
						try {
							servicePublish = new ServicePublish();
							validate = servicePublish.validate(serviceDetail.getWsdlURL(), serviceDetail.getName(),
									serviceDuration, invoke_counts);
							serviceDetail.setServiceDuration((int) serviceDuration[0]);
							try {
								if (publisherId == 0) {
									message += "log first thank you";
								} else {
									message += Arrays.toString(servicePublish.publish(serviceDetail, publisherId));
								}
							} catch (Throwable ex) {
								Logger.getLogger(PublisherInterface.class.getName()).log(Level.SEVERE, null, ex);
								message += "Sorry! Error encountered while publishing! ";
								String error = ex.getMessage();
								message += (error != null) ? error : "";
							}
						} catch (Throwable ex) {
							Logger.getLogger(PublisherInterface.class.getName()).log(Level.SEVERE, null, ex);
							message += "The system encountered an error! \n";
							String error = ex.getMessage();
							message += (error != null) ? error + "\n" : "\n";
						}

					} catch (UnreadableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						message += e.getMessage();
					}
					// String[] res= content.split(";;;");
					msg2.setContent(message);
					myAgent.send(msg2);
				} else {
					block();
				}
			}
		});
	}

	@Override
	protected void processCommand(Object arg0) {
		// TODO Auto-generated method stub
		super.processCommand(arg0);
	}

}
