package politanismd.freshlink.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Produk implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("deleted_at")
    private Object deletedAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("jenis_produk_id")
    private Integer jenisProdukId;
    @SerializedName("satuan_terkecil_id")
    private Integer satuanTerkecilId;
    @SerializedName("kategori_id")
    private Integer kategoriId;
    @SerializedName("keterangan")
    private String keterangan;
    @SerializedName("harga_petani")
    private Integer hargaPetani;
    @SerializedName("harga_jual")
    private Integer hargaJual;
    @SerializedName("foto")
    private String foto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getJenisProdukId() {
        return jenisProdukId;
    }

    public void setJenisProdukId(Integer jenisProdukId) {
        this.jenisProdukId = jenisProdukId;
    }

    public Integer getSatuanTerkecilId() {
        return satuanTerkecilId;
    }

    public void setSatuanTerkecilId(Integer satuanTerkecilId) {
        this.satuanTerkecilId = satuanTerkecilId;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getHargaPetani() {
        return hargaPetani;
    }

    public void setHargaPetani(Integer hargaPetani) {
        this.hargaPetani = hargaPetani;
    }

    public Integer getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Integer hargaJual) {
        this.hargaJual = hargaJual;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
