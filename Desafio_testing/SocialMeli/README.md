# SocialMeli

### Documentacion

Para la realizacion del Sprint 1 me base en la creacion de 3 modelos
en los que se encuentra : *User*, *Post* y *Product*. <br>
Para relacionar los *User* en forma de follows se utilizan dos propiedas dentro de user
que corresponden a *LinkedList* una para los *followers* y otra para los  *followed* del
*User*, se usa una mas para los *posts*.
Adicional a esto se añadieron dos archivos *.json* para cargar datos, por medio de la 
capa *repository*.<br>

Se incluyeron *exceptions* para manejar los casos en los que se intentara acceder a users que no existen,
crear posts a partir de users que no existen, crear post o users que ya existen, intentar dar *unfollow* a un user 
que no esta siendo followed o intentar darse follow  a si mismo.<br>

Los endpoints siguieron todas las metricas establecidas con las siguientes excepciones:
<ol>
  <li>Los *User* no estan difirenciados entre vendedor y comprador.</li>
  <li>Los resultados estan en lowerCamelCase.</li>
  <li>los POST de creacion devuelven el objeto creado ademas del status esperado.</li>
</ol>


