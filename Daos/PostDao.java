package daos;
import beans.Post;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import util.DataBaseUtil;
public class PostDao {

	//插入一个帖子
	public void addPost(Post post) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+ "insert into post" +" (poid,csid,mid,type,title,text,popicaddr,pofileaddr,polink,likenum,time,deleted) "+"values(default,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, post.getCsid());
			psmt.setInt(2, post.getMid());
			psmt.setInt(3, post.getType());
			psmt.setString(4, post.getTitle());
			psmt.setString(5, post.getText());
			psmt.setString(6,post.getPopicaddr());
			psmt.setString(7,post.getPofileaddr());
			psmt.setString(8,post.getPolink());
			psmt.setInt(9, post.getLikenum());
			psmt.setTime(10, post.getTime());
			psmt.setInt(11, post.getDeleted());
			psmt.execute();
		}catch(SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
	}
	//根据poid查询一个帖子
	public Post findPostByPoid(int postid) {
		Post post=new Post();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from post where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, postid);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				post.setPoid(rs.getInt("poid"));
				post.setCsid(rs.getInt("csid"));
				post.setMid(rs.getInt("mid"));
				post.setType(rs.getInt("type"));
				post.setTitle(rs.getString("title"));
				post.setText(rs.getString("text"));
				post.setPopicaddr(rs.getString("popicaddr"));
				post.setPofileaddr(rs.getString("pofileaddr"));
				post.setPolink(rs.getString("polink"));
				post.setLikenum(rs.getInt("likenum"));
				post.setTime(rs.getTime("time"));
				post.setDeleted(rs.getInt("deleted"));
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return post;
	}
	//查找某个专业mid、某个类型type下的所有的帖子，因为当点开某个专业，帖子区会显示所有帖子，资料区会显示所有资料
	public List<Post> getPostByMidType(int mid,int type) {
		List<Post> post=new ArrayList<Post>();
		Connection conn=DataBaseUtil.getConnection();
		try {
			String sql=""+"select * from post where mid = ? and type = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mid);
			psmt.setInt(2, type);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Post p=new Post();
				p.setPoid(rs.getInt("poid"));
				p.setCsid(rs.getInt("csid"));
				p.setMid(rs.getInt("mid"));
				p.setType(rs.getInt("type"));
				p.setTitle(rs.getString("title"));
				p.setText(rs.getString("text"));
				p.setPopicaddr(rs.getString("popicaddr"));
				p.setPofileaddr(rs.getString("pofileaddr"));
				p.setPolink(rs.getString("polink"));
				p.setLikenum(rs.getInt("likenum"));
				p.setTime(rs.getTime("time"));
				p.setDeleted(rs.getInt("deleted"));
				post.add(p);
			}
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		return post;
	}
	//更新某个帖子的点赞数
	public void updateLikenum(int likenum,Post post) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"update post set likenum = ? where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, likenum);
			psmt.setInt(2, post.getPoid());
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
	}
	
	//把某个帖子标记为已删除
	public void updateDeleted(int deleted,Post post) {
		Connection conn=DataBaseUtil.getConnection();
		try {
			
			String sql=""+"update post set deleted = ? where poid = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, deleted);
			psmt.setInt(2, post.getPoid());
			psmt.execute();
			
		}catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            f.printStackTrace();
        }finally {
            DataBaseUtil.closeConnection(conn);
        }
		
	}
}
