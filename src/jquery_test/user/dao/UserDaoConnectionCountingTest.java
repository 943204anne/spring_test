package jquery_test.user.dao;

import java.sql.SQLException;

import jquery_test.user.domain.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest  {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("nbo94");
		user.setName("¹Ú½Ã¿õ2");
		user.setPassword("111");
		
		dao.add(user);
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		
		System.out.println(user2.getPassword());
		
		
		CountingConnectionMaker ccm =
				context.getBean("connectionMaker", CountingConnectionMaker.class);
		
		System.out.println("Connection counter : " + ccm.getCounter());
	}
}
