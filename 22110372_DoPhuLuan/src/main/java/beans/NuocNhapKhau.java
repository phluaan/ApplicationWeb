package beans;

public class NuocNhapKhau {
	public NuocNhapKhau(int nuocNK_id, String tenNuoc) {
		this.nuocNK_id = nuocNK_id;
		this.tenNuoc = tenNuoc;
	}
	private int nuocNK_id;
	private String tenNuoc;
	public int getnuocNK_id() {
		return nuocNK_id;
	}
	public void setnuocNK_id(int nuocNK_id) {
		this.nuocNK_id = nuocNK_id;
	}
	public String getTenNuoc() {
		return tenNuoc;
	}
	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}
	
}
