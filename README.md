- как запустить все тесты/конкретный тест (запуск всех тестов и в нескольких потоках можем
 через testng.xml, если необходим конкретный тест можем создать отдельный сьют либо просто 
запустить через run нужный тест)
- как запустить тестовый отчет (через maven->plugins->allure->serve))
- какие зависимости необходимы для использования -
 для этого проекта (для ui selenium + bonygarcia + testng, для апи rest assured + testng + json-schema-validator, 
allure для отчетов
- как установить зависимости "новые зависимости устанавливам в pom.xml между тегами depencies и пересобираем 
maven,чтобы подтянулись новые зависимости