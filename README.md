# ProjectJava
Разработано три микросервиса.

1 микросервис - producerService - принималка заявок.

Нужно спроектировать REST-метод POST /requests, который будет принимать в JSON заявку на кредит. В заявке должны быть следующие поля: дата рождения, ФИО (можно одним полем), сумма в рублях, количество месяцев и уникальный ID заявки.

Этот микросервис должен просто принимать заявку и помещать ее в топик Kafka. Можно просто сериализовать ее в JSON, например.

Кафку поставьте себе в докере, топик пусть будет называться requests.


2 микросервис - consumerService анализатор заявок.

На регулярной основе должен вычитывать новые заявки из Кафки и анализировать их. Если подавателю меньше 18 или больше 80 лет, заявку нужно отклонить. А также заявку нужно отклонить, если человек хочет более 50 миллионов. Иначе заявка одобряется.

Заявки нужно дополнить статусом (два значения - ОДОБРЕН/НЕ ОДОБРЕН) и сохранить их вместе со статусом в БД PostgreSQL.

БД назовите по своему выбору. В БД нужно для этой цели завести таблицу processed_requests.


3 микросервис - generatedService - генератор договоров.

Нужно спроектировать REST метод GET /generate-agreement/{requestId}. В части URL "requestId" этот метод должен принимать уникальный идентификатор заявки, который приходил в первый микросервис.

По этому ID сервис должен сходить в БД PostgreSQL и из таблицы processed_requests достать заявку. Если у нее статус ОДОБРЕНА - нужно сгенерировать PDF-документ, в который просто включить все данные из заявки в произвольной форме.  Если статус НЕ ОДОБРЕНА, нужно вернуть ошибку 405 Not Allowed.

PDF-документ нужно вернуть из контроллера так, чтобы если такой метод вызвать в браузере, браузер позволял скачать (или открыть) документ.
