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
import webservicerank.serviceRanker.ServiceRanker;
import webservicerank.uiAppInterface.PublisherInterface;
import webservicerank.uiAppInterface.ServiceDetail;

public class SearchAgent extends GatewayAgent {
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
						System.out.println(hashMap);
						
						ServiceDetail serviceDetail = new ServiceDetail();
						serviceDetail.setCategory(hashMap.get("category").split("\\,"));     
			            serviceDetail.setProperties(hashMap.get("properties").split("\\;"));
			            boolean isPriority = false; 
			            boolean isQosParamsWeighted = false;
			            boolean isAvoidSemanticMatchmake = false;
			            float[] weight = new float[5];
			            if (isQosParamsWeighted){
			                weight[0] = Float.valueOf(hashMap.get("reliability"));
			                weight[1] = Float.valueOf(hashMap.get("efficiency"));
			                weight[2] = Float.valueOf(hashMap.get("availability"));
			                weight[3] = Float.valueOf(hashMap.get("cost_effectiveness"));
			                weight[4] = Float.valueOf(hashMap.get("reputaion"));
			                float sum = 0.0f;
			                for (int i=0; i<weight.length; i++){
			                    sum += weight[i];
			                }
			                for (int i=0; i<weight.length; i++){
			                    weight[i] /= sum;
			                }
			            }else{
			                for (int i=0; i<weight.length; i++){
			                    weight[i] = 1.0f/5.0f;
			                }
			            }
			            ServiceRanker ranker;
			            try {
			                //Initialize and call ranking object
			                ranker = new ServiceRanker();
			                message = ranker.rank(serviceDetail, weight, isPriority, isAvoidSemanticMatchmake);
			            } catch (Throwable ex) {
			            	ex.printStackTrace();
			            	message = "Error:";
			            	message += (ex.getMessage()!=null)?ex.getMessage():"Error encountered\n";
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
