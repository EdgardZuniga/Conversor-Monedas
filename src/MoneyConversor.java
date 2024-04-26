import HttpManager.ApiManager;
import HttpManager.JsonManager;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class MoneyConversor {
    private String Menu = """
            **********************************************
            Sea bienvenido/a al conversor de monedas
            
            1) Dólar ==> Peso Argentino
            2) Peso Argentino ==> Dólar
            3) Dólar ==> Real Brasileño
            4) Real Brasileño ==> Dólar
            5) Dólar ==> Peso Colombiano
            6) Peso Colombiano ==> Dólar
            7) Salir del Programa
            **********************************************
            Elija una opción de acuerdo a la acción que desea realizar.
            **********************************************
            """;

    private JsonManager jsonObjectConversor = new JsonManager();
    private double ARS;
    private double COP;
    private double BRL;

    public void Run(){
        boolean test;
        int opcion = 0;
        double dinero;

        while(opcion != 7){
            System.out.println(Menu);

            Scanner respuestaUsuario = new Scanner(System.in);
            Scanner dineroConvertir = new Scanner(System.in);

            try{
                opcion = respuestaUsuario.nextInt();
            }catch (Exception e){
                Consola("No se puede ingresar algo que no sea un Número.\n");
                test = Continue();

                if (test == false) {
                    opcion = 7;
                }
            }

            switch (opcion) {
                    case 1:
                        try{
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                                Consola("El valor de " + dinero + "[USD] a Pesos Argentinos es de: " + (dinero * this.ARS) + "[ARS]");
                            }

                        }catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }
                        break;
                    case 2:
                        try {
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                            Consola("El valor de " + dinero + "[ARS] a Dólares es de: " + (dinero / this.ARS) + "[USD]");
                            }
                        } catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }

                        break;
                    case 3:
                        try {
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                                Consola("El valor de " + dinero + "[USD] a Real Brasileño es de: " + (dinero * this.BRL) + "[BRL]");
                            }
                        }catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }
                        break;
                    case 4:
                        try {
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                                Consola("El valor de " + dinero + "[BRL] a Dólares es de: " + (dinero / this.BRL) + "[USD]");
                            }

                        }catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }
                        break;
                    case 5:
                        try {
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                                Consola("El valor de " + dinero + "[USD] a Pesos Colombianos es de: " + (dinero * this.COP) + "[COP]");
                            }
                        }catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }
                        break;
                    case 6:
                        try {
                            Consola("Cuanto desea convertir?");
                            dinero = dineroConvertir.nextDouble();
                            if (dinero < 0){
                                Consola("Los valores no deben ser Negativos.\n");
                                test = Continue();

                                if (test == false) {
                                    opcion = 7;
                                }
                            }else{
                                Consola("El valor de " + dinero + "[COP] a Dólares es de: " + (dinero / this.COP) + "[USD]");
                            }
                        }catch (Exception e){
                            Consola("Los valores ingresados solo deben ser Numéricos.");
                            test = Continue();

                            if (test == false) {
                                opcion = 7;
                            }
                        }
                        break;
                    case 7:
                        opcion = 7;
                        Consola("Gracias por usar la aplicación");
                        break;

                    default:
                        Consola("No se encontró la opción.\n");
                        test = Continue();

                        if (test == false) {
                            opcion = 7;
                        }
                        break;
                }

        }
    }

    public MoneyConversor(@NotNull ApiManager Api) {
        jsonObjectConversor.jsonParser(Api.getRequest());

        this.ARS = jsonObjectConversor.getMoney("ARS");
        this.COP = jsonObjectConversor.getMoney("COP");
        this.BRL = jsonObjectConversor.getMoney("BRL");
    }

    private void Consola(String message){
        System.out.println(message);
    }

    private boolean Continue(){
        Scanner continuarPrograma = new Scanner(System.in);
        String continuar;

        Consola("Desea Continuar con el Programa?\nEscriba 'Si' si desea continuar.\nEscriba 'No' si desea salir del Programa.\nCualquier otra respuesta sera tomada como un 'No'.");
        continuar = continuarPrograma.nextLine();

        if (continuar.equals("Si")){
            Consola("El Programa Continuará");
            return true;
        }else {
            Consola("Su respuesta fue un 'No' o fue tomado como un 'No'\nGracias por usar el Programa.");
            return false;
        }
    }
}
