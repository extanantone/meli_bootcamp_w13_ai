public abstract class Prototipo {
    private  int valor;
     private int retorno=0;

     int devolver() {
        if(this.valor==1){
            retorno = this.retorno + 2;
        }else{
            retorno = this.retorno + this.valor;
        }
        return retorno;
    }
     int reiniciar (){
        this.retorno = this.valor;
        return this.retorno;
    }
     void inicial (int num){
        this.valor = num;
         if(this.valor==1){
             this.retorno = 1;
         }
    }

}
