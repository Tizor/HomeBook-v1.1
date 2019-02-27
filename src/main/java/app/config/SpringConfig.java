package app.config;


import app.dao.DAO;
import app.dao.DAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration

public class SpringConfig {

    @Bean
    //Бин для подключения к базе данных
    public JdbcTemplate getJdbc(){
      return new JdbcTemplate(getDataSource());

    }

    @Bean
    //Бин настройки для подключения к базе данных
    public DataSource getDataSource(){
        DriverManagerDataSource DS = new DriverManagerDataSource();
        DS.setUrl("jdbc:mysql://localhost:3306/phone_book5");
        DS.setUsername("root");
        DS.setPassword("root");
        DS.setDriverClassName("com.mysql.jdbc.Driver");
        return DS;
    }

    @Bean
    //Бин для работы с базой данных
    public DAO getDao(){
        return new DAOImpl(getJdbc());
    }

}

