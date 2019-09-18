package ar.com.ada.billeteravirtual;

import java.util.*;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static PersonaManager ABMPersona = new PersonaManager();
    public static UsuarioManager ABMUsuario = new UsuarioManager();

    public static void main(String[] args) throws Exception {
        ABMPersona.setup();
        ABMUsuario.setup();

        printOpciones();

        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        while (opcion > 0) {

            switch (opcion) {
            case 1:
                alta();
                break;

            case 2:
                baja();
                break;

            case 3:
                modifica();
                break;

            case 4:
                listar();
                break;

            case 5:
                listarPorNombre();
                break;

            default:
                System.out.println("La opcion no es correcta.");
                break;
            }

            printOpciones();

            opcion = Teclado.nextInt();
            Teclado.nextLine();
        }

        // Hago un safe exit del manager
        ABMPersona.exit();
        ABMUsuario.exit();

    }

    public static void alta() {
        Persona p = new Persona();
        System.out.println("Ingrese el nombre:");
        p.setNombre(Teclado.nextLine());
        System.out.println("Ingrese el DNI:");
        p.setDni(Teclado.nextLine());
        System.out.println("Ingrese la edad:");
        p.setEdad(Teclado.nextInt());
        Teclado.nextLine();
        System.out.println("Ingrese el Email:");
        p.setEmail(Teclado.nextLine());

        ABMPersona.create(p);

        System.out.println("Persona generada con exito.  " + p);

        System.out.println("Desea crear un usuario para esa persona?");

        String rta;
        rta = Teclado.nextLine();
        if (rta.equals("si")) {

            Usuario u = new Usuario();
            u.setUserName(p.getEmail());
            System.out.println("Su nombre de usuario es " + u.getUserName());
            System.out.println("Ingrese su password:");
            u.setPassword(Teclado.nextLine());

            /*
             * System.out.println("Su mail es:"); u.setUserEmail(p.getEmail());
             */
            System.out.println("Ingrese su email de usuario:");
            u.setUserEmail(Teclado.nextLine());

            u.setPersonaId(p.getPesonaId());
            ABMUsuario.create(u);

            System.out.println("Usuario generado con exito.  " + u);
        }
    }

    public static void baja() {
        //System.out.println("Ingrese el nombre:");
        //String n = Teclado.nextLine();
        System.out.println("Ingrese el ID de Persona:");
        int id = Teclado.nextInt();
        Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.read(id);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            ABMPersona.delete(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");
        }
    }

    public static void bajaPorDNI() {
        //System.out.println("Ingrese el nombre:");
        //String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI de Persona:");
        String dni = Teclado.nextLine();
        Persona personaEncontrada = ABMPersona.readByDNI(dni);

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada.");

        } else {
            ABMPersona.delete(personaEncontrada);
            System.out.println("El registro de " + personaEncontrada.getDni() + " ha sido eliminado.");
        }
    }

    public static void modifica() {
        // System.out.println("Ingrese el nombre de la persona a modificar:");
        // String n = Teclado.nextLine();

        System.out.println("Desea modificar un dato de la persona o del usuario? \n1: persona \n2: usuario");
        int seleccion = Teclado.nextInt();
        
        

        if (seleccion == 1) {

            System.out.println("Ingrese el ID de la persona a modificar:");
            int id = Teclado.nextInt();
            Teclado.nextLine();
            Persona personaEncontrada = ABMPersona.read(id);

            if (personaEncontrada != null) {

                System.out.println(personaEncontrada.toString() + "seleccionado para modificacion.");

                System.out
                        .println("Elija qué dato de la persona desea modificar: \n1: nombre, \n2: DNI, \n3: edad, \n4: email");
                int selecper = Teclado.nextInt();

                switch (selecper) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    Teclado.nextLine();
                    personaEncontrada.setNombre(Teclado.nextLine());

                    break;
                case 2:
                    System.out.println("Ingrese el nuevo DNI:");
                    Teclado.nextLine();
                    personaEncontrada.setDni(Teclado.nextLine());
                    

                    break;
                case 3:
                    System.out.println("Ingrese la nueva edad:");
                    Teclado.nextLine();
                    personaEncontrada.setEdad(Teclado.nextInt());
                    

                    break;
                case 4:
                System.out.println("Ingrese el nuevo Email:");
                Teclado.nextLine();
                personaEncontrada.setEmail(Teclado.nextLine());
                
                break;

                default:
                    break;
                }

                // Teclado.nextLine();
                
                ABMPersona.update(personaEncontrada);
                


                System.out.println("El registro de " + personaEncontrada.getNombre() + " ha sido modificado.");

            } else {
                System.out.println("Persona no encontrada.");
            }

        } else {

            System.out.println("Ingrese el ID del usuario que desea modificar:");
            int idu = Teclado.nextInt();
            Usuario usuarioEncontrado = ABMUsuario.read(idu);
            


            if (usuarioEncontrado != null) {

                System.out.println(usuarioEncontrado.toString()+ "seleccionado para modificacion.");


                System.out.println("Elija qué dato del usuario desea modificar: 1: email, 2: password");
                int selecus = Teclado.nextInt();

                if (selecus == 1){
                    System.out.println("Ingrese el nuevo Email de usuario:");
                    Teclado.nextLine();
                    usuarioEncontrado.setUserEmail(Teclado.nextLine());
                }
                else {
                    System.out.println("Ingrese la nueva password de usuario:");
                    Teclado.nextLine();
                    usuarioEncontrado.setPassword(Teclado.nextLine());
                }
            
                
            ABMUsuario.update(usuarioEncontrado);
            
            System.out.println("El registro de "+usuarioEncontrado.getUserName() +" ha sido modificado.");
            }
            else {
                System.out.println("Usuario no encontrado.");
            }

        }
    }

    /*
     * public static void modificaByDNI() { //
     * System.out.println("Ingrese el nombre de la persona a modificar:"); // String
     * n = Teclado.nextLine();
     * System.out.println("Ingrese el DNI de la persona a modificar:"); String dni =
     * Teclado.nextLine(); Persona personaEncontrada = ABMPersona.readByDNI(dni);
     * 
     * if (personaEncontrada != null) {
     * 
     * System.out.println(personaEncontrada.toString() +
     * "seleccionado para modificacion.");
     * System.out.println("Ingrese el nuevo nombre:");
     * personaEncontrada.setNombre(Teclado.nextLine());
     * System.out.println("Ingrese el nuevo DNI:");
     * personaEncontrada.setDni(Teclado.nextLine()); // Teclado.nextLine();
     * System.out.println("Ingrese la nueva edad:");
     * personaEncontrada.setEdad(Teclado.nextInt()); Teclado.nextLine();
     * 
     * System.out.println("Ingrese el nuevo Email:");
     * personaEncontrada.setEmail(Teclado.nextLine());
     * 
     * ABMPersona.update(personaEncontrada); System.out.println("El registro de " +
     * personaEncontrada.getDni() + " ha sido modificado.");
     * 
     * } else { System.out.println("Persona no encontrada."); }
     */

    public static void listar() {

        List<Persona> todas = ABMPersona.buscarTodas();
        for (Persona p : todas) {
            System.out.println("Id: " + p.getPesonaId() + " Nombre: " + p.getNombre());
        }
    }

    public static void listarPorNombre() {

        System.out.println("Ingrese el nombre:");
        String nombre = Teclado.nextLine();

        List<Persona> personas = ABMPersona.buscarPor(nombre);
        for (Persona p : personas) {
            System.out.println("Id: " + p.getPesonaId() + " Nombre: " + p.getNombre());
        }
    }

    public static void printOpciones() {
        System.out.println("=======================================");
        System.out.println("");
        System.out.println("Para agregar una persona presione 1.");
        System.out.println("Para eliminar una persona presione 2.");
        System.out.println("Para modificar una persona presione 3.");
        System.out.println("Para ver el listado presione 4.");
        System.out.println("Buscar una persona por nombre especifico(SQL Injection)) 5.");
        System.out.println("Para terminar presione 0.");
        System.out.println("");
        System.out.println("=======================================");
    }
}