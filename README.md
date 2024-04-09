### **Library Management System (LMS) Assessment**

#### **Background**
Imagine a small library where users can borrow and return books. Your task is to design and implement a backend system for this library using Java/Spring/Spring Boot.

#### **Requirements**

##### **1. Entities**
- **Book:**
    - ID
    - Title
    - Author
    - ISBN
    - Status (borrowed/available)
    - User (who borrowed the book, if borrowed)
- **User:**
    - ID
    - Username
    - Password
    - Borrowed Books list

##### **2. Functionalities**
- **User Registration/Login:** Implement JWT for user registration and login.
- **Borrow a Book:** A user can borrow an available book. If the book is already borrowed, show a message.
- **Return a Book:** A user can return a book they've borrowed.
- **Search for a Book:** Search books by title, author, or ISBN.
- **Message Queue Notification (using Spring JMS):** Whenever a book is borrowed or returned, an asynchronous message is sent to the queue and a listener logs this activity.

##### **3. Persistence (using Spring JPA)**
- Store the books and users data in an H2 or any in-memory database for simplicity.
- Implement CRUD operations for Book and User entities.
- Ensure there's a relation between User and Book to track borrowed books.

##### **4. Security (using Spring Security and JWT)**
- Protect your API endpoints. Only authenticated users should be able to borrow and return books.
- Admin users should be able to add, edit or remove books.
- Passwords should be stored securely (hashed).

##### **5. Bonus**
- Implement rate limiting using Spring components to prevent abuse.

#### **Instructions**
1. Use Spring Initializr or your preferred method to bootstrap your Spring Boot application.
2. Implement the entities and their relationships using Spring JPA.
3. Use Spring Security for user authentication and JWT for authorization.
4. Implement the JMS listeners and producers to handle book borrow and return events.
5. Provide API documentation using tools like Swagger.

#### **Evaluation Criteria**
- Correct implementation of the Spring components: JPA, JMS, Security, etc.
- Code clarity, organization, and modularity.
- Proper error handling and validation.
- Proper use of JWT and securing endpoints.
- Efficient use of JPA for data handling.
- Proper logging and use of JMS for asynchronous tasks.
- Bonus: Rate limiting implementation.

#### **Submission**
The candidate should submit the source code with clear instructions on how to run it. A postman collection or an equivalent for the APIs would be appreciated.
