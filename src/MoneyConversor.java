import HttpManager.ApiManager;
import HttpManager.JsonManager;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class MoneyConversor {

    private int opcion = 0;
    private final double ARS;
    private final double COP;
    private final double BRL;

    public void Run(){
        double dinero;
        String errorMensaje = "Los valores ingresados solo deben ser Numéricos.\n";

        while(opcion != 7){
            String menu = """
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
            Consola(menu);
            Scanner respuestaUsuario = new Scanner(System.in);
            Scanner dineroConvertir = new Scanner(System.in);

            try{
                this.opcion = respuestaUsuario.nextInt();
            }catch (Exception e){
                Consola(errorMensaje);
                ContinueOrNot();
            }
            switch (this.opcion) {
                    case 1:
                        try{
                            messageOptionConverter("Dólares", "Pesos Argentinos");
                            dinero = dineroConvertir.nextDouble();
                            Authentication( dinero, "El valor de " + dinero + "[USD] a Pesos Argentinos es de: " + (dinero * this.ARS) + "[ARS]");
                        }catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 2:
                        try {
                            messageOptionConverter("Pesos Argentinos", "Dólares");
                            dinero = dineroConvertir.nextDouble();
                            Authentication(dinero, "El valor de " + dinero + "[ARS] a Dólares es de: " + (dinero / this.ARS) + "[USD]");
                        } catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 3:
                        try {
                            messageOptionConverter("Dólares", "Reales Brasileños");
                            dinero = dineroConvertir.nextDouble();
                            Authentication(dinero,"El valor de " + dinero + "[USD] a Real Brasileño es de: " + (dinero * this.BRL) + "[BRL]");
                        }catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 4:
                        try {
                            messageOptionConverter("Reales Brasileños", "Dólares");
                            dinero = dineroConvertir.nextDouble();
                            Authentication(dinero, "El valor de " + dinero + "[BRL] a Dólares es de: " + (dinero / this.BRL) + "[USD]");
                        }catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 5:
                        try {
                            messageOptionConverter("Dólares", "Pesos Colombianos");
                            dinero = dineroConvertir.nextDouble();
                            Authentication(dinero, "El valor de " + dinero + "[USD] a Pesos Colombianos es de: " + (dinero * this.COP) + "[COP]");
                        }catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 6:
                        try {
                            messageOptionConverter("Pesos Colombianos", "Dólares");
                            dinero = dineroConvertir.nextDouble();
                            Authentication(dinero, "El valor de " + dinero + "[COP] a Dólares es de: " + (dinero / this.COP) + "[USD]");
                        }catch (Exception e){
                            Consola(errorMensaje);
                            ContinueOrNot();
                        }
                        break;
                    case 7:
                        opcion = 7;
                        Consola("Gracias por usar la aplicación");
                        break;

                    default:
                        Consola("No se encontró la opción.\n");
                        ContinueOrNot();
                }

        }
    }

    public MoneyConversor(@NotNull ApiManager Api) {
        JsonManager jsonObjectConversor = new JsonManager();
        jsonObjectConversor.jsonParser(Api.getRequest());

        this.ARS = jsonObjectConversor.getMoney("ARS");
        this.COP = jsonObjectConversor.getMoney("COP");
        this.BRL = jsonObjectConversor.getMoney("BRL");
    }

    private void Consola(String message){
        System.out.println(message);
    }

    private void ContinueOrNot(){
        Scanner continuarPrograma = new Scanner(System.in);
        String continuar;

        Consola("Desea Continuar con el Programa?\nEscriba 'Si' si desea continuar.\nEscriba 'No' si desea salir del Programa.\nCualquier otra respuesta sera tomada como un 'No'.");
        continuar = continuarPrograma.nextLine();

        if (continuar.equals("Si")){
            Consola("El Programa Continuará");
        }else {
            Consola("Su respuesta fue un 'No' o fue tomado como un 'No'\nGracias por usar el Programa.");
            this.opcion = 7;
        }
    }

    private void messageOptionConverter(String moneyOne, String moneyTwo){
        Consola("Cuántos " + moneyOne + " desea convertir en " + moneyTwo + "?");
    }

    private void Authentication(double dinero, String mensaje){
        if (dinero < 0){
            Consola("Los valores no deben ser Negativos.\n");
            ContinueOrNot();
        }else{
            Consola(mensaje);
        }
    }

}
