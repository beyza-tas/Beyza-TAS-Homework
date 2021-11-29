# CicekSepeti-TestAutoMation Proje İçerik ve Kullanımı

Ön Koşullar

Aşağıdakilerin en son sürümlerinin kurulu olduğundan emin olun:
- [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven](https://maven.apache.org/)

Selenium

[Selenium](https://www.seleniumhq.org/), test yapılarını otomatikleştirmek amacıyla kullanılır.

TestNG

[TestNG](https://testng.org/doc/), JUnit ve NUnit yapılarına benzer bir test çerçecesidir. Onlara göre daha güçlü bir yapı sağlar. Kullanımı daha kolaydır. 

Projeyi Localinize Kurmak İçin

-- Depoyu klonlayın <br>
-- Ön Koşulları sağladığınızdan emin olun. <br>
-- `mvn bağımlılığı:resolve` ile bağımlılıkları kurun. <br>
-- Chrome Tarayıcı ve Selenium Web sürücüsü aynı sürüm olmalıdır. Gerekirse güncellenmelidir.<br>

Test Caseleri Çalıştırmak İçin

'mvn clean test -Dsurefire.suiteXmlFiles=testng/<testNGFile>` ile çalıştırın.
