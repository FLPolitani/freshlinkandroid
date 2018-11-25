
package mobile.apps.bi.id.lagipanen.lagipanenapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaketInvestasi {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("rentang_massa")
    @Expose
    private String rentangMassa;
    @SerializedName("lama_kontrak")
    @Expose
    private String lamaKontrak;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getRentangMassa() {
        return rentangMassa;
    }

    public void setRentangMassa(String rentangMassa) {
        this.rentangMassa = rentangMassa;
    }

    public String getLamaKontrak() {
        return lamaKontrak;
    }

    public void setLamaKontrak(String lamaKontrak) {
        this.lamaKontrak = lamaKontrak;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
