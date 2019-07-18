package daos;
import beans.Comment;
import util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;

public class CommentDao {
	//插入一个评论
	public void addComment(Comment ct) {
		//建立与数据库的连接
		Connection conn=DataBaseUtil.getConnection();
		try {
			//插入语句，其中commentid为自增，所以只用写default
			String sql=""+ "insert into comment" +" (commentid,poid,csid,preid,text,likenum,time,deleted) "+"values(default,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//设定插入的帖子号等值
			psmt.setInt(1, ct.getPoid());
			psmt.setInt(2, ct.getCsid());
			psmt.setInt(3, ct.getPreid());
			psmt.setString(4, ct.getText());
			psmt.setInt(5, ct.getLikenum());
			psmt.setTime(6, ct.getTime());
			psmt.setInt(7, ct.getDeleted());
			//执行插入语句
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据评论id查询评论

	public Comment findCommentByCommentid(int commentid) {
		//建立一个comment对象
		Comment ct=new Comment();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();


		try {
			//查询语句，根据学号查询
			String sql=""+"select * from comment where commentid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, commentid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				//给comment对象设定id等属性值
				ct.setCommentid(rs.getInt("commentid"));
				ct.setPoid(rs.getInt("poid"));
				ct.setCsid(rs.getInt("csid"));
				ct.setPreid(rs.getInt("preid"));
				ct.setDeleted(rs.getInt("deleted"));
				ct.setText(rs.getString("text"));
				ct.setLikenum(rs.getInt("likenum"));
				ct.setTime(rs.getTime("time"));
				
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回comment对象
		return ct;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList findCommentByPoid(int poid) {//根据帖子号查询所有评论
		//建立一个comment对象
		Comment ct=new Comment();
		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();
		ArrayList aList=new ArrayList<String>();//准备组
		try {
			//查询语句，根据学号查询
			String sql=""+"select * from comment where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, poid);
			//执行查询语句
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				//给comment对象设定id等属性值
				ct.setCommentid(rs.getInt("commentid"));
				ct.setPoid(rs.getInt("poid"));
				ct.setCsid(rs.getInt("csid"));
				ct.setPreid(rs.getInt("preid"));
				ct.setDeleted(rs.getInt("deleted"));
				ct.setText(rs.getString("text"));
				ct.setLikenum(rs.getInt("likenum"));
				ct.setTime(rs.getTime("time"));
				aList.add(ct);
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		//返回comment对象
		return aList;
	}
	public void updateLikenumByCommentid(int commentid,int newlikenum) {//根据帖子号改变点赞数

		//建立数据库连接
		Connection conn=DataBaseUtil.getConnection();

		try {
			//查询语句，根据学号查询
			String sql=""+"update comment set likenum = ? where commentid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, newlikenum);
			psmt.setInt(2, commentid);
			//执行更新语句
			psmt.executeUpdate();
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }

	}
}
