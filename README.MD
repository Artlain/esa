Krupnikov Andrey and Abdulvaleev Ruslan 6133

lab2-4

LAB 2
Для лабораторной работы были выбраны две сущности: книга и автор книги.
Функциональная часть должна просто отображать различные данные по этим двум сущностям.
Модель данных выглядит следующим образом:

![image](https://user-images.githubusercontent.com/49097229/212562558-5de30e08-6af4-4fe8-a570-a51267e6a5ea.png)

Автор (Id, Имя, Фамилия, Страна рождения)

Книга (Id, Название, Id автора, дата публикации, количество страниц)

Окно вывода всех книг:
![image](https://user-images.githubusercontent.com/49097229/212562862-2c860b26-c590-4669-974d-b452224a9f82.png)

Окно вывода книг определённого автора, id которого указан в url:
![image](https://user-images.githubusercontent.com/49097229/212562948-4879131d-80f5-4533-b4c2-564b8546949c.png)

Окно вывода всех книг сгруппированных по авторам:
![image](https://user-images.githubusercontent.com/49097229/212563193-1b7bf9f8-6017-40fd-b072-0950abefa7cb.png)


lab3 REST
Был реализован RestController в котором есть 3 json метода и 3 метода возвращающих xml, один из которых отображает данные с помощью шаблона xsl на html странице.

Результат get запроса, возвращающий список книг в json формате:
![image](https://user-images.githubusercontent.com/49097229/212563354-dc40659e-b89a-47f2-99d4-9c2e25baf8a2.png)

Результат get запроса, возвращающий список книг в xml формате на html странице с помощью шаблона xsl:
![image](https://user-images.githubusercontent.com/49097229/212563470-0bb758bf-e521-4e8a-b342-007e5cbd3f29.png)

Результат get запроса, возвращающий список книг по автору, id которого задан в url запроса, в json формате:
![image](https://user-images.githubusercontent.com/49097229/212563533-4879df9e-f259-4115-a3ff-92e898e60774.png)

Результат get запроса, возвращающий список книг по автору, id которого задан в url запроса, в xml формате:
![image](https://user-images.githubusercontent.com/49097229/212563576-60b7acbf-f341-4d54-a400-ddaff88d4c0b.png)

Результат get запроса, возвращаюший все книги, сгруппированные по автору, в формате json:
![image](https://user-images.githubusercontent.com/49097229/212563632-7a2d3930-948c-493b-bf09-ec3814724f13.png)

Результат get запроса, возвращаюший все книги, сгруппированные по автору, в формате xml:
![image](https://user-images.githubusercontent.com/49097229/212563657-462e2135-e64c-4533-a85a-de027da58751.png)


lab4 JMS
Были созданые две доп сущности, которые хранят лог и емейл. Данные сущности хранят информацию об изменении сущности.
Был реализован класс LoggingAspect, который мониторит методы, помеченные кастомной аннотацией @Logging. При выполнении такого метода он выполняет отправку сообщения. Листенеры ловят сообщение и сохраняют данные в бд.
Таблица книг до удаления книги "Война и мир"
![image](https://user-images.githubusercontent.com/49097229/212563827-9e43aa04-1d8c-4ab9-a6d5-1fedefb64751.png)

Отправка запроса на удаление книги по её id
![image](https://user-images.githubusercontent.com/49097229/212563837-221916d7-e93d-4a18-bc68-dca95bc3774a.png)

Таблица после удаления книги
![image](https://user-images.githubusercontent.com/49097229/212563863-3371931a-96db-4f19-af29-066fc030dc30.png)

Логи
![image](https://user-images.githubusercontent.com/49097229/212563900-2dd70542-a941-4af3-9720-c98e41f9f029.png)

Перехваченные и сохранённые даные jms листенерами
![image](https://user-images.githubusercontent.com/49097229/212563929-1171930f-2384-48b0-bed8-d812751f2919.png)

![image](https://user-images.githubusercontent.com/49097229/212563944-44044aec-a32d-4406-be98-df6c86e40410.png)




