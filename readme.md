## What is `springedu2`?
Spring jpa를 공부한 기록을 저장하는 Repository.
### 관련 프로젝트
- 
## Start Guide
### Requirements
- `jdk 17`
- `InteliJ Community`
- `MySQL Community`
### Installation
#### **1️⃣ Git clone**

```powershell
git clone https://github.com/papamoon0113/spring-jpa-study.git
cd spring-jpa-study
```

#### **2️⃣ Create table in MySQL**

```sql
# Log in to mysql first
source \\database\\create_all_table.sql
```

#### **3️⃣ Set _application.properties_**

```sql
# path : sugar-road\\server\\src\\main\\resource\\application.properties

spring.datasource.url: jdbc:mysql://[domain]:[port]/edudb?characterEncoding=UTF-8
# example
# spring.datasource.url: jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8
spring.datasource.username: [username]
spring.datasource.password: [pasword]
spring.datasource.driver-class-name: com.mysql.cj.jdbc.Driver
```

#### 4️⃣ Run server

```powershell
.\\gradlew bootRun
```