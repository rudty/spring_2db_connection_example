# spring_2db_connection_example

2020년 1월 현재 [https://start.spring.io](https://start.spring.io) 기본값인 v2.2.2.RELEASE 로 작성했습니다.

### 설정
- [첫번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig1.java)
- [두번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig2.java)

### 설명 
- [첫번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig1.java) 은 [application.properties](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/resources/application.properties) 에 정의된 org.rudtyz.db1.datasource 를 사용합니다.
- [두번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig2.java) 은 DataSourceBuilder 를 사용해서 연결하고 있습니다. ([application.properties](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/resources/application.properties) 를 통해 값은 가져오지만 사용하지는 않습니다.
- EnableJpaRepositories annotation 에서 basePackages 는 jpa repository 가 위치한 곳을 나타냅니다.
- entityManagerFactory 호출 함수에서 packages 의 인자는 실제로 entity 가 위치한 곳을 나타냅니다.
- jpa 를 사용하지 않는다면 DataSource 만 추가해도 연결 가능합니다. [세번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig3.java) 참고
- 두개 이상의 db 로 transaction 은 [MultipleTransactionConfig](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/MultipleTransactionConfig.java) 를 참고하세요.
- [서비스에서 @Transactional 사용](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/service/HelloService.java)
- [테스트 바로가기](https://github.com/rudty/spring_2db_connection_example/blob/master/src/test/java/org/rudty/dbconnection/DbconnectionApplicationTests.java)
