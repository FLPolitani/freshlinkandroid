package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailPurchaseOrders{

	@SerializedName("data")
	private List<DetailPurchaseOrders> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DetailPurchaseOrders> data){
		this.data = data;
	}

	public List<DetailPurchaseOrders> getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDetailPurchaseOrders{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}