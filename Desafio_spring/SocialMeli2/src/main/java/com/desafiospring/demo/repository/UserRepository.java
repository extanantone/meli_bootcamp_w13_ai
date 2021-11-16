package com.desafiospring.demo.repository;





import com.desafiospring.demo.exception.UserNotFoundException;
import com.desafiospring.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository


public class UserRepository {
// geenramos nuestra base de datos de usuario/vendedorres

   HashMap<Integer, User> mapUser = new HashMap<Integer, User>();

   public UserRepository() {
      //creamos un objeto nuevo
       User user1 = new User(1, "Carol");
       User user2 = new User(2, "Esteban");
       User user3 = new User(3, "Ambar");
       User user4 = new User(4, "Theo");
       User user5 = new User(5, "Emilia");
       User user6 = new User(6, "Leo");
       User user7 = new User(7, "Gonzalo");
       User user8 = new User(8, "Joaquin");
       User user9 = new User(9, "Soledad");
       User user10 = new User(10, "Carolina");

        this.mapUser.put(1, user1);
        this.mapUser.put(2,user2 );
        this.mapUser.put(3, user3);
        this.mapUser.put(4, user4);
        this.mapUser.put(5, user5);
        this.mapUser.put(6, user6);
        this.mapUser.put(7, user7);
        this.mapUser.put(8, user8);
        this.mapUser.put(9, user9);
        this.mapUser.put(10, user10);



    }
 //metodo para encontrar un usario que sigue a un vendedor
    public User FindSeller(int userId) {
       return mapUser.get(userId);

   }
   //metodo para guardar en un usuario cuantas personas lo siguen

   public void AddFollow(int userId, int userIdToSelller){
       //aca le estamos agregando al uservendedor un nuevo seguidor


       if(mapUser.containsKey(userIdToSelller)){
           if(mapUser.containsKey(userId)){
               mapUser.get(userIdToSelller).AddFollowers(mapUser.get(userId));
           }else {
               throw new UserNotFoundException(userId);
           }
       } else {
           throw new UserNotFoundException(userIdToSelller);
       }



   }


}
