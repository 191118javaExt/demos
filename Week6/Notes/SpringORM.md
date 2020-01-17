# Spring ORM
- Spring ORM is a module used to integrate data access code with spring (object relational mapping)
- Allows us to combine hibernate and spring, as well as JPA
Benefits:
- Easier testing 
- Less boiler plate code 
- Easy transaction management
- No longer a hibernate.cfg.xml; those configuration details are in the applicationContext.xml file now
- Our hibernate code has no knowledge of spring but we can leverage DI, AOP, etc.

## We Must Define 3 Spring Beans
1. DataSource
    - Where we configure our database credentials and driver class name
2. SessionFactory
    - Where we configure hibernate specific properties, such as hibernate.dialect, hibernate.hbm2ddl.auto, hibernate.show_sql
3. TransactionManager

- Our DataSource is injected into our SessionFactory
- Our SessionFactory is injected into the TransactionManager
- Our SessionFactory is injected into our DAOs


### Contextual Session
- A session managed by hibernate throughout the scope of a spring managed transaction

### @Repository 
- Stereotype annotations for our DAOs 
- Also indicates to the PersistanceExceptionTranslationPostProcessor that exceptions thrown by your DAOs should be interpreted as Spring data access exceptions (give you more details than SQL exceptions)


## @Trasactional

### Enable `@Transactional` annotation

    <tx:annotation-driven/>

### DataSource

    <bean id="ourDatasource" class="org.apache.commons.dbcp.BasicDataSource">  
        <property name="driverClassName"  value="org.postgresql.Driver"></property>  
        <property name="url" value="#{systemEnvironment['URL']}"></property>  
        <property name="username" value="#{systemEnvironment['USERNAME']}"></property>  
        <property name="password" value="#{systemEnvironment['PASSWORD']}"></property>  
    </bean>  

### SessionFactory

	<bean id="sessionFactory" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="ourDatasource"/>
		<property name="packagesToScan" value="com.revature"/>
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.hbm2ddl.auto">update</prop>
			</props>
		</property>
	</bean>

### TransactionManager

	<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"/>
	</bean>

#### Transaction Propagation
REQUIRED (default)
- Same transaction will be used if one already exists
- Otherwise a new transaction will be opened

REQUIRES_NEW
- A new physical transaction will be created
- Inner transaction can commit or rollback independently of the outer transaction

NESTED
- Inner and outer use the same transaction, but are separated by savepoints 
- Inner can roll back or commit with the second

MANDATORY
- Existing transaction must already be open or container will throw an IllegalTransactionException

NEVER
- An existing cannot already be open; exception will be thrown if one is
- Must execute non-transactionally

SUPPORTS
- Executes within the scope of existing transaction, otherwise will execute non-transactionally

NOT_SUPPORTED
- Executes outside any existing transaction, existing transaction will be paused