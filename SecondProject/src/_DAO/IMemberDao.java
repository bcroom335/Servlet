package _DAO;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDao {
	public void add(MemberBean m)throws SQLException;
	public void update(MemberBean m)throws SQLException;
	public void delete(int seqNo)throws SQLException;
	public List<MemberBean> select(MemberBean m)throws SQLException;
	public void creatconn()throws SQLException;
	public void closeconn()throws SQLException;
}
