package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JenisProduk implements Serializable{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("nama_jenis_produk")
	private String namaJenisProduk;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNamaJenisProduk(String namaJenisProduk){
		this.namaJenisProduk = namaJenisProduk;
	}

	public String getNamaJenisProduk(){
		return namaJenisProduk;
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

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	@Override
 	public String toString(){
		return 
			"JenisProduk{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",nama_jenis_produk = '" + namaJenisProduk + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}