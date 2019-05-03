package Rx;


import io.reactivex.Observable;

public class main {

    String result = "";
    public static void main(String[] args) {
        //http://www.vogella.com/tutorials/RxJava/article.html
       System.out.println("Iniciando");
        main p = new main();
        p.executa();
       System.out.println("Finalizando");
    }




    private void executa() {

        Observable<String> observer = Observable.just("Hello","Ola", "Hola");
        observer.subscribe(s -> {
                    result = s;
                    System.out.println(result);
                });

    }



}
