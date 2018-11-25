package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Kategori implements Serializable{

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("parent_kategori_id")
	private int parentKategoriId;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setParentKategoriId(int parentKategoriId){
		this.parentKategoriId = parentKategoriId;
	}

	public int getParentKategoriId(){
		return parentKategoriId;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	@Override
 	public String toString(){
		return 
			"Kategori{" + 
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",parent_kategori_id = '" + parentKategoriId + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}