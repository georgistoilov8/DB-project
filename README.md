# DB-project

Базата от данни за “Столична компания за градски транспорт” ще съхранява
информация за градския транспорт в София. Пази се информация за превозните
средства в транспортната мрежа. За всяко едно от тях може да се изведат данни за
марката, модел, регистрационен номер, седящи места и правостоящи места. Също така
се записва и дали даденото превозно средство има климатик и дали има рампа за
инвалидни колички. Всяко едно превозно средство има тип. Типовете са няколко: Метро,
Автобус, Тролейбус, Трамвай. В базата от данни се съхранява информация за спирките
на градския транспорт. За всяка спирка се пазят данни за нейната географска ширина и
географска дължина, нейния адрес и дали има възможност да бъде заредена карта за
градския транспорт в околност на спирката. Следващото, за което се пази информация са
линиите на градския транспорт. Всяка една линия представлява последователност от
спирки. За тях имаме разстояние на маршрута, по който преминава съответното превозно
средство, брой на спирките и номер на линията. Информация се пази и за разписанието
на градския транспорт. Разписанието е няколко вида: зимно делнично, зимно празнично,
лятно делнично и лятно празнично. Зимното и лятното зависят от месеците в които се
намираме, а делничното и празничното от дните. Разписанието се определя по спирка,
линия и тип. По тях трите се определя време на пристигане на превозните средства.
Базата от данни пази и информация за хората, които използват градската мрежа. Те са
два вида: Служители и Пътници. За всеки човек се съхранява информация за името и
фамилията му, както и за неговото ЕГН. За служителите се пазят допълнителни данни:
телефонен номер, е-мейл и заплата. Всеки служител има длъжност, която изпълнява
(шофьор, контрольор и т.н.). Също така всеки служител се свързва с линиите по които
работи. Последното нещо, което базата от данни съхранява е информация за карти за
градския транспорт на пътници. Всяка една карта се характеризира с това, че е за
определени линии. Пази се информация и за типа на картата: дали е за брой пътувания
или е за определен период от време по линия. Всяка карта има статус: Валидна,
Невалидна или Блокирана.  

![alt text](https://github.com/georgistoilov8/DB-project/blob/master/Diagram.jpg "E/R diagram")
