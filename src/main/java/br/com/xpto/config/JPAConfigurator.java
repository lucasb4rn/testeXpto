package br.com.xpto.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.xpto.repository")
public class JPAConfigurator {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			Properties additionalProperties) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("br.com.xpto.entitys");
		factoryBean.setDataSource(dataSource);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(additionalProperties);

		return factoryBean;
	}

	@Bean
	@Profile("dev")
	public Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}

	@Bean
	@Profile("dev")
	public DataSource dataSource() {
		
		try {
			
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("padrao");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xpto");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");

			dataSource.setMinPoolSize(10);
			dataSource.setMaxIdleTime(5);
			return dataSource;

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return null;

	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
