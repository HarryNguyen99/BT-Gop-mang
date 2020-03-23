import java.util.Scanner;

public class GopMang {
    public static int[] nhapMang() {
        int size = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.print("Kích thước không được vượt quá 20");
        } while (size > 20);

        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phần tử " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    public static void xuatMang(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static int[] gopMang(int arr1[], int arr2[]) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        for (int k = 0; k < arr3.length; k++) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j]) {
                    arr3[k] = arr1[i];
                    i++;
                } else {
                    arr3[k] = arr2[j];
                    j++;
                }
            } else // 1 trong 2 mảng chưa lấy hết phần tử
            {
                if (i < arr1.length) { //arr1 chưa lấy hết phần tử
                    arr3[k] = arr1[i];
                    i++;
                } else {
                    if (j < arr2.length) { //arr2 chưa lấy hết phần tử
                        arr3[k] = arr2[j];
                        j++;
                    }
                }
            }
        }
        return arr3;
    }

    public static void main(String[] args) {
        System.out.println("Nhập mảng 1: ");
        int[] array1 = nhapMang();
        xuatMang(array1);
        System.out.println("Nhập mảng 2: ");
        int[] array2 = nhapMang();
        xuatMang(array2);
        System.out.print("Mảng đã gộp: ");
        int[] array3 = gopMang(array1,array2);
        xuatMang(array3);

    }
}
