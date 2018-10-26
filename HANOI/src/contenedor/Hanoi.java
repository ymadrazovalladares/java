package contenedor;

public class Hanoi
{
    MIPila mipila;

    public Hanoi(MIPila mipila) {
        this.mipila = mipila;
    }
    public Hanoi( ) {
        this.mipila = new MIPila();
    }
    void moveDisk(char fromPeg, char toPeg, int disk)
    {
        System.out.println("Move the disk "+disk +
                " from "+fromPeg+" to "+toPeg);
    }

    // Function to implement TOH puzzle
    void tohIterative(int num_of_disks, MIPila
            src, MIPila aux, MIPila dest)
    {
        MIPila temporal = new MIPila();

        int i, total_num_of_moves;
        char s = 'S', d = 'D', a = 'A';

        // If number of disks is even, then interchange
        // destination pole and auxiliary pole
        if (num_of_disks % 2 == 0)
        {
            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1);

        // Larger disks will be pushed first
        for (i = num_of_disks; i >= 1; i--)
            temporal.push(src, i);

        for (i = 1; i <= total_num_of_moves; i++)
        {
            if (i % 3 == 1)
                moveDisksBetweenTwoPoles(src, dest, s, d);

            else if (i % 3 == 2)
                moveDisksBetweenTwoPoles(src, aux, s, a);

            else if (i % 3 == 0)
                moveDisksBetweenTwoPoles(aux, dest, a, d);
        }
    }
    void moveDisksBetweenTwoPoles(MIPila src, MIPila dest,
                                  char s, char d) {

        int pole1TopDisk = mipila.pop(src);
        int pole2TopDisk = mipila.pop(dest);

        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            mipila.push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // When pole2 pole is empty
        else if (pole2TopDisk == Integer.MIN_VALUE) {
            mipila.push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
        // When top disk of pole1 > top disk of pole2
        else if (pole1TopDisk > pole2TopDisk) {
            mipila.push(src, pole1TopDisk);
            mipila.push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        }
        // When top disk of pole1 < top disk of pole2
        else {
            mipila.push(dest, pole2TopDisk);
            mipila.push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }
}
