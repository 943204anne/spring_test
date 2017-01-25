package jquery_test.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {

	@Bean
	public UserDao userDao() {
        UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());;
		return userDao;
		
	}

	@Bean
	public DataSource dataSource() {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://192.168.0.69/test");
		dataSource.setUsername("test1");
		dataSource.setPassword("1111");
		
		return dataSource;
		
	}
		
}