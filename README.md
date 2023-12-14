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

La base de datos esta hecha con un simple servidor XAMP

![imagenes Productos](https://github.com/a73heredia/java-Crud/blob/main/listadoProductos.png)
