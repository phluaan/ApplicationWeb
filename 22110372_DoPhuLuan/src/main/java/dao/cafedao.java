package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cafe;
import beans.NuocNhapKhau;
import service.connectDB;

public class cafedao {
	public static List<Cafe> DS() {
		List<Cafe> kq = new ArrayList<Cafe>();
		Connection db = connectDB.DB();
		String sql="Select * from Cafe join NuocNhapKhau on Cafe.NuocNK_Id = NuocNhapKhau.NuocNK_Id";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq.add(new Cafe(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), new NuocNhapKhau(rs.getInt(5), rs.getString(6))));
			}
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	public static List<Cafe> DSTheoLoaiNuoc(int NuocNK_Id) {
		List<Cafe> kq = new ArrayList<Cafe>();
		Connection db = connectDB.DB();
		String sql="Select * from Cafe join NuocNhapKhau on Cafe.NuocNK_Id = NuocNhapKhau.NuocNK_Id where NuocNhapKhau.NuocNK_Id = ?";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			state.setInt(1, NuocNK_Id);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq.add(new Cafe(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), new NuocNhapKhau(rs.getInt(5), rs.getString(6))));
			}
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}

	
	public static List<NuocNhapKhau> DSNuocNhapKhau() {
		List<NuocNhapKhau> kq = new ArrayList<NuocNhapKhau>();
		Connection db = connectDB.DB();
		String sql="Select * from NuocNhapKhau";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq.add(new NuocNhapKhau(rs.getInt(1), rs.getString(2)));
			}
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public static Cafe laycafe(String Ma) {
		Cafe kq = null;
		Connection db = connectDB.DB();
		String sql="Select * from Cafe join NuocNhapKhau on Cafe.NuocNK_Id = NuocNhapKhau.NuocNK_Id where maLoaiCF = ?";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			state.setString(1, Ma);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq =new Cafe(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), new NuocNhapKhau(rs.getInt(5), rs.getString(6)));
			}
			return kq;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kq;
	}
	
	public static boolean Sua(int ncNK_Id, float gia, String tenCF, String maLoaiCF) {
		Connection db = connectDB.DB();
		String sql="update Cafe set NuocNK_Id=?, giaban=?, tenCF=? where maLoaiCF = ?";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			state.setInt(1, ncNK_Id);
			state.setFloat(2, gia);
			state.setString(3, tenCF);
			state.setString(4, maLoaiCF);
			state.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static boolean Them(int ncNK_Id, float gia, String tenCF, String maLoaiCF) {
		Connection db = connectDB.DB();
		String sql="insert into Cafe values(?, ?, ?,?);";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			state.setInt(3, ncNK_Id);
			state.setFloat(4, gia);
			state.setString(2, tenCF);
			state.setString(1, maLoaiCF);
			state.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static boolean Xoa(String maLoaiCF) {
		Connection db = connectDB.DB();
		String sql="Delete Cafe where maLoaiCF = ?";
		try {
			PreparedStatement state = db.prepareStatement(sql);
			state.setString(1, maLoaiCF);
			state.execute();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}




}
