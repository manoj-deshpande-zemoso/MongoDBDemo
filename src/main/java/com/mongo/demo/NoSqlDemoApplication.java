package com.mongo.demo;

import com.mongo.demo.dao.config.CustomMongoRepositoryImpl;
import com.mongo.demo.entity.id.generator.EmployeeEntityEventListener;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = CustomMongoRepositoryImpl.class)
public class NoSqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoSqlDemoApplication.class, args);
	}

}
