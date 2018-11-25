package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Produk implements Serializable{

	@SerializedName("keterangan")
	private Object keterangan;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("kategori")
	private Kategori kategori;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("kategori_id")
	private int kategoriId;

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("foto")
	private String foto;

	@SerializedName("satuan_terkecil_id")
	private int satuanTerkecilId;

	@SerializedName("satuan")
	private Satuan satuan;

	@SerializedName("jenis_produk")
	private JenisProduk jenisProduk;

	@SerializedName("jenis_produk_id")
	private int jenisProdukId;

	@SerializedName("id")
	private int id;

	@SerializedName("harga_jual")
	private int hargaJual;

	@SerializedName("harga_petani")
	private int hargaPetani;

	public void setKeterangan(Object keterangan){
		this.keterangan = keterangan;
	}

	public Object getKeterangan(){
		return keterangan;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setKategori(Kategori kategori){
		this.kategori = kategori;
	}

	public Kategori getKategori(){
		return kategori;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setKategoriId(int kategoriId){
		this.kategoriId = kategoriId;
	}

	public int getKategoriId(){
		return kategoriId;
	}

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

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setSatuanTerkecilId(int satuanTerkecilId){
		this.satuanTerkecilId = satuanTerkecilId;
	}

	public int getSatuanTerkecilId(){
		return satuanTerkecilId;
	}

	public void setSatuan(Satuan satuan){
		this.satuan = satuan;
	}

	public Satuan getSatuan(){
		return satuan;
	}

	public void setJenisProduk(JenisProduk jenisProduk){
		this.jenisProduk = jenisProduk;
	}

	public JenisProduk getJenisProduk(){
		return jenisProduk;
	}

	public void setJenisProdukId(int jenisProdukId){
		this.jenisProdukId = jenisProdukId;
	}

	public int getJenisProdukId(){
		return jenisProdukId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHargaJual(int hargaJual){
		this.hargaJual = hargaJual;
	}

	public int getHargaJual(){
		return hargaJual;
	}

	public void setHargaPetani(int hargaPetani){
		this.hargaPetani = hargaPetani;
	}

	public int getHargaPetani(){
		return hargaPetani;
	}

	@Override
 	public String toString(){
		return 
			"Produk{" +
			"keterangan = '" + keterangan + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",kategori = '" + kategori + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",kategori_id = '" + kategoriId + '\'' + 
			",nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",foto = '" + foto + '\'' +
			",satuan_terkecil_id = '" + satuanTerkecilId + '\'' +
			",satuan = '" + satuan + '\'' + 
			",jenis_produk = '" + jenisProduk + '\'' + 
			",jenis_produk_id = '" + jenisProdukId + '\'' + 
			",id = '" + id + '\'' + 
			",harga_jual = '" + hargaJual + '\'' + 
			",harga_petani = '" + hargaPetani + '\'' + 
			"}";
		}
}