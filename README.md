# java-Crud
Primer Proyecto Java-Maven

La aplicacion se base en la herramienta maven de Java para gestionar las dependencias. En este punto es muy importante leer y tener 
en cuenta la estructura los archivos .pom de cada modulo.
La estructura es la siguiente: 
  *Un app-parent que engloba todos los modulos
  *Un app-dao(data access object) que suministra una interfaz común entre la aplicación y la base de datos
  *Un app-services que maneja la administracion de la parte de negocio.
  *Un app-domain que tiene las clases con sus respectivos atributos y metodos para la posterior implementacion
  de las operaciones sobre productos y clientes
  *Un app-web que contiene todas las vistas hechas con archivos JSP. Implementando las clases Servlet para la inteaccion de las vistas
  con el servidor.

La base de datos esta hecha con un simple servidor XAMP

![listadoProductos](https://github.com/a73heredia/java-Crud/assets/54725913/70cb3701-fa62-4a3c-a4c8-1a603ab8b2ca)

