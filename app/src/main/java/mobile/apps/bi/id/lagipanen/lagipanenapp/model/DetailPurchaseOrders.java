package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import com.google.gson.annotations.SerializedName;

public class DetailPurchaseOrders {

	@SerializedName("purchase_orders_id")
	private int purchaseOrdersId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("jumlah")
	private int jumlah;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("satuan_id")
	private int satuanId;

	@SerializedName("id")
	private int id;

	@SerializedName("produk_id")
	private int produkId;

	@SerializedName("harga_jual")
	private int hargaJual;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public void setPurchaseOrdersId(int purchaseOrdersId){
		this.purchaseOrdersId = purchaseOrdersId;
	}

	public int getPurchaseOrdersId(){
		return purchaseOrdersId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setJumlah(int jumlah){
		this.jumlah = jumlah;
	}

	public int getJumlah(){
		return jumlah;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setSatuanId(int satuanId){
		this.satuanId = satuanId;
	}

	public int getSatuanId(){
		return satuanId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProdukId(int produkId){
		this.produkId = produkId;
	}

	public int getProdukId(){
		return produkId;
	}

	public void setHargaJual(int hargaJual){
		this.hargaJual = hargaJual;
	}

	public int getHargaJual(){
		return hargaJual;
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
			"DetailPurchaseOrders{" +
			"purchase_orders_id = '" + purchaseOrdersId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",jumlah = '" + jumlah + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",satuan_id = '" + satuanId + '\'' + 
			",id = '" + id + '\'' + 
			",produk_id = '" + produkId + '\'' + 
			",harga_jual = '" + hargaJual + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}