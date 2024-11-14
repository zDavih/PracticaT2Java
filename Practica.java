import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Practica {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LocalDate fechaCriada = LocalDate.of(2024, 11, 20),
                fechaOtonio = LocalDate.of(2024, 11, 28),
                fechaJazz = LocalDate.of(2024, 12, 06);
        LocalDate fechaIntroducida;
        Period entre;
        int entradasVendidasCriadasPlatea = 0, entradasVendidasCriadasButacas = 0, entradasVendidasCriadasAnfiteatro = 0,
                entradasVendidasOtonioPlatea = 0, entradasVendidasOtonioButacas = 0, entradasVendidasOtonioAnfiteatro = 0,
                entradasVendidasJazzPlatea = 0, entradasVendidasJazzButacas = 0, entradasVendidasJazzAnfiteatro = 0;

        int entradasTotalesCriadasPlatea = 140, entradasTotalesCriadasButacas = 200, entradasTotalesCriadasAnfiteatro = 200,
                entradasTotalesOtonioPlatea = 140, entradasTotalesOtonioButacas = 200, entradasTotalesOtonioAnfiteatro = 200,
                entradasTotalesJazzPlatea = 140, entradasTotalesJazzButacas = 200, entradasTotalesJazzAnfiteatro = 200;

        String opcionMenuUsuario, usuIntro, claveIntro, opcionAdmin, opcionConsulta, infoEvento;
        final String USUADMIN = "Wawowo23", CLAVEADMIN = "zDavih";
        boolean login = false, apagar = false, descuento = false;
        String ventaEntradas, ventaEntradasCriadas, ventaEntradasOtonio, ventaEntradasJazz, fechaPreguntada, tipoEntradaCodigo = "", tipoEntradaTicket = "", precioMostrado = "";
        int numeroEntradas, numUnico = 0;
        final float IVA = 0.10f;
        float precioTotal, cambioEntrada, dineroIntroducido, dineroRecaudadoCriadas = 0,
                dineroRecaudadoOtonio = 0, dineroRecaudadoJazz = 0, precioEntrada = 0, porcentajeDescuento = 0;
        int billete100 = 100, billete50 = 100, billete20 = 100,
                billete10 = 100, billete5 = 100, monedas2 = 100, monedas1 = 100,
                monedas50c = 100, monedas20c = 100, monedas10c = 100, monedas5c = 100,
                monedas2c = 100, monedas1c = 100, cuentaDinero = 0;

        //Ponemos el cartel de bienvenido al empezar el programa
        System.out.print("""
                
                ░█▀▀█ ▀█▀ ░█▀▀▀ ░█▄─░█ ░█──░█ ░█▀▀▀ ░█▄─░█ ▀█▀ ░█▀▀▄ ░█▀▀▀█ 　 ─█▀▀█\s
                ░█▀▀▄ ░█─ ░█▀▀▀ ░█░█░█ ─░█░█─ ░█▀▀▀ ░█░█░█ ░█─ ░█─░█ ░█──░█ 　 ░█▄▄█\s
                ░█▄▄█ ▄█▄ ░█▄▄▄ ░█──▀█ ──▀▄▀─ ░█▄▄▄ ░█──▀█ ▄█▄ ░█▄▄▀ ░█▄▄▄█ 　 ░█─░█\s
                
                ░█▀▀█ ─█▀▀█ ░█─── ░█▀▀█ ░█▀▀▀█ ░█▄─░█ 　 ▀▀█▀▀ ▀█▀ ░█▀▀█ ░█─▄▀ ░█▀▀▀ ▀▀█▀▀ ░█▀▀▀█\s
                ░█▀▀▄ ░█▄▄█ ░█─── ░█▀▀▄ ░█──░█ ░█░█░█ 　 ─░█── ░█─ ░█─── ░█▀▄─ ░█▀▀▀ ─░█── ─▀▀▀▄▄\s
                ░█▄▄█ ░█─░█ ░█▄▄█ ░█▄▄█ ░█▄▄▄█ ░█──▀█ 　 ─░█── ▄█▄ ░█▄▄█ ░█─░█ ░█▄▄▄ ─░█── ░█▄▄▄█\n\n""");

        System.out.print("""
                ************************************
                *  PULSA UNA TECLA PARA CONTINUAR  *
                ************************************
                \n""");
        scanner.nextLine();

        // Este es el menú principal en el cual podrás acceder a las distintas partes del programa
        do {
            System.out.print("""
                    ***************************************
                    *          MENÚ DE ENTRADAS           *
                    ***************************************
                    * a. Vender entradas para un evento   *
                    * b. Consultar el estado de un evento *
                    * c. Menú de administrador            *
                    ***************************************
                    """);

            System.out.print("Introduce la opción que deseas hacer: ");
            opcionMenuUsuario = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (opcionMenuUsuario) { //Mostramos las opciones del menú según el valor introducido
                //Aquí se procede a la venta de entradas para el evento
                case "a":
                    System.out.print("""
                            ********************************************
                            *            TIPOS DE ENTRADAS             *
                            ********************************************
                            * a. ENTRADA PARA LAS CRIADAS              *
                            * b. ENTRADA PARA EL II CONCIERTO DE OTOÑO *
                            * c. ENTRADA PARA EL CONCIERTO DE JAZZ     *
                            * d. SALIR                                 *
                            ********************************************
                            * Introduzca la opción deseada:\s""");
                    ventaEntradas = scanner.nextLine().toLowerCase();
                    System.out.println();

                    switch (ventaEntradas) {
                        case "a":
                            //Aquí enseñamos los distintos tipos de entrada que se pueden comprar
                            System.out.print("""
                                    ************************************
                                    * TIPOS DE ENTRADAS DE LAS CRIADAS *
                                    ************************************
                                    * a. Entrada Platea                *
                                    * b. Entrada Butaca                *
                                    * c. Entrada Anfiteatro            *
                                    * d. Salir de este menú            *
                                    ************************************
                                    * Introduce la opción deseada:\s""");
                            ventaEntradasCriadas = scanner.nextLine().toLowerCase();
                            System.out.println();
                            //En este switch les daremos distintos valores a las variables según el tipo de entrada que quiera comprar el usuario
                            switch (ventaEntradasCriadas) {
                                case "a":
                                    //Aquí damos los valores correspondientes con las entradas platea
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Platea: 17E + IVA10% : 1.70E = 18.70E";
                                    porcentajeDescuento = 0.05f;
                                    precioEntrada = 17f;
                                    tipoEntradaTicket = "Platea";
                                    tipoEntradaCodigo = "PL";
                                    break;

                                case "b":
                                    //Aquí damos los valores correspondientes con las entradas butaca
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Butaca: 20E + IVA10% : 2E = 22.00E";
                                    porcentajeDescuento = 0.05f;
                                    precioEntrada = 20f;
                                    tipoEntradaTicket = "Butaca";
                                    tipoEntradaCodigo = "BU";
                                    break;

                                case "c":
                                    //Aquí damos los valores correspondientes con las entradas anfiteatro
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Anfiteatro: 13E + IVA10% : 1.30E = 14.30E";
                                    porcentajeDescuento = 0.05f;
                                    precioEntrada = 13f;
                                    tipoEntradaTicket = "Anfiteatro";
                                    tipoEntradaCodigo = "AF";
                                    break;

                                case "d":
                                    System.out.println("Saliendo del menú");
                                    break;

                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }
                            //Fuera del switch hacemos todos los cálculos relacionados con las entradas
                            //Hacemos que si el usuario ha puesto un valor que no corresponda con ningún tipo de entrada no haga los cálculos
                            if (ventaEntradasCriadas.equals("a") || ventaEntradasCriadas.equals("b") || ventaEntradasCriadas.equals("c")) {
                                do { //Preguntamos y verificamos la cantidad de entradas que se van a comprar
                                    System.out.print("¿Cuántas entradas vas a comprar? ");
                                    numeroEntradas = Integer.parseInt(scanner.nextLine());
                                    if (numeroEntradas < 1)
                                        System.out.println("Cantidad de entradas introducida incorrecta, ponga una cantidad correcta");
                                } while (numeroEntradas < 1);

                                //Preguntamos en que día se quiere simular la compra
                                System.out.print("¿Qué día quieres comprar la entrada? (Ponlo en este formato yyyy-mm-dd) : ");
                                fechaPreguntada = scanner.nextLine();

                                //Si el usuario escribe "no" la fecha que se utilizara será la del día actual
                                if (fechaPreguntada.equalsIgnoreCase("no")) fechaIntroducida = LocalDate.now();
                                else fechaIntroducida = LocalDate.parse(fechaPreguntada);

                                //Comprobamos basándonos en la fecha introducida si se puede aplicar el descuento
                                entre = Period.between(fechaIntroducida, fechaCriada);
                                if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                    descuento = true;

                                //Calculamos el precio total de todas las entradas
                                precioTotal = (precioEntrada + (precioEntrada * IVA)) * numeroEntradas;

                                //Calculamos el precio de las entradas con el descuento
                                if (descuento) precioTotal -= (float) (precioTotal * porcentajeDescuento);
                                dineroRecaudadoCriadas += precioTotal;
                                System.out.printf("El precio total a pagar es de %.2f\n", precioTotal);

                                //Pedimos y verificamos la cantidad que debe pagar el cliente por las entradas
                                do {
                                    System.out.print("Introduce la cantidad para pagar: ");
                                    dineroIntroducido = Float.parseFloat(scanner.nextLine());
                                    if (dineroIntroducido < precioTotal)
                                        System.out.printf("La cantidad introducida no es suficiente necesita introducir %.2f euros o más\n", precioTotal);
                                } while (dineroIntroducido < precioTotal);

                                //Calculamos el cambio
                                cambioEntrada = dineroIntroducido - precioTotal;
                                System.out.printf("Su cambio es de %.2f\n", cambioEntrada);
                                if (cambioEntrada > 0) {
                                    //Calculamos la cantidad de billetes y monedas que hay que darle como cambio al cliente
                                    System.out.print("Se te devuelven: ");
                                    //Calculamos el cambio para que se le devuelva en la cantidad mínima de billetes y monedas
                                    while (cambioEntrada >= 100) {
                                        cuentaDinero = (int) cambioEntrada / 100;
                                        cambioEntrada %= 100;
                                        billete100 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 100 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        billete50 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 50 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        billete20 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 20 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        billete10 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 10 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        billete5 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 5 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {
                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 2 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada;
                                        cambioEntrada %= 1;
                                        monedas1 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 1 euro", cuentaDinero);
                                    cuentaDinero = 0;

                                    //Multiplicamos por 100 y redondeamos lo que quede de cambio para poder calcular los céntimos
                                    cambioEntrada = Math.round(cambioEntrada * 100d);

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        monedas50c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 50 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        monedas20c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 20 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        monedas10c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 10 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        monedas5c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 5 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {
                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 2 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    if (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada % 2;
                                        monedas1c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.print(" 1 moneda de un céntimo");
                                    cuentaDinero = 0;
                                    System.out.println();
                                }
                                for (int i = 1; i <= numeroEntradas; i++) { //Imprimimos las entradas

                                    System.out.print("""
                                            *********************************************
                                            *   PULSA UNA TECLA Y ENTER PARA CONTINUAR  *
                                            *********************************************
                                            \n""");
                                    scanner.nextLine();
                                    //Sumamos 1 al número único por cada entrada que se imprime para que en cada entrada sea distinto
                                    numUnico++;
                                    System.out.printf("""
                                            *****************************************************************************************************************************************************
                                            *                                                                                                                                                   *
                                            *       Entrada %3d   de %3d                                                                                                                        *
                                            *                                                                                                                                                   *
                                            *****************************************************************************************************************************************************
                                            *                                                                                                                                                   *
                                            * %s                                                                                                                                                *
                                            *                                                                                                                                                   *
                                            *                             /         (***(""*(****                                                                                               *
                                            *                           ****(/*(*@*****@******(*@(,                                                                                             *
                                            *                               ,@*****@@@***@***@***@*                                                                                             *
                                            *                          ///(.**@*@****/@***@*/***/*/                                                                                             *
                                            *                          //****@@///@///(****++(***(/                                                                                             *
                                            *                         //////////@++++++++*******+++(                                                                                            *
                                            *                      ,*/*,(+//(/+@+@++++@////++($(+(/*                                                                                            *
                                            *                   ,++(/+///(*+++*(*/**+@@*(((+/*(/                                                                                                *
                                            *                  .****++++*******//*******(/((*@/*(/"(,.,                                                                                         *
                                            *                   .(//////"@*@+@++@///@***(+*+*((//**(*                                                                                           *
                                            *                . ·**··$**$ **($+****/**//(&*&&&&,                                                                                                 *
                                            *                 (*,                         ,//(/*(/                                                                                              *
                                            *                                                  &&&(                                                                                             *
                                            *                                                     /*.                                                                                           *
                                            *                                                          /,                                                                                       *
                                            *                                                            /,.                                                                                    *
                                            *                                                              */,                                                                                  *
                                            *                                                                                                                                                   *
                                            * Los menores de 16 años sólo podrán                                                                                                                *
                                            * acceder al recinto acompañados                                                                                                                    *
                                            * de padre, madre o tutor legal                                                                                                                     *
                                            *                                                                                                                                                   *
                                            *                                                                                                                                                   *
                                            * Entrada General %10s                                                                                                                              *
                                            *                                                                                                                                                   *
                                            * BALBONTICKETS                                                                                                                                     *
                                            * -------------       EG%2s---201124 / CRI   -%3d   -%3d / %s                                                                                       *
                                            * BalbonTickets.es                                                                                                                                  *
                                            *****************************************************************************************************************************************************
                                            *                                   %57s                                                      \t*                                                   *
                                            *                                   %45s                                                                \t                                          *
                                            *****************************************************************************************************************************************************
                                            """, i, numeroEntradas, fechaCriada, tipoEntradaTicket, tipoEntradaCodigo, i, numUnico, fechaIntroducida, precioMostrado, ((descuento) ?
                                            "Se dispone del descuento por anticipación" : ""));
                                }
                                System.out.print("""
                                        ************************************
                                        *  PULSA UNA TECLA PARA CONTINUAR  *
                                        ************************************
                                        \n""");
                                scanner.nextLine();

                                //Sumamos el número de las entradas vendidas
                                if (ventaEntradasCriadas.equals("a")) entradasVendidasCriadasPlatea += numeroEntradas;
                                if (ventaEntradasCriadas.equals("b")) entradasVendidasCriadasButacas += numeroEntradas;
                                if (ventaEntradasCriadas.equals("c"))
                                    entradasVendidasCriadasAnfiteatro += numeroEntradas;
                            }
                            break;
                        case "b":
                            System.out.print("""
                                    ***********************************************
                                    * TIPOS DE ENTRADAS DEL II CONCIERTO DE OTOÑO *
                                    ***********************************************
                                    * a. Entrada Platea                           *
                                    * b. Entrada Butaca                           *
                                    * c. Entrada Anfiteatro                       *
                                    * d. Salir de este menú                       *
                                    ***********************************************
                                    * Introduce la opción deseada:\s""");
                            ventaEntradasOtonio = scanner.nextLine().toLowerCase();
                            System.out.println();
                            switch (ventaEntradasOtonio) {
                                case "a":
                                    //Aquí damos los valores correspondientes con las entradas platea
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Platea: 12E + IVA10% : 1.20E = 13.20E";
                                    porcentajeDescuento = 0.07f;
                                    precioEntrada = 12f;
                                    tipoEntradaTicket = "Platea";
                                    tipoEntradaCodigo = "PL";
                                    break;

                                case "b":
                                    //Aquí damos los valores correspondientes con las entradas butaca
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Butaca: 15E + IVA10% : 1.5E = 16.50E";
                                    porcentajeDescuento = 0.07f;
                                    precioEntrada = 15f;
                                    tipoEntradaTicket = "Butaca";
                                    tipoEntradaCodigo = "BU";
                                    break;

                                case "c":
                                    //Aquí damos los valores correspondientes con las entradas anfiteatro
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Anfiteatro: 8E + IVA10% : 0.80E = 8.80E";
                                    porcentajeDescuento = 0.07f;
                                    precioEntrada = 8f;
                                    tipoEntradaTicket = "Anfiteatro";
                                    tipoEntradaCodigo = "AF";
                                    break;

                                case "d":
                                    System.out.println("Saliendo del menú");
                                    break;

                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }
                            //Fuera del switch hacemos todos los cálculos relacionados con las entradas
                            //Hacemos que si el usuario ha puesto un valor que no corresponda con ningún tipo de entrada no haga los cálculos
                            if (ventaEntradasOtonio.equals("a") || ventaEntradasOtonio.equals("b") || ventaEntradasOtonio.equals("c")) {
                                do { //Preguntamos y verificamos la cantidad de entradas que se van a comprar
                                    System.out.print("¿Cuántas entradas vas a comprar? ");
                                    numeroEntradas = Integer.parseInt(scanner.nextLine());
                                    if (numeroEntradas < 1)
                                        System.out.println("Cantidad de entradas introducida incorrecta, ponga una cantidad correcta");
                                } while (numeroEntradas < 1);

                                //Preguntamos en que día se quiere simular la compra
                                System.out.print("¿Qué día quieres comprar la entrada? (Ponlo en este formato yyyy-mm-dd) : ");
                                fechaPreguntada = scanner.nextLine();

                                //Si el usuario escribe "no" la fecha que se utilizara será la del día actual
                                if (fechaPreguntada.equalsIgnoreCase("no")) fechaIntroducida = LocalDate.now();
                                else fechaIntroducida = LocalDate.parse(fechaPreguntada);

                                //Comprobamos basándonos en la fecha introducida si se puede aplicar el descuento
                                entre = Period.between(fechaIntroducida, fechaCriada);
                                if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                    descuento = true;

                                //Calculamos el precio total de todas las entradas
                                precioTotal = (precioEntrada + (precioEntrada * IVA)) * numeroEntradas;

                                //Calculamos el precio de las entradas con el descuento
                                if (descuento) precioTotal -= (float) (precioTotal * porcentajeDescuento);
                                dineroRecaudadoOtonio += precioTotal;
                                System.out.printf("El precio total a pagar es de %.2f\n", precioTotal);

                                //Pedimos y verificamos la cantidad que debe pagar el cliente por las entradas
                                do {
                                    System.out.print("Introduce la cantidad para pagar: ");
                                    dineroIntroducido = Float.parseFloat(scanner.nextLine());
                                    if (dineroIntroducido < precioTotal)
                                        System.out.printf("La cantidad introducida no es suficiente necesita introducir %.2f euros o más\n", precioTotal);
                                } while (dineroIntroducido < precioTotal);

                                //Calculamos el cambio
                                cambioEntrada = dineroIntroducido - precioTotal;
                                System.out.printf("Su cambio es de %.2f\n", cambioEntrada);
                                if (cambioEntrada > 0) {
                                    //Calculamos la cantidad de billetes y monedas que hay que darle como cambio al cliente
                                    System.out.print("Se te devuelven: ");
                                    //Calculamos el cambio para que se le devuelva en la cantidad mínima de billetes y monedas
                                    while (cambioEntrada >= 100) {
                                        cuentaDinero = (int) cambioEntrada / 100;
                                        cambioEntrada %= 100;
                                        billete100 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 100 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        billete50 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 50 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        billete20 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 20 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        billete10 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 10 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        billete5 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 5 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {
                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 2 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada;
                                        cambioEntrada %= 1;
                                        monedas1 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 1 euro", cuentaDinero);
                                    cuentaDinero = 0;

                                    //Multiplicamos por 100 y redondeamos lo que quede de cambio para poder calcular los céntimos
                                    cambioEntrada = Math.round(cambioEntrada * 100d);

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        monedas50c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 50 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        monedas20c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 20 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        monedas10c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 10 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        monedas5c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 5 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {

                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 2 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    if (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada % 2;
                                        monedas1c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.print(" 1 moneda de un céntimo");
                                    cuentaDinero = 0;
                                    System.out.println();
                                }
                                for (int i = 1; i <= numeroEntradas; i++) { //Imprimimos las entradas
                                    System.out.print("""
                                            *********************************************
                                            *   PULSA UNA TECLA Y ENTER PARA CONTINUAR  *
                                            *********************************************
                                            \n""");
                                    scanner.nextLine();
                                    //Sumamos 1 al número único por cada entrada que se imprime para que en cada entrada sea distinto
                                    numUnico++;
                                    System.out.printf("""
                                            *****************************************************************************************************************************************************
                                            *                                                                                                                                                   *
                                            *       Entrada %3d   de %3d                                                                                                                        *
                                            *                                                                                                                                                   *
                                            *****************************************************************************************************************************************************
                                            *                                                                                                                                                   *
                                            * %s                                                                                                                                                *
                                            *                                                                                                                                                   *
                                            *                                      //(.     /                               (                                                                   *
                                            *                                        (////*  /(                             /                                                                   *
                                            *                                        (///////#//(     /                   ///                                                                   *
                                            *                                       /////(///(//////////          (     //////                                                                  *
                                            *                                    ((////////#(////////(//          /#//////////(                                                                 *
                                            *                                      (///(////(///////(////         //#//////////(.                                                               *
                                            *                                       //////(#/(//////(/////       ////(//////#//                                                                 *
                                            *                                       //////////#(////#////////((////////(//#////(                                                                *
                                            *                                 *(//////(/////////(/////////////////////#/#//////(/(                                                              *
                                            *                                     (///////#((////(/#/////////////////#////(#////                                                                *
                                            *                        /((            ///////////(//#/////////////////#//((//////                                                                 *
                                            *             //////(,   ///(////(.     ///////////////#////////////////((////////,                                                                 *
                                            *                ,////#((////(#(//////////////////////////////(////////////////////                                                                 *
                                            *                  ./////#////#//#//////////////////////((////(///////////////////////                                                              *
                                            *                   (//////////////////#/(/////////////////////(///#////////////////////////(                                                       *
                                            *                        ////////#///////////(#////////////(////#((/////((//////////////                                                            *
                                            *                        (///#(////////////////////((//////#////(//////////////#/(///                                                               *
                                            *                      /(/////////////////////////((///#///////(/////#(((/(/////////                                                                *
                                            *                                *////////////#(//////////(////((///////////////(//                                                                 *
                                            *                                   (//////////////////////(/#///#/////////////     ,/                                                              *
                                            *                                  (//////////////#(((/////// # (//#//////                                                                          *
                                            *                             ./(///(##////////(////////#///   #  ,//#///                                                                           *
                                            *                                    /////////(/////////#///   #       (#(                                                                          *
                                            *                                       ////#/*,((////////     #*                                                                                   *
                                            *                                       //         (///(/      ##                                                                                   *
                                            *                                                   /(        (#(                                                                                   *                                                               *
                                            *                                                                                                                                                   *
                                            * Los menores de 16 años sólo podrán                                                                                                                *
                                            * acceder al recinto acompañados                                                                                                                    *
                                            * de padre, madre o tutor legal                                                                                                                     *
                                            *                                                                                                                                                   *
                                            *                                                                                                                                                   *
                                            * Entrada General %10s                                                                                                                              *
                                            *                                                                                                                                                   *
                                            * BALBONTICKETS                                                                                                                                     *
                                            * -------------       EG%2s---201128 / OTO   -%3d   -%3d / %s                                                                                       *
                                            * BalbonTickets.es                                                                                                                                  *
                                            *****************************************************************************************************************************************************
                                            *                                   %57s                                                    \t*
                                            *                                   %45s                                                                \t*
                                            *****************************************************************************************************************************************************
                                            """, i, numeroEntradas, fechaOtonio, tipoEntradaTicket, tipoEntradaCodigo, i, numUnico, fechaIntroducida, precioMostrado, ((descuento) ?
                                            "Se dispone del descuento por anticipación" : ""));
                                }
                                System.out.print("""
                                        ************************************
                                        *  PULSA UNA TECLA PARA CONTINUAR  *
                                        ************************************
                                        \n""");
                                scanner.nextLine();

                                //Sumamos el número de las entradas vendidas
                                if (ventaEntradasOtonio.equals("a")) entradasVendidasOtonioPlatea += numeroEntradas;
                                if (ventaEntradasOtonio.equals("b")) entradasVendidasOtonioButacas += numeroEntradas;
                                if (ventaEntradasOtonio.equals("c")) entradasVendidasOtonioAnfiteatro += numeroEntradas;
                            }
                            break;
                        case "c":
                            System.out.print("""
                                    *******************************************
                                    * TIPOS DE ENTRADAS DEL CONCIERTO DE JAZZ *
                                    *******************************************
                                    * a. Entrada Platea                       *
                                    * b. Entrada Butaca                       *
                                    * c. Entrada Anfiteatro                   *
                                    * d. Salir de este menú                   *
                                    *******************************************
                                    * Introduce la opción deseada:\s""");
                            ventaEntradasJazz = scanner.nextLine().toLowerCase();
                            System.out.println();
                            switch (ventaEntradasJazz) {
                                case "a":
                                    //Aquí damos los valores correspondientes con las entradas platea
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Platea: 20E + IVA10% : 2.00E = 22.00E";
                                    porcentajeDescuento = 0.03f;
                                    precioEntrada = 20f;
                                    tipoEntradaTicket = "Platea";
                                    tipoEntradaCodigo = "PL";
                                    break;

                                case "b":
                                    //Aquí damos los valores correspondientes con las entradas butaca
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Butaca: 25E + IVA10% : 2.5E = 27.50E";
                                    porcentajeDescuento = 0.03f;
                                    precioEntrada = 25f;
                                    tipoEntradaTicket = "Butaca";
                                    tipoEntradaCodigo = "BU";
                                    break;

                                case "c":
                                    //Aquí damos los valores correspondientes con las entradas anfiteatro
                                    //Precio mostrado en la entrada según el tipo de entrada
                                    precioMostrado = "Precio Entrada Anfiteatro: 15E + IVA10% : 1.50E = 16.50E";
                                    porcentajeDescuento = 0.03f;
                                    precioEntrada = 15f;
                                    tipoEntradaTicket = "Anfiteatro";
                                    tipoEntradaCodigo = "AF";
                                    break;

                                case "d":
                                    System.out.println("Saliendo del menú");
                                    break;

                                default:
                                    System.out.println("Opción no válida");
                                    break;
                            }
                            //Fuera del switch hacemos todos los cálculos relacionados con las entradas
                            //Hacemos que si el usuario ha puesto un valor que no corresponda con ningún tipo de entrada no haga los cálculos
                            if (ventaEntradasJazz.equals("a") || ventaEntradasJazz.equals("b") || ventaEntradasJazz.equals("c")) {
                                do { //Preguntamos y verificamos la cantidad de entradas que se van a comprar
                                    System.out.print("¿Cuántas entradas vas a comprar? ");
                                    numeroEntradas = Integer.parseInt(scanner.nextLine());
                                    if (numeroEntradas < 1)
                                        System.out.println("Cantidad de entradas introducida incorrecta, ponga una cantidad correcta");
                                } while (numeroEntradas < 1);

                                //Preguntamos en que día se quiere simular la compra
                                System.out.print("¿Qué día quieres comprar la entrada? (Ponlo en este formato yyyy-mm-dd) : ");
                                fechaPreguntada = scanner.nextLine();

                                //Si el usuario escribe "no" la fecha que se utilizara será la del día actual
                                if (fechaPreguntada.equalsIgnoreCase("no")) fechaIntroducida = LocalDate.now();
                                else fechaIntroducida = LocalDate.parse(fechaPreguntada);

                                //Comprobamos basándonos en la fecha introducida si se puede aplicar el descuento
                                entre = Period.between(fechaIntroducida, fechaCriada);
                                if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                    descuento = true;

                                //Calculamos el precio total de todas las entradas
                                precioTotal = (precioEntrada + (precioEntrada * IVA)) * numeroEntradas;

                                //Calculamos el precio de las entradas con el descuento
                                if (descuento) precioTotal -= (float) (precioTotal * porcentajeDescuento);
                                dineroRecaudadoJazz += precioTotal;
                                System.out.printf("El precio total a pagar es de %.2f\n", precioTotal);

                                //Pedimos y verificamos la cantidad que debe pagar el cliente por las entradas
                                do {
                                    System.out.print("Introduce la cantidad para pagar: ");
                                    dineroIntroducido = Float.parseFloat(scanner.nextLine());
                                    if (dineroIntroducido < precioTotal)
                                        System.out.printf("La cantidad introducida no es suficiente necesita introducir %.2f euros o más\n", precioTotal);
                                } while (dineroIntroducido < precioTotal);

                                //Calculamos el cambio
                                cambioEntrada = dineroIntroducido - precioTotal;
                                System.out.printf("Su cambio es de %.2f\n", cambioEntrada);
                                if (cambioEntrada > 0) {
                                    //Calculamos la cantidad de billetes y monedas que hay que darle como cambio al cliente
                                    System.out.print("Se te devuelven: ");
                                    //Calculamos el cambio para que se le devuelva en la cantidad mínima de billetes y monedas
                                    while (cambioEntrada >= 100) {
                                        cuentaDinero = (int) cambioEntrada / 100;
                                        cambioEntrada %= 100;
                                        billete100 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 100 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        billete50 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 50 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        billete20 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 20 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        billete10 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 10 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        billete5 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d billetes de 5 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {
                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 2 euros", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada;
                                        cambioEntrada %= 1;
                                        monedas1 -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.printf(" %d monedas de 1 euro", cuentaDinero);
                                    cuentaDinero = 0;

                                    //Multiplicamos por 100 y redondeamos lo que quede de cambio para poder calcular los céntimos
                                    cambioEntrada = Math.round(cambioEntrada * 100d);

                                    while (cambioEntrada >= 50) {
                                        cuentaDinero = (int) cambioEntrada / 50;
                                        cambioEntrada %= 50;
                                        monedas50c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 50 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 20) {
                                        cuentaDinero = (int) cambioEntrada / 20;
                                        cambioEntrada %= 20;
                                        monedas20c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 20 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 10) {
                                        cuentaDinero = (int) cambioEntrada / 10;
                                        cambioEntrada %= 10;
                                        monedas10c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 10 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 5) {
                                        cuentaDinero = (int) cambioEntrada / 5;
                                        cambioEntrada %= 5;
                                        monedas5c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 5 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    while (cambioEntrada >= 2) {

                                        cuentaDinero = (int) cambioEntrada / 2;
                                        cambioEntrada %= 2;
                                        monedas2c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0)
                                        System.out.printf(" %d monedas de 2 céntimos", cuentaDinero);
                                    cuentaDinero = 0;

                                    if (cambioEntrada >= 1) {
                                        cuentaDinero = (int) cambioEntrada % 2;
                                        monedas1c -= cuentaDinero;
                                    }
                                    if (cuentaDinero > 0) System.out.print(" 1 moneda de un céntimo");
                                    cuentaDinero = 0;
                                    System.out.println();
                                }
                                for (int i = 1; i <= numeroEntradas; i++) { //Imprimimos las entradas
                                    System.out.print("""
                                            *********************************************
                                            *   PULSA UNA TECLA Y ENTER PARA CONTINUAR  *
                                            *********************************************
                                            \n""");
                                    scanner.nextLine();
                                    //Sumamos 1 al número único por cada entrada que se imprime para que en cada entrada sea distinto
                                    numUnico++;
                                    System.out.printf("""
                                            *****************************************************************************
                                            *                                                                           *
                                            *       Entrada %3d   de %3d                                                *
                                            *                                                                           *
                                            *****************************************************************************
                                            *                                                                           *
                                            * %s                                                                        *
                                            *                                                                           *
                                            *                                                  @@@@@                    *
                                            *                                                  @@@@ &@                  *
                                            *                                                 .@@   (@                  *
                                            *                                                 (@.   @@                  *
                                            *                                                  @  @@@&                  *
                                            *                                                  @&@@@@                   *
                                            *                                                @@@@@@.                    *
                                            *                                              @@@@@@@                      *
                                            *                                            #@@@@.  @                      *
                                            *                                           @@@@   .@@@@@@&                 *
                                            *                                           @@@   @@@@@@@@@@@               *
                                            *                                           @@#  &@&  @@   @@&              *
                                            *                                            @@   @&   @.  &@@              *
                                            *                                             /@/   /@ @@ *@@               *
                                            *                                                ,@@@@@@@@                  *
                                            *                                                       &@                  *
                                            *                                                @@@@    &*                 *
                                            *                                               @@@@@@   @&                 *
                                            *                                               @@@@(  .@&                  *
                                            *                                                                           *
                                            * Los menores de 16 años sólo podrán                                        *
                                            * acceder al recinto acompañados                                            *
                                            * de padre, madre o tutor legal                                             *
                                            *                                                                           *
                                            *                                                                           *
                                            * Entrada General %10s                                                      *
                                            *                                                                           *
                                            * BALBONTICKETS                                                             *
                                            * -------------       EG%2s---201128 / JZZ   -%3d   -%3d / %s               *
                                            * BalbonTickets.es                                                          *
                                            *****************************************************************************
                                            *                                   %57s                                    *
                                            *                                   %45s                                    *
                                            *****************************************************************************
                                            """, i, numeroEntradas, fechaJazz, tipoEntradaTicket, tipoEntradaCodigo, i, numUnico, fechaIntroducida, precioMostrado, ((descuento) ?
                                            "Se dispone del descuento por anticipación" : ""));
                                }
                                System.out.print("""
                                        ************************************
                                        *  PULSA UNA TECLA PARA CONTINUAR  *
                                        ************************************
                                        \n""");
                                scanner.nextLine();
                                //Sumamos el número de las entradas vendidas
                                if (ventaEntradasJazz.equals("a")) entradasVendidasJazzPlatea += numeroEntradas;
                                if (ventaEntradasJazz.equals("b")) entradasVendidasJazzButacas += numeroEntradas;
                                if (ventaEntradasJazz.equals("c")) entradasVendidasJazzAnfiteatro += numeroEntradas;
                            }
                            break;
                    }
                    break;
                // Aquí consultamos el estado del evento
                case "b":
                    do {
                        System.out.print("""
                                ***************************************************
                                *                    EVENTOS                      *
                                ***************************************************
                                * a. Las criadas                                  *
                                * b. II Concierto de Otoño                        *
                                * c. Concierto de Jazz                            *
                                * d. Salir de la consulta de eventos              *
                                ***************************************************
                                * Introduce el evento que deseas consultar:\s""");
                        opcionConsulta = scanner.nextLine().toLowerCase();
                        System.out.println();

                        switch (opcionConsulta) { //Mostramos distintos menús según el evento que se quiere consultar
                            case "a": //Consulta de las criadas
                                System.out.print("""
                                        ******************************************************
                                        *                    LAS CRIADAS                     *
                                        ******************************************************
                                        * a. Entradas vendidas                               *
                                        * b. Entradas libres                                 *
                                        * c. Días restantes y periodo de descuento           *
                                        ******************************************************
                                        * Introduce la opción deseada:\s""");
                                infoEvento = scanner.nextLine().toLowerCase();
                                System.out.println();
                                switch (infoEvento) {
                                    case "a": //Mostramos las entradas vendidas
                                        System.out.printf("Se han vendido un total de %d entradas de platea\n\n", entradasVendidasCriadasPlatea);
                                        System.out.printf("Se han vendido un total de %d entradas de butacas\n\n", entradasVendidasCriadasButacas);
                                        System.out.printf("Se han vendido un total de %d entradas de anfiteatro\n\n", entradasVendidasCriadasAnfiteatro);

                                        break;

                                    case "b": //Mostramos las entradas libres
                                        System.out.printf("Queda un total de %d entradas de platea libres\n\n", (entradasTotalesCriadasPlatea - entradasVendidasCriadasPlatea));
                                        System.out.printf("Queda un total de %d entradas de butacas libres\n\n", (entradasTotalesCriadasButacas - entradasVendidasCriadasButacas));
                                        System.out.printf("Queda un total de %d entradas de anfiteatro libres\n\n", (entradasTotalesCriadasAnfiteatro - entradasVendidasCriadasAnfiteatro));
                                        break;

                                    case "c": //Preguntamos la fecha y comprobamos si está disponible el descuento
                                        System.out.print("Introduce la fecha de hoy (hazlo en este formato yyyy-mm-dd) : ");
                                        fechaIntroducida = LocalDate.parse(scanner.nextLine());
                                        entre = Period.between(fechaIntroducida, fechaCriada);
                                        System.out.println("Quedan " + entre.getMonths() + " meses y " + entre.getDays() + " días para el evento.");
                                        if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                            descuento = true;
                                        if (descuento)
                                            System.out.println("Está disponible el descuento para 7 días antes.");
                                        else System.out.println("No está disponible el descuento.");
                                        break;
                                    default:
                                        System.out.println("Opción introducida incorrecta");
                                        break;
                                }
                                break;
                            case "b": //Consulta del concierto de otoño
                                System.out.print("""
                                        ******************************************************
                                        *               II CONCIERTO DE OTOÑO                *
                                        ******************************************************
                                        * a. Entradas vendidas                               *
                                        * b. Entradas libres                                 *
                                        * c. Días restantes y periodo de descuento           *
                                        ******************************************************
                                        * Introduce la opción deseada:\s""");
                                infoEvento = scanner.nextLine().toLowerCase();
                                System.out.println();

                                switch (infoEvento) {
                                    case "a": //Mostramos las entradas vendidas
                                        System.out.printf("Se han vendido un total de %d entradas de platea\n\n", entradasVendidasOtonioPlatea);
                                        System.out.printf("Se han vendido un total de %d entradas de butacas\n\n", entradasVendidasOtonioButacas);
                                        System.out.printf("Se han vendido un total de %d entradas de anfiteatro\n\n", entradasVendidasOtonioAnfiteatro);
                                        break;

                                    case "b": //Mostramos las entradas libres
                                        System.out.printf("Queda un total de %d entradas de platea libres\n\n", (entradasTotalesOtonioPlatea - entradasVendidasOtonioPlatea));
                                        System.out.printf("Queda un total de %d entradas de butacas libres\n\n", (entradasTotalesOtonioButacas - entradasVendidasOtonioButacas));
                                        System.out.printf("Queda un total de %d entradas de anfiteatro libres\n\n", (entradasTotalesOtonioAnfiteatro - entradasVendidasOtonioAnfiteatro));
                                        break;

                                    case "c": //Preguntamos la fecha y comprobamos si está disponible el descuento
                                        System.out.print("Introduce la fecha hoy (hazlo en este formato yyyy-mm-dd) : ");
                                        fechaIntroducida = LocalDate.parse(scanner.nextLine());
                                        entre = Period.between(fechaIntroducida, fechaOtonio);
                                        System.out.println("Quedan " + entre.getMonths() + " meses y " + entre.getDays() + " días para el evento.");
                                        if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                            descuento = true;
                                        if (descuento)
                                            System.out.println("Está disponible el descuento para 7 días antes.");
                                        else System.out.println("No está disponible el descuento.");
                                        break;

                                    default:
                                        System.out.println("Opción introducida incorrecta");
                                        break;
                                }
                                break;

                            case "c":
                                System.out.print("""
                                        ******************************************************
                                        *                 CONCIERTO DE JAZZ                  *
                                        ******************************************************
                                        * a. Entradas vendidas                               *
                                        * b. Entradas libres                                 *
                                        * c. Días restantes y periodo de descuento           *
                                        ******************************************************
                                        * Introduce la opción deseada:\s""");
                                infoEvento = scanner.nextLine().toLowerCase();
                                System.out.println();
                                switch (infoEvento) {
                                    case "a": //Mostramos las entradas vendidas
                                        System.out.printf("Se han vendido un total de %d entradas de platea\n\n", entradasVendidasJazzPlatea);
                                        System.out.printf("Se han vendido un total de %d entradas de butacas\n\n", entradasVendidasJazzButacas);
                                        System.out.printf("Se han vendido un total de %d entradas de anfiteatro\n\n", entradasVendidasJazzAnfiteatro);

                                        break;

                                    case "b": //Mostramos las entradas libres
                                        System.out.printf("Queda un total de %d entradas de platea libres\n\n", (entradasTotalesJazzPlatea - entradasVendidasJazzPlatea));
                                        System.out.printf("Queda un total de %d entradas de butacas libres\n\n", (entradasTotalesJazzButacas - entradasVendidasJazzButacas));
                                        System.out.printf("Queda un total de %d entradas de anfiteatro libres\n\n", (entradasTotalesJazzAnfiteatro - entradasVendidasJazzAnfiteatro));
                                        break;

                                    case "c": //Preguntamos la fecha y comprobamos si está disponible el descuento
                                        System.out.print("Introduce la fecha hoy (hazlo en este formato yyyy-mm-dd) : ");
                                        fechaIntroducida = LocalDate.parse(scanner.nextLine());
                                        entre = Period.between(fechaIntroducida, fechaJazz);
                                        System.out.println("Quedan " + entre.getMonths() + " meses y " + entre.getDays() + " días para el evento.");
                                        if (entre.getDays() >= 7 || entre.getMonths() > 0 || entre.getYears() > 0)
                                            descuento = true;
                                        if (descuento)
                                            System.out.println("Está disponible el descuento para 7 días antes.");
                                        else System.out.println("No está disponible el descuento.");
                                        break;

                                    default:
                                        System.out.println("Opción introducida incorrecta");
                                        break;
                                }
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (!opcionConsulta.equals("d"));
                    break;
                // Aquí podremos acceder al menú de administrador, previo login.
                case "c":
                    System.out.println("Para acceder al menú de administrador debes loguearte.");

                    do {
                        System.out.print("Introduce el usuario: ");
                        usuIntro = scanner.nextLine();
                        System.out.print("Introduce la contraseña: ");
                        claveIntro = scanner.nextLine();

                        if (!(usuIntro.equals(USUADMIN) && claveIntro.equals(CLAVEADMIN)))
                            System.out.println("Usuario y/o contraseña incorrectas");
                        else {
                            System.out.println("¡Bienvenido Admin!");
                            login = true;
                        }
                    } while (!login);
                    //Aquí ya se ha accedido al menú de administrador y podrás realizar las diferentes opciones
                    do {
                        System.out.print("""
                                ******************************************************
                                *              MENÚ DE ADMINISTRADOR                 *
                                ******************************************************
                                * a. Consultar los ingresos totales por evento.      *
                                * b. Consultar las monedas restantes para el cambio. *
                                * c. Salir al menú principal                         *
                                * d. Apagar                                          *
                                ******************************************************
                                * Introduce la opción deseada:\s""");
                        opcionAdmin = scanner.nextLine().toLowerCase();
                        System.out.println();
                        switch (opcionAdmin) {
                            case "a": //Consultamos los ingresos totales de cada uno de los eventos
                                System.out.printf("""
                                        *******************************************************
                                        *            INGRESOS TOTALES LAS CRIADAS             *
                                        *******************************************************
                                        * Los ingresos totales de las criadas son: %.2f euros *
                                        """, dineroRecaudadoCriadas);
                                scanner.nextLine();

                                System.out.print("""
                                        ************************************
                                        *  PULSA UNA TECLA PARA CONTINUAR  *
                                        ************************************
                                        \n""");
                                scanner.nextLine();

                                System.out.printf("""
                                        ********************************************************************
                                        *             INGRESOS TOTALES II CONCIERTO DE OTOÑO               *
                                        ********************************************************************                                                                 *
                                        * Los ingresos totales del II Concierto de Otoño son: %.2f euros   *
                                        """, dineroRecaudadoOtonio);
                                scanner.nextLine();

                                System.out.print("""
                                        ************************************
                                        *  PULSA UNA TECLA PARA CONTINUAR  *
                                        ************************************
                                        \n""");
                                scanner.nextLine();

                                System.out.printf("""
                                        **************************************************
                                        *    INGRESOS TOTALES CONCIERTO DE JAZZ          *
                                        **************************************************
                                        *  Los ingresos totales de Jazz son: %.2f euros  *
                                        """, dineroRecaudadoJazz);
                                scanner.nextLine();
                                break;

                            case "b": //Consultamos cuanto cambio nos queda
                                System.out.printf("""
                                                *********************************
                                                *       CAMBIO   RESTANTE       *
                                                *********************************
                                                *                               *
                                                *    Billetes de 100 E -> %d    *
                                                *    Billetes de  50 E -> %d    *
                                                *    Billetes de  20 E -> %d    *
                                                *    Billetes de  10 E -> %d    *
                                                *    Billetes de   5 E -> %d    *
                                                *    Monedas  de   2 E -> %d    *
                                                *    Monedas  de   1 E -> %d    *
                                                *    Monedas  de  50 c -> %d    *
                                                *    Monedas  de  20 c -> %d    *
                                                *    Monedas  de  10 c -> %d    *
                                                *    Monedas  de   5 c -> %d    *
                                                *    Monedas  de   2 c -> %d    *
                                                *    Monedas  de   1 c -> %d    *
                                                *                               *
                                                *********************************
                                                """
                                        , billete100, billete50, billete20,
                                        billete10, billete5, monedas2,
                                        monedas1, monedas50c, monedas20c,
                                        monedas10c, monedas5c, monedas2c, monedas1c
                                );
                                break;
                            case "c":
                                System.out.println("Saliendo al menú...");
                                break;

                            case "d": //Apagamos el programa
                                System.out.println("El programa se apagará en: ");
                                //Hacemos un bucle para que cada segundo escriba "." hasta llegar a 3 y termine el programa
                                for (int i = 3; i >= 0; i--) {
                                    System.out.println(i);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    apagar = true;
                                }
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (!opcionAdmin.equals("c") && !apagar);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!apagar);
    }
}