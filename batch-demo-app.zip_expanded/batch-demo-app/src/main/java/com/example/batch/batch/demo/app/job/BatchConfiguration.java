package com.example.batch.batch.demo.app.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.batch.batch.demo.app.entity.Person;
import com.example.batch.batch.demo.app.stages.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	 @Autowired
	 public JobBuilderFactory jobBuilderFactory;

	 @Autowired
	 public StepBuilderFactory stepBuilderFactory;
	 
	 @Autowired
	 DataSource dataSource;
	 
	 @Autowired
	 PlatformTransactionManager transactionManager;
	 
	 @Bean
	 public FlatFileItemReader<Person> reader(){
		 return new FlatFileItemReaderBuilder()
				 .name("personItemReader")
				 .resource(new ClassPathResource("sample-data.csv"))
				 .delimited()
				 .names(new String[]{"firstName", "lastName"})
				 .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
					 {setTargetType(Person.class);}
				 }).build();
	 }
	 
	 @Bean
	 public PersonItemProcessor processor() {
	   return new PersonItemProcessor();
	 }
	 
	 @Bean
	 public JdbcBatchItemWriter<Person> writer(DataSource dataSource){
		 return new JdbcBatchItemWriterBuilder<Person>()
				 .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				 .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
				 .dataSource(dataSource)
				 .build();
	 }
	 
	 @Bean
	 public Step step(JdbcBatchItemWriter<Person> writer) {
		 return this.stepBuilderFactory
		 		.get("step1")
		 		.<Person, Person> chunk(5)
		 		.reader(reader())
		 		.processor(processor())
		 		.writer(writer)
		 		.build();
	 }
	 
	 @Bean
	 public Job job(JobCompletionNotificationListener listener, Step step) {
		 return this.jobBuilderFactory
				 .get("importUserJob")
				 .preventRestart()
				 .incrementer(new RunIdIncrementer())
				 .listener(listener)
				 .flow(step)
				 .end()
				 .build();
	 }
	 
		/*
		 * @Bean public JobRepository getJobRepository() throws Exception {
		 * JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		 * factory.setDataSource(dataSource);
		 * factory.setTransactionManager(transactionManager);
		 * factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
		 * factory.setTablePrefix("BATCH_"); factory.setMaxVarCharLength(1000); return
		 * factory.getObject(); }
		 */

}
