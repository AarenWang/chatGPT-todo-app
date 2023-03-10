## chatgpt-todo-app
用chatGPT生成一个简单的TODO List APP (using chatGPT generate a simple TODO List APP Sourcecode ) 

让chatGPT为程序员服务，辅助程序员开发应用程序，通过引导chatGPT一步一步完成一个TODO List(任务清单) APP开发
Let ChatGPT serve developers and assist them in developing applications by guiding them step-by-step to complete the development of a TODO List application

整个过程大概是这样
 1. 先告诉chatGPT我打算写一个任务管理应用，用的前后端技术栈分别是Vue3和SpringBoot，chatGPT给出开发步骤
 2. 然后让chatGPT分别打印后端和前段代码
 3. 将代码放到本地工程里，有报错话，让chatGPT再次打印
 4. 剩下问题自己修改

## 体验总结
各项能力打分：
1. 明白整个Demo项目创建过程，给出清晰的思路，打分9分(10分满分,下同)
2. 知道前端Vue和后端SpringBoot更细一步的技术框架，比如后端的打包maven工具配置，前端npm、eslint等工具配置, 打分8分
3. 项目代码文件目录结构基本正确，按照指令能分别输出前端和后端代码  打8分
4. 前后端代码打协调性，按照我设定功能，前后端代码的URL、请求字段等约定基本匹配 打7分
5. 代码可用性， 不管是生成前端代码还是后端，80%可用吧，剩下20%，自己要做不少修改，打6分，勉强给他及格，鼓励继续改进
6. 技术理解力，比如后端数据库访问开始用Spring Data Jpa，我让他用MyBatis重新生成下，重新生成用MyBatis编写的代码， 打7分。
7. 业务理解能力，比如我告诉它任务管理需要哪些输入，生成前后端代码有对应字段了。  打7分。
8. 问题解决能力，比如碰到一个报错，把错误信息放进去，如果运气够好能给出正确的修改方法，大部分时间还是得靠自己  打6分，鼓励继续改进

**总结**
- 能代替人工，用常见的技术栈和应用代替生成一些场景的样板案例代码，
- 能给初学者一个明确的设计思路，比如写个Demo拆解成几步，每一步都干啥
- 要改成能跑的Demo，自己还是需要懂点对应技术、花时间修改调整
- 和低代码平台结合，可能会是一个很不错创业方向，有了chatGPT，低代码平台从固定模板到一个“有灵魂”AI编程机器人的转变 



## 运行工程方法
后端
```
mvn clean pacakge  # 编译
mvn spring-boot:run  # 运行spring boot 应用,端口8080
```

前端
```
npm install
npm run serve  # 端口8081，浏览器访问 http://localhost:8081/  
```

##  代码结构

前端
```
todo-list-frontend/
├── public/
│   ├── index.html
│   └── ...
├── src/
│   ├── assets/
│   │   └── ...
│   ├── components/
│   │   ├── TodoList.vue
│   │   ├── TodoItem.vue
│   │   └── ...
│   ├── services/
│   │   ├── TodoService.js
│   │   └── ...
│   ├── App.vue
│   └── main.js
├── .eslintrc.js
├── babel.config.js
├── package.json
└── README.md
```

后端
```
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── todo
│   │   │               ├── TodoListApplication.java
│   │   │               ├── controller
│   │   │               │   └── TodoItemController.java
│   │   │               ├── model
│   │   │               │   └── TodoItem.java
│   │   │               └── repository
│   │   │                   └── TodoItemRepository.java
│   │   └── resources
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── todo
│                       └── controller
│                           └── TodoItemControllerTest.java
```

## 交互过程

Q:  Use vue and SpringBoot create an TODO List app  
A: Creating a TODO list app with Vue and SpringBoot involves building a frontend using Vue for user interface and a backend using SpringBoot for handling data and logic.

Here are the general steps to follow:

1. Set up the SpringBoot backend with an API for handling CRUD operations (create, read, update, and delete).
2. Build the Vue frontend with components for displaying and manipulating the TODO list.
3. Connect the frontend to the backend API using Axios for making HTTP requests.
4. Test the app by adding, deleting, and updating TODO list items.
Here are some specific steps you can follow:

1. Set up the SpringBoot backend:

- Create a new SpringBoot project using a Spring Initializr or your preferred IDE.
- Add dependencies for Spring Web and Spring Data JPA.
- Create a model class for TODO items with fields like id, name, description, and completed.
- Create a repository interface that extends JpaRepository<TodoItem, Long> for accessing TODO item data from a database.
- Create a controller class with endpoints for handling CRUD operations using @RestController and @RequestMapping annotations.
- Test the API using Postman or a similar tool.

6. Build the Vue frontend:
- Install Vue CLI and create a new project.
- Create components for displaying a list of TODO items and adding/editing/deleting TODO items.
- Use v-model directive to bind input fields to component data properties.
- Use v-for directive to loop through the TODO items and display them in a list.
- Use methods and Axios to make HTTP requests to the backend API and update the TODO list.
- Connect the frontend to the backend API:
- Use Axios to make HTTP requests to the API endpoints created in the backend.
- Use Promises or async/await to handle the responses and update the component data.
- Test the app:

Run both the frontend and backend servers.
- Open the app in a web browser and test adding, deleting, and updating TODO list items.
- Verify that the changes are persisted in the backend database.
There are many resources available online to help you build a TODO list app with Vue and SpringBoot. I recommend starting with the official documentation for Vue and SpringBoot, as well as some tutorials and examples on sites like Medium and GitHub.

后续生成每个文件过程 请看图片
![](interview-with-chatGPT.png)
