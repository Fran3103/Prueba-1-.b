import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<Inscripcion> Alumnos = new ArrayList();

    static Scanner scanner = new Scanner(System.in);


    static Integer id = 0;

    public static void  main(String[] args) {
        int opt;

        do {
            System.out.println("=== GESTIÓN DE INSCRIPCIONES ===\n" +
                    "\n" +
                    "1. Registrar inscripción\n" +
                    "2. Listar todas las inscripciones\n" +
                    "3. Buscar inscripción por ID\n" +
                    "4. Cancelar inscripción\n" +
                    "5. Reactivar inscripción\n" +
                    "6. Contar inscripciones activas\n" +
                    "7. Listar inscripciones por curso\n" +
                    "8. Salir");

            System.out.println("Seleccione una opcion: ");
            opt = scanner.nextInt();
            switch (opt) {

                case 1:
                    Registrar();
                    break;
                case 2:
                    Listar();
                    break;
                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Ingrese el ID a buscar:");
                    int idBuscado = scanner2.nextInt();
                    BuscarID(idBuscado);
                    break;
                case 4:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Ingrese el ID de la inscripción a cancelar:");
                    int idCancelar = scanner3.nextInt();
                    Cancelar(idCancelar);
                    break;

                case 5:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Ingrese el ID de la inscripción a reactivar:");
                    int idReactivar = scanner4.nextInt();
                    Reactivar(idReactivar);
                    break;
                case 6:
                    ContarActivas();
                    break;
                case 7:
                    ListarPorCurso();
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;



                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }while (opt != 8);

        scanner.close();

    }




            static void Registrar() {
                System.out.println("ingrese el nombre del alumno:");

                String nombre = new Scanner(System.in).nextLine().trim();

                System.out.println("ingrese el Nombre del curso:");
                String nombreCurso = new Scanner(System.in).nextLine().trim();



                String estado = "Activa";
                id = id + 1;
                Inscripcion inscripcion = new Inscripcion(id, nombre, nombreCurso, estado);
                Alumnos.add(inscripcion);


                System.out.println("Inscripción registrada con éxito. ID " + (inscripcion.Id));

            }

            static void Listar(){

            if (Alumnos.isEmpty()) {
                System.out.println("No hay inscripciones registradas.");
            } else {
                System.out.println("=== LISTA DE INSCRIPCIONES ===");
                for (Inscripcion inscripcion : Alumnos) {
                    System.out.println("ID: " + inscripcion.Id + ", Nombre: " + inscripcion.Alumno + ", Curso: " + inscripcion.Curso + ", Estado: " + inscripcion.Estado);
                }
            }

        }


            static Inscripcion BuscarID(int id) {

                for (Inscripcion alumno : Alumnos) {
                    if (alumno.getId() == id) {
                        System.out.println("Inscripción encontrada: " + alumno.getAlumno() + " en el curso " + alumno.getCurso());
                        return alumno;

                    }
                }
                System.out.println("Inscripción no encontrada.");
                return null;
            }

            static void Cancelar(int id) {
                Inscripcion inscripcion = BuscarID(id);
                if (inscripcion != null) {
                    inscripcion.setEstado("Cancelada");
                    System.out.println("Inscripción cancelada con éxito.");
                }
            }

            static void Reactivar(int id) {
                Inscripcion inscripcion = BuscarID(id);
                if (inscripcion != null) {
                    inscripcion.setEstado("Activa");
                    System.out.println("Inscripción reactivada con éxito.");
                }}

            static void ContarActivas(){

                Integer total = 0;
                for (Inscripcion inscripcion : Alumnos) {
                    if (inscripcion.getEstado().equals("Activa")) {
                        total++;
                    }
                }
                System.out.println("Total de inscripciones activas: " + total);
            }


            static void ListarPorCurso(){

        for (Inscripcion inscripcion : Alumnos) {
                    System.out.println("Curso: " + inscripcion.getCurso() + ", Nombre: " + inscripcion.getAlumno());
                }
            }
    }


