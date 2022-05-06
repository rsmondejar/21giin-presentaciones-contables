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
---
```
