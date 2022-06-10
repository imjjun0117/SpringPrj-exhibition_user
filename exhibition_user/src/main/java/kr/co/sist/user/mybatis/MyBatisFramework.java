package kr.co.sist.user.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framework를 생성하고 MyBatis Handler를 반환
 * 
 * @author user
 */
public class MyBatisFramework {
	private static MyBatisFramework mbf;
	private static SqlSessionFactory ssf;

	private MyBatisFramework() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}

	public static MyBatisFramework getInstance() {
		if (mbf == null) {
			mbf = new MyBatisFramework();
		}
		return mbf;
	}

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		if (ssf == null) {
			Reader reader = null;
			try {
				// 1.설정파일 연결
				reader = Resources.getResourceAsReader("kr/co/sist/user/mybatis/SqlMapConfig.xml");
				// 2.MyBatis Framework 생성
				ssf = new SqlSessionFactoryBuilder().build(reader);
			} finally {
				if (reader != null) {		reader.close();	}
			}
		}
		return ssf;
	}

	public SqlSession getMyBatisHandler() {
		SqlSession ss = null;
		try {
			ss = getSqlSessionFactory().openSession();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return ss;
		
			
		}
}