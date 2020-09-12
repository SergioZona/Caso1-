package Solucion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    /**
     * Metodo main que ejecuta la aplicación.
     *
     * @param args
     */
    public static void main(String args[]) {

        Buffer buffer = new Buffer(20);

    }

    public class Lectura {

        private int cliente;
        private int numMesajes;
        private int servidores;
        private int numThreadServer;
        private int buffer;


        public Lectura() {

            try {
                lecturaArchivo();
            } catch (Exception e) {
                System.out.println("No se pudo leer el archivo.");
            }
        }

        /**
         * Metodo que lee e inicializa los valores de los atributos.
         *
         * @throws IOException
         */
        public void lecturaArchivo() throws IOException {
            File archivo = new File("./data/data.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String siguiente = br.readLine();

            while (siguiente != null) {
                String arr[] = siguiente.split(":");
                int numero = Integer.parseInt(arr[2]);
                System.out.println(numero+"");

                if ("clientes".compareTo(arr[1]) == 0) {
                    cliente = numero;
                } else if ("numMensajesCliente".compareTo(arr[1]) == 0) {
                    numMesajes = numero;
                }
                else if ("servidores".compareTo(arr[1]) == 0) {
                    servidores = numero;
                }
                else if ("numThreadServer".compareTo(arr[1]) == 0) {
                    numThreadServer = numero;
                }
                else if ("buffer".compareTo(arr[1]) == 0) {
                    buffer = numero;
                }

            }
        }


        public int getCliente() {
            return cliente;
        }

        public void setCliente(int cliente) {
            this.cliente = cliente;
        }

        public int getNumMesajes() {
            return numMesajes;
        }

        public void setNumMesajes(int numMesajes) {
            this.numMesajes = numMesajes;
        }

        public int getServidores() {
            return servidores;
        }

        public void setServidores(int servidores) {
            this.servidores = servidores;
        }

        public int getNumThreadServer() {
            return numThreadServer;
        }

        public void setNumThreadServer(int numThreadServer) {
            this.numThreadServer = numThreadServer;
        }

        public int getBuffer() {
            return buffer;
        }

        public void setBuffer(int buffer) {
            this.buffer = buffer;
        }
    }
}
