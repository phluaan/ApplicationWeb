package beans;

public class Cafe {
	public Cafe(String maLoaiCF, String tenCF, int nuocNK_Id, float giaban, NuocNhapKhau nuocNhapKhau) {
		this.maLoaiCF = maLoaiCF;
		this.tenCF = tenCF;
		this.nuocNK_Id = nuocNK_Id;
		this.giaban = giaban;
		this.nuocNhapKhau = nuocNhapKhau;
	}
	private String maLoaiCF;
	private String tenCF;
	private int nuocNK_Id;
	private float giaban;
	private NuocNhapKhau nuocNhapKhau;
	public String gettenCF() {
		return tenCF;
	}
	public void settenCF(String tenCF) {
		this.tenCF = tenCF;
	}
	public String getmaLoaiCF() {
		return maLoaiCF;
	}
	public void setmaLoaiCF(String maLoaiCF) {
		this.maLoaiCF = maLoaiCF;
	}
	public int getnuocNK_Id() {
		return nuocNK_Id;
	}
	public void setnuocNK_Id(int nuocNK_Id) {
		this.nuocNK_Id = nuocNK_Id;
	}
	public float getGiaban() {
		return giaban;
	}
	public void setGiaban(float giaban) {
		this.giaban = giaban;
	}
	public NuocNhapKhau getNuocNhapKhau() {
		return nuocNhapKhau;
	}
	public void setNuocNhapKhau(NuocNhapKhau nuocNhapKhau) {
		this.nuocNhapKhau = nuocNhapKhau;
	}
}
