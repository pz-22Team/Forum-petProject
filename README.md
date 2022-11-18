# Forum-petProject

---

> Створити програму, що моделює наступну ситуацію: Модератори
форуму. Користувач реєструється на форумі і його ім’я записується у базу-даних
(файл). Після того він може написати повідомлення. Викликаються модератори
форуму. Кожен з яких слідкує за певним забороненим словом. Повідомлення
може бути виведене на екран, якщо загальна сума заборонених слів не перевищує
певне число. Кількість заборонених слів заноситься в базу даних. На форумі
можуть працювати кілька користувачів.

---


`Форум (окремий процес)`
```
    -	Приймає повідомлення від користувачів і надсилає на сервер. 
    -	На сервері повідомлення перевіряється модераторами.
    -	Приймає відповідь від сервера.
    -	Якщо є дозвіл, воно публікується.
    -	Якщо ні, користувачу приходить повідомлення.
```
`Сервер (окремий процес)`
```
    -	Вхідні параметри (допустима к-ть заборонених слів)
    -	ділить повідомлення на слова
    -	Запускає n потоків (n - к-ть заборонених слів): - модератори
    -	Кожен потік перевіряє чи к-ть заборонених слів не перевищує задане значення.
    -	Повертає дозвіл надсилання.
Слова за якими слідкують модератори та їх допустима кількість передається як параметр процесу.
Заборонені слова зберігаються в базі даних (файлі).
```

`User(окремий процес)`
```
    -	Користувач заходить(реєструється) на форум.
    -	Надсилає повідомлення на форум
Дані про користувачів зберігаються в базі даних (файлі).
```

---

> ![communication](https://user-images.githubusercontent.com/90086332/201711721-a2934db5-e373-450f-bf29-1abed32a9eed.png) 

---

```
Client
    -	Main window – sign up
    -	Log in
    -	Написати та надіслати повідомлення на форум
    -	База даних MySql

Server
    -	Параметрами прилітає допустима к-ть заборонених слів.
    -	Ділення стрічки на слова.
    -	Заупуск n – потоків, де n – к-ть заборонених слів.
    -	Кожен потік рахує к-ть входження його слова і збільшує глобальну змінну.
    -	Повертається або true або false.
    -	.txt файл (бан ворди слова)

Forum
    -	Відображає к-ть юзерів
    -	Відображає – смски, час публікування, ім’я користувача який який публікував.
```

```
Client UI
```
---
![image](https://user-images.githubusercontent.com/90086332/202787733-8f697735-e018-42c5-b5a0-ed132aeb782c.png)
---
![image](https://user-images.githubusercontent.com/90086332/202787746-04ee327f-4fbf-4128-b337-838bcca9b875.png)
---
![image](https://user-images.githubusercontent.com/90086332/202787755-5cfc8b35-d4d8-4721-8b7d-7f993e418eaa.png)
---
![image](https://user-images.githubusercontent.com/90086332/202787771-99298365-4048-4a21-a6bb-53e93c14083d.png)
---
![image](https://user-images.githubusercontent.com/90086332/202787783-f8607cd3-afdd-423c-8d25-afb2ab8702b2.png)
---

