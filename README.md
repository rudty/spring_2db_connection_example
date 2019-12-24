# spring_2db_connection_example

### 설정
- [첫번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig1.java)
- [두번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig2.java)

### 설명 
- EnableJpaRepositories annotation 에서 basePackages 는 jpa repository 가 위치한 곳을 나타냅니다.
- entityManagerFactory 호출 함수에서 packages 의 인자는 실제로 entity 가 위치한 곳을 나타냅니다.
- jpa 를 사용하지 않는다면 DataSource 만 추가해도 연결 가능합니다. [세번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig3.java) 참고


### 주의사항
- [첫번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig1.java)에서 entityManagerFactory 와 transactionManager 의 bean 의 이름은 spring jpa 에서 사용하고 있기에 변경 시 오류가 발생합니다
- 위 문제의 수정을 위해서는 annotation EnableJpaRepositories 에서 entityManagerFactoryRef, transactionManagerRef 를 추가하세요 [두번째 db의 설정](https://github.com/rudty/spring_2db_connection_example/blob/master/src/main/java/org/rudty/dbconnection/config/DatabaseConfig2.java)참고

