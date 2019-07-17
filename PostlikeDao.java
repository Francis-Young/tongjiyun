package daos;

import beans.Postlike;
import util.DataBaseUtil;
import java.sql.*;



public class PostlikeDao {
	//插入一个评论
	public void addPostlike(Postlike pe) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中polikeid为自增，所以只用写default
			String sql=""+ "insert into postlike" +" (polikeid,poid,sid) "+"values(default,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的帖子号等值
			psmt.setInt(1, pe.getPoid());
			psmt.setInt(2, pe.getSid());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据点赞id查询点赞

	public Postlike findpostlikeByPostlikeid(int polikeid) {
		//建立一个postlike对象
		Postlike pe=new Postlike();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据学号查询
			String sql=""+"select * from postlike where postlikeid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, polikeid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给comment对象设定id等属性值
				pe.setPolikeid(rs.getInt("polikeid"));
				pe.setPoid(rs.getInt("poid"));
				pe.setSid(rs.getInt("sid"));
	
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回Postlike对象
		return pe;
	}

	public int countPostlikeByPoid(int poid) {//根据帖子号查询所有评论

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		int countPostlike=0;
		try {
			//查询语句，根据学号查询
			String sql=""+"select count(*)  from postlike where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, poid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			countPostlike=rs.getInt(1);
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回comment对象
		return countPostlike;
	}
}