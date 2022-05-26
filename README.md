# 21 GIIN - Proyecto asignatura Proyectos de Programación
==========================================================

## Introducción
Para la asignatura se ha pedido realizar un proyecto en Java de **Presentaciones Contables**.

## Configurar fichero hibernate
Lo primero sería hacer una copia del fichero `hibernate.example.cfg.xml` y guardarlo con nombre `hibernate.cfg.xml`.

Dentro de este fichero habría que cambiar las partes de código que aparecen como `CHANGE_ME`.

```xml
...
<property name="connection.url">jdbc:mysql://CHANGE_ME?serverTimezone=UTC</property>
<property name="connection.username">CHANGE_ME</property>
<property name="connection.password">CHANGE_ME</property>
```

## Scanned on Sonar Cloud
[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/summary/new_code?id=rsmondejar_21giin-presentaciones-contables)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=rsmondejar_21giin-presentaciones-contables&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=rsmondejar_21giin-presentaciones-contables)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=rsmondejar_21giin-presentaciones-contables&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=rsmondejar_21giin-presentaciones-contables)

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=rsmondejar_21giin-presentaciones-contables&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=rsmondejar_21giin-presentaciones-contables)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=rsmondejar_21giin-presentaciones-contables&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=rsmondejar_21giin-presentaciones-contables)
