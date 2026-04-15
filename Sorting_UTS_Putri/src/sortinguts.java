public class sortinguts {

    public static void main(String[] args) {

        Mahasiswa[] dataMahasiswa = {
            new Mahasiswa("Andi Pratama", "2201012345", 85),
            new Mahasiswa("Sinta Dewi Lestari", "2201012567", 92),
            new Mahasiswa("Budi Santoso", "2201012789", 78),
            new Mahasiswa("Rina Ayu Putri", "2201012910", 88),
            new Mahasiswa("Eko Wijaya", "2201013034", 65),
            new Mahasiswa("Maya Sari", "2201013256", 95),
            new Mahasiswa("Dimas Prakoso", "2201013478", 72),
            new Mahasiswa("Nadia Safira", "2201013690", 81),
            new Mahasiswa("Rizky Aditya", "2201013812", 90),
            new Mahasiswa("Putri Nirmala", "2201014035", 76)
        };

        Mahasiswa[] bubbleArr = dataMahasiswa.clone();
        Mahasiswa[] insertionArr = dataMahasiswa.clone();
        Mahasiswa[] selectionArr = dataMahasiswa.clone();

        bubbleSort(bubbleArr);
        insertionSort(insertionArr);
        selectionSort(selectionArr);
    }

    // class
    static class Mahasiswa {
        String nama;
        String nim;
        int nilai;

        Mahasiswa(String nama, String nim, int nilai) {
            this.nama = nama;
            this.nim = nim;
            this.nilai = nilai;
        }
    }

    // tampilan header
    static void tampilHeader(String judul) {
        System.out.println("\n================ " + judul + " ================");
    }

    // tampil data
    static void tampilData(Mahasiswa[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(
                "%2d. %-20s | %-15s | %-3d\n",
                (i + 1),
                arr[i].nama,
                arr[i].nim,
                arr[i].nilai
            );
        }
        System.out.println();
    }

    // bubble sort
    static void bubbleSort(Mahasiswa[] arr) {
        tampilHeader("BUBBLE SORT");

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("Iterasi ke-" + (i + 1));

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].nilai < arr[j + 1].nilai) {
                    Mahasiswa temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            tampilData(arr);
        }
    }

    // insertion sort
    static void insertionSort(Mahasiswa[] arr) {
        tampilHeader("INSERTION SORT");

        for (int i = 1; i < arr.length; i++) {
            Mahasiswa key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].nilai < key.nilai) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            System.out.println("Iterasi ke-" + i);
            tampilData(arr);
        }
    }

    // selection sort
    static void selectionSort(Mahasiswa[] arr) {
        tampilHeader("SELECTION SORT");

        for (int i = 0; i < arr.length - 1; i++) {
            int indeksMaks = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].nilai > arr[indeksMaks].nilai) {
                    indeksMaks = j;
                }
            }

            Mahasiswa temp = arr[indeksMaks];
            arr[indeksMaks] = arr[i];
            arr[i] = temp;

            System.out.println("Iterasi ke-" + (i + 1));
            tampilData(arr);
        }
    }
}