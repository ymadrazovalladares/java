package contenedor;

public class UsaHanoi {
    public static void main(String[] args)
    {
        Hanoi hanoi = new Hanoi();
        // Input: number of disks
        int num_of_disks = 4;


        MIPila src, dest, aux;

        // Create three stacks of size 'num_of_disks'
        // to hold the disks
        src = hanoi.mipila.createMiPila(num_of_disks);
        dest = hanoi.mipila.createMiPila(num_of_disks);
        aux = hanoi.mipila.createMiPila(num_of_disks);

        hanoi.tohIterative(num_of_disks, src, aux, dest);
    }
}


