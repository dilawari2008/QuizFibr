# QuizFibr

## Steps to test

#### 1. register a user - username has to be unique
file:///home/vagish/Pictures/register.png![image](https://user-images.githubusercontent.com/40742522/218109307-aa013018-5091-4927-a511-85f25ea21f27.png)

#### 2. login user
file:///home/vagish/Pictures/login.png![image](https://user-images.githubusercontent.com/40742522/218109464-a0375e71-92c9-4976-9edd-e29bb482871d.png)


#### 3. create quiz - quiz code has to be unique, authenticate using the token provided after the most recent login
file:///home/vagish/Pictures/create%20quiz1.png![image](https://user-images.githubusercontent.com/40742522/218109512-62a8c18f-4031-4723-821a-85330616ca83.png)
file:///home/vagish/Pictures/create%20quiz%202.png![image](https://user-images.githubusercontent.com/40742522/218109547-8b395379-77c1-4a02-9ee8-6b5cbaeae6e6.png)

#### 4. share quiz link as - ec2-43-206-227-25.ap-northeast-1.compute.amazonaws.com:8081/api/quizes/{your_quiz_code}
file:///home/vagish/Pictures/get%20quiz.png![image](https://user-images.githubusercontent.com/40742522/218109592-6d8884bc-0631-4e6f-b442-cbc49e590dd7.png)

so for example your quiz code is qz2 then the link to be shared is ec2-43-206-227-25.ap-northeast-1.compute.amazonaws.com:8081/api/quizes/qz2

#### 5. submit quiz - same link, but post request with body
file:///home/vagish/Pictures/submit%20quiz.png![image](https://user-images.githubusercontent.com/40742522/218109673-5a421d2d-167d-4d29-8873-b8632f1128b9.png)

#### 6. view submissions - authenticate as the admin of the quiz to view the submissions
file:///home/vagish/Pictures/list%20submissions1.png![image](https://user-images.githubusercontent.com/40742522/218109744-a3ebd571-d737-4d05-bb9a-9f1564f76ae5.png)
file:///home/vagish/Pictures/list%20submissions%202.png![image](https://user-images.githubusercontent.com/40742522/218109777-aeefe8b6-c613-4ba4-b86e-cc06f3907c9a.png)
