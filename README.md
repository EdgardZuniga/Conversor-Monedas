<h1>Conversor de Monedas</h1>

El proyecto consiste en consumir una API, la cual nos proporciona el valor de distintas monedas internacionales a comparacion del Dolar.
La tarea consistia en usar esa API, usar esos datos y crear un menu en el cual podemos seleccionar la moneda que queramos convertir de ella a dolar o viceversa.

El proyecto contiene un directorio de "Paquetes" en el cual estan dos archivos/Clases de Java.
![image](https://github.com/EdgardZuniga/Conversor-Monedas/assets/132112607/dbfed47f-4562-4ee7-a934-37857d60130e)

<h2>ApiManager</h2>

![image](https://github.com/EdgardZuniga/Conversor-Monedas/assets/132112607/4d2c560c-8d06-4d5f-88fe-bd3d1ac94338)


Como su nombre indica, administra o crea la conexion con la API, al instanciarla, el constructor tiene como parametro la url de la API.

Metodos:

  **-openConnection();**
  
  *Usa la url de la API para crear un objeto HttpURLConnection y luego se abre la conexion.*
    
  **-getRequest();**
  
  *Regresa la respuesta de la API*

  
  **-closeConnection();**
  
  *Cierra la conexion con la API.*
  
<h2>Json Manager</h2>

![image](https://github.com/EdgardZuniga/Conversor-Monedas/assets/132112607/d415a6e6-464d-4844-afcd-a808addccbd5)


Este al instanciarlo, usa un metodo donde necesita la respuesta de la API para convertirla a formato JSON.

Metodos:

  **jsonParser**
  
  *Este metodo necesita la respuesta de la API para convertirla a formato JSON*
    
  **getMoney**
  
  *Sirve para obtner la direccion en el JSON de la API para usar rapidamente los valores de las monedas*
  
....


