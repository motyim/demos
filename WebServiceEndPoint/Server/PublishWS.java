package mypack;  
import javax.xml.ws.Endpoint;  

//Endpoint publisher  
public class PublishWS{  
    public static void main(String[] args) {  
       		//vaild url 
       		Endpoint.publish("http://localhost:7779/ws/hello", new ServerImp());  
       		System.out.println("Published ...");
        }  
}  