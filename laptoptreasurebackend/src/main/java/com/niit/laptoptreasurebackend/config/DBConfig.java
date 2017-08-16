package com.niit.laptoptreasurebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.laptoptreasurebackend.dao.CartItemDAO;
import com.niit.laptoptreasurebackend.dao.CategoryDAO;
import com.niit.laptoptreasurebackend.dao.SupplierDAO;
import com.niit.laptoptreasurebackend.dao.UserDetailsDAO;
import com.niit.laptoptreasurebackend.dao.UserOrderDAO;
import com.niit.laptoptreasurebackend.model.Cart;
import com.niit.laptoptreasurebackend.model.CartItem;
import com.niit.laptoptreasurebackend.model.Category;
import com.niit.laptoptreasurebackend.model.Product;
import com.niit.laptoptreasurebackend.model.Supplier;
import com.niit.laptoptreasurebackend.model.UserDetails;
import com.niit.laptoptreasurebackend.model.UserOrder;



@Configuration //indicates that the class can be used by the Spring IoC container as a source of bean definitions.
@ComponentScan("com.niit.laptoptreasurebackend") //@ComponentScan annotation to specify the base packages to scan.
@EnableTransactionManagement //which makes it possible to fully use Java for the configuration
public class DBConfig
{     
	   @Bean(name="dataSource") //@Bean annotation tells Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context. 
	  public DataSource getH2DataSource() //it provides a facility of creating a pool of connections.
	  {
           System.out.println("----Data Source Creation-----");
		   DriverManagerDataSource dataSource = new DriverManagerDataSource();
		   dataSource.setDriverClassName("org.h2.Driver");
		   dataSource.setUrl("jdbc:h2:tcp://localhost/~/database");
		   dataSource.setUsername("sa");
		   dataSource.setPassword("anuash02");
		   System.out.println("----Data Source Creation-----");
		   return dataSource;
	  }
	   @Autowired
	   @Bean(name="sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource)
	   {
           System.out.println("------Hibernate properties creation------");
		   Properties properties=new Properties();
		   properties.setProperty("hibernate.hbm2ddl.auto", "update");
		   properties.put("hibernate.show_sql", "true");
		   properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		   System.out.println("------Hibernate properties created------");
		   
		   System.out.println("------LacalSessionFactoryBuider object creation------");
		   LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		   sessionBuilder.addProperties(properties);
		   System.out.println("------Factory Builder object created------");
		   sessionBuilder.addAnnotatedClass(Category.class);
		   
		   sessionBuilder.addAnnotatedClass(Supplier.class);
		   
		   sessionBuilder.addAnnotatedClass(Product.class);
		   
		   sessionBuilder.addAnnotatedClass(UserDetails.class);
		   //sessionBuilder.addAnnotatedClass(Cart.class);
		   sessionBuilder.addAnnotatedClass(Cart.class);
		   sessionBuilder.addAnnotatedClass( CartItem.class);
		   sessionBuilder.addAnnotatedClass(UserOrder.class);
		   System.out.println("------Session Factory  object creation------");
		   SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		   System.out.println("------Session factory object created------");
		   return sessionFactory;
		   //return sessionBuilder.buildSessionFactory();
	   }
	   
	   
       @Autowired
	   @Bean(name="transactionManager")
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	   {

		   HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
				   return transactionManager;
	   }
       
      
	   @Autowired
	   @Bean(name="categoryDAO")
	   public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	   {
		   System.out.println("-- CategoryDAO Object Creation--");
		   return new CategoryDAO(sessionFactory);
	   }
	   
	   @Autowired
	   @Bean(name="cartItemDAO")
	   public CartItemDAO getCartItemDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----CartItem DAO object Creation------");
		return new CartItemDAO(sessionFactory);
	   }
	   
	   @Autowired
	   @Bean(name="userOrderDAO")
	   public UserOrderDAO getUserOrderDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----UserOrder DAO object Creation------");
		return new UserOrderDAO(sessionFactory);
	   }
	   
	   @Autowired
	   @Bean(name="userdetailsDAO")
	   public UserDetailsDAO getUserDetailDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----User DAO object Creation------");
        return new UserDetailsDAO(sessionFactory);
		   
	   }
	/*   @Autowired
	   @Bean(name="cartDAO")
	   public CartDAO getCartDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----Cart DAO object Creation------");
		return new CartDAO(sessionFactory);
       
	   }*/	
	   @Autowired
	   @Bean(name="supplierDAO")
	   public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	   {
          System.out.println("-----Supplier DAO object Creation------");
          return new SupplierDAO(sessionFactory);
		   
	   }
}
