package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseProduk implements Serializable{

	@SerializedName("data")
	private List<Produk> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<Produk> data){
		this.data = data;
	}

	public List<Produk> getData(){
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
			"ResponseProduk{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}